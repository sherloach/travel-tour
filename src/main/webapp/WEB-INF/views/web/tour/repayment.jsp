<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Repayment</title>
    <style>
        /*.img-repayment {
            position: absolute;
            width: 33px;
            border-color: #c3c3c3;
            border-style: solid;
            border-width: thin;
            margin: 0px;
            padding: 2px;
        }*/
    </style>

</head>
<body>
<%--<div class="re-payment-container">--%>
<%--    <div class="green-header" style="background-color: #27ae60; min-height: 25vh;"></div>--%>
<%--    <div class="info-container" style="position: relative; bottom: 5vh;min-height: 52vh;">--%>
<%--        <div class="re-payment-info" style="background: #ffffff; max-width: 60vw; min-height: 252px; margin: auto; border-radius: 4px; border-color: #eaeaea9d; border-style: solid;    border-width: thin;--%>
<%--    box-shadow: 0 2px 4px 0 rgb(27 27 27 / 20%);">--%>
<%--            <form:form id="formSubmit" role="form" modelAttribute="model">--%>
<%--                <div class="row-pm" style="margin: 20px;">--%>
<%--                    <div class="col-50-pm">--%>
<%--                        <p style="font-size: 20px; padding-bottom: 10px; font-weight: bold;">Tour Description</p>--%>
<%--                        <div class="row-pm" style="margin-bottom: 18px;">--%>
<%--                            <div class="col-50-pm">--%>
<%--                                <label class="lb-repayment" style="display: block; font-size: 17px; font-weight: bold;">Tour</label>--%>
<%--                                <img class="img-repayment" src="/template/web/img/flight.png" alt="Tour logo" style=" position: absolute;width: 33px;border-color: #c3c3c3;border-style: solid;border-width: thin;margin: 0px;padding: 2px;"/>--%>
<%--                                <form:input cssClass="form-control" path="name" required="required" cssStyle="width: 20vw; margin-left: 33px; padding-left: 10px; padding: 7px; font-size: 15px;" disabled="true"/>--%>
<%--                            </div>--%>
<%--                            <div class="col-50-pm">--%>
<%--                                <label class="lb-repayment" style="display: block; font-size: 17px; font-weight: bold;">Location</label>--%>
<%--                                <img class="img-repayment" src="/template/web/img/location.png" alt="Location logo"  style=" position: absolute;width: 33px;border-color: #c3c3c3;border-style: solid;border-width: thin;margin: 0px;padding: 2px;"/>--%>
<%--                                <form:input cssClass="form-control" path="location" required="required" cssStyle="width: 20vw; margin-left: 33px; padding-left: 10px; padding: 7px; font-size: 15px;" disabled="true"/>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <div class="row-pm" style="margin-bottom: 18px;">--%>
<%--                            <div class="col-50-pm">--%>
<%--                                <label class="lb-repayment" style="display: block; font-size: 17px; font-weight: bold;">Date</label>--%>
<%--                                <img class="img-repayment" src="/template/web/img/calendar.png" alt="Date logo"  style=" position: absolute;width: 33px;border-color: #c3c3c3;border-style: solid;border-width: thin;margin: 0px;padding: 2px;"/>--%>
<%--                                <form:input cssClass="form-control" path="startDate" required="required" cssStyle="width: 20vw; margin-left: 33px; padding-left: 10px; padding: 7px; font-size: 15px;" disabled="true"/>--%>
<%--                            </div>--%>
<%--                            <div class="col-50-pm">--%>
<%--                                <label class="lb-repayment" style="display: block; font-size: 17px; font-weight: bold;">Duration</label>--%>
<%--                                <img class="img-repayment" src="/template/web/img/night-mode.png" alt="Duration logo"  style=" position: absolute;width: 33px;border-color: #c3c3c3;border-style: solid;border-width: thin;margin: 0px;padding: 2px;"/>--%>
<%--                                <form:input cssClass="form-control" path="duration" required="required" cssStyle="width: 20vw;margin-left: 33px; padding-left: 10px; padding: 7px; font-size: 15px;" disabled="true"/>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <div class="row-pm" style="margin-bottom: 18px;">--%>
<%--                            <div class="col-50-pm">--%>
<%--                                <label class="lb-repayment" style="display: block; font-size: 17px; font-weight: bold;">Tickets</label>--%>
<%--                                <img class="img-repayment" src="/template/web/img/tickets.png" alt="Tickets logo"  style=" position: absolute;width: 33px;border-color: #c3c3c3;border-style: solid;border-width: thin;margin: 0px;padding: 2px;"/>--%>
<%--                                <input type="number" onkeydown="return false" required min="1" class="input-pm" id="nuticket" name="nuticket" style="margin-bottom: 0; width: 20vw; margin-left: 33px; padding-left: 10px; padding: 8px ">--%>
<%--                                <p style="display: block">Hiện còn ${model.maxGroupSize - model.currentGroupSize} vé</p>--%>
<%--                            </div>--%>
<%--                            <div class="col-50-pm">--%>
<%--                                <input type="button" value="Payment" class="btn-pm" id="btn-payment" style="margin: 25px 0; padding: 8px; width: 22vw;">--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </form:form>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

