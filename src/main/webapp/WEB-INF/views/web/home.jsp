<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.nqhtour.util.SecurityUtils"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html> 
<html>

<head>

<meta charset="UTF-8">

<title>Home Page</title>

</head>

<body>
	<header class="my-header">
		<!-- nav -->
		<div class="my-nav">
			<nav class="nav nav--tours">
				<a href="#" class="nav__el">All tours</a>
				<form class="nav__search">
					<button class="nav__search-btn">
						<svg>
							<use xlink:href="img/icons.svg#icon-search"></use>
						</svg>
					</button>
					<input
						type="text"
						placeholder="Search tours" class="nav__search-input" /> </form> </nav>
			<div class="header__logo">
				<img src="/template/web/img/logo-white.png" alt="Natours logo" />
			</div>
			<nav class="nav nav--user">
				<!--<a href="#" class="nav__el">My bookings</a>
				<a href="#" class="nav__el">
					<img src="img/user.jpg" alt="User photo" class="nav__user-img" />
					<span>QuangHoa</span>
				</a>-->

				<security:authorize access = "isAnonymous()">
					<a href="<c:url value='/login'/>" class="nav__el">Log in</a>
					<a href="<c:url value='/signup'/>" class="nav__el nav__el--cta">Sign up</a>
				</security:authorize>
				<security:authorize access = "isAuthenticated()">
					<a href="<c:url value='#'/>" class="nav__el">Welcome, <%=SecurityUtils.getPrincipal().getFullName()%></a>
					<a href="<c:url value='/logout'/>" class="nav__el nav__el--cta">Log out</a>
				</security:authorize>
			</nav>
		</div>

		<!-- Landing -->
		<div class="landing">
			<div class="hero-text-box">
				<p style="font-size: 3.5rem;">BOOK A TICKET AND JUST LEAVE.<br>CHOICES YOU MAKE.</p>
			</div>
			<div class="landing-img">
				<div class="slick-lide logo-landing"><img src="/template/web/img/landing1.jpg"></div>
				<div class="slick-lide logo-landing"><img src="/template/web/img/landing2.jpg"></div>
			</div>
		</div>
    </header>

		<div class="row pre-main">
			<div class="pre-main-logo">
				<img src="/template/web/img/logo-green-round.png" alt="Natours logo" style="position: relative;left: 100px;height: 170px;"/>
			</div>
			<div class="pre-main-text">
				<p>WE PROVIDE A NICE TOURS VIETNAM AND ASIA. WITH MORE THAN 15 YEARS EXPERIENCE IN THE TRAVEL INDUSTRY, NQHTOUR IS A POPULAR TRAVEL IN VIETNAM AND AROUND THE GLOBE. YOU ARE MORE COMFORTABLE WITH PRIVATE CAR AND GUIDES AS WELL AS SUPPORT SERVICE 24 HOURS PER DAY.</p>
			</div>
		</div>

    <!-- <section class="overview"> -->
    <main class="main">
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
    </main>
</body>

</html>