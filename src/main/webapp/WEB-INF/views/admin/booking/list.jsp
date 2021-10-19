<%@ page import="com.nqhtour.util.SecurityUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Bookings</title>
</head>
<body>
    <div class="page has-sidebar-left height-full">
        <header class="blue accent-3 relative">
            <div class="container-fluid text-white">
                <div class="row p-t-b-10 ">
                    <div class="col">
                        <h4>
                            <i class="icon-database"></i> Bookings
                        </h4>
                    </div>
                </div>
                <div class="row justify-content-between">
                    <ul class="nav nav-material nav-material-white responsive-tab"
                        id="v-pills-tab" role="tablist">
                        <li class="float-right"><a class="nav-link" href="">
                            <i class="icon icon-plus-circle"></i></a></li>
                    </ul>
                </div>
            </div>
        </header>

        <c:if test="${not empty message}">
            <div role="alert" class="alert alert-${alert}">
                <strong>${message}</strong>
            </div>
        </c:if>
        <form action="<c:url value=''/>" id="formSubmit" method="get">
            <div class="container-fluid animatedParent animateOnce">
                <div class="tab-content my-3" id="v-pills-tabContent">
                    <div class="tab-pane animated fadeInUpShort show active"
                         id="v-pills-all" role="tabpanel" aria-labelledby="v-pills-all-tab">
                        <div class="row my-3">
                            <div class="col-md-12">
                                <div class="card r-0 shadow">
                                    <div class="table-responsive">
                                        <table class="table table-striped table-hover my-user-list-table r-0 data-tables js-dynamitable">
                                            <thead>
                                                <tr>
                                                    <th><input class="js-filter form-control" type="text" value=""></th>
                                                    <th><input class="js-filter form-control" type="text" value=""></th>
                                                    <th><input class="js-filter form-control" type="text" value=""></th>
                                                    <th>
                                                        <input style="background-color: #ffffff" class="js-filter date-time-picker form-control" value="" data-options="{&quot;timepicker&quot;:false,&quot;format&quot;:&quot;m/d/Y&quot;}" autocomplete="off">
                                                    </th>
                                                    <th>
                                                        <select class="js-filter form-control">
                                                            <option value=""></option>
                                                            <option value="CARD">Card</option>
                                                            <option value="CASH">Cash</option>
                                                        </select>
                                                    </th>
                                                    <th>
                                                        <select class="js-filter form-control">
                                                            <option value=""></option>
                                                            <option value="PENDING">Pending</option>
                                                            <option value="APPROVED">Approved</option>
                                                            <option value="CANCELED">Canceled</option>
                                                        </select>
                                                    </th>
                                                    <th></th>
                                                </tr>
                                                <tr class="no-b my-user-list">
                                                    <th style="width: 80px;">#ID</th>
                                                    <th>CUSTOMER</th>
                                                    <th>TOUR NAME</th>
                                                    <th style="width: 170px;">ORDER DATE</th>
                                                    <th style="width: 105px;">PAYMENT</th>
                                                    <th>STATUS</th>
                                                    <th>CONTROL</th>
                                                </tr>
                                            </thead>

                                            <tbody>
                                            <c:forEach var="item" items="${model}">
<%--                                                <c:url var="detailURL" value="/admin/booking/list/detail">--%>
<%--                                                    <c:param name="bookingid" value="${item.id}"/>--%>
<%--                                                </c:url>--%>
                                                <tr>
                                                    <td style="text-align: center">${item.id}</td>
                                                    <td>${item.clientName}</td>
                                                    <td onclick="handleRedirectToDetailBooking(${item.id})">${item.tourName}</td>
                                                    <td><fmt:formatDate type="both" dateStyle="short" timeStyle="short" pattern="MM/dd/yyyy hh:mm a" value="${item.createdDate}" /></td>
                                                    <td>
                                                        <c:if test="${item.paid == true}">
                                                            Card
                                                        </c:if>
                                                        <c:if test="${item.paid == false}">
                                                            Cash
                                                        </c:if>
                                                    </td>
                                                    <c:if test="${item.status == 'PENDING'}">
                                                        <td style="color: #f39c12;">Pending</td>
                                                    </c:if>
                                                    <c:if test="${item.status == 'APPROVED'}">
                                                        <td style="color: #27ae60;">Approved</td>
                                                    </c:if>
                                                    <c:if test="${item.status == 'CANCELED'}">
                                                        <td style="color: #ed5564;">Canceled</td>
                                                    </c:if>
                                                    <td style="text-align: left">
