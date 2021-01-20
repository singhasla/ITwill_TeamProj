<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"/>
<c:set var="noticeList" value="${noticeMap.noticeList }"/>
<c:set var="noticeListCount" value="${noticeMap.noticeListCount }"/>
<c:set var="section" value="${noticeMap.section }"/>
<c:set var="pageNo" value="${noticeMap.pageNo }"/>
<c:set var="search" value="${noticeMap.search }"/>

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
							<c:choose>	
								<c:when test="${noticeList == null }">
									<tr>
										<td colspan="4">등록된 이벤트가 없습니다.</td>
									</tr>		
								</c:when>
								<c:otherwise>
									<c:forEach var="notice" items="${noticeList}">
									<fmt:formatDate var="noticeFormattedDate" value="${notice.noticeWriteDate}" pattern="yy-MM-dd"/>
									<tr>
										<td><span>${notice.noticeNo}</span></td>
										<td class="table_title"><a href="${contextPath}/notice/viewNotice.do?noticeNo=${notice.noticeNo}" class="table_title"><span style="color: #ffffff;">[${notice.noticeCategory}]${notice.noticeTitle}</span></a></td>
										<td>${noticeFormattedDate}</td>	
										<td>${notice.noticeReadCount}</td>
									</tr>
									</c:forEach>
								</c:otherwise>	
							</c:choose>	
							</tbody>
							</table>
						</div>
						<!-- Search Begin -->
			        	<div class="faq-search-box noticesearch">
				        	<form action="${contextPath}/notice/listNotice.do">
								<div class="form-box tmg0">
									<input type="hidden" name="section" value="${section}">
									<input type="hidden" name="pageNo" value="${pageNo}">
									<input type="text" class="search" name="search" value="${search}">
									<input type="submit" value="검색">
								</div>
							</form>	
						</div>
						<!-- Search End -->
						<!-- 공지 등록버튼 -->
			            <c:if test="${userID eq 'admin'}">
			           		<a class="site-btn submit" href="${contextPath}/notice/addNotice.do">등록</a>
			            </c:if>
			            <!-- 페이징 -->
			            <div class="row" style="justify-content: center;">
			            <c:if test="${noticeListCount != null}">
			            	<c:choose>
			            		<c:when test="${noticeListCount > 100}">
			            			<c:forEach var="page" begin="1" end="10" step="1">
				            			<c:if test="${section > 1 && page = 1}">
				            			<div class="paging">
				            				<a href="${contextPath}/notice/listNotice.do?section=${section-1}&pageNo=${(section-1)*10+1}&search=${search}">
				            				<span class="arrow_carrot-left"></span></a>
				            			</div>
				            			</c:if>
				            			<div class="paging">
				            				<a href="${contextPath}/notice/listNotice.do?section=${section}&pageNo=${page}&search=${search}">${(section-1)*10}</a>
			            				</div>
			            				<c:if test="${page==10}">
			            				<div class="paging">	
			            					<a href="${contextPath}/notice/listNotice.do?section=${section+1}&pageNo=${section*10+1}&search=${search}">
			            					<span class="arrow_carrot-right"></span></a>
			            				</div>
			            				</c:if>
			            			</c:forEach>
			            		</c:when>
			            		<c:when test="${noticeListCount == 100}">
			            			<c:forEach var="page" begin="1" end="10" step="1">
			            			<div class="paging">	
			            				<span><a>${page}</a></span>
			            			</div>	
			            			</c:forEach>
			            		</c:when>
			            		<c:when test="${noticeListCount < 100 }">
			            			<c:forEach var="page" begin="1" end="${noticeListCount/10+1}" step="1">
			            				<c:choose>
			            					<c:when test="${page==pageNo}">
			            					<div class="paging">
			            						<span><a class="current" href="${contextPath}/notice/listNotice.do?section=${section}&pageNo=${page}&search=${search}">${page}</a></span>
			            					</div>
			            					</c:when>
			            					<c:otherwise>
			            					<div class="paging">
			            						<span><a href="${contextPath}/notice/listNotice.do?section=${section}&pageNo=${page}&search=${search}">${page}</a></span>
			            					</div>	
			            					</c:otherwise>
			            				</c:choose>
			            			</c:forEach>
			            		</c:when>
			            	</c:choose>
						</c:if>
						</div>
						<!-- 페이징 끝 -->
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