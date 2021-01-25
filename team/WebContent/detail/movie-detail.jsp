<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="detail" value="${DetailVO}" />
<c:set var="star" value="${star}" />

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
    <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Mulish:wght@300;400;500;600;700;800;900&display=swap"
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

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>


<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

	<!-- Header -->
	<jsp:include page="../inc/header.jsp" />
	
    <!-- Breadcrumb Begin -->
    <div class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb__links">
                        <a href="#"><i class="fa fa-home"></i> Home</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->

    <!-- movie-detail Section Begin -->
    <section class="anime-details spad">
        <div class="container">
            <div class="anime__details__content">
                <div class="row">
                    <div class="col-lg-3">
                        <div class="anime__details__pic set-bg" data-setbg="${detail.movieImage}">
                            <div class="comment"><i class="fa fa-comments"></i> 11</div>
                            <div class="view"><i class="fa fa-eye"></i>${detail.movieTime}</div>
                        </div>
                    </div>
                    <div class="col-lg-9">
                        <div class="anime__details__text">
                            <div class="anime__details__title">
                                <div>
                                	<h3>${detail.movieName}</h3>
                                </div>
                                <span>${detail.movieName}</span>
                            </div>
                            <div class="anime__details__rating">
                                <!-- 별점 -->
                                <span>평점 &nbsp; ${detail.movieAvgRating }</span>
                                <div class="rating">
 		   	                        <c:forEach var="i" begin="2" end="${star}" step="2">
 		   	                        	<a href="#"><i class="fa fa-star"></i></a>
 		   	                        </c:forEach>      
	   	                        	<c:if test="${star%2 >= 1}">
 	                                    <a href="#"><i class="fa fa-star-half-o"></i></a>
									</c:if>
                                </div>
                            </div>
                            <p>${detail.movieContent}
                            </p>
                            <div class="anime__details__widget">
                                <div class="row">
                                    <div class="col-lg-6 col-md-6">
                                        <ul>
                                        	<li><span>감독 :</span> ${detail.movieDirector}</li>
                                            <li><span>주연 :</span> ${detail.actorName}</li>
                                            <li><span>가격 :</span> ${detail.moviePrice}</li>
                                            
                                        </ul>
                                    </div>
                                    <div class="col-lg-6 col-md-6">
                                        <ul>
                                        	<li><span>장르 :</span> ${detail.CN1} &nbsp;&nbsp; ${detail.CN2}</li>
                                            <li><span>개봉일 :</span> ${detail.movieReleaseDate}</li>
                                            <li><span>상영시간 :</span> ${detail.movieTime}</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="anime__details__btn">
                                <a href="${contextPath}/ordersvlt/addCart.do?userNo=${userNo}&&movieNo=${detail.movieNo}" class="follow-btn">장바구니</a>
                               <%--  <a href="${contextPath}/detailServlet/watching.do?movieNo=${detail.movieNo}" class="watch-btn"><span>바로 보기</span> --%> 
                                	<i class="fa fa-angle-right"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col ">
                        <div class="anime__details__review">
                            <div class="section-title">
                                <h5>한줄 평</h5>
                            </div>
                            <div class="anime__review__item">
                                <div class="anime__review__item__text">
                                    <h6>아이디 -<span>작성시간</span></h6>
                                    <p>댓글작성 댓글내용 댓글작성 댓글내용 댓글작성 댓글내용 댓글작성 댓글내용</p>
                                </div>
                            </div>
                            <div class="anime__review__item">
                                <div class="anime__review__item__text">
                                    <h6>Lewis Mann - <span>5 Hour ago</span></h6>
                                    <p>Finally it came out ages ago</p>
                                </div>
                            </div>
                        </div>
                        <div class="anime__details__form">
                            <div class="section-title">
                                <h5>한줄평 남기기</h5>
                            </div>
                            <form action="#">
                                <textarea placeholder="주제와 무관한 댓글, 악플은 삭제될 수 있습니다."></textarea>
                                <button type="submit"><i class="fa fa-location-arrow"></i> 등록</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- movie-detail Section End -->
	

<!-- footer영역 -->
<jsp:include page="../inc/footer.jsp" />

</body>
</html>