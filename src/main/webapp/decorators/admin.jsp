<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<%@ page import="com.nqhtour.util.SecurityUtils" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Admin Home</title>

	<!-- Icons -->
	<link href="<c:url value='/template/admin/assets/img/basic/favicon.ico'/>" rel="stylesheet" type="image/x-icon">

	<!-- CSS-->
	<link href="<c:url value='/template/admin/assets/css/app.css'/>" rel="stylesheet" type="text/css">

	<!-- Custom styles for this template-->
	<link href="<c:url value='/template/admin/assets/css/mystyle.css'/>" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/template/signup/css/mystyle.css'/>">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
	<%-- <script src="<c:url value='/ckeditor/ckeditor.js' />"></script> --%>
	<!-- sweetalert -->
    <script src="<c:url value='/template/admin/sweetalert/sweetalert2.min.js' />"></script>
    <link rel="stylesheet" href="<c:url value='/template/admin/sweetalert/sweetalert2.min.css' />" />

	<style>
        .loader {
            position: fixed;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            background-color: #F5F8FA;
            z-index: 9998;
            text-align: center;
        }

        .plane-container {
            position: absolute;
            top: 50%;
            left: 50%;
        }
    </style>
    <!-- Js -->
    <!--
    --- Head Part - Use Jquery anywhere at page.
    --- http://writing.colin-gourlay.com/safely-using-ready-before-including-jquery/
    -->
    <script>(function(w,d,u){w.readyQ=[];w.bindReadyQ=[];function p(x,y){if(x=="ready"){w.bindReadyQ.push(y);}else{w.readyQ.push(x);}};var a={ready:p,bind:p};w.$=w.jQuery=function(f){if(f===d||f===u){return a}else{p(f)}}})(window,document)</script>
</head>
<body class="light">
	<%@ include file="/common/admin/header.jsp" %>
	
	<dec:body/>	

	<!--/#app -->
	
	<script src="<c:url value='/template/admin/assets/js/app.js'/>"></script>
	<script src="<c:url value='/template/paging/jquery.twbsPagination.js'/>" type="text/javascript"></script>	
	<!--
	--- Footer Part - Use Jquery anywhere at page.
	--- http://writing.colin-gourlay.com/safely-using-ready-before-including-jquery/
	-->
	<script>(function($,d){$.each(readyQ,function(i,f){$(f)});$.each(bindReadyQ,function(i,f){$(d).bind("ready",f)})})(jQuery,document)</script>
</body>
</html>