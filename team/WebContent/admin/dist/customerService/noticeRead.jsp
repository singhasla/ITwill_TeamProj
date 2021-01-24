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
                        <h1 class="mt-4">이벤트</h1>
                        <div class="row">
	                        <div class="card mb-4 ecol-12 ecol-lg-8 ecol-xl-9">
	                            <div class="card-header">
	                                <i class="fas fa-table mr-1"></i>
	                                	이벤트 정보
	                            </div>
	                            <div class="card-body">
	                                <div class="table-responsive">
	                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
	                                        <colgroup>
												<col width="20%">
												<col width="*">
											</colgroup>
	                                        <tbody>
	                                        	<tr>
											<th>번호</th>
											<td>
												
											</td>
										</tr>
										<tr>
											<th>제목</th>
											<td>
											
											</td>
										</tr>
										<tr>
											<th>내용</th>
											<td>
												<textarea cols="40" rows="15" name="noticeContent" placeholder="내용을 입력해 주세요." class="widhun"></textarea>
											</td>
										</tr>
										<tr>
											<th>첨부파일</th>
											<td>
											</td>
										</tr>
	                                        </tbody>
	                                    </table>
	                                </div>
	                            </div>
	                        </div>
	                        <div class="card mb-4  ecol-12 ecol-lg-4 ecol-xl-3">
	                            <div class="card-header">
	                                <i class="fas fa-table mr-1"></i>
	                                	이미지
	                            </div>
	                            <div class="card-body">
	                                <div class="table-responsive">
	                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
	                                        <thead>
	                                            <tr align="center">
	                                                <th style="width: 20%;">이미지</th>
	                                            </tr>
	                                        </thead>
	                                        <tbody>
	                                        	<tr>
	                                        		<td><img src="${contextPath}/files/event/2/이벤트이미지1.png" class="maxwid"></td>
	                                        	</tr>
	                                        </tbody>
	                                    </table>
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
