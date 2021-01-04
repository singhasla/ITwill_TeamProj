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

	<!-- Notice Section Begin -->
	<section class="blog-details spad">
	    <div class="container">
		    <div class="row d-flex justify-content-center">
	            <div class="col-lg-8">
	                <div class="blog__details__title">
	                    <h2>고객센터</h2>
	                </div>
	            </div>
			    <div class="col-lg-12">
			        <div class="blog__details__content">
			     		<ul class="blog__details__btns" style="text-align: center;">
	                        <li class="blog__details__btns__item" style="display: inline-block; padding-left: 100px; padding-right: 100px;">
	                            <h5><a href="#">공지사항</a></h5>
	                        </li>
	                        <li class="blog__details__btns__item" style="display: inline-block; padding-left: 100px; padding-right: 100px;">
	                            <h5><a href="#">자주 묻는 질문</a></h5>
	                        </li>
	                        <li class="blog__details__btns__item" style="display: inline-block; padding-left: 100px; padding-right: 100px;">
	                            <h5><a href="#">문의하기</a></h5>
	                        </li>
                        </ul>
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
    <!-- Notice Section End -->
	
	
	<!-- footer영역 -->
	<jsp:include page="../inc/footer.jsp" />

</body>
</html>