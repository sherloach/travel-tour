<%@include file="/common/taglib.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div class="page has-sidebar-left">
        <header class="blue accent-3 relative">
            <div class="container-fluid text-white">
                <div class="row p-t-b-10 ">
                    <div class="col">
                        <h4>
                            <i class="icon-package"></i> Detail Booking
                        </h4>
                    </div>
                </div>
                <div class="row">
                    <ul class="nav responsive-tab nav-material nav-material-white">
                        <li><a class="nav-link"
                               href="/admin/booking/list">
                            <i class="icon icon-arrow_back"></i></a></li>
                    </ul>
                </div>
            </div>
        </header>
        <div class="container-fluid animatedParent animateOnce my-3">
            <c:if test="${model.invoice != null}">
                <div class="row my-5">
                    <div class="col-lg-12">
                        <div class="counter-box white shadow2 r-5">
                            <div class="table-responsive">
                                <table class="table table-hover ">
                                    <thead>
                                        <tr class="no-b">
                                            <th><span style="font-weight: bold">#INVOICE:</span> ${model.invoice.invoiceId}</th>
                                            <th><i class="icon icon-date_range"></i><span style="font-weight: bold"> DATE:</span> <fmt:formatDate type="both" dateStyle="short" timeStyle="short" pattern="MM/dd/yyyy hh:mm a" value="${model.invoice.createdDate}" /></th>
                                            <th><i class="icon icon-user"></i><span style="font-weight: bold"> EMPLOYEE:</span> ${model.invoice.employeeName}</th>
                                        </tr>
                                        <tr class="no-b">
                                            <th><i class="icon icon-taxes"></i><span style="font-weight: bold"> TAX:</span> ${model.invoice.taxId}</th>
                                            <th><i class="icon icon-user-secret"></i><span style="font-weight: bold"> CUSTOMER:</span> ${model.clientName}</th>
                                            <th><i class="icon icon-phone_iphone"></i><span style="font-weight: bold"> PHONE:</span> ${model.clientPhone}</th>
                                        </tr>
                                    </thead>
<%--                                    <tbody>--%>
<%--                                        <tr class="no-b">--%>
<%--                                            <td><i class="icon icon-data_usage"></i> ${model.invoice.invoiceId}</td>--%>
<%--                                            <td><i class="icon icon-add_location"></i> ${model.invoice.createdDate} </td>--%>
<%--                                            <td><i class="icon icon-data_usage"></i> ${model.invoice.taxId}</td>--%>
<%--                                            <td><i class="icon icon-data_usage"></i> ${model.clientName}</td>--%>
<%--                                            <td><i class="icon icon-add_location"></i> ${model.invoice.employeeName}</td>--%>
<%--                                        </tr>--%>
<%--                                    </tbody>--%>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>

            <div class="animated fadeInUpShort">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card no-b shadow">
                            <div class="card-body p-0">
                                <div class="table-responsive">
                                    <table class="table table-hover ">
                                        <thead>
                                            <tr class="no-b my-user-list">
                                                <th></th>
                                                <th>TOUR</th>
                                                <th>LOCATION</th>
                                                <th>STARTDATE</th>
                                                <th>No.ADULT</th>
                                                <th>No.CHILDREN</th>
                                                <c:if test="${model.invoice != null}">
                                                    <th>TOTAL</th>
                                                </c:if>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr class="no-b my-user-list">
                                                <td class="w-10"><img src="${pageContext.request.contextPath}/template/upload/tour/${model.imageTour}" alt=""></td>
                                                <td> <h6>${model.tourName}</h6><small class="text-muted">Du Lịch Trong Nước</small> </td>
                                                <td>${model.destination}</td>
                                                <td>${model.startDate}</td>
                                                <td>x${model.adultQuantity}</td>
                                                <td>x${model.childrenQuantity}</td>
                                                <c:if test="${model.invoice != null}">
                                                    <td><fmt:formatNumber value="${model.invoice.totalPrice}" type="currency" currencySymbol=""/> VND</td>
                                                </c:if>
                                            </tr>
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
    </div>
</body>
</html>
