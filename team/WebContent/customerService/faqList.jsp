<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"/>
<c:set var="faqList" value="${faqList}"/>
<c:set var="faqListCount" value="${faqListCount}"/>
<c:set var="section" value="${faqMap.section}"/>
<c:set var="pageNo" value="${faqMap.pageNo}"/>
<c:set var="search" value="${faqMap.search}"/>

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
    
    <!-- jQuery -->
	<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
	
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
	
	<!-- FAQ Section Begin -->
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
	                            <h5><a href="${contextPath}/faq/listFaq.do">자주 묻는 질문</a></h5>
	                        </li>
	                        <li class="blog__details__btns__item">
	                            <h5><a href="${contextPath}/qna/addQna.do">문의하기</a></h5>
	                        </li>
                        </ul>
                        <!-- FAQ -->
                        <div class="blog__details__form accordions">
	                        <h4>자주 묻는 질문</h4>
	                        <c:choose>
	                        	<c:when test="${faqListCount == 0 }">
	                        		<div>
	                        			<p>등록된 FAQ가 없습니다.</p>
	                        		</div>
	                        	</c:when>
		                        	<c:otherwise>
		                        		<c:forEach var="faqVO" items="${faqList}">
										    <dl id="faq_list" class="faq-list">
										    	<dt class="accordion content-box-question" style="padding: 28px 0px 28px 70px">
										    		<a href="#">
										    			<span>${faqVO.faqTitle}</span>
										    			<span class="arrow_triangle-down scrolldown" id="arrow"></span>
										    		</a>
										    	</dt>
										    	<dd class="content-box-answer" id="fqaAnswer" style="display: none;">
													<div><p>${fn:replace(faqVO.faqContent,LF,BR)}</p></div>
												</dd>
											</dl>
										</c:forEach>
								</c:otherwise>
							</c:choose>
						</div>
						<!-- FAQ end -->
						<!-- Search Begin -->
			        	<div class="faq-search-box noticesearch" style="margin-top: 20px;">
				        	<form action="${contextPath}/faq/listFaq.do">
								<div class="form-box tmg0">
									<input type="hidden" name="section" value="${section}">
									<input type="hidden" name="pageNo" value="${pageNo}">
									<input type="text" class="search" name="search" value="${search}">
									<input type="submit" value="검색">
								</div>
							</form>	
						</div>
						<!-- Search End -->
						<!-- 페이징 -->
			            <div class="row" style="justify-content: center;">
			            <c:if test="${faqListCount != 0}">
			            	<c:choose>
			            		<c:when test="${faqListCount > 100}">
			            			<c:forEach var="page" begin="1" end="10" step="1">
				            			<c:if test="${section > 1 && page = 1}">
				            			<div class="paging">
				            				<a href="${contextPath}/faq/listFaq.do?section=${section-1}&pageNo=${(section-1)*10+1}">
				            				<span class="arrow_carrot-left"></span></a>
				            			</div>
				            			</c:if>
				            			<div class="paging">
				            				<a href="${contextPath}/faq/listFaq.do?section=${section}&pageNo=${page}">${(section-1)*10}</a>
			            				</div>
			            				<c:if test="${page==10}">
			            				<div class="paging">	
			            					<a href="${contextPath}/faq/listFaq.do?section=${section+1}&pageNo=${section*10+1}">
			            					<span class="arrow_carrot-right"></span></a>
			            				</div>
			            				</c:if>
			            			</c:forEach>
			            		</c:when>
			            		<c:when test="${faqListCount == 100}">
			            			<c:forEach var="page" begin="1" end="10" step="1">
			            			<div class="paging">	
			            				<span><a>${page}</a></span>
			            			</div>	
			            			</c:forEach>
			            		</c:when>
			            		<c:when test="${faqListCount < 100 }">
			            			<c:forEach var="page" begin="1" end="${faqListCount/10+1}" step="1">
			            				<c:choose>
			            					<c:when test="${page==pageNo}">
			            					<div class="paging">
			            						<span><a class="current" href="${contextPath}/faq/listFaq.do?section=${section}&pageNo=${page}&pageNum=${page}&search=${search}">${page}</a></span>
			            					</div>
			            					</c:when>
			            					<c:otherwise>
			            					<div class="paging">
			            						<span><a href="${contextPath}/faq/listFaq.do?section=${section}&pageNo=${page}&search=${search}">${page}</a></span>
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
    <!-- FAQ Section End -->	
	
	<!-- footer영역 -->
	<jsp:include page="../inc/footer.jsp" />
	<script>
		$(".accordion").click(function(){
			$("#fqaAnswer").toggle();
			if($("#arrow").hasClass(".arrow_triangle-down") === true)
				$("#arrow").removeClass('arrow_triangle-down').addClass('arrow_triangle-up');
			else
				$("#arrow").removeClass('arrow_triangle-up').addClass('arrow_triangle-down');
		});
	</script>
	
</body>
</html>