<div class="container">
    <div class="d-none d-sm-block mb-5 pb-4" style="padding-top: 130px;">
        <div id="map" style="height: 480px; position: relative; overflow: hidden;"></div>
<%--        <div id='map' style='width: 400px; height: 300px;'></div>--%>
    </div>
    <div class="row" style="margin-top: 0;">
        <div class="col-12">
            <h2 class="contact-title">Confirm Your Information</h2>
        </div>
        <div class="col-lg-8">

            <form class="form-contact contact_form" action="" id="contactForm">
                <div class="row" style="margin-top: 0;margin-bottom: 0">
                    <div class="col-sm-6" style="padding-left: 0;">
                        <div class="form-group">
                            <input style="font-size: 1.5rem" class="form-control valid" name="name" id="name" type="text" readonly value="${client.name}" placeholder="Enter your name">
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="form-group">
                            <input style="font-size: 1.5rem" class="form-control valid" name="email" id="email" type="email" readonly value="${client.email}" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter email address'" placeholder="Email">
                        </div>
                    </div>
                </div>
                <div class="row" style="margin-top: 0;margin-bottom: 0">
                    <div class="col-sm-6" style="padding-left: 0;">
                        <div class="form-group">
                            <input style="font-size: 1.5rem" class="form-control valid" name="phoneNumber" id="phoneNumber" readonly type="text" value="${client.phoneNumber}" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter email address'" placeholder="Email">
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
            <div class="media contact-info">
                <span class="contact-info__icon"><i class="ti-home"></i></span>
                <div class="media-body">
                    <h3>Quận 1, Hồ Chí Minh.</h3>
                    <p>DaKao, B1A 770</p>
                </div>
            </div>
            <div class="media contact-info">
                <span class="contact-info__icon"><i class="ti-tablet"></i></span>
                <div class="media-body">
                    <h3>+1 253 565 2365</h3>
                    <p>Mon to Fri 9am to 6pm</p>
                </div>
            </div>
            <div class="media contact-info">
                <span class="contact-info__icon"><i class="ti-email"></i></span>
                <div class="media-body">
                    <h3>support@nqhtours.com</h3>
                    <p>Send us your query anytime!</p>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    <%--var ticketAvailable = ${model.maxGroupSize - model.currentGroupSize};--%>
    <%--document.getElementById("nuticket").max = ticketAvailable;--%>

    mapboxgl.accessToken = 'pk.eyJ1IjoibGVlc3NhbmciLCJhIjoiY2ttMGI5eXB0MnJ4bDJybXB6aDc4Y3dqcyJ9.pEaqr7h0A_Vl6idlG-Dx7g';
    const map = new mapboxgl.Map({
        container: 'map',
        style: 'mapbox://styles/mapbox/light-v10',
    });

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
