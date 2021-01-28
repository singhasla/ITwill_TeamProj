<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zxx">
<head>
<meta charset="UTF-8">
<meta name="description" content="Anime Template">
<meta name="keywords" content="Anime, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>다본다MOVIE</title>

<!-- Google Font -->
<link href="https://fonts.googleapis.com/css2?family=Oswald:wght@300;400;500;600;700&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Mulish:wght@300;400;500;600;700;800;900&display=swap" rel="stylesheet">

<!-- Css Styles -->
<link rel="stylesheet" href="${contextPath}/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="${contextPath}/css/font-awesome.min.css" type="text/css">
<link rel="stylesheet" href="${contextPath}/css/elegant-icons.css" type="text/css">
<link rel="stylesheet" href="${contextPath}/css/plyr.css" type="text/css">
<link rel="stylesheet" href="${contextPath}/css/nice-select.css" type="text/css">
<link rel="stylesheet" href="${contextPath}/css/owl.carousel.min.css" type="text/css">
<link rel="stylesheet" href="${contextPath}/css/slicknav.min.css" type="text/css">
<link rel="stylesheet" href="${contextPath}/css/style.css" type="text/css">
<link rel="stylesheet" href="${contextPath}/css_Jo/style_Jo.css" type="text/css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>
	<jsp:forward page="mainServlet/main.do"/>
</body>
</html>