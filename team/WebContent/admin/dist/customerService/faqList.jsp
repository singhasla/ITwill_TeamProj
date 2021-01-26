<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>        
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="faqListCount" value="${faqListCount}"/>
<c:set var="faqList" value="${faqList}"/>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>관리자 페이지입니다</title>
        <link rel="stylesheet" href="${contextPath}/admin/dist/css/event.css" type="text/css">
        <link href="${contextPath}/admin/dist/css/styles.css" rel="stylesheet" />
        <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js" crossorigin="anonymous"></script>
        <!-- jQuery -->
		<script type="text/javascript" src="${contextPath}/js/jquery-3.3.1.min.js"></script>
    
    </head>
    <body class="sb-nav-fixed">
    <!-- 헤더 -->
	<jsp:include page="../adminInc/header.jsp"/>
        <div id="layoutSidenav">
        <!-- 사이드 메뉴 -->
        	<jsp:include page="../adminInc/sidenav.jsp"/>
        	
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">
                        <div class="breadcrumb-item">
                        <div class="col-6"><h1 class="mt-4">자주하는 질문</h1></div>
                        <div class="col-6 eventbutton" >
                        	<button type="button" class="btn btn-primary" onclick="location.href='${contextPath}/faqAdmin/addFaq.do'">자주하는질문 등록</button></div> 
                        </div>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table mr-1"></i>
                                	FAQ 관리
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr align="center">
                                                <th style="width: 5%;">번호</th>
                                                <th style="width: 25%;">자주하는 질문(FAQ)</th>
                                                <th style="width: 50%;">내용(Answer)</th>
                                                <th style="width: 20%;">관리</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<c:choose>
                                       			<c:when test="${faqListCount==0}">			
													<tr align="center">
														<td colspan="4">등록된 FAQ가 없습니다.</td>
													</tr>
												</c:when>
												<c:otherwise>	
													<c:forEach var="faq" items="${faqList}">
			                                            <tr class="eventlist"  onclick="readFaq('${faq.faqNo}', event)">
			                                                <td>${faq.faqNo}</td>
			                                                <td>${faq.faqTitle}</td>
			                                                <td><div class="cut">${faq.faqContent}</div></td>
			                                                <td>
			                                                	<button type="button" class="btn btn-warning" onclick="modifyFaq('${faq.faqNo}', event)">수정</button>
			                                                	<button type="button" class="btn btn-danger" onclick="deleteFaq('${faq.faqNo}', event)">삭제</button>
			                                                </td>
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
                </main>
                <form name="faqInfo" method="post"></form>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2020</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script type="text/javascript">
        function readFaq(faqNo,event) {
        	event.stopPropagation();
			var form = document.faqInfo;
        	form.action = "${contextPath}/faqAdmin/readFaq.do?faqNo=" + faqNo;
        	form.submit();
        }
        function modifyFaq(faqNo,event) {
        	event.stopPropagation();
			var form = document.faqInfo;
        	form.action = "${contextPath}/faqAdmin/modifyFaq.do?faqNo=" + faqNo;
        	form.submit();
        }
        function deleteFaq(faqNo,event) {
        	event.stopPropagation();
			var form = document.faqInfo;
        	if(confirm("정말로 삭제하시겠습니까?")) {
        		form.action = "${contextPath}/faqAdmin/deleteFaq.do?faqNo=" + faqNo;
        		form.submit();
        	}
        }
	
		</script>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="${contextPath}/admin/dist/js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="${contextPath}/admin/dist/assets/demo/chart-area-demo.js"></script>
        <script src="${contextPath}/admin/dist/assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
        <script src="${contextPath}/admin/dist/assets/demo/datatables-demo.js"></script>
    </body>
</html>
