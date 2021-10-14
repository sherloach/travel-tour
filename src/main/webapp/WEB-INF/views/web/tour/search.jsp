<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.nqhtour.util.SecurityUtils"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Tours</title>
</head>
<body>
<%--    <div class="vertical-nav bg-white" id="sidebar">--%>
<%--        <div class="py-4 px-3 mb-4 bg-light" style="padding-top: 7.5rem!important;">--%>
<%--            <div class="media d-flex align-items-center"><img src="/template/web/img/logo-green-round.png" alt="TravelTour" width="65" class="mr-3 rounded-circle img-thumbnail shadow-sm">--%>
<%--                <div class="media-body">--%>
<%--                    <h4 class="m-0">Booking Tour</h4>--%>
<%--                    <p class="font-weight-light text-muted mb-0">Perfect Agent</p>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>

<%--        <p class="text-gray font-weight-bold text-uppercase px-3 small pb-4 mb-0">TOURS</p>--%>

<%--        <ul class="flex-column bg-white mb-0 my-nav-general">--%>
<%--            <li class="nav-item">--%>
<%--                <a href="#" class="nav-link text-dark bg-light">--%>
<%--                    <i class="fa fa-compass mr-3 text-primary fa-fw"></i>--%>
<%--                    All Tours--%>
<%--                </a>--%>
<%--            </li>--%>
<%--            <li class="nav-item">--%>
<%--                <a href="#" class="nav-link text-dark">--%>
<%--                    <i class="fa fa-street-view mr-3 text-primary fa-fw"></i>--%>
<%--                    My Tours--%>
<%--                </a>--%>
<%--            </li>--%>
<%--        </ul>--%>

<%--        <p class="text-gray font-weight-bold text-uppercase px-3 small py-4 mb-0">USER</p>--%>

<%--        <ul class="flex-column bg-white mb-0 my-nav-general">--%>
<%--            <li class="nav-item">--%>
<%--                <a href="#" class="nav-link text-dark">--%>
<%--                    <i class="fa fa-user-circle mr-3 text-primary fa-fw"></i>--%>
<%--                    My Account--%>
<%--                </a>--%>
<%--            </li>--%>
<%--        </ul>--%>
<%--    </div>--%>
<%--    <!-- End vertical navbar -->--%>

<%--    <!-- Page content holder -->--%>
<%--    <div class="page-content p-5" id="content" style="margin-left: 20rem;">--%>
<%--        <!-- Toggle button -->--%>
<%--        <button id="sidebarCollapse" type="button" class="btn btn-light bg-white rounded-pill shadow-sm px-4 mb-4" style="margin-left: 5px"><i class="fa fa-bars mr-2"></i><small class="text-uppercase font-weight-bold">Toggle</small></button>--%>

<%--        <!-- Demo content -->--%>
<%--        <h4 class="display-4" style="margin-bottom: 10px">Searching: ${key}</h4>--%>
<%--        <div class="card-container" style="min-height: 40vh;">--%>
<%--            <c:forEach var="item" items="${model.listResult}">--%>
<%--                <div class="card">--%>
<%--                    <div class="card__header">--%>
<%--                        <div class="card__picture">--%>
<%--                            <div class="card__picture-overlay">&nbsp;</div>--%>
<%--                            <img src="${pageContext.request.contextPath}/template/upload/tour/${item.imageCover}" alt="Tour 1" class="card__picture-img" />--%>
<%--                        </div>--%>

<%--                        <h3 class="heading-tertirary">--%>
<%--                            <span>${item.name}</span>--%>
<%--                        </h3>--%>
<%--                    </div>--%>

<%--                    <div class="card__details">--%>
<%--                        <h4 class="card__sub-heading">${item.duration}-day tour</h4>--%>
<%--                        <p class="card__text">--%>
<%--                                ${item.summary}--%>
<%--                        </p>--%>
<%--                        <div class="card__data">--%>
<%--                            <svg class="card__icon">--%>
<%--                                <use xlink:href="img/icons.svg#icon-map-pin"></use>--%>
<%--                            </svg>--%>
<%--                            <span>${item.location}</span>--%>
<%--                        </div>--%>
<%--                        <div class="card__data">--%>
<%--                            <svg class="card__icon">--%>
<%--                                <use xlink:href="img/icons.svg#icon-calendar"></use>--%>
<%--                            </svg>--%>
<%--                            <span>--%>
<%--                                    ${item.startDate}--%>
<%--                            </span>--%>
<%--                        </div>--%>
<%--                        <div class="card__data">--%>
<%--                            <svg class="card__icon">--%>
<%--                                <use xlink:href="img/icons.svg#icon-flag"></use>--%>
<%--                            </svg>--%>
<%--                            <span>3 stops</span>--%>
<%--                        </div>--%>
<%--                        <div class="card__data">--%>
<%--                            <svg class="card__icon">--%>
<%--                                <use xlink:href="img/icons.svg#icon-user"></use>--%>
<%--                            </svg>--%>
<%--                            <span>${item.maxGroupSize} people</span>--%>
<%--                        </div>--%>
<%--                    </div>--%>

<%--                    <div class="card__footer">--%>
<%--                        <p>--%>
<%--                            <span class="card__footer-value">$<fmt:formatNumber value="${item.price}" type="currency" currencySymbol=""/></span>--%>
<%--                            <span class="card__footer-text">per person</span>--%>
<%--                        </p>--%>
<%--                        <p class="card__ratings">--%>
<%--                            <span class="card__footer-value">4.9</span>--%>
<%--                            <span class="card__footer-text">rating (21)</span>--%>
<%--                        </p>--%>

