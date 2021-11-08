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
        <div class="tab-content pb-3" id="v-pills-tabContent">
            <!-- Today Tab Start-->
            <div class="tab-pane animated fadeInUpShort show active" id="v-pills-1">
                <div class="col-md-12">
                    <div class="card no-b my-3 shadow2">
                        <div class="card-header white no-b d-flex justify-content-between">
                            <h4>Monthly ${month}, ${year}</h4>
                        </div>
                        <div class="card-body pb-5 pl-5 pr-5">
                            <div class="tab-content">
                                <div class="tab-pane fade show active" id="w8-tab1" role="tabpanel" aria-labelledby="w8-tab1">
                                    <div class="my-2" style="height: 400px">
                                        <canvas
                                                data-chart="bar"
                                                data-dataset="[[
                                                        <c:forEach var="item" items="${numberTickets}">
                                                            ${item.adultQuantity},
                                                        </c:forEach>
                                                        ],[
                                                        <c:forEach var="item" items="${numberTickets}">
                                                            ${item.childrenQuantity},
                                                        </c:forEach>
                                                        ]]"
                                                data-labels="[
                                                        <c:forEach var="item" items="${numberTickets}">
                                                            '${item.tourName}',
                                                        </c:forEach>
                                                        ]"
                                                data-dataset-options="[
                                                        {
                                                            label: 'Adult',
                                                            backgroundColor: '#7986cb',
                                                            borderWidth: 0,
                                                        },
                                                        {
                                                             label: 'Children',
                                                             backgroundColor: '#88e2ff',
                                                             borderWidth: 0,
                                                         }
                                                        ]"
                                                data-options="{
                                                          legend: { display: true,},
                                                          scales: {
                                                               xAxes: [{
                                                                    stacked: true,
                                                                     barThickness:25,
                                                                     gridLines: {
                                                                        zeroLineColor: 'rgba(255,255,255,0.1)',
                                                                         color: 'rgba(255,255,255,0.1)',
                                                                         display: false,},
                                                                     }],
                                                               yAxes: [{
                                                                    stacked: true,
                                                                         gridLines: {
                                                                            zeroLineColor: 'rgba(255,255,255,0.1)',
                                                                            color: 'rgba(255,255,255,0.1)',
                                                                        }
                                                               }]
                                                          }
                                                    }"
                                        >
                                        </canvas>
                                    </div>
                                </div>
                            </div>
                        </div>
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
                                <table class="table table-hover ">
                                    <thead>
                                    <tr class="no-b">
                                        <th></th>
                                        <th id="title-report" style="font-weight: 400;font-size: 25px;">QUANTITY (${month}/${year})</th>
                                        <th>
                                            <select id="routeSelect" class="form-control" required="required">
                                                <option value="">Choose...</option>
                                                <c:forEach var="item" items="${routes}">
                                                    <option value="${item.id}">${item.destination}</option>
                                                </c:forEach>
                                            </select>
                                        </th>
                                        <th style="text-align: right;vertical-align: middle;"><input id="yearPicker" class="datepicker" autocomplete="off" style="width: 90px;border: 1px solid #cbcbcb;"></th>
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
                                    <c:forEach var="quantity" items="${numberTickets}">
                                        <tr class="no-b my-user-list">
                                            <th style="font-weight: 400;">${quantity.tourName}</th>
                                            <th style="font-weight: 400;">x${quantity.adultQuantity}</th>
                                            <th style="font-weight: 400;">x${quantity.childrenQuantity}</th>
                                            <th style="font-weight: 400;">${quantity.adultQuantity + quantity.childrenQuantity} people(s)</th>
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
            const destination = document.querySelector('#routeSelect');
            const routeId = destination.options[destination.selectedIndex].value;
            console.log(monthYear);
            window.location.href = '/admin/report/quantity?month=' + monthYear[0] + '&year=' + monthYear[1] + '&routeid=' + routeId;
        });

    });
</script>
</body>
</html>