<%--                                                        <a href='/admin/route/list/tour?route=${item.id}' class="my-btn-tour-delete btn-fab btn-fab-sm btn-primary shadow text-white"><i class="icon-note-list"></i></a>--%>
                                                        <c:if test="${item.status == 'PENDING'}">
                                                            <a href="#" id="btn-update-booking-status"
                                                               onclick="handleModalAndSetBookingId(event, ${item.id}, ${item.adultPrice}, ${item.childrenPrice}, ${item.adultQuantity}, ${item.childrenQuantity})"
                                                               class="btn-fab btn-fab-sm btn-primary shadow text-white"><i class="icon-edit"></i></a>
                                                        </c:if>
                                                        <c:if test="${item.status != 'CANCELED'}">
                                                            <c:if test="${item.paid == false}">
                                                                <a href="#" style="background-color: #ed5564" onclick="warningBeforeDelete(${item.id})" id="btn-remove-paid" class="btn-fab btn-fab-sm shadow text-white"><i class="icon-trash"></i></a>
                                                            </c:if>
                                                        </c:if>
                                                    </td>
                                                </tr
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
        </form>
    </div>

    <div class="bg-modal">
        <div class="modal-contents" style="width: 500px;">
            <div class="close">+</div>
            <form action="" style="position: relative">
                <h4>Please provide Tax ID before approve this booking</h4>
                <br />
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label>Invoice ID</label>
                        <input class="form-control" id="invoiceId" name="invoiceId" autocomplete="off" required="required" />
                    </div>
                    <div class="col-md-6 mb-3">
                        <label>Tax ID</label>
                        <input class="form-control" id="taxId" name="taxId" autocomplete="off" required="required" />
                    </div>
                </div>
                <br />
                <button class="btn btn-primary" id="btnSaveInvoice" type="button">Save</button>
            </form>
        </div>
    </div>

    <security:authorize access = "isAuthenticated()">
        <p hidden id="emailEmployee"><%=SecurityUtils.getPrincipal().getFullName()%></p>
    </security:authorize>

    <script src="<c:url value='/template/admin/dynamitable2/dynamitable.jquery.js'/>"></script>
    <script>
        // document.getElementById('btn-update-booking-status').addEventListener("click", function () {
        //     document.querySelector('.bg-modal').style.display = "flex";
        // });
        let currentBookingId;
        let currentTotalPrice;
        const emailEmployee = document.getElementById('emailEmployee').textContent;

        document.querySelector('.close').addEventListener("click", function () {
            document.querySelector('.bg-modal').style.display = "none";
        });

        document.querySelector('#btnSaveInvoice').addEventListener('click', e => {
            const invoiceId = $('#invoiceId').val();
            const taxId = $('#taxId').val();
            const data = {invoiceId, bookingId: currentBookingId, taxId, emailEmployee, totalPrice: currentTotalPrice};
            console.log(data);
            approveBookingAndCreateInvoice(data);
        });

        function handleModalAndSetBookingId(event, bookingId, adultPrice, childrenPrice, adultQuantity, childrenQuantity) {
            event.stopPropagation();
            document.querySelector('.bg-modal').style.display = "flex";
            $('#invoiceId').val('');
            $('#taxId').val('');
            currentBookingId = bookingId;
            currentTotalPrice = adultQuantity * adultPrice + childrenQuantity * childrenPrice;
        }

        function handleRedirectToDetailBooking(bookingId) {
            window.location.href = "/admin/booking/list/detail?bookingid=" + bookingId;
        }

        function approveBookingAndCreateInvoice(data) {
            $.ajax({
                url: '/api/booking/invoice',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(data),
                success: function (result) {
                    window.location.href = "/admin/booking/list";
                },
                error: function (error) {
                    console.log(error);
                }
            });
        }

        function cancelBooking(data) {
            $.ajax({
                url: '/api/booking/invoice/cancel',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(data),
                success: function (result) {
                    window.location.href = "/admin/booking/list";
                },
                error: function (error) {
                    console.log(error);
                }
            });
        }

        function warningBeforeDelete(bookingId) {
            swal({
                title: "Are you sure?",
                text: "You will not be able to recover this booking!",
                type: "warning",
                showCancelButton: true,
                confirmButtonClass: "btn-success",
                cancelButtonClass: "btn-danger",
                confirmButtonText: "Delete",
                cancelButtonText: "Cancel",
            }).then(function(isConfirm) {
                if (isConfirm.value === true) {
                    const data = {bookingId, emailEmployee};
                    cancelBooking(data);
                }
            });
        }
    </script>
</body>
</html>
