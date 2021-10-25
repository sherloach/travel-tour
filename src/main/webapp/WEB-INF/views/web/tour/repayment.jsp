<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Repayment</title>
</head>
<body>
    <div class="bradcam_area bradcam_bg_4" style="background-image: url('/template/web/img/tours/tour-5-1.jpg');background-size: cover;background-position: center center;padding: 50px 0;background-repeat: no-repeat;position: relative;z-index: 0;">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="bradcam_text text-center">
                        <h3 style="font-size: 80px;color: #fff;font-weight: 500;margin-bottom: 0;line-height: 90px;text-transform: capitalize;">Checkout</h3>
                        <p style="font-size: 18px;color: #fff;font-weight: 400;text-transform: capitalize;">Confirm your information and choose a method payment</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="d-none d-sm-block mb-5 pb-4" style="padding-top: 130px;">
            <div id="map" style="height: 480px; position: relative; overflow: hidden;"></div>
    <%--        <div id='map' style='width: 400px; height: 300px;'></div>--%>
        </div>
        <div class="row" style="margin-top: 0;">
            <div class="col-12">
                <h2 class="contact-title" style="font-size: 27px;font-weight: 600;margin-bottom: 20px;">Your Information</h2>
            </div>
            <div class="col-lg-8">

                <form class="form-contact contact_form" action="" id="contactForm">
                    <div class="row" style="margin-top: 0;margin-bottom: 0">
                        <div class="col-sm-6" style="padding-left: 0;">
                            <div class="form-group">
                                <input style="border: 1px solid #e5e6e9;height: 48px;padding-left: 18px;font-size: 13px;background: transparent;" class="form-control valid" name="name" id="name" type="text" readonly value="${client.name}" placeholder="Enter your name">
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group">
                                <input style="border: 1px solid #e5e6e9;height: 48px;padding-left: 18px;font-size: 13px;background: transparent;" class="form-control valid" name="email" id="email" type="email" readonly value="${client.email}" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter email address'" placeholder="Email">
                            </div>
                        </div>
                    </div>
                    <div class="row" style="margin-top: 0;margin-bottom: 0">
                        <div class="col-sm-6" style="padding-left: 0;">
                            <div class="form-group">
                                <input style="border: 1px solid #e5e6e9;height: 48px;padding-left: 18px;font-size: 13px;background: transparent;" class="form-control valid" name="phoneNumber" id="phoneNumber" readonly type="text" value="${client.phoneNumber}" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter email address'" placeholder="Email">
                            </div>
                        </div>
                    </div>
                    <div class="row" style="margin-top: 20px;margin-bottom: 20px;display: block;">
                        <label class="payment-container">Pay by Cash
                            <input id="radio-cash" type="radio" checked="checked" name="radio">
                            <span class="checkmark"></span>
                        </label>
                        <label class="payment-container">Pay with Visa
                            <input id="radio-visa" type="radio" name="radio">
                            <span class="checkmark"></span>
                        </label>
                    </div>
                    <div class="form-group mt-3">
                        <button type="submit" id="btnBooking" class="btn btn--green span-all-rows">Book</button>
                    </div>
                </form>
            </div>
            <div class="col-lg-3 offset-lg-1">
                <div class="media contact-info" style="margin-bottom: 25px;">
                    <span class="contact-info__icon" style="margin-right: 20px;"><i style="color: #8f9195;font-size: 27px;" class="fa fa-home"></i></span>
                    <div class="media-body">
                        <h3 style="font-size: 16px;color: #2a2a2a;">Quận 1, Hồ Chí Minh.</h3>
                        <p style="font-size: 16px;">DaKao, B1A 770</p>
                    </div>
                </div>
                <div class="media contact-info" style="margin-bottom: 25px;">
                    <span class="contact-info__icon" style="margin-right: 20px;"><i style="color: #8f9195;font-size: 27px;" class="fa fa-phone-square"></i></span>
                    <div class="media-body">
                        <h3 style="font-size: 16px;color: #2a2a2a;">+1 253 565 2365</h3>
                        <p style="font-size: 16px;">Mon to Fri 9am to 6pm</p>
                    </div>
                </div>
                <div class="media contact-info" style="margin-bottom: 25px;">
                    <span class="contact-info__icon" style="margin-right: 20px;"><i style="color: #8f9195;font-size: 27px;" class="fa fa-envelope-square"></i></span>
                    <div class="media-body">
                        <h3 style="font-size: 16px;color: #2a2a2a;">support@nqhtours.com</h3>
                        <p style="font-size: 16px;">Send us your query anytime!</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script>
        <%--var ticketAvailable = ${model.maxGroupSize - model.currentGroupSize};--%>
        <%--document.getElementById("nuticket").max = ticketAvailable;--%>
        const displayMap = () => {
            mapboxgl.accessToken = 'pk.eyJ1IjoibGVlc3NhbmciLCJhIjoiY2ttMGI5eXB0MnJ4bDJybXB6aDc4Y3dqcyJ9.pEaqr7h0A_Vl6idlG-Dx7g';
            const map = new mapboxgl.Map({
                container: 'map',
                style: 'mapbox://styles/mapbox/streets-v11',
                center: [106.7867, 10.8480],
                zoom: 14
            });

            // const bounds = new mapboxgl.LngLatBounds();
            const el = document.createElement('div');
            el.className = 'marker';

            new mapboxgl.Marker({
                element: el,
                anchor: 'bottom'
            }).setLngLat([106.7867, 10.8480]).addTo(map);

            new mapboxgl.Popup({
                closeOnClick: false,
                offset: 30
            }).setLngLat([106.7867, 10.8480]).setHTML("NQHTours").addTo(map);

            // bounds.extend([106.7867, 10.8480]);
            //
            // map.fitBounds(bounds, {
            //     padding: {
            //         top: 200,
            //         bottom: 150,
            //         left: 100,
            //         right: 100
            //     }
            // });
        };
        displayMap();

        document.getElementById('btnBooking').addEventListener('click', e => {
            e.preventDefault();
            const paid = document.getElementById('radio-cash').checked ? false : true;
            const data = {
                adultQuantity: ${adultQuantity},
                childrenQuantity: ${childrenQuantity},
                instourId: ${instour.id},
                clientId: ${client.id},
                paid
            };

            console.log(data);
            if (paid) {
                // STRIPE
                payByVisa(data);
            } else {
                payByCash(data);
            }
        });

        const payByCash = (data) => {
            $.ajax({
                url: '/api/booking',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(data),
                success: function (result) {
                    window.location.href = "/trang-chu";
                },
                error: function (error) {
                    window.location.href = "/trang-chu";
                }
            });
        };

        const payByVisa = (data) => {
            $.ajax({
                url: '/api/booking/checkout-session?instourid=' + data.instourId + '&clientid=' + data.clientId + '&tourid=' + ${tourId} + '&adultq=' + data.adultQuantity + '&childq=' + data.childrenQuantity,
                type: 'GET',
                contentType: 'text/plain',
                success: function (result) {
                    window.location.href = result;
                },
                error: function (error) {
                    window.location.href = "/trang-chu";
                }
            });
        };

        // $("#formSubmit").validate({
        //     rules: {
        //         nuticket: {
        //             required: true
        //         }
        //     },
        //
        //     messages: {
        //         nuticket: {
        //             required: "Please provide a number ticket!"
        //         }
        //     }
        // });

        <%--var btnApply = document.getElementById("btn-payment");--%>
        <%--btnApply.addEventListener("click", function (event) {--%>
        <%--    // TODO: change this code using JSON--%>
        <%--    var check = $('#formSubmit').valid();--%>
        <%--    if (check) {--%>
        <%--        var idClient = ${model.id};--%>
        <%--        //checkout(idClient);--%>
        <%--        window.location.href = "/tour/checkout?id=" + ${model.id} + "&nuTickets=" + $("#nuticket").val();--%>
        <%--    } else {--%>
        <%--        $('.error').css({ 'position' : 'initial', 'color' : 'red', '-webkit-transform': 'initial', 'max-width': 'initial', 'text-align': 'initial', 'transform': 'initial' });--%>
        <%--    }--%>
        <%--});--%>

        <%--function checkout(d) {--%>
        <%--    $.ajax({--%>
        <%--        url: '/api/client/tour',--%>
        <%--        type: 'POST',--%>
        <%--        contentType: 'text/plain',--%>
        <%--        data: d,--%>
        <%--        success: function (result) {--%>
        <%--            if (result == "true") {--%>
        <%--                //window.location.href = "/tour/checkout?id=" + ${model.id};--%>
        <%--                window.location.href = "/tour/repayment?id=" + ${model.id};--%>
        <%--            } else if (result == "false") {--%>
        <%--                swal("Warning!", "You paid for this tour!", "warning");--%>
        <%--            }--%>
        <%--        },--%>
        <%--        error: function (error) {--%>
        <%--            window.location.href = "/trang-chu";--%>
        <%--        }--%>
        <%--    });--%>
        <%--}--%>
    </script>

</body>
</html>
