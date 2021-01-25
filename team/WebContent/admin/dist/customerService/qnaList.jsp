<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>        
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="qnaListCount" value="${qnaListCount}"/>
<c:set var="qnaList" value="${qnaList}"/>


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
                        	<div class="col-6"><h1 class="mt-4">문의 사항</h1></div>
                        	<div class="col-6 eventbutton" >
	                        	<form>
	                        		<c:choose>
										<c:when test='${answerCheck != null && !answerCheck.equals("")}'>
											<input type="checkbox" class="custom-control-input" name="answerCheck" id="answerCheck" checked onclick="this.form.submit()">
										</c:when>
										<c:otherwise>
											<input type="checkbox" class="custom-control-input" name="answerCheck" id="answerCheck" onclick="this.form.submit()">
										</c:otherwise>
									</c:choose>
									<label class="custom-control-label" for="answerCheck">답변대기 상태인 글만 보기</label>
	                        	</form> 
                        	</div>
                        </div>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table mr-1"></i>
                                	문의 사항 관리             	
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr align="center">
                                                <th style="width: 8%;">번호</th>
                                                <th style="width: 10%;">구분</th>
                                                <th style="width: 35%;">문의내용</th>
                                                <th style="width: 8%;">작성자</th>
                                                <th style="width: 14%;">작성일</th>
                                                <th style="width: 10%;">상태</th>
                                                <th style="width: 15%;">관리</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<c:choose>
                                       			<c:when test="${qnaListCount==0}">			
													<tr align="center">
														<td colspan="7">등록된 공지사항 없습니다.</td>
													</tr>
												</c:when>
												<c:otherwise>	
													<c:forEach var="qna" items="${qnaList}">
													<fmt:formatDate var="qnaFmtDate" value="${qna.qnaWriteDate}" pattern="yyyy-MM-dd HH:mm"/>
			                                            <tr class="eventlist" onclick="readQna('${qna.qnaNo}', event)">
			                                                <td>${qna.qnaNo}</td>
			                                                <td>${qna.qnaCategory}</td>
			                                                <td>${qna.qnaTitle}</td>
			                                                <td>${qna.userNo}</td>
			                                                <td>${qnaFmtDate}</td>
			                                                <td>
			                                                <c:choose>
																<c:when test="${qna.answerContent!=null}">
																	<div style="color: #dc3545">답변완료</div>
																</c:when>
																<c:otherwise>
																	<div style="color: #0062cc">답변대기</div>
																</c:otherwise>
															</c:choose>
															</td>
			                                                <td>
			                                                	<button type="button" class="btn btn-warning" onclick="answerQna('${qna.qnaNo}', event)">답변</button>
			                                                	<button type="button" class="btn btn-danger" onclick="deleteQna('${qna.qnaNo}', event)">삭제</button>
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
                <form method="post"	name="qnaInfo">
                	<input type="hidden" name="answerCheck" value="${answerCheck}" />
                </form>
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
        function listQna(){
        	var form = document.qnaInfo;
        	form.action = "${contextPath}/qnaAdmin/listQna.do";	
        	form.submit();
        }
        function readQna(qnaNo,event) {
        	event.stopPropagation();
			var form = document.qnaInfo;
        	form.action = "${contextPath}/qnaAdmin/readQna.do?qnaNo=" + qnaNo;
        	form.submit();
        }
        function answerQna(qnaNo,event) {
        	event.stopPropagation();
			var form = document.qnaInfo;
        	form.action = "${contextPath}/qnaAdmin/answerQna.do?qnaNo=" + qnaNo;
        	form.submit();
        }
        function deleteQna(qnaNo,event) {
        	event.stopPropagation();
			var form = document.qnaInfo;
        	if(confirm("정말로 삭제하시겠습니까?")) {
        		form.action = "${contextPath}/qnaAdmin/deleteQna.do?qnaNo=" + qnaNo;
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
