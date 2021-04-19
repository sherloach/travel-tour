<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<meta charset="UTF-8">
	<title>NQHTour</title>

	<link href="https://fonts.googleapis.com/css?family=Lato:300,300i,700" rel="stylesheet" />

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link rel="stylesheet" href="<c:url value='/template/web/css/style.css'/>" />
	<link rel="stylesheet" href="<c:url value='/template/web/css/mystyle.css'/>" />
	<link rel="shortcut icon" type="image/png" href="<c:url value='/template/web/img/favicon.png'/>" />
</head>
<body>

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