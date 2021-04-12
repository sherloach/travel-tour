<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.nqhtour.util.SecurityUtils"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NQHTOUR</title>
</head>
<body>
	<section class="section-header" style="background-image: url(${pageContext.request.contextPath}/template/upload/tour/${model.imageCover}); background-size: cover; background-position: center;">
      <div class="heading-box">
        <h1 class="heading-primary">
          <span>${model.name}</span>
        </h1>
        <div class="heading-box__group">
          <div class="heading-box__detail">
            <svg class="heading-box__icon">
              <use xlink:href="img/icons.svg#icon-clock"></use>
            </svg>
            <span class="heading-box__text">${model.duration} days</span>
          </div>
          <div class="heading-box__detail">
            <svg class="heading-box__icon">
              <use xlink:href="img/icons.svg#icon-map-pin"></use>
            </svg>
            <span class="heading-box__text">${model.location}</span>
          </div>
        </div>
      </div>
    </section>

    <section class="section-description">
      <div class="overview-box">
        <div>
          <div class="overview-box__group">
            <h2 class="heading-secondary ma-bt-lg">Quick facts</h2>
            <div class="overview-box__detail">
              <svg class="overview-box__icon">
                <use xlink:href="img/icons.svg#icon-calendar"></use>
              </svg>
              <span class="overview-box__label">Next date</span>
              <span class="overview-box__text">${model.startDate}</span>
            </div>
            <div class="overview-box__detail">
              <svg class="overview-box__icon">
                <use xlink:href="img/icons.svg#icon-trending-up"></use>
              </svg>
              <span class="overview-box__label">Difficulty</span>
              <span class="overview-box__text">Medium</span>
            </div>
            <div class="overview-box__detail">
              <svg class="overview-box__icon">
                <use xlink:href="img/icons.svg#icon-user"></use>
              </svg>
              <span class="overview-box__label">Participants</span>
              <span class="overview-box__text">${model.maxGroupSize} people</span>
            </div>
            <div class="overview-box__detail">
              <svg class="overview-box__icon">
                <use xlink:href="img/icons.svg#icon-star"></use>
              </svg>
              <span class="overview-box__label">Rating</span>
              <span class="overview-box__text">4.9 / 5</span>
            </div>
          </div>

          <div class="overview-box__group">
            <h2 class="heading-secondary ma-bt-lg">BOOKING NOW...</h2>

            <div class="overview-box__detail">
            </div>
          </div>
        </div>
      </div>

      <div class="description-box">
        <h2 class="heading-secondary ma-bt-lg">About ${model.name}</h2>
        <p class="description__text">
			${model.description}
		</p>
      </div>
    </section>

    <section class="section-pictures">
      <div class="picture-box">
        <img
          class="picture-box__img picture-box__img--1"
          src="img/tours/tour-5-1.jpg"
          alt="The Park Camper Tour 1"
        />
      </div>
      <div class="picture-box">
        <img
          class="picture-box__img picture-box__img--2"
          src="img/tours/tour-5-2.jpg"
          alt="The Park Camper Tour 1"
        />
      </div>
      <div class="picture-box">
        <img
          class="picture-box__img picture-box__img--3"
          src="img/tours/tour-5-3.jpg"
          alt="The Park Camper Tour 1"
        />
      </div>
    </section>

    <section class="section-reviews">
      <div class="reviews">
        <div class="reviews__card">
          <div class="reviews__avatar">
            <img
              src="/template/web/img/users/user-7.jpg"
              alt="Jim Brown"
              class="reviews__avatar-img"
            />
            <h6 class="reviews__user">Jim Brown</h6>
          </div>
          <p class="reviews__text">
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Cumque
            dignissimos sint quo commodi corrupti accusantium veniam saepe
            numquam.
          </p>
          <div class="reviews__rating">
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="img/icons.svg#icon-star"></use>
            </svg>
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="img/icons.svg#icon-star"></use>
            </svg>
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="img/icons.svg#icon-star"></use>
            </svg>
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="img/icons.svg#icon-star"></use>
            </svg>
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="img/icons.svg#icon-star"></use>
            </svg>
          </div>
        </div>

        <div class="reviews__card">
          <div class="reviews__avatar">
            <img
              src="/template/web/img/users/user-14.jpg"
              alt="Laura Wilson"
              class="reviews__avatar-img"
            />
            <h6 class="reviews__user">Laura Wilson</h6>
          </div>
          <p class="reviews__text">
            Veniam adipisci blanditiis, corporis sit magnam aperiam ad, fuga
            reiciendis provident deleniti cumque similique itaque animi,
            sapiente obcaecati beatae accusantium.
          </p>
          <div class="reviews__rating">
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="img/icons.svg#icon-star"></use>
            </svg>
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="img/icons.svg#icon-star"></use>
            </svg>
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="img/icons.svg#icon-star"></use>
            </svg>
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="img/icons.svg#icon-star"></use>
            </svg>
            <svg class="reviews__star reviews__star--inactive">
              <use xlink:href="img/icons.svg#icon-star"></use>
            </svg>
          </div>
        </div>

        <div class="reviews__card">
          <div class="reviews__avatar">
            <img
              src="/template/web/img/users/user-15.jpg"
              alt="Ben Hadley"
              class="reviews__avatar-img"
            />
            <h6 class="reviews__user">Ben Hadley</h6>
          </div>
          <p class="reviews__text">
            Debitis, nesciunt itaque! At quis officia natus. Suscipit,
            reprehenderit blanditiis mollitia distinctio ducimus porro tempore
            perspiciatis sunt vel.
          </p>
          <div class="reviews__rating">
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="img/icons.svg#icon-star"></use>
            </svg>
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="img/icons.svg#icon-star"></use>
            </svg>
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="img/icons.svg#icon-star"></use>
            </svg>
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="img/icons.svg#icon-star"></use>
            </svg>
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="img/icons.svg#icon-star"></use>
            </svg>
          </div>
        </div>

        <div class="reviews__card">
          <div class="reviews__avatar">
            <img
              src="/template/web/img/users/user-6.jpg"
              alt="Alexander Jones"
              class="reviews__avatar-img"
            />
            <h6 class="reviews__user">Alexander Jones</h6>
          </div>
          <p class="reviews__text">
            Quaerat laborum eveniet ut aut maiores doloribus mollitia aperiam
            quis praesentium sed inventore harum aliquam veritatis at adipisci
            ea assumenda!
          </p>
          <div class="reviews__rating">
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="img/icons.svg#icon-star"></use>
            </svg>
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="img/icons.svg#icon-star"></use>
            </svg>
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="img/icons.svg#icon-star"></use>
            </svg>
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="img/icons.svg#icon-star"></use>
            </svg>
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="img/icons.svg#icon-star"></use>
            </svg>
          </div>
        </div>

        <div class="reviews__card">
          <div class="reviews__avatar">
            <img
              src="/template/web/img/users/user-3.jpg"
              alt="Ayla Cornell"
              class="reviews__avatar-img"
            />
            <h6 class="reviews__user">Ayla Cornell</h6>
          </div>
          <p class="reviews__text">
            Perferendis quo aliquid iste quas laboriosam molestias illo est
            voluptatem odit ea. Vero placeat culpa provident dicta maiores!
          </p>
          <div class="reviews__rating">
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="img/icons.svg#icon-star"></use>
            </svg>
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="img/icons.svg#icon-star"></use>
            </svg>
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="img/icons.svg#icon-star"></use>
            </svg>
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="img/icons.svg#icon-star"></use>
            </svg>
            <svg class="reviews__star reviews__star--active">
              <use xlink:href="img/icons.svg#icon-star"></use>
            </svg>
          </div>
        </div>
      </div>
    </section>

    <section class="section-cta">
      <div class="cta">
        <div class="cta__img cta__img--logo">
          <img src="/template/web/img/logo-white.png" alt="Natours logo" class="" />
        </div>
        <img src="img/tour-5-2.jpg" alt="" class="cta__img cta__img--1" />
        <img src="img/tour-5-1.jpg" alt="" class="cta__img cta__img--2" />

        <div class="cta__content">
          <h2 class="heading-secondary">What are you waiting for?</h2>
          <p class="cta__text">
            ${model.duration} days. 1 adventure. Infinite memories. Make it yours today!
          </p>
          <!-- <button class="btn btn--green span-all-rows"><a href="">Book tour now!</a></button> -->
			<security:authorize access = "isAnonymous()">
				<a href="<c:url value='/login'/>" class="btn btn--green span-all-rows">Book tour now!</a>
			</security:authorize>
			<security:authorize access = "hasRole('CLIENT')">
				<%-- <c:param name="role" value="<%=SecurityUtils.getAuthorities()%>"/> --%>
				<%-- <c:if test="${role.contains("CLIENT")}"><a href="<c:url value='/tour/checkout?id=${model.id}'/>" class="btn btn--gr<%-- een span-all-rows">Book tour now!</a></c:if>  --%>
				<%-- <a href="<c:url value='/tour/checkout?id=${model.id}'/>" class="btn btn--green span-all-rows">Book tour now!</a> --%>
				<button id="btn-apply" class="btn btn--green span-all-rows">Book tour now!</button>
			</security:authorize>
        </div>
      </div>
    </section>
    
    <security:authorize access = "isAuthenticated()">
			<p hidden id="emailClient"><%=SecurityUtils.getPrincipal().getFullName()%></p>
	</security:authorize>

	<script>
		var btnApply = document.getElementById("btn-apply");
		btnApply.addEventListener("click", function (event) {
			var email = $("#emailClient").text();
			//var data = email + " " + ${model.id};
			// TODO: change this code using JSON
            var data = "{ \"email\": " + "\"" + email + "\"" + ", \"tourId\": " + ${model.id} + " }";
			check(data);
		});
		
		/*function check(d) {
			$.ajax({
				url: '/api/client/tour',
				type: 'POST',
				contentType: 'text/plain',
				data: d,
				success: function (result) {
					if (result == "true") {
						window.location.href = "/tour/checkout?id=" + ${model.id};
					} else if (result == "false") {
						swal("Warning!", "You paid for this tour!", "warning");
					}
				},
				error: function (error) {
					window.location.href = "/trang-chu";
				}
			});
		}*/

        function check(d) {
          $.ajax({
            url: '/api/client/tour',
            type: 'POST',
            contentType: 'text/plain',
            data: d,
            success: function (result) {
              if (result == "true") {
                window.location.href = "/tour/checkout?id=" + ${model.id};
              } else if (result == "false") {
                swal("Warning!", "You paid for this tour!", "warning");
              }
            },
            error: function (error) {
              window.location.href = "/trang-chu";
            }
          });
        }
	</script>
</body>
</html>