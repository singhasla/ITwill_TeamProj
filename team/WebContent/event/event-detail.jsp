<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"/>
<c:set var="eventNo"  value="${event.eventNo}"/>
<c:set var="eventTitle"  value="${event.eventTitle}"/>
<c:set var="eventContent"  value="${event.eventContent}"/>
<c:set var="eventImage"  value="${event.eventImage}"/>
<c:set var="eventWriteDate"  value="${event.eventWriteDate}"/>
<c:set var="prev"  value="${event.prev_eventNo}"/>
<c:set var="next"  value="${event.next_eventNo}"/>
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
	
	    <!-- Event-Details Section Begin -->
	    <section class="blog-details spad">
	        <div class="container">
	            <div class="row d-flex justify-content-center">
	                <div class="col-lg-8">
	                    <div class="blog__details__title">
	                        <h6><span class="icon_calendar"></span><fmt:formatDate value="${eventWriteDate}"/></h6>
	                        <h2>${eventTitle}</h2>
	                    </div>
	                </div>
	                <div class="col-lg-12">
	                    <div class="blog__details__pic"></div>
	                </div>
	                <div class="col-lg-12">
	                    <div class="blog__details__content">
	                        <div class="blog__details__item__text">
	                            <img src="${contextPath}/files/event/${eventNo}/${eventImage}"/>
	                            <p>${eventContent}</p>
	                        </div>
	                        <div class="blog__details__tags">
	                            <a href="#">태그1</a>
	                            <a href="#">태그2</a>
	                            <a href="#">태그3</a>
	                        </div>
	                        <div class="blog__details__btns">
	                            <div class="row">
	                                <div class="col-lg-6 next1">
	                                    <div class="blog__details__btns__item" >
	                                    	<c:choose>
	                                    		<c:when test="${prev == 0 || prev eq null}">
													<h5><a onclick="prev_none()"><span class="arrow_left"></span>이전페이지</a></h5>
	                                        	</c:when>
	                                        	<c:otherwise>
	                                        		<h5><a href="${contextPath}/eventServlet/event-detail.do?eventNo=${prev}"><span class="arrow_left"></span>이전페이지</a></h5>
	                                        	</c:otherwise>
	                                        </c:choose>	
	                                    </div>
	                                </div>
	                                <div class="col-lg-6 next1">
	                                    <div class="blog__details__btns__item next__btn">
	                                    	<c:choose>
	                                    		<c:when test="${next == 0 || next eq null}">
	                                        		<h5><a onclick="next_none()">다음페이지<span class="arrow_right"></span></a></h5>
	                                        	</c:when>
	                                        	<c:otherwise>
	                                        		<h5><a href="${contextPath}/eventServlet/event-detail.do?eventNo=${next}">다음페이지<span class="arrow_right"></span></a></h5>
	                                        	</c:otherwise>
	                                        </c:choose>	
                                        </div>
                                    </div>
                                </div>
                         	</div>
                         	<!-- 이벤트 수정,삭제 버튼 -->
                         	<c:choose>
				            <c:when test="${userID eq 'admin'}">
				           		<button type="button" class="site-btn cancel" onclick="location.href='${contextPath}/eventServlet/deleteEvent.do?eventNo=${eventNo}'">삭제</button>
				           		<button type="button" class="site-btn cancel" onclick="location.href='${contextPath}/eventServlet/modifyEvent.do?eventNo=${eventNo}'">수정</button>
				            
					            <div class="btn-area ar" style="float: left;">
									<a href="${contextPath}/eventServlet/listEvent.do" class="btn-box board">목록</a>
								</div>
							</c:when>
							<c:otherwise>
								<div class="btn-area ar">
									<a href="${contextPath}/eventServlet/listEvent.do" class="btn-box board">목록</a>
								</div>
							</c:otherwise>
							</c:choose>
                    	</div>
                    </div>
                </div>
                
            </div>
        </section>
        <!-- Event Details Section End -->
		
		<script>
			function prev_none(){
				window.alert("이전페이지가 존재하지 않습니다.");
			}
			
			function next_none(){
				window.alert("다음페이지가 존재하지 않습니다.");
			}
		</script>
	<!-- footer영역 -->
	<jsp:include page="../inc/footer.jsp" />

</body>
</html>	