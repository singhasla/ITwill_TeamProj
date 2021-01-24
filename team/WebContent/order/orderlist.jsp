<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="userNo" value="${sessionScope.userNo}"/>
<%--String userNo = (String)session.getAttribute("userNo"); --%>

<!DOCTYPE html>
<html lang="zxx">

<head>
<meta charset="UTF-8">
<meta name="description" content="Anime Template">
<meta name="keywords" content="Anime, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<title>Anime | Template</title>

	<!-- Google Font -->
	<link
		href="https://fonts.googleapis.com/css2?family=Oswald:wght@300;400;500;600;700&display=swap"
		rel="stylesheet">
	<link
		href="https://fonts.googleapis.com/css2?family=Mulish:wght@300;400;500;600;700;800;900&display=swap"
		rel="stylesheet">

	<!-- Css Styles -->
	<link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
	<link rel="stylesheet" href="../css/font-awesome.min.css" type="text/css">
	<link rel="stylesheet" href="../css/elegant-icons.css" type="text/css">
	<link rel="stylesheet" href="../css/plyr.css" type="text/css">
	<link rel="stylesheet" href="../css/nice-select.css" type="text/css">
	<link rel="stylesheet" href="../css/owl.carousel.min.css" type="text/css">
	<link rel="stylesheet" href="../css/slicknav.min.css" type="text/css">
	<link rel="stylesheet" href="../css/style.css" type="text/css">
	
	<style>
	
	.hover :hover {
		  color: #5CAAEF;
		}
		
	</style>
</head>

<body>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>

	<!-- Header Section Begin -->
	<jsp:include page="../inc/header.jsp" />
	<!-- Header End -->

	<!-- Blog Details Section Begin -->
	<section class="blog-details spad">
		<div class="container">
			<div class="row d-flex justify-content-center">
				<div class="col-12">
					<div class="blog__details__title">
						<h2>구매내역</h2>
					</div>
				</div>
				<div class="col-8">
					<table class="table table-hover">
						<thead>
							<p style="color: white;">${userID} 님이 구매하신 상품입니다.</p>
							<tr style="color: white;" >
								<th scope="col">#</th>
								<th width="20%" scope="col" style="text-align: center">영화</th>
								<th width="50%" scope="col">제목</th>
								<th width="15%" scope="col">시청하기</th>
								<th width="10%"scope="col" style="text-align: center">삭제</th>
							</tr>
						</thead>
						<tbody style="color: white;">
							<c:choose>
								<c:when test="${myOrderList == null}">
										<tr>
											<td colspan="5" align="center">구매하신 상품이 없습니다.</td>
										</tr>
								</c:when>
								
								<c:when test="${myOrderList != null}">
									<c:forEach var="orderListInf" items="${myOrderList}" varStatus="status">
										<tr class="hover">
											<td scope="row" style="vertical-align: middle">${status.index+1}</td>
											<td><img src="${orderListInf.movieImage}" class="cart_thumbnail"/></td>
											<td style="vertical-align: middle">${orderListInf.movieName}</td>
											<td style="vertical-align: middle">	
												<a href="${orderListInf.movieLink}">
													<img style="max-width: 80%" src="../img/playbutton.png" >
												</a>
												<!-- 나중에 상세보기페이지로 이동할 예정 -->
												<%-- <a href="${contextPath}/ordersvlt/xxxx.do?userNo=${userNo}&movieNo=${orderListInf.movieNo}"></div>
													<img src="../img/playbutton.png">
												</a> --%>
											</td>
											<td style="vertical-align: middle; text-align: center;">
												<a class="icon_trash" href="${contextPath}/ordersvlt/delOrder.do?userNo=${userNo}&movieNo=${orderListInf.movieNo}"></a>
											</td>
										</tr>
									</c:forEach>
								</c:when>
							</c:choose>
						</tbody>
					</table>
			</div>
		</div>
	</section>
	<!-- Blog Details Section End -->

	<!-- Footer Section Begin -->
	<jsp:include page="../inc/footer.jsp" />
	<!-- Footer Section End -->


	<!-- Js Plugins -->
	<script src="../js/jquery-3.3.1.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/player.js"></script>
	<script src="../js/jquery.nice-select.min.js"></script>
	<script src="../js/mixitup.min.js"></script>
	<script src="../js/jquery.slicknav.js"></script>
	<script src="../js/owl.carousel.min.js"></script>
	<script src="../js/main.js"></script>

</body>

</html>