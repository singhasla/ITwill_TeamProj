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
                        <h1 class="mt-4">이벤트</h1>
                        <div class="row">
	                        <div class="card mb-4 ecol-12 ecol-lg-8 ecol-xl-9">
	                            <div class="card-header">
	                                <i class="fas fa-table mr-1"></i>
	                                	이벤트 관리
	                            </div>
	                            <div class="card-body">
	                                <div class="table-responsive">
	                                	<form action="${contextPath}/eventAdmin/insertEvent.do" method="post" enctype="multipart/form-data" >
		                                    <table class="table table-bordered" width="100%" cellspacing="0">
		                                        <colgroup>
													<col width="20%">
													<col width="*">
												</colgroup>
		                                        <tbody>
		                                        	<tr align="center"><th colspan="2" >이벤트 등록</th></tr>
		                                        	<tr>
														<th>제목</th>
														<td>
															<input type="text" name="eventTitle" placeholder="제목을 입력해 주세요." class="widhun">
														</td>
													</tr>
													<tr>
														<th>내용</th>
														<td>
															<textarea cols="40" rows="15" name="eventContent" placeholder="내용을 입력해 주세요."></textarea>
														</td>
													</tr>
													<tr>
														<th>첨부파일</th>
														<td>
															<input type="file" name="eventImage" id="eventImage" onchange="showPreview(this, 'image')"/>
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
	                        <div class="card mb-4  ecol-12 ecol-lg-4 ecol-xl-3">
	                            <div class="card-header">
	                                <i class="fas fa-table mr-1"></i>
	                                	썸네일
	                            </div>
	                            <div class="card-body">
	                                <div class="table-responsive">
	                                    <table class="table table-bordered" width="100%" cellspacing="0">
	                                        <thead>
	                                            <tr align="center">
	                                                <th style="width: 20%;">이미지</th>
	                                            </tr>
	                                        </thead>
	                                        <tbody>
	                                        	<tr>
	                                        		<td><img src="" id="thumbnail" class="maxwid"></td>
	                                        	</tr>
	                                        </tbody>
	                                    </table>
	                                </div>
	                            </div>
	                        </div>
                        </div>
                    </div>
                </main>
               <form method="post"	name="eventInfo"></form>
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
        
        <script>
    	function showPreview(obj, allowType){
    		
    		if(obj.files && obj.files[0]){
    			var fileType = obj.files[0].type.split("/")[0];
    			
    			if(fileType=="image"){
    				
    				var reader = new FileReader();				
    				reader.readAsDataURL(obj.files[0]);
    				
    				reader.onload = function(ProgressEvent){
    					$("#thumbnail").attr("src", ProgressEvent.target.result)
    				}
    			}else{
    				if(allowType=="image"){
    					alert("이미지 파일만 첨부하실 수 있습니다.");
    					obj.value = "";
    				}
    			}
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
