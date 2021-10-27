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
    <div class="bradcam_area bradcam_bg_4" style="background-image: url('/template/web/img/tours/tour-1-cover.jpg');background-size: cover;background-position: center center;padding: 50px 0;background-repeat: no-repeat;position: relative;z-index: 0;">
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
                                <div class="row" style="margin-top: 5px; margin-bottom: 10px">
                                    <div class="col-lg-12">
                                        <div class="single_select">
                                            <select id="selectRoute">
                                                <option value="">Destination</option>
                                                <c:forEach var="route" items="${routes}">
                                                    <option value="${route.id}">${route.destination}</option>
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
                                            <div id="slider-range" style="font-size: 13px"></div>
                                            <p>
                                                <input type="text" id="amount" readonly style="width: 100%;border:0; color:#7A838B; font-weight:400;background-color: transparent;font-size: 16px">
                                                <input id="minPriceHidden" type="hidden" value="">
                                                <input id="maxPriceHidden" type="hidden" value="">
                                            </p>
                                        </div>
                                    </div>
                                </div>


                            </div>

                            <div class="reset_btn">
                                <button id="btnReset" class="boxed-btn4" type="submit">Reset</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-8">
                    <div class="row" style="margin-top: 40px">
                        <c:forEach var="item" items="${model}">
                            <div class="col-lg-6 col-md-6" style="padding-bottom: 20px;}">
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
                                            <span class="card__footer-value"><fmt:formatNumber value="${item.adultPrice}" type="currency" /> ₫</span>
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
                max: 15000000,
                values: [ 750000, 3000000 ],
                slide: function( event, ui ) {
                    $( "#amount" ).val(ui.values[0].toLocaleString('en-US', { style: 'currency', currency: 'VND' }) + " - " + ui.values[1].toLocaleString('en-US', { style: 'currency', currency: 'VND' }) );
                    $('#minPriceHidden').val(ui.values[0]);
                    $('#maxPriceHidden').val(ui.values[1]);
                }
            });

            // initial
            $( "#amount" ).val("₫750,000 - ₫3,000,000");
            $('#minPriceHidden').val($( "#slider-range" ).slider( "values", 0 ));
            $('#maxPriceHidden').val($( "#slider-range" ).slider( "values", 1 ));
        });

        $('select').niceSelect();

        jQuery('#startDatetime').datetimepicker({
            timepicker:false,
            format:'m/d/Y',
            formatDate:'m/d/Y'
        });

        document.getElementById('btnReset').addEventListener('click', e => {
            const startDate = $('#startDatetime').val();
            const minPrice = $('#minPriceHidden').val();
            const maxPrice = $('#maxPriceHidden').val();
            const routeId = document.getElementById('selectRoute').options[document.getElementById('selectRoute').selectedIndex].value;
            console.log(routeId, minPrice, maxPrice, startDate);
            window.location.href = "/tour/search?id=" + routeId + "&min=" + minPrice + "&max=" + maxPrice + "&startdate=" + startDate;
        });
    </script>
</body>
</html>
