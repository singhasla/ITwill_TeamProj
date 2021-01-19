<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"/>
<c:set var="eventList" value="${eventMap.eventList}"/>
<c:set var="allEvents" value="${eventMap.allEvents}"/>
<c:set var="section" value="${eventMap.section}"/>
<c:set var="pageNum" value="${eventMap.pageNum}"/>
<c:set var="allEvent"/>

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
                        <h2>이벤트</h2>
                        <p>EVENT</p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Normal Breadcrumb End -->

    <!-- Event Section Begin -->
    <section class="blog spad">
        <div class="container">
        	<!-- Search Begin -->
        	<div class="faq-search-box">
				<div class="form-box tmg0">
					<input type="text" class="search">
					<input type="submit" value="검색">
				</div>
			</div>
			<!-- Search End  -->
			<!-- Event List Begin -->
            <div class="row">
	            <c:choose>
	            	<c:when test="${empty eventList}">
	            		<p></p>
	            	</c:when>
	            	<c:when test="${!empty eventList}">
	            		<c:forEach var="event" items="${eventList}" varStatus="eventNo">	
			                <div class="col-lg-6" onclick="location.href='${contextPath}/eventServlet/event-detail.do?eventNo=${event.eventNo}'">
			                    <div class="row">
			                        <div class="col-lg-12">
			                            <div class="blog__item set-bg" data-setbg="${contextPath}/files/event/${event.eventNo}/${event.eventImage}">
			                                <div class="blog__item__text">
			                                    <p><span class="icon_calendar"></span><fmt:formatDate value="${event.eventWriteDate}"/></p>
			                                    <h4><a href="${contextPath}/eventServlet/event-detail.do?eventNo=${event.eventNo}">${event.eventTitle}</a></h4>
			                                </div>
			                            </div>
			                        </div>
			                    </div>
			                </div>
	                	</c:forEach>
	                </c:when>
	            </c:choose> 
            </div>
            <!-- Event List End -->
            
            <!-- 이벤트 등록버튼 -->
            <c:if test="${userID eq 'admin'}">
           		<a class="site-btn submit" href="${contextPath}/eventServlet/eventForm.do">이벤트등록</a>
            </c:if>
        </div>
    </section>
    <!-- Event Section End -->
	
	
	
	<!-- footer영역 -->
	<jsp:include page="../inc/footer.jsp" />

</body>
</html>	