<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.nqhtour.util.SecurityUtils"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NQHTOUR | Payment</title>
</head>
<body>
	<div class="row-pm" style="margin-top: 5rem; margin-bottom: 5rem;">
	  <div class="col-50-pm">
		<div class="container-pm" style="font-size:large">
		  <form action="/action_page.php">
		  
			<div class="row-pm">
			  <div class="col-50-pm">
				<h3>Payment</h3>
				<label for="fname">Accepted Cards</label>
				<div class="icon-container-pm">
				  <i class="fa fa-cc-visa" style="color:navy;"></i>
				  <i class="fa fa-cc-amex" style="color:blue;"></i>
				  <i class="fa fa-cc-mastercard" style="color:red;"></i>
				  <i class="fa fa-cc-discover" style="color:orange;"></i>
				</div>
				<label for="cname">Name on Card</label>
				<input type="text" class="input-pm" id="cname" name="cardname" placeholder="John More Doe">
				<label for="ccnum">Credit card number</label>
				<input type="text" class="input-pm" id="ccnum" name="cardnumber" placeholder="1111-2222-3333-4444">
				<div class="row-pm">
				  <div class="col-50-pm">
					<label for="expyear">Exp Year</label>
					<input type="text" class="input-pm" id="expyear" name="expyear" placeholder="2018">
				  </div>
				  <div class="col-50-pm">
					<label for="cvv">CVV</label>
					<input type="text" class="input-pm" id="cvv" name="cvv" placeholder="352">
				  </div>
				</div>
			  </div>
			</div>
			<security:authorize access = "isAuthenticated()">
					<p hidden id="emailClient"><%=SecurityUtils.getPrincipal().getFullName()%></p>
			</security:authorize>
			<input type="button" value="Payment" class="btn-pm" id="btn-payment">
		  </form>
		</div>
	  </div>
	  <div class="col-25-pm">
		<div class="container-pm" style="font-size:large">
		  <h4>Tour <span class="price" style="color:black"><i class="fa fa-shopping-cart"></i> <b>1</b></span></h4>
		  <img src="${pageContext.request.contextPath}/template/upload/tour/${model.imageCover}" alt="" style="height: 300px; border-radius: 15px; opacity: 0.8;">
		  <p>${model.name}<span class="price">${model.duration} days</span></p>
		  <hr>
		  <!-- <p>Total <span class="price" style="color:black"><b>$${model.price}</b></span></p> -->
		  <p>Total <span class="price" style="color:black"><b>$<fmt:formatNumber value="${model.price}" type="currency" currencySymbol=""/></b></span></p>
		</div>
	  </div>
	</div>
	
	<script>
		(function () {
			$('#btn-payment').click(function (e) {
				e.preventDefault();
				//var e = document.getElementById("emailClient");
				var email = $("#emailClient").text();
				var data = "{ \"email\": " + "\"" + email + "\"" + ", \"tourId\": " + ${model.id} + " }";
				booking(data);
				swal("Success!", "You paid for the tour!", "success").then((value) => {
					window.location.href = "/trang-chu";
				});
			});

			function booking(d) {
				$.ajax({
					url: '/api/client/booking',
					type: 'POST',
					contentType: 'text/plain',
					data: d,
					dataType: 'json',
					success: function (result) {
						if (result == "true") {
							console.log("Payment success!");
						}
					}
				});
			}
		}());
	</script>
</body>
</html>