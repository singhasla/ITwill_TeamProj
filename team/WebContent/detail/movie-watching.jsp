<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>    
<c:set var="detail" value="${DetailVO}" />
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
<title>Insert title here</title>
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
                        <a href="../main/index.jsp"><i class="fa fa-home"></i> Home</a>
                        <a href="#">Categories</a>
                        <span>${detail.CN1} &nbsp;&nbsp; ${detail.CN2}</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->

    <!-- movie-watching Section Begin -->
    <section class="anime-details spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="anime__video__player">
                        <video id="player">
                            <source src="${detail.movieLink}" type="video/mp4" />
                            <!-- Captions are optional -->
                            <track kind="captions" label="English captions" src="#" srclang="en" default />
                        </video>
                    </div>
                    <div class="anime__details__episodes">
                        <div class="section-title">
                            <h5>영화 정보</h5>
                        </div>
                     </div>   
		             <div class="anime__details__content">
		                <div class="row">
		                    <div class="col-lg-3">
		                        <div class="anime__details__pic set-bg" data-setbg="${detail.movieImage}">
		                            <div class="comment"><i class="fa fa-comments"></i> 11</div>
		                            <div class="view"><i class="fa fa-eye"></i> ${detail.movieTime}</div>
		                        </div>
		                    </div>
		                    <div class="col-lg-9">
		                        <div class="anime__details__text">
		                            <div class="anime__details__title">
		                                <h3>${detail.movieName}</h3>
		                            </div>
		                            <div class="anime__details__rating">
		                                <!-- 별점 -->
		                                <div class="rating">
		                                    <a href="#"><i class="fa fa-star"></i></a>
		                                    <a href="#"><i class="fa fa-star"></i></a>
		                                    <a href="#"><i class="fa fa-star"></i></a>
		                                    <a href="#"><i class="fa fa-star"></i></a>
		                                    <a href="#"><i class="fa fa-star-half-o"></i></a>
		                                </div>
		                                <span>투표자수 n명</span>
		                            </div>
		                            <p>${detail.movieContent}</p>
		                            <div class="anime__details__widget">
		                                <div class="row">
		                                    <div class="col-lg-6 col-md-6">
		                                        <ul>
		                                        	<li><span>감독 :</span> ${detail.movieDirector}</li>
		                                            <li><span>주연 :</span> ${detail.actorName}</li>
		                                            <li><span>등급 :</span> -</li>
		                                            
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
		                        </div>
		                    </div>
		                </div>
		            </div>   
                </div>
            </div>
        </div>
    </section>
    <!-- movie-watching Section End -->
	
	<!-- footer영역 -->
	<jsp:include page="../inc/footer.jsp" />

</body>
</html>