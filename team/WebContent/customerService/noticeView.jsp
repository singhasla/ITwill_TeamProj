<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"/>
<c:set var="noticeNo" value="${noticeMap.noticeVO.noticeNo }"/>
<c:set var="noticeTitle" value="${noticeMap.noticeVO.noticeTitle }"/>
<c:set var="noticeContent" value="${noticeMap.noticeVO.noticeContent }"/>
<c:set var="noticeFile" value="${noticeMap.noticeVO.noticeFile }"/>
<c:set var="noticeWriteDate" value="${noticeMap.noticeVO.noticeWriteDate }"/>
<c:set var="noticeReadCount" value="${noticeMap.noticeVO.noticeReadCount }"/>
<c:set var="noticeCategory" value="${noticeMap.noticeVO.noticeCategory }"/>
<fmt:formatDate var="noticeFormattedDate" value="${noticeWriteDate }" pattern="yy-MM-dd"/>
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
                        <div class="col-lg-12" style="margin-top: 60px;">
		                    <div class="blog__details__content">
		                        <div class="blog__details__item__text titlebackground">
		                            <h4>${noticeTitle}</h4>
		                            <span>조회수 : ${noticeReadCount}</span>
		                            <span>등록일 : ${noticeFormattedDate}<small>|</small></span>
		                        </div>
		                        <div class="filearea">
		                        	첨부파일 : <a onclick="downloadNotice(${noticeNo}, '${noticeFile}')">${noticeFile }</a>
		                        </div>
		                        <div class="blog__details__item__text">
		                        	<p>${fn:replace(noticeContent,LF,BR)}</p>
		                        </div>
		                        <div class="blog__details__tags">
		                            <a href="#">태그1</a>
		                            <a href="#">태그2</a>
		                            <a href="#">태그3</a>
		                        </div>
		                        <div style="margin-bottom: 20px;">
			                        <div class="next">
			                        	<span>다음 글</span><a href=""><span style="color: #646464;">[이전글 카테고리] 이전글 제목</span></a>
			                        </div>
			                         <div class="next">
			                        	<span>이전 글</span><a href=""><span style="color: #646464;">[다음글 카테고리] 다음글 제목</span></a>
			                        </div>
		                        </div>
		                        <!-- 공지사항 수정 삭제 버튼 -->
					            <c:if test="${userID eq 'admin'}">
					           		<button type="button" class="site-btn cancel" onclick="location.href='${contextPath}/notice/deleteNotice.do?noticeNo=${noticeNo}'">삭제</button>
					           		<button type="button" class="site-btn cancel" onclick="location.href='${contextPath}/notice/modifyNotice.do?noticeNo=${noticeNo}'">수정</button>
					            </c:if>
	                        </div>
                    	</div>
					</div>		
				</div>			
	        </div>
		</div>
    </section>
    <!-- Notice Section End -->
	
	<form mothod="post"	name="noticeInfo">
	
	</form>
	
	<!-- footer영역 -->
	<jsp:include page="../inc/footer.jsp" />
	
	<script type="text/javascript">
		function downloadNotice(noticeNo, noticeFile) {
			var form = document.noticeInfo;
			form.action = "${contextPath}/notice/download.do?noticeNo=" + noticeNo + "&noticeFile=" + noticeFile;
			form.submit();
		}
	
	</script>
	
</body>
</html>