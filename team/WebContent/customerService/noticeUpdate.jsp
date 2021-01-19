<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"/>
<c:set var="noticeNo" value="${noticeMap.noticeVO.noticeNo}"/>
<c:set var="noticeTitle" value="${noticeMap.noticeVO.noticeTitle}"/>
<c:set var="noticeContent" value="${noticeMap.noticeVO.noticeContent}"/>
<c:set var="noticeFile" value="${noticeMap.noticeVO.noticeFile}"/>
<c:set var="noticeCategory" value="${noticeMap.noticeVO.noticeCategory}"/>
<c:set var="noticeCategoryList" value="${noticeMap.noticeCategoryList}"/>
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
	                            <h5><a href="faq.jsp">자주 묻는 질문</a></h5>
	                        </li>
	                        <li class="blog__details__btns__item">
	                            <h5><a href="inquireForm.jsp">문의하기</a></h5>
	                        </li>
                        </ul>
                        <div class="noticeForm">
	                        <h4>공지사항 수정</h4>
						    <form action="${contextPath}/notice/updateNotice.do" method="post" enctype="multipart/form-data" class="writeForm">
								<input type="hidden" name="pageNo" value="${pageNo}"/>
								<input type="hidden" name="search" value="${search}"/>
								<input type="hidden" name="noticeNo" value="${noticeNo}"/>	
								<input type="hidden" name="originalFile" value="${noticeFile}"/>
								<table class="table">
									<colgroup>
										<col width="20%">
										<col width="*">
									</colgroup>
									<tbody>
										<tr>
											<th>제목</th>
											<td>
												<input type="text" name="noticeTitle" value="${noticeTitle }" class="widhun">
											</td>
										</tr>
										<tr>
											<th>종류</th>
											<td>
												<select class="nice-select" name="noticeCategory" id="noticeCategory">
													<option>선택하세요</option>
													<c:forEach var="category" items="${noticeCategoryList}">
														<c:choose>
															<c:when test="${category.noticeCategory == noticeCategory}">
																<option value="${category.noticeCategory}" selected>${category.noticeCategory}</option>
															</c:when>
															<c:otherwise>
																<option value="${category.noticeCategory}">${category.noticeCategory}</option>
															</c:otherwise>
														</c:choose>
													</c:forEach>
												</select>
											</td>
										</tr>
										<tr>
											<th>내용</th>
											<td>
												<textarea cols="40" rows="15" name="noticeContent" class="widhun">${noticeContent}</textarea>
											</td>
										</tr>
										<tr>
											<th>첨부파일</th>
											<td>
												<c:if test="${not empty noticeFile }">
													<div class="originalFile">
														<p style="color: #ffffff;">${noticeFile}</p>
														<input type="checkbox" name="deleteFile" id="deleteFile">
														<label for="deleteFile">첨부된 파일 삭제하기</label>
													</div>
													<p class="alert" style="display: none;">파일 첨부 시 기존 파일이 삭제됩니다.</p>
												</c:if>
												<input type="file" name="noticeFile" id="noticeFile" onchange="checkFile(this); showPreview(this);" >
											</td>
										</tr>
									</tbody>
								</table>
								<div class="button">
									<button type="button" class="site-btn cancel" onclick="history.back();">취소</button>
									<button type="submit" class="site-btn submit">등록</button>
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
	
	<script>
	function checkFile(obj){
		if($(obj).parent().siblings(".alert")){
			if($(obj).val().length > 0){
				$(obj).parent().siblings(".alert").fadeIn();
			}else{
				$(obj).parent().siblings(".alert").hide();
			}
		}
	}
	
	</script>

</body>
</html>