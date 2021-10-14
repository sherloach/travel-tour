<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.nqhtour.util.SecurityUtils"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NQHTOUR</title>
</head>
<body>
	<section class="section-header" style="background-image: url(${pageContext.request.contextPath}/template/upload/tour/${model.image}); background-size: cover; background-position: center;">
      <div class="heading-box">
        <h1 class="heading-primary">
          <span>${model.name}</span>
        </h1>
        <div class="heading-box__group">
          <div class="heading-box__detail">
            <svg class="heading-box__icon">
              <use xlink:href="/template/web/img/icons.svg#icon-clock"></use>
            </svg>
            <span class="heading-box__text">${model.duration} days</span>
          </div>
          <div class="heading-box__detail">
            <svg class="heading-box__icon">
              <use xlink:href="/template/web/img/icons.svg#icon-map-pin"></use>
            </svg>
            <span class="heading-box__text">${model.destination}</span>
          </div>
        </div>
      </div>
    </section>

    <section class="section-description">
      <div class="overview-box">
        <div>
          <div class="overview-box__group">
            <h2 class="heading-secondary ma-bt-lg">Quick facts</h2>
            <div class="overview-box__detail">
              <svg class="overview-box__icon">
                <use xlink:href="/template/web/img/icons.svg#icon-calendar"></use>
              </svg>
              <span class="overview-box__label">Next date</span>
              <span class="overview-box__text">${model.instours.get(0).startDate}</span>
            </div>
            <div class="overview-box__detail">
              <svg class="overview-box__icon">
                <use xlink:href="/template/web/img/icons.svg#icon-map-pin"></use>
              </svg>
              <span class="overview-box__label">Start Location</span>
              <span class="overview-box__text">${model.startLocation}</span>
            </div>
            <div class="overview-box__detail">
              <svg class="overview-box__icon">
                <use xlink:href="/template/web/img/icons.svg#icon-user"></use>
              </svg>
              <span class="overview-box__label">Participants</span>
              <span id="maxGroupSizeTour" class="overview-box__text">${model.maxGroupSize} people</span>
            </div>
            <div class="overview-box__detail">
              <svg class="overview-box__icon">
                <use xlink:href="/template/web/img/icons.svg#icon-star"></use>
              </svg>
              <span class="overview-box__label">Rating</span>
              <span class="overview-box__text">${model.ratingsAverage} / 5</span>
            </div>
          </div>

          <div class="overview-box__group">
            <h2 class="heading-secondary ma-bt-lg">ABOUT ${model.name}</h2>
            <p style="font-size: 17px">
              ${model.description}
            </p>
          </div>
        </div>
      </div>

      <div class="description-box">
        <h2 class="heading-secondary ma-bt-lg">TOUR PROGRAM</h2>
        <c:forEach var="item" items="${model.tourLocations}">
          <p class="overview-box__label" style="font-size: 1.6rem">Ngày ${item.day}: ${item.location.address}</p>
          <p style="font-size: 17px">
              ${item.description}
          </p>
          <br>
        </c:forEach>
      </div>
    </section>

    <section class="section-pictures">
      <div class="picture-box">
        <img
          class="picture-box__img picture-box__img--1"
          src="${pageContext.request.contextPath}/template/upload/tour/tour-1-2.jpg"
          alt="The Park Camper Tour 1"
        />
      </div>
      <div class="picture-box">
        <img
          class="picture-box__img picture-box__img--2"
          src="${pageContext.request.contextPath}/template/upload/tour/tour-5-2.jpg"
          alt="The Park Camper Tour 2"
        />
      </div>
      <div class="picture-box">
        <img
          class="picture-box__img picture-box__img--3"
          src="${pageContext.request.contextPath}/template/upload/tour/tour-5-3.jpg"
          alt="The Park Camper Tour 3"
        />
      </div>
    </section>

    <section class="section-map">
      <div id='map' data-loclength='${model.tourLocations.size()}'></div>
      <c:forEach var="item" items="${model.tourLocations}" varStatus="loop">
        <input type="hidden" id="locations-${loop.index}" data-longitude="${item.location.longitude}" data-latitude="${item.location.latitude}" data-day="${item.day}" data-address="${item.location.address}">
      </c:forEach>
    </section>

    <section class="section-reviews">
      <div class="reviews">
        <div class="reviews__card">
          <div class="reviews__avatar">
            <img
              src="/template/web/img/users/user-7.jpg"
              alt="Jim Brown"
              class="reviews__avatar-img"
            />
            <h6 class="reviews__user">Jim Brown</h6>
          </div>
          <p class="reviews__text">
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Cumque
            dignissimos sint quo commodi corrupti accusantium veniam saepe
            numquam.
          </p>
          <div class="reviews__rating">
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="/template/web/img/icons.svg#icon-star"></use>
            </svg>
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="/template/web/img/icons.svg#icon-star"></use>
            </svg>
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="/template/web/img/icons.svg#icon-star"></use>
            </svg>
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="/template/web/img/icons.svg#icon-star"></use>
            </svg>
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="/template/web/img/icons.svg#icon-star"></use>
            </svg>
          </div>
        </div>

        <div class="reviews__card">
          <div class="reviews__avatar">
            <img
              src="/template/web/img/users/user-14.jpg"
              alt="Laura Wilson"
              class="reviews__avatar-img"
            />
            <h6 class="reviews__user">Laura Wilson</h6>
          </div>
          <p class="reviews__text">
            Veniam adipisci blanditiis, corporis sit magnam aperiam ad, fuga
            reiciendis provident deleniti cumque similique itaque animi,
            sapiente obcaecati beatae accusantium.
          </p>
          <div class="reviews__rating">
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="img/icons.svg#icon-star"></use>
            </svg>
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="img/icons.svg#icon-star"></use>
            </svg>
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="img/icons.svg#icon-star"></use>
            </svg>
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="img/icons.svg#icon-star"></use>
            </svg>
            <svg class="reviews__star reviews__star--inactive">
              <use xlink:href="img/icons.svg#icon-star"></use>
            </svg>
          </div>
        </div>

        <div class="reviews__card">
          <div class="reviews__avatar">
            <img
              src="/template/web/img/users/user-15.jpg"
              alt="Ben Hadley"
              class="reviews__avatar-img"
            />
            <h6 class="reviews__user">Ben Hadley</h6>
          </div>
          <p class="reviews__text">
            Debitis, nesciunt itaque! At quis officia natus. Suscipit,
            reprehenderit blanditiis mollitia distinctio ducimus porro tempore
            perspiciatis sunt vel.
          </p>
          <div class="reviews__rating">
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="img/icons.svg#icon-star"></use>
            </svg>
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="img/icons.svg#icon-star"></use>
            </svg>
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="img/icons.svg#icon-star"></use>
            </svg>
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="img/icons.svg#icon-star"></use>
            </svg>
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="img/icons.svg#icon-star"></use>
            </svg>
          </div>
        </div>

        <div class="reviews__card">
          <div class="reviews__avatar">
            <img
              src="/template/web/img/users/user-6.jpg"
              alt="Alexander Jones"
              class="reviews__avatar-img"
            />
            <h6 class="reviews__user">Alexander Jones</h6>
          </div>
          <p class="reviews__text">
            Quaerat laborum eveniet ut aut maiores doloribus mollitia aperiam
            quis praesentium sed inventore harum aliquam veritatis at adipisci
            ea assumenda!
          </p>
          <div class="reviews__rating">
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="img/icons.svg#icon-star"></use>
            </svg>
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="img/icons.svg#icon-star"></use>
            </svg>
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="img/icons.svg#icon-star"></use>
            </svg>
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="img/icons.svg#icon-star"></use>
            </svg>
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="img/icons.svg#icon-star"></use>
            </svg>
          </div>
        </div>

        <div class="reviews__card">
          <div class="reviews__avatar">
            <img
              src="/template/web/img/users/user-3.jpg"
              alt="Ayla Cornell"
              class="reviews__avatar-img"
            />
            <h6 class="reviews__user">Ayla Cornell</h6>
          </div>
          <p class="reviews__text">
            Perferendis quo aliquid iste quas laboriosam molestias illo est
            voluptatem odit ea. Vero placeat culpa provident dicta maiores!
          </p>
          <div class="reviews__rating">
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="img/icons.svg#icon-star"></use>
            </svg>
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="img/icons.svg#icon-star"></use>
            </svg>
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="img/icons.svg#icon-star"></use>
            </svg>
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="img/icons.svg#icon-star"></use>
            </svg>
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="img/icons.svg#icon-star"></use>
            </svg>
          </div>
        </div>
      </div>
    </section>

    <section class="section-cta">
      <div class="cta">
        <div class="cta__img cta__img--logo">
          <img src="/template/web/img/logo-white.png" alt="NQHTours logo" class="" />
        </div>
        <img src="${pageContext.request.contextPath}/template/upload/tour/tour-5-2.jpg" alt="" class="cta__img cta__img--1" />
        <img src="${pageContext.request.contextPath}/template/upload/tour/tour-5-3.jpg" alt="" class="cta__img cta__img--2" />

        <div class="cta__content">
            <%-- CHOOSE DATE--%>
            <div>
              <input class="form__input" id="startDatetime" style="width: 250px" type="text" value="${model.instours.get(0).startDate}" required name="startDates" readonly>
            </div>
            <%-- ADULT --%>
            <div style="background-color: #f2f2f2;border-radius: 4px;padding: 0px 10px;position: relative;">
              <span class="" style="font-size: 16px;vertical-align: middle;">Adult</span>
              <span id="adultPrice" class="price-color" style="color: #ffbd00;font-size: 16px;vertical-align: middle;margin-left: 15px;display: inline-block;min-width: 80px;"> x ${model.adultPrice}</span>
              <div class="btn-group">
                <button type="button" class="number-button minus-adult btn-general" style="padding: 10px;border: none;">
                  <i class="fa fa-minus"></i>
                </button>
                <span class="number-detail number-adult" style="font-size: 16px;padding: 14px 10px;">1</span>
                <button type="button" class="number-button plus-adult btn-general" style="padding: 10px;border: none;">
                  <i class="fa fa-plus"></i>
                </button>
              </div>
            </div>
            <%-- CHILDREN --%>
            <div style="background-color: #f2f2f2;border-radius: 4px;padding: 0px 10px;position: relative;">
              <span class="" style="font-size: 16px;vertical-align: middle;">Children</span>
              <span id="childrenPrice" class="price-color" style="color: #ffbd00;font-size: 16px;vertical-align: middle;margin-left: 15px;display: inline-block;min-width: 80px;"> x 0</span>
              <div class="btn-group">
                <button type="button" class="number-button minus-children btn-general" style="padding: 10px;border: none;">
                  <i class="fa fa-minus"></i>
                </button>
                <span class="number-detail number-children" style="font-size: 16px;padding: 14px 10px;">0</span>
                <button type="button" class="number-button plus-children btn-general" style="padding: 10px;border: none;">
                  <i class="fa fa-plus"></i>
                </button>
              </div>
            </div>

            <input id="finalStartsDate" type="hidden" name="" value="">
            <input id="adultPriceTemp" type="hidden" name="" value="${model.adultPrice}">
            <input id="childrenPriceTemp" type="hidden" name="" value="${model.childrenPrice}">

            <c:forEach var="item" items="${model.instours}">
              <input class="hiddenStartDate" type="hidden" name="" value="${item.startDate}x/x${item.id}x/x${item.participants}">
            </c:forEach>
        </div>
        <div style="display: flex;align-items: center;margin-top: 15px;">
          <button style="display: none; margin-top: 20px; width: 250px" id="btn-sold-out" class="btn btn--yellow span-all-rows">Sold Out!</button>
          <security:authorize access = "isAnonymous()">
            <a style="margin-top: 20px; width: 250px" href="<c:url value='/login'/>" class="btn btn--green span-all-rows">Book tour now!</a>
          </security:authorize>
          <security:authorize access = "hasRole('CLIENT')">
          <button style="margin-top: 20px; width: 250px" id="btn-book-tour" class="btn btn--green span-all-rows">Book tour now!</button>
          </security:authorize>
          <span id="totalPrice" style="font-size: 25px;font-weight: 400;margin: 20px 0px 0px 31px;">${model.adultPrice}</span>
        </div>
      </div>
    </section>
    
    <security:authorize access = "isAuthenticated()">
			<p hidden id="emailClient"><%=SecurityUtils.getPrincipal().getFullName()%></p>
	</security:authorize>

	<script>
        const startDatesOfTour = document.querySelectorAll('.hiddenStartDate');
        const datetimePickerPlugin = document.querySelector('#startDatetime');
        const finalChoosingStartDate = document.querySelector('#finalStartsDate');
        const maxGroupSizeTour = document.querySelector('#maxGroupSizeTour').textContent.split(' ')[0];
        let instourId = [];
        const allowDates = [];
        const maxGroupSizePerTours = [];
        const emailClient = $("#emailClient").text();

        const locLength = document.getElementById('map').dataset.loclength;
        let locations = [];
        for (let i = 0; i < locLength; i++) {
          const address = document.getElementById('locations-' + i).dataset.address;
          const day = document.getElementById('locations-' + i).dataset.day;
          const latitude = document.getElementById('locations-' + i).dataset.latitude;
          const longitude = document.getElementById('locations-' + i).dataset.longitude;
          locations.push({address, day, latitude, longitude});
        }

        // store instour id inside array of object, with key is startDate and value is instour id.
        startDatesOfTour.forEach((item, index) => {
          instourId[item.value.split('x/x')[0]] = item.value.split('x/x')[1];
          allowDates.push(item.value.split('x/x')[0]);
          maxGroupSizePerTours[item.value.split('x/x')[0]] = item.value.split('x/x')[2];
        });
        console.log(allowDates);
        // console.log(maxGroupSizePerTours);

        jQuery('#startDatetime').datetimepicker({
          timepicker:false,
          format:'m/d/Y',
          allowDates: allowDates,
          formatDate:'m/d/Y'
        });

        $('#startDatetime').on('change', function() {
          finalChoosingStartDate.value = instourId[datetimePickerPlugin.value];

          const ticketRemain = +maxGroupSizeTour - +maxGroupSizePerTours[datetimePickerPlugin.value];
          console.log('Con lai: ', ticketRemain);
          // $('#dateChange').html(currentInstour[0]);
          // $("#quantity").attr({
          //   "max" : ticket,
          //   "min" : 1
          // });
          // $("#quantity").val(1);
          // const currentPrice = 1 * $('#priceTemp').val();
          // $('#priceTag').html(currentPrice.toLocaleString('en-US', { style: 'currency', currency: 'VND' }));
          //
          if (ticketRemain === 0) {
            $('#btn-sold-out').css('display', 'block');
            $('#book-tour').css('display', 'none');
          } else {
            $('#btn-sold-out').css('display', 'none');
            $('#book-tour').css('display', 'block');
          }
        });

        let numberAdult = 1;
        let numberChildren = 0;
        const numberAdultSpan = document.querySelector('.number-adult');
        const numberChildrenSpan = document.querySelector('.number-children');
        const adultPriceDB = +$('#adultPriceTemp').val();
        const childrenPriceDB = +$('#childrenPriceTemp').val();
        const totalPriceFirst = +adultPriceDB + +childrenPriceDB;
        $('#adultPrice').html(adultPriceDB.toLocaleString('en-US', { style: 'currency', currency: 'VND' }));
        $('#totalPrice').html(totalPriceFirst.toLocaleString('en-US', { style: 'currency', currency: 'VND' }));

        document.querySelector('.plus-adult').addEventListener('click', e => {
          numberAdult += 1;
          numberAdultSpan.textContent = numberAdult;
          const currentPrice = calcCurrentPrice(numberAdult, adultPriceDB);
          $('#adultPrice').html(currentPrice.toLocaleString('en-US', { style: 'currency', currency: 'VND' }));
          displayTotalPrice();
        });

        document.querySelector('.minus-adult').addEventListener('click', e => {
          if (numberAdult > 1) {
            numberAdult -= 1;re
          }
          numberAdultSpan.textContent = numberAdult;
          const currentPrice = calcCurrentPrice(numberAdult, adultPriceDB);
          $('#adultPrice').html(currentPrice.toLocaleString('en-US', { style: 'currency', currency: 'VND' }));
          displayTotalPrice();
        });

        document.querySelector('.plus-children').addEventListener('click', e => {
          numberChildren += 1;
          numberChildrenSpan.textContent = numberChildren;
          const currentPrice = calcCurrentPrice(numberChildren, childrenPriceDB);
          $('#childrenPrice').html(currentPrice.toLocaleString('en-US', { style: 'currency', currency: 'VND' }));
          displayTotalPrice();
        });

        document.querySelector('.minus-children').addEventListener('click', e => {
          if (numberChildren !== 0) {
            numberChildren -= 1;
          }
          numberChildrenSpan.textContent = numberChildren;
          const currentPrice = calcCurrentPrice(numberChildren, childrenPriceDB);
          $('#childrenPrice').html(currentPrice.toLocaleString('en-US', { style: 'currency', currency: 'VND' }));
          displayTotalPrice();
        });

        const btnBookTour = document.getElementById('btn-book-tour');
        if (btnBookTour) {
          btnBookTour.addEventListener('click', e => {
            console.log('adult quantity:', numberAdult);
            console.log('children quantity:', numberChildren);
            console.log('email:', emailClient);
            console.log('instour ID:', finalChoosingStartDate.value);
            window.location.href = "/tour/repayment?instourid=" + finalChoosingStartDate.value +
                    "&email=" + emailClient + "&adultq=" + numberAdult + "&childq=" + numberChildren + "&tourid=" + ${model.id};
          });
        }

        const calcCurrentPrice = (quantity, price) => {
          return quantity * price;
        };

        const displayTotalPrice = () => {
          const totalPrice = (numberAdult * adultPriceDB) + (numberChildren * childrenPriceDB);
          $('#totalPrice').html(totalPrice.toLocaleString('en-US', { style: 'currency', currency: 'VND' }));
        };

        const displayMap = locations => {
          mapboxgl.accessToken = 'pk.eyJ1IjoibGVlc3NhbmciLCJhIjoiY2ttMGI5eXB0MnJ4bDJybXB6aDc4Y3dqcyJ9.pEaqr7h0A_Vl6idlG-Dx7g';
          const map = new mapboxgl.Map({
            container: 'map',
            style: 'mapbox://styles/mapbox/streets-v11',
          });

          const bounds = new mapboxgl.LngLatBounds();
          locations.forEach(loc => {
            const el = document.createElement('div');
            el.className = 'marker';

            const coordinates = [loc.longitude, loc.latitude];
            new mapboxgl.Marker({
              element: el,
              anchor: 'bottom'
            }).setLngLat(coordinates).addTo(map);

            new mapboxgl.Popup({
              closeOnClick: false,
              offset: 30
            }).setLngLat(coordinates).setHTML("Day " + loc.day + ": " + loc.address).addTo(map);

            bounds.extend(coordinates);
          });

          map.fitBounds(bounds, {
            padding: {
              top: 200,
              bottom: 150,
              left: 100,
              right: 100
            }
          });
        };
        displayMap(locations);
		
		/*function check(d) {
			$.ajax({
				url: '/api/client/tour',
				type: 'POST',
				contentType: 'text/plain',
				data: d,
				success: function (result) {
					if (result == "true") {
						window.location.href = "/tour/checkout?id=" + ${model.id};
					} else if (result == "false") {
						swal("Warning!", "You paid for this tour!", "warning");
					}
				},
				error: function (error) {
					window.location.href = "/trang-chu";
				}
			});
		}*/

        function check(d) {
          $.ajax({
            url: '/api/client/tour',
            type: 'POST',
            contentType: 'text/plain',
            data: d,
            success: function (result) {
              if (result == "true") {
                //window.location.href = "/tour/checkout?id=" + ${model.id};
                window.location.href = "/tour/repayment?id=" + ${model.id};
              } else if (result == "false") {
                swal("Warning!", "You paid for this tour!", "warning");
              }
            },
            error: function (error) {
              window.location.href = "/trang-chu";
            }
          });
        }
	</script>
</body>
</html>