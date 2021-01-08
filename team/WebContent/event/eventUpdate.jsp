<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<c:set var="eventNo"  value="${event.eventNo}"/>
<c:set var="eventTitle"  value="${event.eventTitle}"/>
<c:set var="eventContent"  value="${event.eventContent}"/>
<c:set var="eventImage"  value="${event.eventImage}"/>
<c:set var="eventWriteDate"  value="${event.eventWriteDate}"/>

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
                        <p>이벤트 수정 페이지</p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Normal Breadcrumb End -->

    <!-- Event Section Begin -->
    <section class="blog spad">
        <div class="container">
        	<h3>이벤트 수정</h3>
            <form action="${contextPath}/eventServlet/updateEvent.do" method="post" enctype="multipart/form-data" class="eventForm">
				<input type="hidden" name="eventNo" value="${eventNo}"/>
				<input type="hidden" name="userID" value="${userID}"/>
				<input type="hidden" name="originalFile" value="${eventImage}"/>
				<table class="table">
					<colgroup>
						<col width="20%">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th>제목</th>
							<td>
								<input type="text" name="eventTitle" value="${eventTitle}" class="widhun">
							</td>
						</tr>
						<tr>
							<th>내용</th>
							<td>
								<textarea cols="40" rows="15" name="eventContent" class="widhun">${eventContent}</textarea>
							</td>
						</tr>
						<tr>
							<th>첨부파일</th>
							<td>
								<c:if test="${not empty eventImage}">
									<c:if test="${eventImageFileType eq 'image'}">
										<img alt="${contextPath}/files/event/${eventNo}/${eventImage}" class="preview">
									</c:if>
									<p style="color: #ffffff;">${eventImage}</p>
								</c:if>
								<input type="file" name="eventImage">
							</td>
						</tr>
					</tbody>
				</table>
				<div class="button">
					<button type="submit" class="site-btn submit">수정</button>
					<button type="button" class="site-btn cancel" onclick="history.back();">취소</button>
				</div>
			</form>
        </div>
    </section>
    <!-- Event Section End -->
	
	
	
	<!-- footer영역 -->
	<jsp:include page="../inc/footer.jsp" />

</body>
</html>	