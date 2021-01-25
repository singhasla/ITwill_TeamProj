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
<title>main</title>
<!-- Google Font -->
<link href="https://fonts.googleapis.com/css2?family=Oswald:wght@300;400;500;600;700&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Mulish:wght@300;400;500;600;700;800;900&display=swap" rel="stylesheet">

<!-- Css Styles -->
<link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="../css/font-awesome.min.css" type="text/css">
<link rel="stylesheet" href="../css/elegant-icons.css" type="text/css">
<link rel="stylesheet" href="../css/plyr.css" type="text/css">
<link rel="stylesheet" href="../css/nice-select.css" type="text/css">
<link rel="stylesheet" href="../css/owl.carousel.min.css" type="text/css">
<link rel="stylesheet" href="../css/slicknav.min.css" type="text/css">
<link rel="stylesheet" href="../css/style.css" type="text/css">
<link rel="stylesheet" href="../css_Jo/style_Jo.css" type="text/css">

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
				<div class="hero__items set-bg" data-setbg="../img/hero/movie1.jpg">
					<div class="row">
						<div class="col-lg-6">
							<div class="hero__text">
								<div class="label">드라마</div>
								<h2>나이팅게일</h2>
								<p>샘 클라플린, 데이몬 헤리맨, 아이슬링 프란쵸시, ...</p>
								<a href="#"><span>Watch Now</span> <i
									class="fa fa-angle-right"></i></a>
							</div>
						</div>
					</div>
				</div>
				<div class="hero__items set-bg" data-setbg="../img/hero/movie2.jpg">
					<div class="row">
						<div class="col-lg-6">
							<div class="hero__text">
								<div class="label">범죄</div>
								<h2>도굴</h2>
								<p>이제훈, 조우진, 신혜선, 임원희, 송영창, 주진모</p>
								<a href="#"><span>Watch Now</span> <i
									class="fa fa-angle-right"></i></a>
							</div>
						</div>
					</div>
				</div>
				<div class="hero__items set-bg" data-setbg="../img/hero/movie3.jpg">
					<div class="row">
						<div class="col-lg-6">
							<div class="hero__text">
								<div class="label">액션</div>
								<h2>원더 우먼 1984</h2>
								<p>갤 가돗, 크리스 파인, 크리스틴 위그, 페드로 파...</p>
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
								<a href="#" class="primary-btn">View All <span
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
											<div class="ep">18 / 18</div>
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
								<a href="#" class="primary-btn">View All <span
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
											<div class="ep">18 / 18</div>
											<div class="comment">
												<i class="fa fa-comments"></i> 11
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

