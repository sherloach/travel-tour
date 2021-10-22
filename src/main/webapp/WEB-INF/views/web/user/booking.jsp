<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <section class="blog_area section-padding" style="background-color: #eef7f5;">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="blog_right_sidebar" style="box-shadow: 0 1.5rem 4rem rgb(0 0 0 / 10%);">
                        <aside class="single_sidebar_widget post_category_widget" style="background: #fbf9ff;padding: 30px;margin-bottom: 30px;font-size: 16px;">
                            <img src="/template/web/img/logo-green-round.png" style="margin-bottom: 20px; width: 80px;" alt="flag">
                            <p>Welcome</p>
                            <h4 class="widget_title" style="font-size: 20px;margin-bottom: 40px;">@gmail.com</h4>
                            <ul class="list cat-list" style="margin: 0px;padding: 0px;">
                                <li>
                                    <a href="#" class="d-flex">
                                        <p>My Account</p>
                                    </a>
                                </li>
                                <li>
                                    <a href="#" class="d-flex">
                                        <p>My Trips</p>
                                    </a>
                                </li>
                            </ul>
                        </aside>
                    </div>
                </div>
                <div class="col-lg-9 mb-5 mb-lg-0">
                    <div class="" style="box-shadow: 0 1.5rem 4rem rgb(0 0 0 / 10%);margin-bottom: 20px">
                        <div class="" style="background: #f9f9ff;padding: 20px 0px 20px 0px;">
                            <div class="table-head">
                                <div class="" style="margin-left: 30px; font-weight: bold;font-size: 16px;"><i style="font-size: 35px; vertical-align: middle; margin-right: 10px; color: #28b487" class="fa fa-map-marker" aria-hidden="true"></i>MY TRIPS</div>
                            </div>
                        </div>
                    </div>
                    <div class="" style="box-shadow: 0 1.5rem 4rem rgb(0 0 0 / 10%);">
                        <div class="progress-table" style="font-size: 16px;font-weight: 400;">
                            <div class="table-head" style="display: flex;justify-content: center;text-align: center;">
                                <div class="" style="width: 28.07%;color: #28b487;line-height: 40px;text-transform: uppercase;font-weight: 500;">Tour</div>
                                <div class="" style="width: 19.74%;color: #28b487;line-height: 40px;text-transform: uppercase;font-weight: 500;">Children</div>
                                <div class="" style="width: 19.74%;color: #28b487;line-height: 40px;text-transform: uppercase;font-weight: 500;">Adult</div>
                                <div class="" style="width: 19.74%;color: #28b487;line-height: 40px;text-transform: uppercase;font-weight: 500;">Destination</div>
                                <div class="" style="width: 11.83%;"></div>
                            </div>
                            <c:forEach var="booking" items="${client.bookings}" varStatus="loop">
                                <div class="table-row" style="text-align: center;justify-content: center;align-items: end;">
                                    <div class="" style="width: 28.07%;"> <img style="margin-right: 10px; width: 60px; border-radius: 5px" src="${pageContext.request.contextPath}/template/upload/tour/${booking.imageTour}" alt="flag">${booking.tourName}</div>
                                    <div class="" style="width: 19.74%"><p><fmt:formatNumber value="${booking.adultPrice}" type="currency"/>đ</p></div>
                                    <div class="" style="width: 19.74%"><p><fmt:formatNumber value="${booking.childrenPrice}" type="currency"/>đ</p></div>
                                    <div class="" style="width: 19.74%"><p>${booking.destination}</p></div>
                                    <div class="" style="width: 11.83%"><button tourId="${booking.tourId}" class="btnReview btn btn--green" style="padding: 5px 12px !important;font-size: 12px;position: relative;top: -10px;">Review</button></div>
                                </div>
                                <div class="table-row" style="text-align: center;justify-content: center;background: #eef5f2">
                                    <div class="" style="width: 28.07%">${booking.startDate}</div>
                                    <div class="" style="width: 19.74%">x${booking.adultQuantity}</div>
                                    <div class="" style="width: 19.74%">x${booking.childrenQuantity}</div>
                                    <c:if test="${booking.status == 'PENDING'}">
                                        <div class="" style="width: 19.74%; color: #f39c12">Pending</div>
                                    </c:if>
                                    <c:if test="${booking.status == 'APPROVED'}">
                                        <div class="" style="width: 19.74%; color: #27ae60">Approved</div>
                                    </c:if>
                                    <c:if test="${booking.status == 'CANCELED'}">
                                        <div class="" style="width: 19.74%; color: #ed5564">Canceled</div>
                                    </c:if>
                                    <div class="" style="width: 11.83%"></div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <div class="bg-modal">
        <div class="modal-contents" style="width: auto">
            <div class="close">+</div><br />
            <form action="">
                <div class="review-container">
                    <div class="post">
                        <div class="text">Thanks for rating us!</div>
                    </div>
                    <div class="star-widget">
                        <input id="rate-5" type="radio" name="rate" value="5" />
                        <label class="fa fa-star" for="rate-5"></label>
                        <input id="rate-4" type="radio" name="rate" value="4" />
                        <label class="fa fa-star" for="rate-4"></label>
                        <input id="rate-3" type="radio" name="rate" value="3" />
                        <label class="fa fa-star" for="rate-3"></label>
                        <input id="rate-2" type="radio" name="rate" value="2" />
                        <label class="fa fa-star" for="rate-2"></label>
                        <input id="rate-1" type="radio" name="rate" value="1" />
                        <label class="fa fa-star" for="rate-1"></label><br />
                        <div class="review-textarea">
                            <textarea class="reviewContent form__input" cols="30" placeholder="Describe your experience.."></textarea>
                            <button class="btn btn--green btn--small btnAddReview" style="margin-top: 20px">Post</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <script>
        let tourId;
        document.addEventListener("click", function (e) {
            const tourIdInput = e.target;

            if (tourIdInput.classList.contains('btnReview')) {
                document.querySelector('.bg-modal').style.display = "flex";
                console.log(tourIdInput);
                tourId = tourIdInput.getAttribute('tourId');
            }
        });

        document.querySelector('.close').addEventListener("click", function () {
            document.querySelector('.bg-modal').style.display = "none";
        });

        document.querySelector('.btnAddReview').addEventListener('click', e => {
            e.preventDefault();
            const rating = document.querySelector('input[name="rate"]:checked').value;
            const review = document.querySelector('.reviewContent').value;
            const data = { rating, review, tourId, clientId: ${client.id} };
            console.log(data);
            addReview(data);
        });

        function addReview(data) {
            $.ajax({
                url: '/api/review',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(data),
                success: function (result) {
                    window.location.href = "/tour?id=" + tourId;
                },
                error: function (error) {
                    console.log(error);
                }
            });
        }
    </script>
</body>
</html>
