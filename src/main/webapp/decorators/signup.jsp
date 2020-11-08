<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Sign Up</title>

	<!-- Icons font CSS-->
	<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/template/signup/vendor/mdi-font/css/material-design-iconic-font.min.css'/>">
	<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/template/signup/vendor/font-awesome-4.7/css/font-awesome.min.css'/>">
    <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i" rel="stylesheet">

    <!-- Vendor CSS-->
	<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/template/signup/vendor/select2/select2.min.css'/>">
	<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/template/signup/vendor/datepicker/daterangepicker.css'/>">

    <!-- Main CSS-->
	<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/template/signup/css/main.css'/>">
	<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/template/signup/css/mystyle.css'/>">

	<script src="<c:url value='/template/signup/vendor/jquery/jquery.min.js'/>"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
</head>
<body>
	<dec:body/>

	<!-- Jquery JS-->
    <!-- Vendor JS-->
	<script src="<c:url value='/template/signup/vendor/select2/select2.min.js'/>"></script>
	<script src="<c:url value='/template/signup/vendor/datepicker/moment.min.js'/>"></script>
	<script src="<c:url value='/template/signup/vendor/datepicker/daterangepicker.js'/>"></script>

    <!-- Main JS-->
	<script src="<c:url value='/template/signup/js/global.js'/>"></script>
</body>
</html>