<%--                        <c:url var="TourDetailURL" value="/tour">--%>
<%--                            <c:param name="id" value="${item.id}"/>--%>
<%--                        </c:url>--%>
<%--                        <a href="${TourDetailURL}" class="btn btn--green btn--small">Details</a>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </c:forEach>--%>
<%--        </div>--%>

<%--    </div>--%>

<%--    <script>--%>
<%--        $(function() {--%>
<%--            // Sidebar toggle behavior--%>
<%--            $('#sidebarCollapse').on('click', function() {--%>
<%--                $('#sidebar, #content').toggleClass('active');--%>
<%--            });--%>
<%--        });--%>
<%--    </script>--%>

    <div class="bradcam_area bradcam_bg_4" style="background-image: url('/template/web/img/tours/tour-1-cover.jpg.jpg');background-size: cover;background-position: center center;padding: 50px 0;background-repeat: no-repeat;position: relative;z-index: 0;">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="bradcam_text text-center">
                        <h3 style="font-size: 80px;color: #fff;font-weight: 500;margin-bottom: 0;line-height: 90px;text-transform: capitalize;">Destinations</h3>
                        <p style="font-size: 18px;color: #fff;font-weight: 400;text-transform: capitalize;">Pixel Perfect Design With Awesome Contents</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="popular_places_area">
        <div class="container">
            <div class="row">
                <div class="col-lg-4">
                    <div class="filter_result_wrap">
                        <h3>Filter Result</h3>
                        <div class="filter_bordered">
                            <div class="filter_inner">
                                <div class="row" style="margin-top: 5px">
                                    <div class="col-lg-12">
                                        <div class="single_select">
                                            <select>
                                                <option data-display="Destination">Destination</option>
                                                <c:forEach var="route" items="${routes}">
                                                    <option value="${route.destination}">${route.destination}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-lg-12">
                                        <div class="single_select">
                                            <input class="nice-select" id="startDatetime" type="text" name="startDates" readonly>
                                        </div>
                                    </div>
                                    <div class="col-lg-12">
                                        <div class="range_slider_wrap">
                                            <span class="range">Prise range</span>
                                            <div id="slider-range"></div>
                                            <p>
                                                <input type="text" id="amount" readonly style="border:0; color:#7A838B; font-weight:400;">
                                            </p>
                                        </div>
                                    </div>
                                </div>


                            </div>

                            <div class="reset_btn">
                                <button class="boxed-btn4" type="submit">Reset</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-8">
                    <div class="row" style="margin-top: 40px">
                        <c:forEach var="item" items="${model}">
                            <div class="col-lg-6 col-md-6">
                                <div class="card">
                                    <div class="card__header">
                                        <div class="card__picture">
                                            <div class="card__picture-overlay">&nbsp;</div>
                                            <img src="${pageContext.request.contextPath}/template/upload/tour/${item.image}" alt="Tour 1" class="card__picture-img" />
                                        </div>

                                        <h3 class="heading-tertirary">
                                            <span style="line-height: 1.5">${item.name}</span>
                                        </h3>
                                    </div>

                                    <div class="card__details">
                                        <h4 class="card__sub-heading">${item.duration}-day tour</h4>
                                        <p class="card__text">
                                                ${item.summary}
                                        </p>
                                        <div class="card__data">
                                            <svg class="card__icon">
                                                <use xlink:href="/template/web/img/icons.svg#icon-map-pin"></use>
                                            </svg>
                                            <span>${item.destination}</span>
                                        </div>
                                        <div class="card__data">
                                            <svg class="card__icon">
                                                <use xlink:href="/template/web/img/icons.svg#icon-calendar"></use>
                                            </svg>
                                            <span>
                                                    ${item.instours.get(0).startDate}
                                            </span>
                                        </div>
                                        <div class="card__data">
                                            <svg class="card__icon">
                                                <use xlink:href="/template/web/img/icons.svg#icon-flag"></use>
                                            </svg>
                                            <span>3 stops</span>
                                        </div>
                                        <div class="card__data">
                                            <svg class="card__icon">
                                                <use xlink:href="/template/web/img/icons.svg#icon-user"></use>
                                            </svg>
                                            <span>${item.maxGroupSize} people</span>
                                        </div>
                                    </div>

                                    <div class="card__footer">
                                        <p>
                                            <span class="card__footer-value"><fmt:formatNumber value="${item.adultPrice}" type="currency" currencyCode="VND" /></span>
                                                <%--						<span class="card__footer-text">per person</span>--%>
                                        </p>
                                        <p class="card__ratings">
                                            <span class="card__footer-value">${item.ratingsAverage}/5</span>
                                            <span class="card__footer-text">rating (${item.ratingsQuantity})</span>
                                        </p>

                                        <c:url var="TourDetailURL" value="/tour">
                                            <c:param name="id" value="${item.id}"/>
                                        </c:url>
                                        <a href="${TourDetailURL}" class="btn btn--green btn--small">Details</a>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="<c:url value='/template/web/js/nice-select.min.js'/>"></script>
    <script src="<c:url value='/template/web/js/jquery-ui.min.js'/>"></script>
    <script>
        $( function() {
            $( "#slider-range" ).slider({
                range: true,
                min: 0,
                max: 600,
                values: [ 75, 300 ],
                slide: function( event, ui ) {
                    $( "#amount" ).val( "$" + ui.values[ 0 ] + " - $" + ui.values[ 1 ] );
                }
            });
            $( "#amount" ).val( "$" + $( "#slider-range" ).slider( "values", 0 ) +
                " - $" + $( "#slider-range" ).slider( "values", 1 ) );
        } );

        $('select').niceSelect();

        jQuery('#startDatetime').datetimepicker({
            timepicker:false,
            format:'m/d/Y',
            formatDate:'m/d/Y'
        });
    </script>
</body>
</html>
