<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"/>


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
	                    <h2>고객센터</h2>
	                </div>
	            </div>
	            <div class="col-lg-12">
			        <div class="blog__details__content">
			     		<ul class="blog__details__btns">
	                        <li class="blog__details__btns__item">
	                            <h5><a href="${contextPath}/notice/listNotice.do">공지사항</a></h5>
	                        </li>
	                        <li class="blog__details__btns__item">
	                            <h5><a href="${contextPath}/faq/faqList.do">자주 묻는 질문</a></h5>
	                        </li>
	                        <li class="blog__details__btns__item">
	                            <h5><a href="${contextPath}/qna/addQna.do">문의하기</a></h5>
	                        </li>
                        </ul>
                        <div class="blog__details__form" style="color: #ffffff;">
	                        <h4>공지사항</h4>
						    <table class="notice_table">
							<colgroup>
								<col style="width:10%;">
								<col style="width:*">
								<col style="width:15%;">
								<col style="width:10%;">
							</colgroup>
							<thead>
							<tr>
								<th>번호</th>
								<th style="text-align: left;">제목</th>
								<th>등록일</th>
								<th>조회수</th>
							</tr>
							</thead>
							<tbody>
								<tr>
									<td style="color: red;"><span>공지</span></td>
									<td class="table_title"><a href="noticeView.jsp" class="table_title">[카테고리]제목입니다</a></td>
									<td>2020.12.28</td>	
									<td>233</td>
								</tr>
							</tbody>
							</table>
						</div>
						<!-- Search Begin -->
			        	<div class="faq-search-box">
				        	<form action="${contextPath}/notice/listNotice.do">
								<div class="form-box tmg0">
									<input type="hidden" name="section" value="${section}">
									<input type="hidden" name="pageNum" value="${pageNum}">
									<input type="text" class="search" name="search" value="${search}">
									<input type="submit" value="검색">
								</div>
							</form>	
						</div>
						<!-- 공지 등록버튼 -->
			            <c:if test="${userID eq 'admin'}">
			           		<a class="site-btn submit" href="${contextPath}/notice/addNotice.do">공지 등록</a>
			            </c:if>
						<div class="paging">
							<div>&lt;<span class="current">1</span>
							<a href="" data-page-no="2" title="2페이지">2</a>
							&gt;</div>
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