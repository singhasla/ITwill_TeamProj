<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"/>
<c:set var="qnaList" value="${qnaList}"/>
<c:set var="qnaListCount" value="${qnaListCount}" />
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
                        <div class="blog__details__form colorwhite pd-30">
	                        <h4>나의 문의내역</h4>
						    <table class="notice_table">
							<colgroup>
								<col style="width:10%;">
								<col style="width:15%;">
								<col style="width:*">
								<col style="width:10%;">
							</colgroup>
							<thead>
							<tr>
								<th>상태</th>
								<th>구분</th>
								<th style="text-align: left;">제목</th>
								<th>등록일</th>
							</tr>
							</thead>
							<tbody>
							<c:choose>	
								<c:when test="${qnaListCount == 0 }">
									<tr>
										<td colspan="4">등록된 문의내역이 없습니다.</td>
									</tr>		
								</c:when>
								<c:otherwise>
									<c:forEach var="qna" items="${qnaList}">
									<fmt:formatDate var="qnaFormattedDate" value="${qna.qnaWriteDate }" pattern="yy-MM-dd"/>
									<tr>
										<c:choose>
											<c:when test="${qna.answerContent!=null}">
												<td>답변완료</td>
											</c:when>
											<c:otherwise>
												<td>답변대기</td>
											</c:otherwise>
										</c:choose>
										<td><span>${qna.qnaCategory}</span></td>
										<td class="table_title"><a href="${contextPath}/qna/viewQna.do?qnaNo=${qna.qnaNo}" class="table_title"><span style="color: #ffffff;">${qna.qnaTitle}</span></a></td>
										<td>${qnaFormattedDate}</td>
									</tr>
									</c:forEach>
								</c:otherwise>	
							</c:choose>	
							</tbody>
							</table>
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