<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin</title>
</head>
<body>
<div class="page has-sidebar-left">
    <header class="blue accent-3 relative">
        <div class="container-fluid text-white">
            <div class="row p-t-b-10 ">
                <div class="col">
                    <h4>
                        <i class="icon-package"></i>
                        Locations
                    </h4>
                </div>
            </div>
            <div class="row">
                <ul class="nav responsive-tab nav-material nav-material-white">
                    <li>
                        <a class="nav-link" href="<c:url value='/admin/tour/edit?id=${model.id}'/>">
                            <i class="icon icon-list"></i>Info Tours
                        </a>
                    </li>
                    <li>
                        <a class="nav-link" id="btnAddLocation" href="#">
                            <i class="icon icon-list"></i>Add New Location
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </header>
    <c:if test="${not empty message}">
        <div role="alert" class="alert alert-${alert}">
            <strong>${message}</strong>
        </div>
    </c:if>
    <div class="container-fluid animatedParent animateOnce my-3">
        <div class="animated fadeInUpShort">
            <form:form id="formSubmit" role="form" modelAttribute="model">
                <div class="row">
                    <div class="col-md-8 ">
                        <div class="row">
                            <div class="col-md-9 mb-3">
                                <label>Location</label>
                                <select class="js-example-basic-single" id="locationSelect" name="state">
                                    <option value="">Select a location...</option>
                                    <c:forEach var="item" items="${locations}">
                                        <option value="${item.id}">${item.address}</option>
                                    </c:forEach>
                                </select>
                                <div class="invalid-feedback">
                                    Please provide a location.
                                </div>
                            </div>
                            <div class="col-md-3 mb-3">
                                <label>Day</label>
                                <select style="height: 31px; font-size: 14px" class="form-control" id="day">
                                    <option value="1">ngày 1</option>
                                    <option value="2">ngày 2</option>
                                    <option value="3">ngày 3</option>
                                    <option value="4">ngày 4</option>
                                    <option value="5">ngày 5</option>
                                    <option value="6">ngày 6</option>
                                    <option value="7">ngày 7</option>
                                    <option value="8">ngày 8</option>
                                    <option value="9">ngày 9</option>
                                    <option value="10">ngày 10</option>
                                    <option value="11">ngày 11</option>
                                    <option value="12">ngày 12</option>
                                    <option value="13">ngày 13</option>
                                    <option value="14">ngày 14</option>
                                    <option value="15">ngày 15</option>
                                </select>
                                <div class="invalid-feedback">
                                    Please choose a duration.
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label>Description</label>
                            <textarea class="form-control p-t-40" id="description" placeholder="Write Something..." rows="6" required></textarea>
                            <div class="invalid-feedback">
                                Please provide a step details.
                            </div>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="card mt-4">
                            <h6 class="card-header white">Publish</h6>
                            <div class="card-body text-success">

                                <div class="custom-control custom-checkbox mb-3">
                                    <input type="checkbox" class="custom-control-input" id="customControlValidation1" required>
                                    <label class="custom-control-label" for="customControlValidation1">Check this checkbox</label>
                                    <div class="invalid-feedback">Are you sure?</div>
                                </div>
                            </div>
                            <div class="card-footer bg-transparent">
                                <button class="btn btn-primary" type="button" id="btnSaveOrUpdateTourLocation">Publish</button>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="animated fadeInUpShort">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="card no-b shadow">
                                <div class="card-body p-0">
                                    <div class="table-responsive">
                                        <table class="table table-striped table-hover my-user-list-table r-0">
                                            <thead>
                                                <tr class="no-b my-user-list">
                                                    <th>LOCATION</th>
                                                    <th>COORDINATES</th>
                                                    <th>DAY</th>
                                                    <th>DESCRIPTION</th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody class="stepLocations">
                                                <c:forEach var="item" items="${model.tourLocations}" varStatus="loop">
                                                    <tr class="no-b">
                                                        <td id="address-${loop.index}" locationId="${item.location.id}" style="text-align: center">${item.location.address}</td>
                                                        <td style="text-align: center"><span class="badge badge-success">${item.location.longitude} - ${item.location.latitude}</span></td>
                                                        <td id="day-${loop.index}" style="text-align: center">${item.day}</td>
                                                        <td id="description-${loop.index}" style="width: 650px; text-align: inherit"><div>${item.description}</div></td>
                                                        <td style="text-align: center;"><a href='#' onclick="handleSetInputValue(${loop.index})" class="btn-fab btn-fab-sm btn-primary shadow text-white"><i class="icon-pencil"></i></a></td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Cần phải có ID để xử lý thêm, sửa -->
                <form:hidden path="id" id="tourID"/>
            </form:form>
        </div>
    </div>
</div>

