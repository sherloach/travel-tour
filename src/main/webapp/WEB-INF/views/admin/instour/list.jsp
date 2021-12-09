<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin - Instours</title>
</head>
<body>
<div class="page has-sidebar-left">
    <header class="blue accent-3 relative">
        <div class="container-fluid text-white">
            <div class="row p-t-b-10 ">
                <div class="col">
                    <h4>
                        <i class="icon-package"></i> Instours
                    </h4>
                </div>
            </div>
            <div class="row">
                <ul class="nav responsive-tab nav-material nav-material-white">
                    <li><a class="nav-link"
                           href="#">
                        <i class="icon icon-plus-circle"></i> Add New Instour</a></li>
                </ul>
            </div>
        </div>
    </header>
    <c:if test="${not empty message}">
        <div role="alert" class="alert alert-${alert}">
            <strong>${message}</strong>
        </div>
    </c:if>
    <form action="<c:url value='/admin/tour/list'/>" id="formSubmit" method="get">
        <div class="container-fluid animatedParent animateOnce my-3">
            <div class="row my-5">
                <div class="col-lg-6">
                    <div class="counter-box white shadow2 r-5">
                        <div class="table-responsive">
                            <table class="table table-hover ">
                                <tbody>
                                    <tr class="no-b">
                                        <td class="w-10" style="width: 100px;"><img src="${pageContext.request.contextPath}/template/upload/tour/${tour.image}" alt=""></td>
                                        <td> <h6>${tour.name}</h6><small class="text-muted">Du Lịch Trong Nước</small> </td>
                                        <td><i class="icon icon-data_usage"></i> ${tour.duration} days</td>
                                        <td><i class="icon icon-add_location"></i> ${tour.destination} </td>
<%--                                        <td><fmt:formatNumber value="${item.adultPrice}" type="currency" currencySymbol=""/> VND</td>--%>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <button class="btn btn-primary" type="button" id="btnAddInstour">Open Instour</button>

            <div class="animated fadeInUpShort">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card no-b shadow">
                            <div class="card-body p-0">
                                <div class="table-responsive">
                                    <table class="table table-hover ">
                                        <thead>
                                            <tr class="no-b my-user-list">
<%--                                                <th>GUIDE</th>--%>
                                                <th>STARTDATE</th>
                                                <th>PARTICIPANTS</th>
                                                <th>STATUS</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="item" items="${tour.instours}">
                                                <tr class="no-b">
<%--                                                    <td class="w-10"><img src="${pageContext.request.contextPath}/template/upload/tour/${item.imageCover}" alt=""></td>--%>
<%--                                                    <td>--%>
<%--                                                        <div class="avatar avatar-md mr-3 mt-1 float-left">--%>
<%--                                                            <span class="avatar-letter avatar-letter-a avatar-md circle">--%>
<%--                                                                <img class="user_avatar" src="" alt="User Image" />--%>
<%--                                                            </span>--%>
<%--                                                        </div>--%>
<%--                                                        <div>--%>
<%--                                                            <div>--%>
<%--                                                                <strong>${guides}</strong>--%>
<%--                                                            </div>--%>
<%--                                                            <small></small>--%>
<%--                                                        </div>--%>
<%--                                                    </td>--%>
                                                    <td style="text-align: center;"> <i class="icon icon-timer"></i> ${item.startDate} </td>
                                                    <td style="text-align: center;"> <i class="icon icon-people"></i> ${item.participants} / ${tour.maxGroupSize} </td>
                                                    <c:if test="${item.status == 'OPEN'}">
                                                        <td style="text-align: center;"><span class="badge badge-success"> ${item.status} </span></td>
                                                    </c:if>
                                                    <c:if test="${item.status == 'CLOSE'}">
                                                        <td style="text-align: center;"><span class="badge badge-danger"> ${item.status} </span></td>
                                                    </c:if>
                                                    <c:if test="${item.status == 'COMPLETED'}">
                                                        <td style="text-align: center;"><span class="badge badge-warning"> ${item.status} </span></td>
                                                    </c:if>
                                                    <td style="text-align: center;">
<%--                                                    <c:if test="${item.participants == 0}">--%>
<%--                                                        <a href='#' onclick="" class="btn-fab btn-fab-sm btn-primary shadow text-white"><i class="icon-pencil"></i></a>--%>
<%--                                                    </c:if>--%>
                                                        <c:if test="${item.status != 'COMPLETED'}">
                                                            <a href='#' onclick="handleSetInputValue(${item.guideId}, '${item.startDate}', '${item.status}', ${item.id})" class="btn-fab btn-fab-sm btn-primary shadow text-white"><i class="icon-pencil"></i></a>
                                                        </c:if>
                                                        <c:if test="${item.participants != 0}">
                                                            <a href='/admin/route/list/tour/instour/detail?id=${item.id}' onclick="" style="background-color: #f39c12 !important" class="btn-fab btn-fab-sm btn--yellow shadow text-white"><i class="icon-list"></i></a>
                                                        </c:if>
                                                    </td>
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
        </div>

        <input type="hidden" id="tourIdHidden" value="${tour.id}">
    </form>
</div>

