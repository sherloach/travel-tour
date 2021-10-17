const search = document.querySelector('#stepLocation');
const suggestion = document.querySelector('.suggestion');
const latitudeInput = document.querySelector('#latitude');
const longitudeInput = document.querySelector('#longitude');
const features = [];
const featureIds = [];

let map, marker, draw;
let timeout = null;

const mapPosition = () => {
    let currentPosition;
    let currentNamePosition;
    let topSearchPosition;
    const placeType = {
        'country': 4,
        'region': 10,
        'postcode': 10,
        'district': 12,
        'place': 12,
        'locality': 17,
        'neighborhood': 17,
        'address': 17,
        'poi': 17
    };

    return {
        setCurrentPosition(position) {
            currentPosition = position;
        },

        getCurrentPosition: function() {
            return currentPosition;
        },

        setCurrentNamePosition(name) {
            currentNamePosition = name;
        },

        getCurrentNamePosition: function() {
            return currentNamePosition;
        },

        getPlaceType(type) {
            return placeType[type];
        },

        setTopSearchPosition(position) {
            topSearchPosition = position;
        },

        getTopSearchPosition() {
            return topSearchPosition;
        }
    }
};

const mapBox = mapPosition();

const addMarkerToMap = (center) => {
    marker = new mapboxgl.Marker({
        color: "#2980b9",
        draggable: false
    })
        .setLngLat(center)
        .addTo(map);
};

function setupMap(center) {
    map = new mapboxgl.Map({
        container: 'map',
        style: 'mapbox://styles/mapbox/streets-v11',
        center,
        zoom: 15
    });

    const nav = new mapboxgl.NavigationControl({ showCompass: false });
    map.addControl(nav, 'top-left');

    map.on('style.load', () => {
        map.on('click', e => {
            let coordinates = e.lngLat;
            renderInfoCard(coordinates);
        });
    });

    addMarkerToMap(center);
}

const successPosition = (position) => {
    setupMap([position.coords.longitude, position.coords.latitude]);
    mapBox.setCurrentPosition([position.coords.longitude, position.coords.latitude]);
};

const errorPosition = () => {
    setupMap([106.7875967, 10.848056]);
};

const initMap = () => {
    mapboxgl.accessToken = 'pk.eyJ1IjoibGVlc3NhbmciLCJhIjoiY2ttMGI5eXB0MnJ4bDJybXB6aDc4Y3dqcyJ9.pEaqr7h0A_Vl6idlG-Dx7g';
    navigator.geolocation.getCurrentPosition(
        successPosition,
        errorPosition,
        {
            enableHighAccuracy: true
        });
};
initMap();

const flyToLocation = (location, type) => {
    suggestion.classList.remove('show');
    let zoom = mapBox.getPlaceType(type);
    marker.setLngLat(location).addTo(map);

    map.flyTo({
        center: [location[0], location[1]],
        essential: true,
        zoom
    });
};

const fly = (location, type, place_name) => {
    search.value = place_name;
    flyToLocation(location, type);
};

const fetchLocation = async (url) => {
    try {
        let response = await fetch(url);
        if (!response.ok) return;
        let result = await response.json();
        return result;
    } catch (err) {
        return null;
    }
};

const renderSuggestionForm = (data) => {
    suggestion.classList.add('show');
    if (!data) {
        suggestion.innerHTML = '<div class="suggest"><span>No matching address found.</span></div>';
    } else {
        const autocompleteData = data.features.map(item =>
            `<div class="suggest">
          <span class="sg" coordinates="${item.center}" type="${item.place_type[0]}">${item.place_name}</span>
        </div>`
        ).join('');

        mapBox.setTopSearchPosition(data.features[0]);
        suggestion.innerHTML = autocompleteData;
    }
};

const renderInfoCard = async (location) => {
    const data = await getLocationByCoordinates(location.lng, location.lat);
    const html = `
      <h4 style="font-size: 12px">${data.features[0].text}</h4>
      ${data.features[0].properties.category ? `<p><span style="font-weight: bold;font-size: 12px">Category:</span style="font-size: 12px"> ${data.features[0].properties.category}</p>` : ''}
      ${data.features[0].properties.address ? `<p><span style="font-weight: bold; font-size: 12px">Address:</span style="font-size: 12px"> ${data.features[0].properties.address}</p>` : ''}
    `;

    new mapboxgl
        .Popup()
        .setLngLat(location)
        .setHTML(html)
        .addTo(map);
};

const getLocationByCoordinates = async (lng, lat) => {
    let url = `https://api.mapbox.com/geocoding/v5/mapbox.places/${lng},${lat}.json?access_token=${mapboxgl.accessToken}`;
    const data = await fetchLocation(url);
    return data;
};

const getLocation = async (location) => {
    let url = `https://api.mapbox.com/geocoding/v5/mapbox.places/${location}.json?access_token=${mapboxgl.accessToken}`;
    const data = await fetchLocation(url);
    return data;
};

const onKeyupSearch = () => {
    clearTimeout(timeout);
    let location;
    timeout = setTimeout(async () => {
        location = search.value;
        if (location === '') {
            suggestion.classList.remove('show');
            return;
        }

        const data = await getLocation(location);
        renderSuggestionForm(data);
    }, 500);
};

const handleSearchSuggestion = (e) => {
    e.stopPropagation();
    const suggest = e.target;

    if (suggest.classList == 'sg') {
        const coordinates = [...suggest.getAttribute('coordinates').split(',')];
        const type = suggest.getAttribute('type');
        const place_name = suggest.innerHTML;

        fly(coordinates, type, place_name);
        longitudeInput.value = coordinates[0];
        latitudeInput.value = coordinates[1];
    }
};

window.onclick = (e) => {
    if (!e.target.matches('.searchTerm')) {
        suggestion.classList.remove('show');
    } else {
        if (search.value) suggestion.classList.add('show');
    }
};

document.addEventListener('click', handleSearchSuggestion);
search.addEventListener('keyup', onKeyupSearch);