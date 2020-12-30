<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                        <a href="#">장르</a>
                        <span>영화제목넣기</span>
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
                        <video id="player" playsinline controls data-poster="./videos/anime-watch.jpg">
                            <source src="../videos/1.mp4" type="video/mp4" />
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
		                        <div class="anime__details__pic set-bg" data-setbg="../img/anime/details-pic.jpg">
		                            <div class="comment"><i class="fa fa-comments"></i> 11</div>
		                            <div class="view"><i class="fa fa-eye"></i> 9141</div>
		                        </div>
		                    </div>
		                    <div class="col-lg-9">
		                        <div class="anime__details__text">
		                            <div class="anime__details__title">
		                                <h3>영화제목</h3>
		                                <span>TENET, 2020</span>
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
		                            <p>영화 줄거리 : 시간의 흐름을 뒤집는 인버전을 통해 현재와 미래를 오가며 세상을 파괴하려는 사토르(케네스 브래너)를 막기 위해 투입된 작전의 주도자(존 데이비드 워싱턴). 
		     							인버전에 대한 정보를 가진 닐(로버트 패틴슨)과 미술품 감정사이자 사토르에 대한 복수심이 가득한 그의 아내 캣(엘리자베스 데비키)과 협력해 미래의 공격에 맞서 제3차 세계대전을 막아야 한다!
		                            </p>
		                            <div class="anime__details__widget">
		                                <div class="row">
		                                    <div class="col-lg-6 col-md-6">
		                                        <ul>
		                                        	<li><span>감독 :</span> 감독이름</li>
		                                            <li><span>주연 :</span> 출연진</li>
		                                            <li><span>등급 :</span> n세 관람</li>
		                                            
		                                        </ul>
		                                    </div>
		                                    <div class="col-lg-6 col-md-6">
		                                        <ul>
		                                        	<li><span>장르 :</span> 액션, 모험</li>
		                                            <li><span>개봉일 :</span> 년도</li>
		                                            <li><span>상영시간 :</span> 시간</li>
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