<div class="bg-modal">
    <div class="modal-contents" style="width: 900px;">
        <div class="close">+</div>
        <form action="" style="position: relative">
            <h2>Step Location</h2>
            <div class="row">
                <div class="col-md-8 mb-3">
                    <div id="map" style="height: 300px; width: 100%;"></div>
                </div>
                <div class="col-md-4 mb-3" style="text-align: left">
                    <label>Address</label>
                    <input class="form-control" id="stepLocation" name="address" autocomplete="off" required="required" />
                    <div class="suggestion"></div>
                    <br />
                    <label>Latitude</label>
                    <input id="latitude" class="form-control" name="latitude" value="" autocomplete="off" readonly="true" required="required" />
                    <br />
                    <label>Longitude</label>
                    <input id="longitude" class="form-control" name="longitude" value="" autocomplete="off" readonly="true" required="required" />
                    <br />
                    <button class="btn btn-primary" id="btnSaveLocation" style="width: 100%" type="button">Save</button>
                    <div class="invalid-feedback exist-error-span">
                        This location was exist in database.
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>

<script src="<c:url value='/template/admin/assets/js/map.js'/>"></script>
<script>
    // TODO: design a form that includes both location choosing and newest location adding.
    const tourId = document.getElementById('tourID').value;
    const locationSelect = document.getElementById('locationSelect');
    const dayInput = document.getElementById('day');
    const descriptionInput = document.getElementById('description');
    const latitudeElement = document.getElementById('latitude');
    const longitudeElement = document.getElementById('longitude');
    const addressElement = document.getElementById('stepLocation');

    function handleSetInputValue(index) {
        const currentLocation = document.getElementById('address-' + index).getAttribute('locationId');
        const currentDay = document.getElementById('day-' + index).textContent;
        const currentDescription = document.getElementById('description-' + index).textContent;
        const arrLoc = locationSelect.options;
        console.log(currentLocation, currentDay, currentDescription);
        for (let i = 0; i < arrLoc.length; i++) {
            if (arrLoc[i].value == currentLocation) {
                $('#locationSelect').prop('selectedIndex', i).change();
            }
        }
        descriptionInput.value = currentDescription;
        dayInput.selectedIndex = currentDay - 1;
    }

    document.getElementById('btnSaveLocation').addEventListener('click', e => {
        const latitude = latitudeElement.value;
        const longitude = longitudeElement.value;
        const address = addressElement.value;
        console.log(latitude, longitude, address);
        const data = { longitude, latitude, address };
        const isExistLocation = checkExistLocation(data);
        console.log('isExistLocation', isExistLocation);
        saveLocation(data);

        // if (isExistLocation) {
        //     $('.exist-error-span').css('display', 'block');to
        // } else {
        //     saveLocation(data);
        //     $('.exist-error-span').css('display', 'none');
        // }

        latitude.value = '';
        longitude.value = '';
        address.value = '';
    });

    const checkExistLocation = (data) => {
        let isExist = true;

        $.ajax({
            url: '/api/location/check',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                isExist = result;
                console.log('result', result);
                console.log('exist', isExist);
            },
            error: function (error) {
                console.log(error.responseText);
            }
        });

        return isExist;
    };

    const saveLocation = (data) => {
        $.ajax({
            url: '/api/location',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                window.location.href = '/admin/tour/edit/location/edit?id=' + tourId + '&message=insert_success';
            },
            error: function (error) {
                window.location.href = '/admin/tour/edit/location/edit?id=' + tourId + '&message=error_system';
            }
        });
    };

    window.addEventListener("load", function () {
        document.getElementById('btnAddLocation').addEventListener("click", function () {
            document.querySelector('.bg-modal').style.display = "flex";
        });

        document.querySelector('.close').addEventListener("click", function () {
            document.querySelector('.bg-modal').style.display = "none";
        });

        document.querySelector('#btnSaveOrUpdateTourLocation').addEventListener("click", function (event) {
            event.preventDefault();

            document.getElementById("formSubmit").classList.add("was-validated");
            var editorElement = document.getElementById("description");
            if (editorElement.value == '') {
                editorElement.parentNode.classList.add("is-invalid");
                editorElement.parentNode.classList.remove("is-valid");
            } else {
                editorElement.parentNode.classList.remove("is-invalid");
                editorElement.parentNode.classList.add("is-valid");
            }

            if (document.querySelector('#formSubmit').checkValidity() == true) {
                event.stopPropagation();

                event.preventDefault();
                const locationId = locationSelect.options[locationSelect.selectedIndex].value;
                const day = dayInput.value;
                const description = descriptionInput.value;
                const data = { day, description, tourId, locationId };
                console.log(data);
                addTourLocation(data);
            }
        }, false);

        function addTourLocation(data) {
            $.ajax({
                url: '/api/tour/location',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(data),
                dataType: 'json',
                success: function (result) {
                    window.location.href = '/admin/tour/edit/location/edit?id=' + tourId + '&message=insert_success';
                },
                error: function (error) {
                    window.location.href = '/admin/tour/edit/location/edit?id=' + tourId + '&message=error_system';
                }
            });
        }

        $(document).ready(function() {
            $('.js-example-basic-single').select2();
        });
    }, false);
</script>
</body>
</html>