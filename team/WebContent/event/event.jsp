<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
	request.setCharacterEncoding("UTF-8");
%>
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
    <link rel="stylesheet" href="../css/event.css" type="text/css">

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
	
	<!-- Normal Breadcrumb Begin -->
    <section class="normal-breadcrumb set-bg" data-setbg="../img/normal-breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="normal__breadcrumb__text">
                        <h2>event</h2>
                        <p>이벤트 페이지</p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Normal Breadcrumb End -->

    <!-- Event Section Begin -->
    <section class="blog spad">
        <div class="container">
        	<div class="faq-search-box">
				<div class="form-box tmg0">
					<input type="text" class="search">
					<input type="submit" value="검색">
				</div>
			</div>
            <div class="row">
                <div class="col-lg-6">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="blog__item set-bg" data-setbg="../img/blog/blog-1.jpg">
                                <div class="blog__item__text">
                                    <p><span class="icon_calendar"></span>1번</p>
                                    <h4><a href="/event/event-detail.do">이벤트명</a></h4>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-6">
                            <div class="blog__item small__item set-bg" data-setbg="../img/blog/blog-4.jpg">
                                <div class="blog__item__text">
                                    <p><span class="icon_calendar"></span>2번</p>
                                    <h4><a href="event-detail.jsp">이벤트명</a></h4>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-6">
                            <div class="blog__item small__item set-bg" data-setbg="../img/blog/blog-5.jpg">
                                <div class="blog__item__text">
                                    <p><span class="icon_calendar"></span>3번</p>
                                    <h4><a href="event-detail.jsp">이벤트명</a></h4>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-12">
                            <div class="blog__item set-bg" data-setbg="../img/blog/blog-7.jpg">
                                <div class="blog__item__text">
                                    <p><span class="icon_calendar"></span>4번</p>
                                    <h4><a href="event-detail.jsp">이벤트명</a></h4>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-6">
                            <div class="blog__item small__item set-bg" data-setbg="../img/blog/blog-10.jpg">
                                <div class="blog__item__text">
                                    <p><span class="icon_calendar"></span>5번</p>
                                    <h4><a href="event-detail.jsp">이벤트명</a></h4>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-6">
                            <div class="blog__item small__item set-bg" data-setbg="../img/blog/blog-11.jpg">
                                <div class="blog__item__text">
                                    <p><span class="icon_calendar"></span>6번</p>
                                    <h4><a href="event-detail.jsp">이벤트명</a></h4>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="row">
                        <div class="col-lg-6 col-md-6 col-sm-6">
                            <div class="blog__item small__item set-bg" data-setbg="../img/blog/blog-2.jpg">
                                <div class="blog__item__text">
                                    <p><span class="icon_calendar"></span>7번</p>
                                    <h4><a href="event-detail.jsp">이벤트명</a></h4>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-6">
                            <div class="blog__item small__item set-bg" data-setbg="../img/blog/blog-3.jpg">
                                <div class="blog__item__text">
                                    <p><span class="icon_calendar"></span>8번</p>
                                    <h4><a href="event-detail.jsp">이벤트명</a></h4>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-12">
                            <div class="blog__item set-bg" data-setbg="../img/blog/blog-6.jpg">
                                <div class="blog__item__text">
                                    <p><span class="icon_calendar"></span>9번</p>
                                    <h4><a href="event-detail.jsp">이벤트명</a></h4>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-6">
                            <div class="blog__item small__item set-bg" data-setbg="../img/blog/blog-8.jpg">
                                <div class="blog__item__text">
                                    <p><span class="icon_calendar"></span>10번</p>
                                    <h4><a href="event-detail.jsp">이벤트명</a></h4>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-6">
                            <div class="blog__item small__item set-bg" data-setbg="../img/blog/blog-9.jpg">
                                <div class="blog__item__text">
                                    <p><span class="icon_calendar"></span>11번</p>
                                    <h4><a href="event-detail.jsp">이벤트명</a></h4>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-12">
                            <div class="blog__item set-bg" data-setbg="../img/blog/blog-12.jpg">
                                <div class="blog__item__text">
                                    <p><span class="icon_calendar"></span>12번</p>
                                    <h4><a href="event-detail.jsp">이벤트명</a></h4>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <a class="site-btn submit" href="${contextPath}/eventServlet/eventForm.do">이벤트등록</a>
        </div>
    </section>
    <!-- Event Section End -->
	
	
	
	<!-- footer영역 -->
	<jsp:include page="../inc/footer.jsp" />

</body>
</html>	