<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>NQHTour</title>

	<link href="https://fonts.googleapis.com/css?family=Lato:300,300i,700" rel="stylesheet" />
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;1,300;1,400&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

	<%-- Bootstrap --%>
	<link rel="stylesheet" type="text/css" href="<c:url value='/template/login/vendor/bootstrap/css/bootstrap.min.css'/>">

	<%-- CSS--%>
	<link rel="stylesheet" href="<c:url value='/template/web/css/style.css'/>" />
	<link rel="stylesheet" href="<c:url value='/template/web/css/mystyle.css'/>" />
	<link rel="shortcut icon" type="image/png" href="<c:url value='/template/web/img/favicon.png'/>" />

	<!-- JQuery -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

	<!-- sweetalert -->
    <script src="<c:url value='/template/admin/sweetalert/sweetalert2.min.js' />"></script>
    <link rel="stylesheet" href="<c:url value='/template/admin/sweetalert/sweetalert2.min.css' />" />
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>

	<%-- Mapbox--%>
	<script src='https://api.mapbox.com/mapbox-gl-js/v2.3.1/mapbox-gl.js'></script>
	<link href='https://api.mapbox.com/mapbox-gl-js/v2.3.1/mapbox-gl.css' rel='stylesheet' />

	<%-- DatetimePicker--%>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.css" integrity="sha512-bYPO5jmStZ9WI2602V2zaivdAnbAhtfzmxnEGh9RwtlI00I9s8ulGe4oBa5XxiC6tCITJH/QG70jswBhbLkxPw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.full.min.js" integrity="sha512-AIOTidJAcHBH2G/oZv9viEGXRqDNmfdPVPYOYKGy3fti0xIplnlgMHUGfuNRzC6FkzIo0iIxgFnr9RikFxK+sw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

<%--	&lt;%&ndash; Travelo Template &ndash;%&gt;--%>
<%--	<link rel="stylesheet" href="<c:url value='/template/web/travelo/css/owl.carousel.min.css' />" />--%>
<%--	<link rel="stylesheet" href="<c:url value='/template/web/travelo/css/magnific-popup.css' />" />--%>
<%--	<link rel="stylesheet" href="<c:url value='/template/web/travelo/css/themify-icons.css' />" />--%>
<%--	<link rel="stylesheet" href="<c:url value='/template/web/travelo/css/nice-select.css' />" />--%>
<%--	<link rel="stylesheet" href="<c:url value='/template/web/travelo/css/flaticon.css' />" />--%>
<%--	<link rel="stylesheet" href="<c:url value='/template/web/travelo/css/gijgo.css' />" />--%>
<%--	<link rel="stylesheet" href="<c:url value='/template/web/travelo/css/animate.css' />" />--%>
<%--	<link rel="stylesheet" href="<c:url value='/template/web/travelo/css/slick.css' />" />--%>
<%--	<link rel="stylesheet" href="<c:url value='/template/web/travelo/css/slicknav.css' />" />--%>
<%--	<link rel="stylesheet" href="<c:url value='/template/web/travelo/css/owl.carousel.min.css' />" />--%>
<%--	<link rel="stylesheet" href="<c:url value='/template/web/travelo/css/owl.carousel.min.css' />" />--%>
<%--	<link rel="stylesheet" href="<c:url value='/template/web/travelo/css/owl.carousel.min.css' />" />--%>
<%--	<link rel="stylesheet" href="<c:url value='/template/web/travelo/css/travelo-style.css' />" />--%>
<%--	<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css">--%>

</head>
<body>
	<!-- Navigation -->
	<%@ include file="/common/web/header.jsp" %>

	<dec:body/>

	<!-- Footer -->
	<%@ include file="/common/web/footer.jsp" %>

	<script src="https://js.stripe.com/v3/"></script>
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