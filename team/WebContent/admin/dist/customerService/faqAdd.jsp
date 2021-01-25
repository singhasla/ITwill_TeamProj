<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>        
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


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
                        <h1 class="mt-4">자주하는 질문</h1>
                        <div class="row">
	                        <div class="card mb-4 ecol-12">
	                            <div class="card-header">
	                                <i class="fas fa-table mr-1"></i>
	                                	FAQ 등록
	                            </div>
	                            <div class="card-body">
	                                <div class="table-responsive">
	                                	<form action="${contextPath}/faqAdmin/insertFaq.do" method="post">
		                                    <table class="table table-bordered" width="100%" cellspacing="0">
		                                        <colgroup>
													<col width="20%">
													<col width="*">
												</colgroup>
		                                        <tbody>
		                                        	<tr>
												<th>자주하는 질문(FAQ)</th>
												<td>
													<input type="text" name="faqTitle" placeholder="질문(Q)을 입력해 주세요." class="widhun">
												</td>
											</tr>
											<tr>
												<th>내용(ANSWER)</th>
												<td>
													<textarea cols="40" rows="15" name="faqContent" placeholder="답(A)을 입력해 주세요."></textarea>
												</td>
											</tr>
		                                        </tbody>
		                                    </table>
		                                    <div class="float-right">
												<button type="submit" class="btn btn-primary">등록</button>
												<button type="button" class="btn btn-secondary" onclick="history.back();">취소</button>
											</div>
		                            	</form>        
	                                </div>
	                            </div>
	                        </div>
                        </div>
                    </div>
                </main>
                <form name="userForm" method="post"></form>
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
