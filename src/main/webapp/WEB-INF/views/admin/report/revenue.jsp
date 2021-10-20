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
                            <i class="icon-package"></i> Revenue by month
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
            <div class="animated fadeInUpShort">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card no-b shadow">
                            <div class="card-body p-0">
                                <div class="table-responsive">
                                    <table class="table table-hover ">
                                        <thead>
                                            <tr class="no-b">
                                                <th></th>
                                                <th></th>
                                                <th id="title-report" style="font-weight: 400;font-size: 25px;">REVENUE (${month}/${year})</th>
                                                <th style="text-align: right;vertical-align: middle;"><input id="yearPicker" class="datepicker" style="width: 90px;border: 1px solid #cbcbcb;"></th>
                                            </tr>
                                        </thead>
                                        <thead style="background-color: #27ae60;color: #ffffff;">
                                            <tr class="no-b my-user-list">
                                                <th>TOUR</th>
                                                <th>No.Adult</th>
                                                <th>No.Children</th>
                                                <th>TOTAL</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="revenue" items="${revenues}">
                                                <tr class="no-b my-user-list">
                                                    <th style="font-weight: 400;">${revenue.tourName}</th>
                                                    <th style="font-weight: 400;">x${revenue.adultQuantity}</th>
                                                    <th style="font-weight: 400;">x${revenue.childrenQuantity}</th>
                                                    <th style="font-weight: 400;"><fmt:formatNumber value="${revenue.adultQuantity * revenue.adultPrice + revenue.childrenQuantity * revenue.childrenQuantity}" type="currency" currencySymbol=""/> VND</th>
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
    </div>

    <script>
        $(document).ready(function () {
            $(".datepicker").datepicker( {
                format: "mm/yyyy", // Notice the Extra space at the beginning
                viewMode: "months",
                minViewMode: "months"
            });

            $('#yearPicker').on('change', function() {
                const monthYear = document.querySelector('#yearPicker').value.split('/');
                console.log(monthYear);
                window.location.href = '/admin/report/revenue?month=' + monthYear[0] + '&year=' + monthYear[1];
            });

            const months = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];

            const transferNumberToMonth = (numberMonth) => {
                return months[numberMonth - 1];
            };
        });
    </script>
</body>
</html>
