<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"/>
<c:set var="qnaVO" value="${qnaVO}"/>
<c:set var="qnaNo" value="${qnaVO.qnaNo}"/>
<c:set var="qnaTitle" value="${qnaVO.qnaTitle}"/>
<c:set var="qnaContent" value="${qnaVO.qnaContent}"/>
<c:set var="qnaCategory" value="${qnaVO.qnaCategory}"/>
<c:set var="qnaWriteDate" value="${qnaVO.qnaWriteDate}"/>
<c:set var="answerTitle" value="${qnaVO.answerTitle}"/>
<c:set var="answerContent" value="${qnaVO.answerContent}"/>
<c:set var="answerWriteDate" value="${qnaVO.answerWriteDate}"/>

<fmt:formatDate var="qnaFormattedDate" value="${qnaWriteDate}" pattern="yy-MM-dd"/>

<%
	request.setCharacterEncoding("UTF-8");
	pageContext.setAttribute("LF", "\n");
	pageContext.setAttribute("BR", "<br>");
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
    <link rel="stylesheet" href="../css/customerService.css" type="text/css">
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

	<!-- Notice Section Begin -->
	<section class="blog-details spad">
	    <div class="container">
		    <div class="row d-flex justify-content-center">
	            <div class="col-lg-8">
	                <div class="blog__details__title">
	                    <h2>문의내역</h2>
	                </div>
	            </div>
	            <div class="col-lg-12">
			        <div class="blog__details__content border">
                        <div class="blog__details__form" style="color: #ffffff; padding: 30px;">
		                    <div class="blog__details__content">
		                        <div class="blog__details__item__text titlebackground">
		                        <c:choose>
		                        	<c:when test="${answerContent!=null}">
		                            	<span style="float: left; color: red;"><em>•</em>답변완료</span>
		                        	</c:when>
		                        	<c:otherwise>
		                        		<span style="float: left;"><em>•</em>답변대기</span>
		                        	</c:otherwise>
		                        </c:choose>  
		                            <h4 style="padding-left: 100px;">${qnaTitle}</h4>
		                            <span>등록일 : ${qnaFormattedDate}<small>|</small></span>
		                        </div>
		                        <div class="qnacategory">
		                        	구분  |<span style="display: inline-block;">${qnaCategory}</span>
		                        </div>
		                        <div class="content-box-question">
		                        	<p>${fn:replace(qnaContent,LF,BR)}</p>
		                        </div>
		                        <div class="content-box-answer">
		                        	<p>${fn:replace(answerContent,LF,BR)}</p>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="btn-area ar">
					<a href="${contextPath}/qna/myQnaList.do" class="btn-box board">목록</a>
				</div>		
			</div>			
        </div>
    </section>
    <!-- Notice Section End -->
	
	
	<!-- footer영역 -->
	<jsp:include page="../inc/footer.jsp" />

</body>
</html>