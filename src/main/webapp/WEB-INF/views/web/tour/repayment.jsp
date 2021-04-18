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
<div class="re-payment-container">
    <div class="green-header" style="background-color: #27ae60; min-height: 25vh;"></div>
    <div class="info-container" style="position: relative; bottom: 5vh;min-height: 52vh;">
        <div class="re-payment-info" style="background: #ffffff; max-width: 60vw; min-height: 252px; margin: auto; border-radius: 4px; border-color: #eaeaea9d; border-style: solid;    border-width: thin;
    box-shadow: 0 2px 4px 0 rgb(27 27 27 / 20%);">
            <form:form id="formSubmit" role="form" modelAttribute="model">
                <div class="row-pm" style="margin: 20px;">
                    <div class="col-50-pm">
                        <p style="font-size: 20px; padding-bottom: 10px; font-weight: bold;">Tour Description</p>
                        <div class="row-pm" style="margin-bottom: 18px;">
                            <div class="col-50-pm">
                                <label class="lb-repayment" style="display: block; font-size: 17px; font-weight: bold;">Tour</label>
                                <img class="img-repayment" src="/template/web/img/flight.png" alt="Tour logo" style=" position: absolute;width: 33px;border-color: #c3c3c3;border-style: solid;border-width: thin;margin: 0px;padding: 2px;"/>
                                <form:input cssClass="form-control" path="name" required="required" cssStyle="width: 20vw; margin-left: 33px; padding-left: 10px; padding: 7px" disabled="true"/>
                            </div>
                            <div class="col-50-pm">
                                <label class="lb-repayment" style="display: block; font-size: 17px; font-weight: bold;">Location</label>
                                <img class="img-repayment" src="/template/web/img/location.png" alt="Location logo"  style=" position: absolute;width: 33px;border-color: #c3c3c3;border-style: solid;border-width: thin;margin: 0px;padding: 2px;"/>
                                <form:input cssClass="form-control" path="location" required="required" cssStyle="width: 20vw; margin-left: 33px; padding-left: 10px; padding: 7px" disabled="true"/>
                            </div>
                        </div>
                        <div class="row-pm" style="margin-bottom: 18px;">
                            <div class="col-50-pm">
                                <label class="lb-repayment" style="display: block; font-size: 17px; font-weight: bold;">Date</label>
                                <img class="img-repayment" src="/template/web/img/calendar.png" alt="Date logo"  style=" position: absolute;width: 33px;border-color: #c3c3c3;border-style: solid;border-width: thin;margin: 0px;padding: 2px;"/>
                                <form:input cssClass="form-control" path="startDate" required="required" cssStyle="width: 20vw; margin-left: 33px; padding-left: 10px; padding: 7px" disabled="true"/>
                            </div>
                            <div class="col-50-pm">
                                <label class="lb-repayment" style="display: block; font-size: 17px; font-weight: bold;">Duration</label>
                                <img class="img-repayment" src="/template/web/img/night-mode.png" alt="Duration logo"  style=" position: absolute;width: 33px;border-color: #c3c3c3;border-style: solid;border-width: thin;margin: 0px;padding: 2px;"/>
                                <form:input cssClass="form-control" path="duration" required="required" cssStyle="width: 20vw;margin-left: 33px; padding-left: 10px; padding: 7px" disabled="true"/>
                            </div>
                        </div>
                        <div class="row-pm" style="margin-bottom: 18px;">
                            <div class="col-50-pm">
                                <label class="lb-repayment" style="display: block; font-size: 17px; font-weight: bold;">Tickets</label>
                                <img class="img-repayment" src="/template/web/img/tickets.png" alt="Tickets logo"  style=" position: absolute;width: 33px;border-color: #c3c3c3;border-style: solid;border-width: thin;margin: 0px;padding: 2px;"/>
                                <input type="number" onkeydown="return false" min="1" class="input-pm" id="nuticket" name="nuticket" style="margin-bottom: 0; width: 20vw; margin-left: 33px; padding-left: 10px; padding: 8px ">
                                <p style="display: block">Hiện còn ${model.maxGroupSize - model.currentGroupSize} vé</p>
                            </div>
                            <div class="col-50-pm">
                                <input type="button" value="Payment" class="btn-pm" id="btn-payment" style="margin: 25px 0; padding: 8px; width: 22vw;">
                            </div>
                        </div>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</div>

<script>
    var ticketAvailable = ${model.maxGroupSize - model.currentGroupSize};
    document.getElementById("nuticket").max = ticketAvailable;

    var btnApply = document.getElementById("btn-payment");
    btnApply.addEventListener("click", function (event) {
        // TODO: change this code using JSON
        var idClient = ${model.id};
        //checkout(idClient);
        window.location.href = "/tour/checkout?id=" + ${model.id} + "&nuTickets=" + $("#nuticket").val();
    });

    function checkout(d) {
        $.ajax({
            url: '/api/client/tour',
            type: 'POST',
            contentType: 'text/plain',
            data: d,
            success: function (result) {
                if (result == "true") {
                    //window.location.href = "/tour/checkout?id=" + ${model.id};
                    window.location.href = "/tour/repayment?id=" + ${model.id};
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
