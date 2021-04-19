<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>NQHTour</title>

	<link href="https://fonts.googleapis.com/css?family=Lato:300,300i,700" rel="stylesheet" />
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

	<link rel="stylesheet" type="text/css" href="<c:url value='/template/login/vendor/bootstrap/css/bootstrap.min.css'/>">

	<link rel="stylesheet" href="<c:url value='/template/web/css/style.css'/>" />
	<link rel="stylesheet" href="<c:url value='/template/web/css/mystyle.css'/>" />
	<link rel="shortcut icon" type="image/png" href="<c:url value='/template/web/img/favicon.png'/>" />

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<!-- sweetalert -->
    <script src="<c:url value='/template/admin/sweetalert/sweetalert2.min.js' />"></script>
    <link rel="stylesheet" href="<c:url value='/template/admin/sweetalert/sweetalert2.min.css' />" />
</head>
<body>
	<!-- Navigation -->
	<%@ include file="/common/web/header.jsp" %>

	<dec:body/>

	<!-- Footer -->
	<%@ include file="/common/web/footer.jsp" %>
</body>
</html>