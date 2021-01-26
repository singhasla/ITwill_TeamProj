<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="userNo" value="${sessionScope.userNo}" />

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
<link rel="stylesheet" href="../css/font-awesome.min.css"
	type="text/css">
<link rel="stylesheet" href="../css/elegant-icons.css" type="text/css">
<link rel="stylesheet" href="../css/plyr.css" type="text/css">
<link rel="stylesheet" href="../css/nice-select.css" type="text/css">
<link rel="stylesheet" href="../css/owl.carousel.min.css"
	type="text/css">
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
						<h2>나의 찜 목록</h2>
					</div>
				</div>
				<div class="col-8">
					<table class="table table-hover">
						<thead>
							<p style="color: white;">${userID}님의 찜 목록에 담긴 상품입니다.</p>
							<tr style="color: white;">
								<th scope="col">#</th>
								<th width="15%" scope="col" style="text-align: center">영화</th>
								<th width="50%" scope="col">제목</th>
								<th width="20%" scope="col">가격</th>
								<th width="15%">
									<button>
										<a
											href="${contextPath}/wishsvlt/allDelWish.do?userNo=${userNo}">
											전체삭제 </a>
									</button>
								</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${myWishList == null}">
									<tr>
										<td colspan="5" align="center">찜 목록에 담긴 상품이 없습니다.</td>
									</tr>
								</c:when>

								<c:when test="${myWishList != null}">
									<c:forEach var="wishListInf" items="${myWishList}"
										varStatus="status">
										<tr class="hover" style="color: white;"
											onclick="location.href='${contextPath}/detailServlet/detail.do?movieNo=${wishListInf.movieNo}'">
											<td scope="row" style="vertical-align: middle">${status.index+1}</td>
											<td><img src="${wishListInf.movieImage}"
												class="cart_thumbnail" /></td>
											<td style="vertical-align: middle">${wishListInf.movieName}</td>
											<td style="vertical-align: middle"><fmt:formatNumber
													type="number" maxFractionDigits="3"
													value="${wishListInf.moviePrice}" /></td>
											<td style="vertical-align: middle; text-align: center;">
												<a class="icon_trash"
												href="${contextPath}/wishsvlt/delWish.do?userNo=${userNo}&movieNo=${wishListInf.movieNo}"></a>
											</td>
										</tr>
									</c:forEach>
								</c:when>
							</c:choose>
						</tbody>
					</table>
					<div class="col-12"></div>
				</div>
				
				<!-- 페이지번호 구간 -->
				<div class="col-12">
					<nav aria-label="Page navigation example">
						<ul class="pagination justify-content-center">

							<c:if test="${currentPage eq startPage}">
								<li class="page-item disabled"><a class="page-link"
									href="#" tabindex="-1" aria-disabled="true">Previous</a></li>
							</c:if>
							<c:if test="${currentPage ne startPage}">
								<li class="page-item"><a class="page-link"
									href="${contextPath}/wishsvlt/myWishList.do?movieNo=${wishListInf.movieNo}&pageNum=${currentPage-1}"
									tabindex="-1" aria-disabled="true">Previous</a></li>
							</c:if>

							<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
								<li class="page-item"><a class="page-link"
									href="${contextPath}/wishsvlt/myWishList.do?movieNo=${wishListInf.movieNo}&pageNum=${i}">${i}</a>
								</li>
							</c:forEach>

							<c:if test="${currentPage eq startPage}">
								<li class="page-item disabled"><a class="page-link"
									href="#">Next</a></li>
							</c:if>
							<c:if test="${currentPage ne startPage}">
								<li class="page-item"><a class="page-link"
									href="${contextPath}/wishsvlt/myWishList.do?movieNo=${wishListInf.movieNo}&pageNum=${currentPage+1}">Next</a>
								</li>
							</c:if>
						</ul>
					</nav>
				</div>
				<!-- 페이지번호 끝 -->
				
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