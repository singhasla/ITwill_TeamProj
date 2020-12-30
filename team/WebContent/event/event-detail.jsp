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
	
	    <!-- Event-Details Section Begin -->
	    <section class="blog-details spad">
	        <div class="container">
	            <div class="row d-flex justify-content-center">
	                <div class="col-lg-8">
	                    <div class="blog__details__title">
	                        <h6>이벤트카테고리 <span>이벤트날짜</span></h6>
	                        <h2>이벤트명</h2>
	                    </div>
	                </div>
	                <div class="col-lg-12">
	                    <div class="blog__details__pic">
	                        <img src="../img/blog/details/blog-details-pic.jpg" alt="">
	                    </div>
	                </div>
                <div class="col-lg-8">
                    <div class="blog__details__content">
                        <div class="blog__details__text">
                            <p>11이벤트 설정</p>
                        </div>
                        <div class="blog__details__item__text">
                            <h4>이벤트명</h4>
                            <img src="../img/blog/details/bd-item-1.jpg" alt="">
                            <p>이벤트 설명</p>
                        </div>
                        <div class="blog__details__tags">
                            <a href="#">태그1</a>
                            <a href="#">태그2</a>
                            <a href="#">태그3</a>
                        </div>
                        <div class="blog__details__btns">
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="blog__details__btns__item">
                                        <h5><a href="#"><span class="arrow_left"></span>이전페이지</a>
                                        </h5>
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="blog__details__btns__item next__btn">
                                        <h5><a href="#">다음페이지<span class="arrow_right"></span></a></h5>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="blog__details__comment">
                                <h4>댓글수</h4>
                                <div class="blog__details__comment__item">
                                    <div class="blog__details__comment__item__text">
                                        <span>댓글날짜</span>
                                        <h5>아이디</h5>
                                        <p>댓글내용댓글내용</p>
                                        <a href="#">수정</a>
                                        <a href="#">삭제</a>
                                    </div>
                                </div>
                                <div class="blog__details__comment__item blog__details__comment__item--reply">
                                    <div class="blog__details__comment__item__text">
                                        <span>날짜</span>
                                        <h5>아이디</h5>
                                        <p>답댓글내용답댓글내용</p>
                                        <a href="#">수정</a>
                                        <a href="#">삭제</a>
                                    </div>
                                </div>
                                <div class="blog__details__comment__item">
                                    <div class="blog__details__comment__item__text">
                                        <span>날짜</span>
                                        <h5>아이디</h5>
                                        <p>댓글내용댓글내용</p>
                                        <a href="#">수정</a>
                                        <a href="#">삭제</a>
                                    </div>
                                </div>
                            </div>
                            <div class="blog__details__form">
                                <h4>댓글달기</h4>
                                <form action="#">
                                    <div class="row">
                                        <div class="col-lg-6 col-md-6 col-sm-6">
                                            <input type="text" placeholder="Name">
                                        </div>
                                        <div class="col-lg-6 col-md-6 col-sm-6">
                                            <input type="text" placeholder="Email">
                                        </div>
                                        <div class="col-lg-12">
                                            <textarea placeholder="Message"></textarea>
                                            <button type="submit" class="site-btn">입력</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Event Details Section End -->
	


	<!-- footer영역 -->
	<jsp:include page="../inc/footer.jsp" />

</body>
</html>	