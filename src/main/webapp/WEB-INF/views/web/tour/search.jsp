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
    <div class="vertical-nav bg-white" id="sidebar">
        <div class="py-4 px-3 mb-4 bg-light" style="padding-top: 7.5rem!important;">
            <div class="media d-flex align-items-center"><img src="/template/web/img/logo-green-round.png" alt="TravelTour" width="65" class="mr-3 rounded-circle img-thumbnail shadow-sm">
                <div class="media-body">
                    <h4 class="m-0">Booking Tour</h4>
                    <p class="font-weight-light text-muted mb-0">Perfect Agent</p>
                </div>
            </div>
        </div>

        <p class="text-gray font-weight-bold text-uppercase px-3 small pb-4 mb-0">TOURS</p>

        <ul class="flex-column bg-white mb-0 my-nav-general">
            <li class="nav-item">
                <a href="#" class="nav-link text-dark bg-light">
                    <i class="fa fa-compass mr-3 text-primary fa-fw"></i>
                    All Tours
                </a>
            </li>
            <li class="nav-item">
                <a href="#" class="nav-link text-dark">
                    <i class="fa fa-street-view mr-3 text-primary fa-fw"></i>
                    My Tours
                </a>
            </li>
            <%--<li class="nav-item">
                <a href="#" class="nav-link text-dark font-italic">
                    <i class="fa fa-cubes mr-3 text-primary fa-fw"></i>
                    Services
                </a>
            </li>
            <li class="nav-item">
                <a href="#" class="nav-link text-dark font-italic">
                    <i class="fa fa-picture-o mr-3 text-primary fa-fw"></i>
                    Gallery
                </a>
            </li>--%>
        </ul>

        <p class="text-gray font-weight-bold text-uppercase px-3 small py-4 mb-0">USER</p>

        <ul class="flex-column bg-white mb-0 my-nav-general">
            <li class="nav-item">
                <a href="#" class="nav-link text-dark">
                    <i class="fa fa-user-circle mr-3 text-primary fa-fw"></i>
                    My Account
                </a>
            </li>
            <%--<li class="nav-item">
                <a href="#" class="nav-link text-dark font-italic">
                    <i class="fa fa-bar-chart mr-3 text-primary fa-fw"></i>
                    Bar charts
                </a>
            </li>
            <li class="nav-item">
                <a href="#" class="nav-link text-dark font-italic">
                    <i class="fa fa-pie-chart mr-3 text-primary fa-fw"></i>
                    Pie charts
                </a>
            </li>
            <li class="nav-item">
                <a href="#" class="nav-link text-dark font-italic">
                    <i class="fa fa-line-chart mr-3 text-primary fa-fw"></i>
                    Line charts
                </a>
            </li>--%>
        </ul>
    </div>
    <!-- End vertical navbar -->

    <!-- Page content holder -->
    <div class="page-content p-5" id="content">
        <!-- Toggle button -->
        <button id="sidebarCollapse" type="button" class="btn btn-light bg-white rounded-pill shadow-sm px-4 mb-4" style="margin-left: 5px"><i class="fa fa-bars mr-2"></i><small class="text-uppercase font-weight-bold">Toggle</small></button>

        <!-- Demo content -->
        <h3 class="display-4" style="margin-left: 10px; margin-bottom: 10px">Tìm kiếm: ${key}</h3>
        <div class="card-container">
            <c:forEach var="item" items="${model.listResult}">
                <div class="card">
                    <div class="card__header">
                        <div class="card__picture">
                            <div class="card__picture-overlay">&nbsp;</div>
                            <img src="${pageContext.request.contextPath}/template/upload/tour/${item.imageCover}" alt="Tour 1" class="card__picture-img" />
                        </div>

                        <h3 class="heading-tertirary">
                            <span>${item.name}</span>
                        </h3>
                    </div>

                    <div class="card__details">
                        <h4 class="card__sub-heading">${item.duration}-day tour</h4>
                        <p class="card__text">
                                ${item.summary}
                        </p>
                        <div class="card__data">
                            <svg class="card__icon">
                                <use xlink:href="img/icons.svg#icon-map-pin"></use>
                            </svg>
                            <span>${item.location}</span>
                        </div>
                        <div class="card__data">
                            <svg class="card__icon">
                                <use xlink:href="img/icons.svg#icon-calendar"></use>
                            </svg>
                            <span>
                                    ${item.startDate}
                            </span>
                        </div>
                        <div class="card__data">
                            <svg class="card__icon">
                                <use xlink:href="img/icons.svg#icon-flag"></use>
                            </svg>
                            <span>3 stops</span>
                        </div>
                        <div class="card__data">
                            <svg class="card__icon">
                                <use xlink:href="img/icons.svg#icon-user"></use>
                            </svg>
                            <span>${item.maxGroupSize} people</span>
                        </div>
                    </div>

                    <div class="card__footer">
                        <p>
                            <span class="card__footer-value">$<fmt:formatNumber value="${item.price}" type="currency" currencySymbol=""/></span>
                            <span class="card__footer-text">per person</span>
                        </p>
                        <p class="card__ratings">
                            <span class="card__footer-value">4.9</span>
                            <span class="card__footer-text">rating (21)</span>
                        </p>

                        <c:url var="TourDetailURL" value="/tour">
                            <c:param name="id" value="${item.id}"/>
                        </c:url>
                        <a href="${TourDetailURL}" class="btn btn--green btn--small">Details</a>
                    </div>
                </div>
            </c:forEach>
        </div>

    </div>

    <script>
        $(function() {
            // Sidebar toggle behavior
            $('#sidebarCollapse').on('click', function() {
                $('#sidebar, #content').toggleClass('active');
            });
        });
    </script>
</body>
</html>
