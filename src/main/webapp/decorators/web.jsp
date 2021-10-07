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

	<link rel="stylesheet" type="text/css" href="<c:url value='/template/login/vendor/bootstrap/css/bootstrap.min.css'/>">

	<link rel="stylesheet" href="<c:url value='/template/web/css/style.css'/>" />
	<link rel="stylesheet" href="<c:url value='/template/web/css/mystyle.css'/>" />
	<link rel="shortcut icon" type="image/png" href="<c:url value='/template/web/img/favicon.png'/>" />

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<!-- sweetalert -->
    <script src="<c:url value='/template/admin/sweetalert/sweetalert2.min.js' />"></script>
    <link rel="stylesheet" href="<c:url value='/template/admin/sweetalert/sweetalert2.min.css' />" />
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
</head>
<body>
	<!-- Navigation -->
	<%@ include file="/common/web/header.jsp" %>

	<dec:body/>

	<!-- Footer -->
	<%@ include file="/common/web/footer.jsp" %>

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