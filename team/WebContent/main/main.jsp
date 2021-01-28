<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="latestList" value="${latestList}" />
<c:set var="hotList" value="${hotList}" />
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
<title>Insert title here</title>
</head>


<body>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>

	<!-- Header -->
	<jsp:include page="../inc/header.jsp" />

	<!-- Hero Section Begin -->
	<section class="hero">
		<div class="container">
			<div class="hero__slider owl-carousel">
				<div class="hero__items set-bg" data-setbg="${contextPath}/img/hero/JJ.jpg" style="background-size: contain;">
					<div class="row">
						<div class="col-lg-6">
							<div class="hero__text">
								<div class="label">로맨스, 드라마</div>
								<h2>조제</h2>
								<p>한지민, 남주혁 外</p>
								<a href="#"><span>Watch Now</span> <i
									class="fa fa-angle-right"></i></a>
							</div>
						</div>
					</div>
				</div>
				<div class="hero__items set-bg" data-setbg="${contextPath}/img/hero/PARASITE.jpg" style="background-size: contain;">
					<div class="row">
						<div class="col-lg-6">
							<div class="hero__text">
								<div class="label">드라마, 스릴러</div>
								<h2>기생충</h2>
								<p>송강호, 이선균, 조여정 外</p>
								<a href="#"><span>Watch Now</span> <i
									class="fa fa-angle-right"></i></a>
							</div>
						</div>
					</div>
				</div>
				<div class="hero__items set-bg" data-setbg="${contextPath}/img/hero/NG.jpg" style="background-size: contain;">
					<div class="row">
						<div class="col-lg-6">
							<div class="hero__text">
								<div class="label">스릴러</div>
								<h2>나이팅게일</h2>
								<p>아이슬링 프란시오시, 베이칼리 가남바르, 샘 클라플린 外</p>
								<a href="#"><span>Watch Now</span> <i
									class="fa fa-angle-right"></i></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Hero Section End -->

	<!-- Product Section Begin -->
	<section class="product spad">
		<div class="container">
			<div class="row">

				<!-- 신작무비 -->
				<div align="center">
					<div class="row">
						<div class="col-lg-10 col-md-8 col-sm-8">
							<div class="section-title">
								<h4>최신 영화</h4>
							</div>
						</div>
						<div class="col-lg-2 col-md-4 col-sm-4">
							<div class="btn__all">
								<a href="${contextPath}/ctgrServlet/latestAll.do" class="primary-btn">View All <span
									class="arrow_right"></span></a>
							</div>
						</div>
					</div>
					<!-- 그림한칸 영역-->
					<div class="row">
						<c:forEach var="latest" items="${latestList}" end="5">
							<div class="col-lg-4 col-md-6 col-sm-6">
								<a href="${contextPath}/detailServlet/detail.do?movieNo=${latest.movieNo}">
									<div class="product__item">
										<div class="product__item__pic set-bg"
											data-setbg="${latest.movieImage}">
											<div class="comment">
												<i class="fa fa-comments"></i> 11
											</div>
											<div class="view">
												<i class="fa fa-eye"></i> ${latest.movieTime}
											</div>
										</div>
										<div class="product__item__text">
											<ul>
												<li>${latest.cn1}</li>
												<c:if test="${latest.cn2 != null}">
													<li>${latest.cn2}</li>
												</c:if>
											</ul>
											<h5>
												<a href="#">${latest.movieName}</a>
											</h5>
										</div>
									</div>
								</a>
							</div>
						</c:forEach>
					</div>
				</div>
				<!-- 신작무비 -->
						

				<!-- 베스트무비 -->
				<div align="center">
					<div class="row">
						<div class="col-lg-10 col-md-8 col-sm-8">
							<div class="section-title">
								<h4>인기 영화</h4>
							</div>
						</div>
						<div class="col-lg-2 col-md-4 col-sm-4">
							<div class="btn__all">
								<a href="${contextPath}/ctgrServlet/hotAll.do" class="primary-btn">View All <span
									class="arrow_right"></span></a>
							</div>
						</div>
					</div>
					<!-- 그림한칸 영역-->
					<div class="row">
						<c:forEach var="hot" items="${hotList}" end="5">
							<div class="col-lg-4 col-md-6 col-sm-6">
								<a href="${contextPath}/detailServlet/detail.do?movieNo=${hot.movieNo}">
									<div class="product__item">
										<div class="product__item__pic set-bg"
											data-setbg="${hot.movieImage}">
											<div class="comment">
												<i class="fa fa-comments"></i> 5
											</div>
											<div class="view">
												<i class="fa fa-eye"></i> ${hot.movieTime}
											</div>
										</div>
										<div class="product__item__text">
											<ul>
												<li>${hot.cn1}</li>
												<c:if test="${hot.cn2 != null}">
													<li>${hot.cn2}</li>
												</c:if>
											</ul>
											<h5>
												<a href="#">${hot.movieName}</a>
											</h5>
										</div>
									</div>
								</a>
							</div>
						</c:forEach>
					</div>
				</div>
				<!-- 베스트 무비 -->
			</div>
		</div>
	</section>
	<!-- Product Section End -->

	<jsp:include page="../inc/footer.jsp" />

</body>
</html>