<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Repayment</title>
</head>
<body>
<div class="re-payment-container">
    <div class="green-header" style="background-color: #27ae60; min-height: 25vh;"></div>
    <div class="info-container" style="position: relative; bottom: 5vh;min-height: 52vh;">
        <div class="re-payment-info" style="background: #ffffff; max-width: 70vw; min-height: 252px; margin: auto; border-radius: 4px; border-color: #eaeaea9d; border-style: solid;    border-width: thin;
    box-shadow: 0 2px 4px 0 rgb(27 27 27 / 20%);">
            <form action="/action_page.php">
                <div class="row-pm" style="margin: 20px;">
                    <div class="col-50-pm">
                        <p style="font-size: 20px; padding-bottom: 10px; font-weight: bold;">Tour Description</p>
                        <label>Tour</label>
                        <img src="/template/web/img/location.png" alt="Location logo" />
                        <p>Mien Tay Song Nuoc</p>
                        <div class="row-pm">
                            <div class="col-50-pm">
                                <label>Date</label>
                                <img src="/template/web/img/calendar.png" alt="Date logo" />
                                <p>11/11/2021 12:30pm</p>
                            </div>
                            <div class="col-50-pm">
                                <label>Duration</label>
                                <img src="/template/web/img/night-mode.png" alt="Duration logo" />
                                <p>4 days</p>
                            </div>
                        </div>
                        <div class="row-pm">
                            <div class="col-50-pm">
                                <label>Tickets</label>
                                <img src="/template/web/img/tickets.png" alt="Tickets logo" />
                                <input type="number" min="1" class="input-pm" id="nuticket" name="nuticket">
                            </div>
                            <div class="col-50-pm">
                                <input type="button" value="Payment" class="btn-pm" id="btn-payment" style="margin: 14px 0;">
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<script>
    document.getElementById("nuticket").max = 5 - 1;
</script>

</body>
</html>