<!-- 
				액션/SF
				<div align="center">
					<div class="row">
						<div class="col-lg-8 col-md-8 col-sm-8">
							<div class="section-title">
								<h4>액션/SF</h4>
							</div>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-4">
							<div class="btn__all">
								<a href="#" class="primary-btn">View All <span
									class="arrow_right"></span></a>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-4 col-md-6 col-sm-6">
							<div class="product__item">
								<div class="product__item__pic set-bg"
									data-setbg="../img/trending/trend-1.jpg">
									<div class="ep">18 / 18</div>
									<div class="comment">
										<i class="fa fa-comments"></i> 11
									</div>
									<div class="view">
										<i class="fa fa-eye"></i> 9141
									</div>
								</div>
								<div class="product__item__text">
									<ul>
										<li>Active</li>
										<li>Movie</li>
									</ul>
									<h5>
										<a href="#">보루토1</a>
									</h5>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-6 col-sm-6">
							<div class="product__item">
								<div class="product__item__pic set-bg"
									data-setbg="../img/trending/trend-1.jpg">
									<div class="ep">18 / 18</div>
									<div class="comment">
										<i class="fa fa-comments"></i> 11
									</div>
									<div class="view">
										<i class="fa fa-eye"></i> 9141
									</div>
								</div>
								<div class="product__item__text">
									<ul>
										<li>Active</li>
										<li>Movie</li>
									</ul>
									<h5>
										<a href="#">보루토2</a>
									</h5>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-6 col-sm-6">
							<div class="product__item">
								<div class="product__item__pic set-bg"
									data-setbg="../img/trending/trend-1.jpg">
									<div class="ep">18 / 18</div>
									<div class="comment">
										<i class="fa fa-comments"></i> 11
									</div>
									<div class="view">
										<i class="fa fa-eye"></i> 9141
									</div>
								</div>
								<div class="product__item__text">
									<ul>
										<li>Active</li>
										<li>Movie</li>
									</ul>
									<h5>
										<a href="#">보루토3</a>
									</h5>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-6 col-sm-6">
							<div class="product__item">
								<div class="product__item__pic set-bg"
									data-setbg="../img/trending/trend-2.jpg">
									<div class="ep">18 / 18</div>
									<div class="comment">
										<i class="fa fa-comments"></i> 11
									</div>
									<div class="view">
										<i class="fa fa-eye"></i> 9141
									</div>
								</div>
								<div class="product__item__text">
									<ul>
										<li>Active</li>
										<li>Movie</li>
									</ul>
									<h5>
										<a href="#">보루토4</a>
									</h5>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-6 col-sm-6">
							<a href="../detail/movie-detail.jsp">
								<div class="product__item">
									<div class="product__item__pic set-bg"
										data-setbg="../img/trending/trend-3.jpg">
										<div class="ep">18 / 18</div>
										<div class="comment">
											<i class="fa fa-comments"></i> 11
										</div>
										<div class="view">
											<i class="fa fa-eye"></i> 9141
										</div>
									</div>
									<div class="product__item__text">
										<ul>
											<li>Active</li>
											<li>Movie</li>
										</ul>
										<h5>
											<a href="#">애니2</a>
										</h5>
									</div>
								</div>
							</a>
						</div>
						<div class="col-lg-4 col-md-6 col-sm-6">
							<div class="product__item">
								<div class="product__item__pic set-bg"
									data-setbg="../img/trending/trend-3.jpg">
									<div class="ep">18 / 18</div>
									<div class="comment">
										<i class="fa fa-comments"></i> 11
									</div>
									<div class="view">
										<i class="fa fa-eye"></i> 9141
									</div>
								</div>
								<div class="product__item__text">
									<ul>
										<li>Active</li>
										<li>Movie</li>
									</ul>
									<h5>
										<a href="#">보루토5</a>
									</h5>
								</div>
							</div>
						</div>
					</div>
				</div>

				코미디
				<div align="center">
					<div class="row">
						<div class="col-lg-8 col-md-8 col-sm-8">
							<div class="section-title">
								<h4>코미디</h4>
							</div>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-4">
							<div class="btn__all">
								<a href="#" class="primary-btn">View All <span
									class="arrow_right"></span></a>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-4 col-md-6 col-sm-6">
							<div class="product__item">
								<div class="product__item__pic set-bg"
									data-setbg="../img/trending/trend-1.jpg">
									<div class="ep">18 / 18</div>
									<div class="comment">
										<i class="fa fa-comments"></i> 11
									</div>
									<div class="view">
										<i class="fa fa-eye"></i> 9141
									</div>
								</div>
								<div class="product__item__text">
									<ul>
										<li>Active</li>
										<li>Movie</li>
									</ul>
									<h5>
										<a href="#">보루토1</a>
									</h5>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-6 col-sm-6">
							<a href="../detail/movie-detail.jsp">
								<div class="product__item">
									<div class="product__item__pic set-bg"
										data-setbg="../img/trending/trend-3.jpg">
										<div class="ep">18 / 18</div>
										<div class="comment">
											<i class="fa fa-comments"></i> 11
										</div>
										<div class="view">
											<i class="fa fa-eye"></i> 9141
										</div>
									</div>
									<div class="product__item__text">
										<ul>
											<li>Active</li>
											<li>Movie</li>
										</ul>
										<h5>
											<a href="#">애니2</a>
										</h5>
									</div>
								</div>
							</a>
						</div>
						<div class="col-lg-4 col-md-6 col-sm-6">
							<div class="product__item">
								<div class="product__item__pic set-bg"
									data-setbg="../img/trending/trend-1.jpg">
									<div class="ep">18 / 18</div>
									<div class="comment">
										<i class="fa fa-comments"></i> 11
									</div>
									<div class="view">
										<i class="fa fa-eye"></i> 9141
									</div>
								</div>
								<div class="product__item__text">
									<ul>
										<li>Active</li>
										<li>Movie</li>
									</ul>
									<h5>
										<a href="#">보루토2</a>
									</h5>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-6 col-sm-6">
							<div class="product__item">
								<div class="product__item__pic set-bg"
									data-setbg="../img/trending/trend-1.jpg">
									<div class="ep">18 / 18</div>
									<div class="comment">
										<i class="fa fa-comments"></i> 11
									</div>
									<div class="view">
										<i class="fa fa-eye"></i> 9141
									</div>
								</div>
								<div class="product__item__text">
									<ul>
										<li>Active</li>
										<li>Movie</li>
									</ul>
									<h5>
										<a href="#">보루토3</a>
									</h5>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-6 col-sm-6">
							<div class="product__item">
								<div class="product__item__pic set-bg"
									data-setbg="../img/trending/trend-2.jpg">
									<div class="ep">18 / 18</div>
									<div class="comment">
										<i class="fa fa-comments"></i> 11
									</div>
									<div class="view">
										<i class="fa fa-eye"></i> 9141
									</div>
								</div>
								<div class="product__item__text">
									<ul>
										<li>Active</li>
										<li>Movie</li>
									</ul>
									<h5>
										<a href="#">보루토4</a>
									</h5>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-6 col-sm-6">
							<div class="product__item">
								<div class="product__item__pic set-bg"
									data-setbg="../img/trending/trend-3.jpg">
									<div class="ep">18 / 18</div>
									<div class="comment">
										<i class="fa fa-comments"></i> 11
									</div>
									<div class="view">
										<i class="fa fa-eye"></i> 9141
									</div>
								</div>
								<div class="product__item__text">
									<ul>
										<li>Active</li>
										<li>Movie</li>
									</ul>
									<h5>
										<a href="#">보루토5</a>
									</h5>
								</div>
							</div>
						</div>
					</div>
				</div>


				로맨스/멜로
				<div align="center">
					<div class="row">
						<div class="col-lg-8 col-md-8 col-sm-8">
							<div class="section-title">
								<h4>로맨스/멜로</h4>
							</div>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-4">
							<div class="btn__all">
								<a href="#" class="primary-btn">View All <span
									class="arrow_right"></span></a>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-4 col-md-6 col-sm-6">
							<div class="product__item">
								<div class="product__item__pic set-bg"
									data-setbg="../img/trending/trend-1.jpg">
									<div class="ep">18 / 18</div>
									<div class="comment">
										<i class="fa fa-comments"></i> 11
									</div>
									<div class="view">
										<i class="fa fa-eye"></i> 9141
									</div>
								</div>
								<div class="product__item__text">
									<ul>
										<li>Active</li>
										<li>Movie</li>
									</ul>
									<h5>
										<a href="#">보루토1</a>
									</h5>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-6 col-sm-6">
							<a href="../detail/movie-detail.jsp">
								<div class="product__item">
									<div class="product__item__pic set-bg"
										data-setbg="../img/trending/trend-3.jpg">
										<div class="ep">18 / 18</div>
										<div class="comment">
											<i class="fa fa-comments"></i> 11
										</div>
										<div class="view">
											<i class="fa fa-eye"></i> 9141
										</div>
									</div>
									<div class="product__item__text">
										<ul>
											<li>Active</li>
											<li>Movie</li>
										</ul>
										<h5>
											<a href="#">애니2</a>
										</h5>
									</div>
								</div>
							</a>
						</div>
						<div class="col-lg-4 col-md-6 col-sm-6">
							<div class="product__item">
								<div class="product__item__pic set-bg"
									data-setbg="../img/trending/trend-1.jpg">
									<div class="ep">18 / 18</div>
									<div class="comment">
										<i class="fa fa-comments"></i> 11
									</div>
									<div class="view">
										<i class="fa fa-eye"></i> 9141
									</div>
								</div>
								<div class="product__item__text">
									<ul>
										<li>Active</li>
										<li>Movie</li>
									</ul>
									<h5>
										<a href="#">보루토2</a>
									</h5>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-6 col-sm-6">
							<div class="product__item">
								<div class="product__item__pic set-bg"
									data-setbg="../img/trending/trend-1.jpg">
									<div class="ep">18 / 18</div>
									<div class="comment">
										<i class="fa fa-comments"></i> 11
									</div>
									<div class="view">
										<i class="fa fa-eye"></i> 9141
									</div>
								</div>
								<div class="product__item__text">
									<ul>
										<li>Active</li>
										<li>Movie</li>
									</ul>
									<h5>
										<a href="#">보루토3</a>
									</h5>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-6 col-sm-6">
							<div class="product__item">
								<div class="product__item__pic set-bg"
									data-setbg="../img/trending/trend-2.jpg">
									<div class="ep">18 / 18</div>
									<div class="comment">
										<i class="fa fa-comments"></i> 11
									</div>
									<div class="view">
										<i class="fa fa-eye"></i> 9141
									</div>
								</div>
								<div class="product__item__text">
									<ul>
										<li>Active</li>
										<li>Movie</li>
									</ul>
									<h5>
										<a href="#">보루토4</a>
									</h5>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-6 col-sm-6">
							<div class="product__item">
								<div class="product__item__pic set-bg"
									data-setbg="../img/trending/trend-3.jpg">
									<div class="ep">18 / 18</div>
									<div class="comment">
										<i class="fa fa-comments"></i> 11
									</div>
									<div class="view">
										<i class="fa fa-eye"></i> 9141
									</div>
								</div>
								<div class="product__item__text">
									<ul>
										<li>Active</li>
										<li>Movie</li>
									</ul>
									<h5>
										<a href="#">보루토5</a>
									</h5>
								</div>
							</div>
						</div>
					</div>
				</div>


				공포/스릴러
				<div align="center">
					<div class="row">
						<div class="col-lg-8 col-md-8 col-sm-8">
							<div class="section-title">
								<h4>공포/스릴러</h4>
							</div>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-4">
							<div class="btn__all">
								<a href="#" class="primary-btn">View All <span
									class="arrow_right"></span></a>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-4 col-md-6 col-sm-6">
							<div class="product__item">
								<div class="product__item__pic set-bg"
									data-setbg="../img/trending/trend-1.jpg">
									<div class="ep">18 / 18</div>
									<div class="comment">
										<i class="fa fa-comments"></i> 11
									</div>
									<div class="view">
										<i class="fa fa-eye"></i> 9141
									</div>
								</div>
								<div class="product__item__text">
									<ul>
										<li>Active</li>
										<li>Movie</li>
									</ul>
									<h5>
										<a href="#">보루토1</a>
									</h5>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-6 col-sm-6">
							<a href="../detail/movie-detail.jsp">
								<div class="product__item">
									<div class="product__item__pic set-bg"
										data-setbg="../img/trending/trend-3.jpg">
										<div class="ep">18 / 18</div>
										<div class="comment">
											<i class="fa fa-comments"></i> 11
										</div>
										<div class="view">
											<i class="fa fa-eye"></i> 9141
										</div>
									</div>
									<div class="product__item__text">
										<ul>
											<li>Active</li>
											<li>Movie</li>
										</ul>
										<h5>
											<a href="#">애니2</a>
										</h5>
									</div>
								</div>
							</a>
						</div>
						<div class="col-lg-4 col-md-6 col-sm-6">
							<div class="product__item">
								<div class="product__item__pic set-bg"
									data-setbg="../img/trending/trend-1.jpg">
									<div class="ep">18 / 18</div>
									<div class="comment">
										<i class="fa fa-comments"></i> 11
									</div>
									<div class="view">
										<i class="fa fa-eye"></i> 9141
									</div>
								</div>
								<div class="product__item__text">
									<ul>
										<li>Active</li>
										<li>Movie</li>
									</ul>
									<h5>
										<a href="#">보루토2</a>
									</h5>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-6 col-sm-6">
							<div class="product__item">
								<div class="product__item__pic set-bg"
									data-setbg="../img/trending/trend-1.jpg">
									<div class="ep">18 / 18</div>
									<div class="comment">
										<i class="fa fa-comments"></i> 11
									</div>
									<div class="view">
										<i class="fa fa-eye"></i> 9141
									</div>
								</div>
								<div class="product__item__text">
									<ul>
										<li>Active</li>
										<li>Movie</li>
									</ul>
									<h5>
										<a href="#">보루토3</a>
									</h5>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-6 col-sm-6">
							<div class="product__item">
								<div class="product__item__pic set-bg"
									data-setbg="../img/trending/trend-2.jpg">
									<div class="ep">18 / 18</div>
									<div class="comment">
										<i class="fa fa-comments"></i> 11
									</div>
									<div class="view">
										<i class="fa fa-eye"></i> 9141
									</div>
								</div>
								<div class="product__item__text">
									<ul>
										<li>Active</li>
										<li>Movie</li>
									</ul>
									<h5>
										<a href="#">보루토4</a>
									</h5>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-6 col-sm-6">
							<div class="product__item">
								<div class="product__item__pic set-bg"
									data-setbg="../img/trending/trend-3.jpg">
									<div class="ep">18 / 18</div>
									<div class="comment">
										<i class="fa fa-comments"></i> 11
									</div>
									<div class="view">
										<i class="fa fa-eye"></i> 9141
									</div>
								</div>
								<div class="product__item__text">
									<ul>
										<li>Active</li>
										<li>Movie</li>
									</ul>
									<h5>
										<a href="#">보루토5</a>
									</h5>
								</div>
							</div>
						</div>
					</div>
				</div>

				애니메이션
				<div align="center">
					<div class="row">
						<div class="col-lg-8 col-md-8 col-sm-8">
							<div class="section-title">
								<h4>에니메이션</h4>
							</div>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-4">
							<div class="btn__all">
								<a href="#" class="primary-btn">View All <span
									class="arrow_right"></span></a>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-4 col-md-6 col-sm-6">
							<div class="product__item">
								<div class="product__item__pic set-bg"
									data-setbg="../img/trending/trend-1.jpg">
									<div class="ep">18 / 18</div>
									<div class="comment">
										<i class="fa fa-comments"></i> 11
									</div>
									<div class="view">
										<i class="fa fa-eye"></i> 9141
									</div>
								</div>
								<div class="product__item__text">
									<ul>
										<li>Active</li>
										<li>Movie</li>
									</ul>
									<h5>
										<a href="#">보루토1</a>
									</h5>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-6 col-sm-6">
							<a href="../detail/movie-detail.jsp">
								<div class="product__item">
									<div class="product__item__pic set-bg"
										data-setbg="../img/trending/trend-3.jpg">
										<div class="ep">18 / 18</div>
										<div class="comment">
											<i class="fa fa-comments"></i> 11
										</div>
										<div class="view">
											<i class="fa fa-eye"></i> 9141
										</div>
									</div>
									<div class="product__item__text">
										<ul>
											<li>Active</li>
											<li>Movie</li>
										</ul>
										<h5>
											<a href="#">애니2</a>
										</h5>
									</div>
								</div>
							</a>
						</div>
						<div class="col-lg-4 col-md-6 col-sm-6">
							<div class="product__item">
								<div class="product__item__pic set-bg"
									data-setbg="../img/trending/trend-1.jpg">
									<div class="ep">18 / 18</div>
									<div class="comment">
										<i class="fa fa-comments"></i> 11
									</div>
									<div class="view">
										<i class="fa fa-eye"></i> 9141
									</div>
								</div>
								<div class="product__item__text">
									<ul>
										<li>Active</li>
										<li>Movie</li>
									</ul>
									<h5>
										<a href="#">보루토2</a>
									</h5>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-6 col-sm-6">
							<div class="product__item">
								<div class="product__item__pic set-bg"
									data-setbg="../img/trending/trend-1.jpg">
									<div class="ep">18 / 18</div>
									<div class="comment">
										<i class="fa fa-comments"></i> 11
									</div>
									<div class="view">
										<i class="fa fa-eye"></i> 9141
									</div>
								</div>
								<div class="product__item__text">
									<ul>
										<li>Active</li>
										<li>Movie</li>
									</ul>
									<h5>
										<a href="#">보루토3</a>
									</h5>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-6 col-sm-6">
							<div class="product__item">
								<div class="product__item__pic set-bg"
									data-setbg="../img/trending/trend-2.jpg">
									<div class="ep">18 / 18</div>
									<div class="comment">
										<i class="fa fa-comments"></i> 11
									</div>
									<div class="view">
										<i class="fa fa-eye"></i> 9141
									</div>
								</div>
								<div class="product__item__text">
									<ul>
										<li>Active</li>
										<li>Movie</li>
									</ul>
									<h5>
										<a href="#">보루토4</a>
									</h5>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-6 col-sm-6">
							<div class="product__item">
								<div class="product__item__pic set-bg"
									data-setbg="../img/trending/trend-3.jpg">
									<div class="ep">18 / 18</div>
									<div class="comment">
										<i class="fa fa-comments"></i> 11
									</div>
									<div class="view">
										<i class="fa fa-eye"></i> 9141
									</div>
								</div>
								<div class="product__item__text">
									<ul>
										<li>Active</li>
										<li>Movie</li>
									</ul>
									<h5>
										<a href="#">보루토5</a>
									</h5>
								</div>
							</div>
						</div>
					</div>
				</div>
				애니메이션 끝
 -->				
				
			</div>
		</div>
	</section>
	<!-- Product Section End -->

	<jsp:include page="../inc/footer.jsp" />




</body>
</html>