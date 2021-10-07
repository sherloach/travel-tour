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
<%--                <div class="row">--%>
<%--                    <div class="col-md-8 mb-3">--%>
<%--                        <div class="row">--%>
<%--                            <div class="col-md-6 mb-3">--%>
<%--                                <label>Location</label>--%>
<%--                                <select class="js-example-basic-single" id="locationSelect" name="state">--%>
<%--                                    <option value="">Select a location...</option>--%>
<%--                                    <c:forEach var="item" items="${locations}">--%>
<%--                                        <option value="${item.id}">${item.address}</option>--%>
<%--                                    </c:forEach>--%>
<%--                                </select>--%>
<%--&lt;%&ndash;                                <a href='#' class="my-btn-tour my-btn-tour-delete btn-fab btn-fab-sm btn-primary shadow text-white" id=""><i class="icon-add"></i></a>&ndash;%&gt;--%>
<%--                                <div class="invalid-feedback">--%>
<%--                                    Please provide a name.--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--&lt;%&ndash;                            <div class="col-md-6 mb-3">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <label>Duration</label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <select class="form-control" id="duration">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                   <option value="1">1 ngày</option>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                   <option value="2">2 ngày</option>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                   <option value="3">3 ngày</option>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                   <option value="4">4 ngày</option>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                   <option value="5">5 ngày</option>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                   <option value="6">6 ngày</option>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                   <option value="7">7 ngày</option>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                   <option value="8">8 ngày</option>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                   <option value="9">9 ngày</option>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                   <option value="10">10 ngày</option>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                   <option value="11">11 ngày</option>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                   <option value="12">12 ngày</option>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                   <option value="13">13 ngày</option>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                   <option value="14">14 ngày</option>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                   <option value="15">15 ngày</option>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                </select>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <div class="invalid-feedback">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    Please choose a duration.&ndash;%&gt;--%>
<%--&lt;%&ndash;                                </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            </div>&ndash;%&gt;--%>
<%--                        </div>--%>
<%--                        <div class="row">--%>
<%--                            <div class="col-md-12 mb-3">--%>
<%--                                <label for="description">Description</label>--%>
<%--                                <textarea class="form-control p-t-40"  id="description" placeholder="Write Something..." rows="7" required="required" />--%>
<%--                                <div class="invalid-feedback">--%>
<%--                                    Please provide a tour details.--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="col-md-3">--%>
<%--                        <div class="card mt-4">--%>
<%--                            <h6 class="card-header white">Publish</h6>--%>
<%--                            <div class="card-body text-success">--%>

<%--                                <div class="custom-control custom-checkbox mb-3">--%>
<%--                                    <input type="checkbox" class="custom-control-input" id="customControlValidation1" required>--%>
<%--                                    <label class="custom-control-label" for="customControlValidation1">Check this checkbox</label>--%>
<%--                                    <div class="invalid-feedback">Are you sure?</div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <div class="card-footer bg-transparent">--%>
<%--                                <button class="btn btn-primary" type="button" id="btnSaveOrUpdateTourLocation">Publish</button>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>

                <div class="row">
                    <div class="col-md-8 ">
                        <div class="row">
                            <div class="col-md-8 mb-3">
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
                            <div class="col-md-4 mb-3">
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
                                                    <th>DURATION</th>
                                                    <th>DESCRIPTION</th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody class="stepLocations">
                                                <c:forEach var="item" items="${model.tourLocations}" varStatus="loop">
                                                    <tr class="no-b">
                                                        <td id="address-${loop.index}" locationId="${item.location.id}" style="text-align: center">${item.location.address}</td>
                                                        <td style="text-align: center"><span class="badge badge-success">${item.location.longitude} - ${item.location.latitude}</span></td>
                                                        <td id="day-${loop.index}" style="text-align: center"><i class="icon icon-data_usage"></i> Ngày ${item.day}</td>
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
    <div class="modal-contents">
        <div class="close">+</div><br />
        <form action="">
            <h2>Add Location</h2><br />
            <br />
            <input class="form-control" id="stepLocation" name="address" autocomplete="off" required="required" />
            <div class="suggestion"></div>
            <br />
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label>Latitude</label>
                    <input id="latitude" class="form-control" name="latitude" value="" autocomplete="off" readonly="true" required="required" />
                </div>
                <div class="col-md-6 mb-3">
                    <label>Longitude</label>
                    <input id="longitude" class="form-control" name="longitude" value="" autocomplete="off" readonly="true" required="required" />
                </div>
            </div>
            <br />
            <button class="btn btn-primary" id="btnSaveLocation" type="button">Save</button>
        </form>
    </div>
</div>

<script>
    // TODO: design a form that includes both location choosing and newest location adding.
        const tourId = document.getElementById('tourID').value;
        const locationSelect = document.getElementById('locationSelect');
        const dayInput = document.getElementById('day');
        const descriptionInput = document.getElementById('description');

        function handleSetInputValue(index) {
            const currentLocation = document.getElementById('address-' + index).getAttribute('locationId');
            const currentDay = document.getElementById('day-' + index).textContent.split(' ')[2];
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

                if (document.querySelector('#btnSaveOrUpdateTourLocation').checkValidity() == true) {
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