<div class="bg-modal">
    <div class="modal-contents" style="width: 700px;">
        <div class="close">+</div><br />
        <form action="">
            <h2>Add Instour</h2><br />
            <div class="row">
                <div class="col-md-4 mb-3">
                    <label>Start Date</label>
                    <input class="date-time-picker form-control" id="startDates" name="startDate" value="" data-options="{&quot;timepicker&quot;:false,&quot;format&quot;:&quot;m/d/Y&quot;,&quot;minDate&quot;:&quot;-1969/12/25&quot;}" autocomplete="off" readonly="true" required="required" />
                    <div class="invalid-feedback" id="warningDate">Please choose a date.</div>
                </div>
                <div class="col-md-4 mb-3">
                    <label class="my-1 mr-2">Select A Guide</label>
                    <select class="form-control custom-select my-1 mr-sm-2 r-0 light s-12" id="guides" required="required">
                        <option value="" selected="selected">Choose...</option>
                        <c:forEach var="guide" items="${guides}">
                            <option value="${guide.id}">${guide.name}</option>
                        </c:forEach>
                    </select>
                    <div class="invalid-feedback">Please choose a guide. </div>
                </div>
                <div class="col-md-4 mb-3">
                    <label class="my-1 mr-2">Choose Status</label>
                    <select class="custom-select my-1 mr-sm-2 form-control r-0 light s-12" id="status">
                        <option value="OPEN" selected="selected">OPEN</option>
                        <option value="CLOSE">CLOSE</option>
                        <option value="COMPLETED">COMPLETED</option>
                    </select>
                    <div class="invalid-feedback">Please choose a status. </div>
                </div>
            </div>
            <br />
            <button class="btn btn-primary" id="btnCreateInsTour" type="button">Add</button>
            <button class="btn btn-warning" id="btnDisableAdd" style="display: none" type="button">Warning</button>
        </form>
    </div>
</div>

<input id="instourIdUpdated" type="hidden" value="">

<script type="text/javascript">
    const startDatesInput = document.querySelector('#startDates');
    const guideInput = document.getElementById('guides');
    const statusInput = document.getElementById('status');
    const tourId = document.getElementById('tourIdHidden').value;

    document.getElementById('btnAddInstour').addEventListener("click", function () {
        document.querySelector('.bg-modal').style.display = "flex";
        $('#status').prop('disabled', 'disabled');
    });

    document.querySelector('.close').addEventListener("click", function () {
        document.querySelector('.bg-modal').style.display = "none";
        $('#status').prop('disabled', false);
    });

    document.querySelector('#btnCreateInsTour').addEventListener('click', function () {
        const startDate = startDatesInput.value;
        const instourId = $('#instourIdUpdated').val(); // using this id when updating.
        const guideId = guideInput.options[guideInput.selectedIndex].value;
        const status = statusInput.options[statusInput.selectedIndex].value;
        console.log(instourId, startDate, guideId, status, tourId);
        const data = {id: instourId, tourId, guideId, status, startDate};
        addInstour(data);
        $('#status').prop('disabled', false);
    });

    function handleSetInputValue(guideId, startDate, status, instourId) {
        document.querySelector('.bg-modal').style.display = "flex";

        const arrGuides = guideInput.options;
        console.log(guideId, startDate, status, instourId);
        for (let i = 0; i < arrGuides.length; i++) {
            if (arrGuides[i].value == guideId) {
                $('#guides').prop('selectedIndex', i).change();
            }
        }

        $('#instourIdUpdated').val(instourId);
        startDatesInput.value = startDate;
        if (status === 'OPEN') {
            statusInput.selectedIndex = 0;
        } else if (status === 'CLOSE') {
            statusInput.selectedIndex = 1;
        } else if (status === 'COMPLETED') {
            statusInput.selectedIndex = 2;
        }
    }

    function warningBeforeDelete(tourID) {
        swal({
            title: "Are you sure?",
            text: "You will not be able to recover this tour!",
            type: "warning",
            showCancelButton: true,
            confirmButtonClass: "btn-success",
            cancelButtonClass: "btn-danger",
            confirmButtonText: "Delete",
            cancelButtonText: "Cancel",
        }).then(function(isConfirm) {
            if (isConfirm.dismiss !== 'cancel') {
                //var ids = $('tbody input[type=checkbox]:checked').map(function () {
                //   return $(this).val();
                //}).get();
                //var id = $(this).data("value");
                var data = "{\"tourId\": " + tourID + " }";
                deleteTour(tourID);
            }
        });
    }

    function  addInstour(data) {
        $.ajax({
            url: '/api/instours',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (result) {
                window.location.href = "/admin/route/list/tour/instour?tour=" + tourId + "&message=insert_success";
            },
            error: function (error) {
                window.location.href = "/admin/route/list/tour/instour?tour=" + tourId + "&message=error_system";
            }
        });
    }

    function deleteTour(data) {
        $.ajax({
            url: '${tourAPI}',
            type: 'DELETE',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (result) {
                window.location.href = "${tourURL}?page=1&limit=6&message=delete_success";
            },
            error: function (error) {
                window.location.href = "${tourURL}?page=1&limit=6&message=delete_people_failed";
            }
        });
    }
</script>

</body>
</html>