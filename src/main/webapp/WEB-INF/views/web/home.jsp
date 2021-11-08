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
							<use xlink:href="/template/web/img/icons.svg#icon-search"></use>
						</svg>
					</button>
					<input
						type="text"
						placeholder="Search tours"
						class="nav__search-input"
						id="my_search_input"
						onkeypress="keyPressSearch(event)"/>
				</form>
			</nav>
			<div class="header__logo" style="margin-top: 14px">
				<img src="/template/web/img/logo-white.png" alt="NQH logo" />
			</div>
			<nav class="nav nav--user">
				<security:authorize access = "isAnonymous()">
					<a href="<c:url value='/login'/>" class="nav__el">Log in</a>
					<a href="<c:url value='/signup'/>" class="nav__el nav__el--cta">Sign up</a>
				</security:authorize>
				<security:authorize access = "isAuthenticated()">
					<a href="<c:url value='/me/booking'/>" class="nav__el">Welcome, <%=SecurityUtils.getPrincipal().getFullName()%></a>
					<a href="<c:url value='/logout'/>" class="nav__el nav__el--cta">Log out</a>
				</security:authorize>
			</nav>
		</div>

		<div class="my-header">
			<div class="hero-text-box">
				<h1>OUTDOORS
					<span class="sub-hero">IS WHERE LIFE HAPPENS</span>
				</h1>

				<a href="#" class="btn btn-full my-btn-hero">Discover our tours</a>
			</div>
		</div>
    </header>

	<section class="section-about">
		<div class="u-center-text u-margin-bottom-big">
			<h2 class="heading-secondary my-heading-about">Exciting tours for adventurous people</h2>
		</div>
		<div class="row" style="margin-right: auto; margin-left: auto">
			<div class="my-col-1-of-2">
				<h3 class="heading-tertiary u-margin-bottom-small">You're going to fall in love with nature</h3>
				<p class="paragraph">Lorem ipsum dolor sit amet consectetur adipisicing elit. Aperiam, ipsum sapiente aspernatur libero repellat quis consequatur
					ducimus quam nisi exercitationem omnis earum qui.</p>
				<h3 class="heading-tertiary u-margin-bottom-small">Live adventures like you never have before</h3>
				<p class="paragraph">Lorem ipsum dolor sit amet consectetur adipisicing elit. Asperiores nulla deserunt voluptatum nam.</p><a class="btn-text" href="#">Learn more →</a>
			</div>
			<div class="my-col-1-of-2">
				<div class="composition"><img style="width: 100%" src="/template/web/img/multi-tours2.PNG" alt="" /></div>
			</div>
		</div>
	</section>

	<div class="popular_destination_area">
		<div class="container">
			<div class="row justify-content-center" style="display: flex; flex-wrap: wrap">
				<div class="col-lg-6">
					<div class="section_title text-center mb_70">
						<h3 class="heading-secondary" style="font-size: 38px;padding-bottom: 7px;">Popular Destination</h3>
						<p style="font-size: 16px;
								color: #7A838B;
								line-height: 28px;
								margin-bottom: 0;
								font-weight: 400;">Suffered alteration in some form, by injected humour or good day randomised booth anim 8-bit hella wolf moon beard words.</p>
					</div>
				</div>
			</div>
			<div class="row">
				<c:forEach var="route" items="${routes}" varStatus="loop">
                    <div class="col-lg-4 col-md-6">
                        <div class="single_destination">
                            <div class="thumb">
                                <img src="/template/web/img/tours/route-${loop.index}.jpg" alt="">
                            </div>
                            <div class="content">
                                <p class="d-flex align-items-center">${route.destination} <a href="<c:url value='/tour/search?id=${route.id}'/>">  ${route.tourQuantity} Tours</a> </p>
                            </div>
                        </div>
                    </div>
				</c:forEach>
			</div>
		</div>
	</div>

    <main class="main">
		<div class="justify-content-center" style="display: flex; flex-wrap: wrap;padding-bottom: 10rem">
			<div class="col-lg-6">
				<div class="section_title text-center mb_70">
					<h3 class="heading-secondary" style="font-size: 38px;padding-bottom: 7px;">Popular Places</h3>
					<p style="font-size: 16px;
								color: #7A838B;
								line-height: 28px;
								margin-bottom: 0;
								font-weight: 400;">Suffered alteration in some form, by injected humour or good day randomised booth anim 8-bit hella wolf moon beard words.</p>
				</div>
			</div>
		</div>
      	<div class="card-container">
      	<c:forEach var="item" items="${model.listResult}">
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
						<span class="card__footer-value"><fmt:formatNumber value="${item.adultPrice}" type="currency" currencySymbol=""/> ₫</span>
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
      	</c:forEach>
      </div>
    </main>

	<script>
		function keyPressSearch(event) {
			event.keyCode;
			if (event.keyCode == 13 || event.which == 13) {
				event.preventDefault();
				var key = $('#my_search_input').val();
				window.location.href = "/tour/search?key="+key;
			}
		}
	</script>
</body>

</html>