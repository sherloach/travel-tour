<%@include file="/common/taglib.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div class="page has-sidebar-left height-full">
        <header class="blue accent-3 relative">
            <div class="container-fluid text-white">
                <div class="row p-t-b-10 ">
                    <div class="col">
                        <h4>
                            <i class="icon-database"></i> Participants of ${instour.bookings.get(0).tourName}
                        </h4>
                    </div>
                </div>
                <div class="row justify-content-between">
                    <ul class="nav nav-material nav-material-white responsive-tab"
                        id="v-pills-tab" role="tablist">
                        <li><a class="nav-link"
                               href="/admin/route/list/tour/instour?tour=${instour.bookings.get(0).tourId}">
                            <i class="icon icon-arrow_back"></i></a></li>
                        <li><a class="nav-link"
                               href="<c:url value='/admin/booking/list'/>">
                            <i class="icon icon-edit"></i> Approve Booking</a>
                        </li>
                    </ul>
                </div>
            </div>
        </header>

        <form action="" id="formSubmit" method="get">
            <div class="container-fluid animatedParent animateOnce">
                <div class="tab-content my-3" id="v-pills-tabContent">
                    <div class="tab-pane animated fadeInUpShort show active"
                         id="v-pills-all" role="tabpanel" aria-labelledby="v-pills-all-tab">
                        <div class="row my-3">
                            <div class="col-md-12">
                                <div class="card r-0 shadow">
                                    <div class="table-responsive" style="overflow-x: initial;">
                                        <table class="table table-striped table-hover my-user-list-table r-0">
                                            <thead>
                                            <tr class="no-b my-user-list">
                                                <th>NAME</th>
                                                <th>PHONE</th>
                                                <th>No.Adult</th>
                                                <th>No.Children</th>
                                                <th>BOOKING DATE</th>
                                                <th>STATUS</th>
                                            </tr>
                                            </thead>

                                            <tbody>
                                                <c:forEach var="item" items="${instour.bookings}">
                                                    <tr>
                                                        <td style="text-align: center"><strong>${item.clientName}</strong></td>
                                                        <td>${item.clientPhone}</td>
                                                        <td>x${item.adultQuantity}</td>
                                                        <td>x${item.childrenQuantity}</td>
                                                        <td><fmt:formatDate type="both" dateStyle="short" timeStyle="short" pattern="MM/dd/yyyy hh:mm a" value="${item.createdDate}" /></td>
                                                        <c:if test="${item.status == 'PENDING'}">
                                                            <td style="color: #f39c12;">Pending</td>
                                                        </c:if>
                                                        <c:if test="${item.status == 'APPROVED'}">
                                                            <td style="color: #27ae60;">Approved</td>
                                                        </c:if>
                                                        <c:if test="${item.status == 'CANCELED'}">
                                                            <td style="color: #ed5564;">Canceled</td>
                                                        </c:if>
                                                        <c:if test="${item.status == 'COMPLETED'}">
                                                            <td style="color: #0f59a5;">Completed</td>
                                                        </c:if>
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
        </form>
    </div>
</body>
</html>
