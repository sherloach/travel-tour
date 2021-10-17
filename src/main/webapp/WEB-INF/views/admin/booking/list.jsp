<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Bookings</title>
</head>
<body>
<%--<table class="js-dynamitable     table table-bordered">--%>
<%--    <!-- table heading -->--%>
<%--    <thead>--%>
<%--    <tr>--%>
<%--        <th>Name <span class=""></span> <span class=""></span> </th>--%>
<%--        <th>Email <span class=""></span> <span class=""></span> </th>--%>
<%--        <th>Age <span class=""></span> <span class=""></span> </th>--%>
<%--        <th>Account <span class=""></span> <span class=""></span> </th>--%>
<%--        <th>Scoring <span class=""></span> <span class=""></span> </th>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <th> <!-- input filter -->--%>

<%--            <input  class="js-filter  form-control" type="text" value="">--%>
<%--        </th>--%>
<%--        <th> <!-- select filter -->--%>

<%--            <select class="js-filter  form-control">--%>
<%--                <option value=""></option>--%>
<%--                <option value="@dynamitable.com">dynamitable.com</option>--%>
<%--                <option value="@sample.com">Sample</option>--%>
<%--            </select>--%>
<%--        </th>--%>
<%--        <th><input class="js-filter  form-control" type="text" value=""></th>--%>
<%--        <th><input class="js-filter  form-control" type="text" value=""></th>--%>
<%--        <th><input class="js-filter  form-control" type="text" value=""></th>--%>
<%--    </tr>--%>
<%--    </thead>--%>

<%--    <!-- table body -->--%>
<%--    <tbody>--%>
<%--    <tr>--%>
<%--        <td>Freddy Krueger</td>--%>
<%--        <td>freddy.krueger@sample.com</td>--%>
<%--        <td class="text-right">122</td>--%>
<%--        <td class="text-right">2300$</td>--%>
<%--        <td class="text-right">+15</td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td>Clint Eastwood</td>--%>
<%--        <td>clint.eastwood@sample.com</td>--%>
<%--        <td class="text-right">62</td>--%>
<%--        <td class="text-right">48 500$</td>--%>
<%--        <td class="text-right">+12</td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td>Peter Parker</td>--%>
<%--        <td>peter.parker@dynamitable.com</td>--%>
<%--        <td class="text-right">22</td>--%>
<%--        <td class="text-right">210$</td>--%>
<%--        <td class="text-right">-5</td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td>Bruce Wayne</td>--%>
<%--        <td>bruce.wayne@dynamitable.com</td>--%>
<%--        <td class="text-right">42</td>--%>
<%--        <td class="text-right">-8500$</td>--%>
<%--        <td class="text-right">+2</td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td>Jackie Chan</td>--%>
<%--        <td>jackie.chan@sample.com</td>--%>
<%--        <td class="text-right">32</td>--%>
<%--        <td class="text-right">-250.55$</td>--%>
<%--        <td class="text-right">0</td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td>Bruce Lee</td>--%>
<%--        <td>bruce.lee@sample.com</td>--%>
<%--        <td class="text-right">32</td>--%>
<%--        <td class="text-right">510$</td>--%>
<%--        <td class="text-right">-7</td>--%>
<%--    </tr>--%>
<%--    </tbody>--%>
<%--</table>--%>
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
                                                <c:url var="detailURL" value="/admin/booking/list/detail">
                                                    <c:param name="bookingid" value="${item.id}"/>
                                                </c:url>
                                                <tr onclick="window.location = ${detailURL}">
                                                    <td style="text-align: center">${item.id}</td>
                                                    <td>${item.clientName}</td>
                                                    <td>${item.tourName}</td>
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
                                                        <td style="color: #2979ff; font-weight: bold;">Pending</td>
                                                    </c:if>
                                                    <c:if test="${item.status == 'APPROVED'}">
                                                        <td style="color: #27ae60;font-weight: bold;">Approved</td>
                                                    </c:if>
                                                    <c:if test="${item.status == 'CANCELED'}">
                                                        <td style="color: #ed5564;font-weight: bold;">Canceled</td>
                                                    </c:if>
                                                    <td style="text-align: left">
<%--                                                        <a href='/admin/route/list/tour?route=${item.id}' class="my-btn-tour-delete btn-fab btn-fab-sm btn-primary shadow text-white"><i class="icon-note-list"></i></a>--%>
                                                        <c:if test="${item.status == 'PENDING'}">
                                                            <a href="#" id="btn-update-booking-status" class="btn-fab btn-fab-sm btn-primary shadow text-white"><i class="icon-edit"></i></a>
                                                        </c:if>
                                                        <c:if test="${item.status != 'CANCELED'}">
                                                            <c:if test="${item.paid == false}">
                                                                <a href="#" style="background-color: #ed5564" id="btn-remove-paid" class="btn-fab btn-fab-sm shadow text-white"><i class="icon-trash"></i></a>
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
                <h2>Please provide Tax ID before confirm this booking</h2>
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

    <script src="<c:url value='/template/admin/dynamitable2/dynamitable.jquery.js'/>"></script>
    <script>
        document.getElementById('btn-update-booking-status').addEventListener("click", function () {
            document.querySelector('.bg-modal').style.display = "flex";
        });

        document.querySelector('.close').addEventListener("click", function () {
            document.querySelector('.bg-modal').style.display = "none";
        });
    </script>
</body>
</html>
