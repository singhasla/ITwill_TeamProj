<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>        
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="qna" value="${qnaVO}"/>
<fmt:formatDate var="qnaFmtDate" value="${qna.qnaWriteDate}" pattern="yyyy-MM-dd HH:mm"/>
<fmt:formatDate var="answerFmtDate" value="${qna.answerWriteDate}" pattern="yyyy-MM-dd HH:mm"/>
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
                        <h1 class="mt-4">문의 사항</h1>
                        <div class="row">
	                        <div class="card mb-4 ecol-12">
	                            <div class="card-header">
	                                <i class="fas fa-table mr-1"></i>
	                                	문의 사항 관리
	                            </div>
	                            <div class="card-body">
	                                <div class="table-responsive">
	                                    <table class="table table-bordered bdlr" id="dataTable" width="100%" cellspacing="0">
	                                        <colgroup>
												<col width="20%">
												<col width="*">
												<col width="20%">
												<col width="*">
											</colgroup>
	                                        <tbody>
			                                    <tr align="center"><th colspan="4">문의 내역 정보</th></tr>    
			                                    <tr>
													<th>번호</th>
													<td>${qna.qnaNo}</td>
													<th>구분</th>
													<td>${qna.qnaCategory}</td>
												</tr>
												<tr>
													<th>작성자</th>
													<td>${qna.userNo}</td>
													<th>문의 작성일</th>
													<td>${qnaFmtDate}</td>
												</tr>
												<tr>
													<th>문의 제목</th>
													<td colspan="3">${qna.qnaTitle}</td>
												</tr>
												<tr>
													<th>문의 내용</th>
													<td colspan="3">${qna.qnaContent}</td>
												</tr>
												<tr>
													<th>답변 내용</th>
													<c:choose>
														<c:when test="${qna.answerContent!=null}">
															<td colspan="3">${qna.answerContent}</td>
														</c:when>
														<c:otherwise>
															<td colspan="3">
																<button type="button" class="btn btn-warning" onclick="answerQna('${qna.qnaNo}', event)">답변 달기</button>
															</td>
														</c:otherwise>
													</c:choose>
												</tr>
												<c:choose>
													<c:when test="${qna.answerWriteDate!=null}">
													<tr>	
														<th>답변 작성일</th>
														<td colspan="3">${answerFmtDate}</td>
													</tr>
													</c:when>
													<c:otherwise>
													<tr style="display: none;">
														<th>답변 작성일</th>
														<td colspan="3"></td>
													</tr>
													</c:otherwise>
												</c:choose>
	                                        </tbody>
	                                    </table>
	                                    <div class="text-center">
											<button type="button" class="btn btn-secondary" onclick="location.href='${contextPath}/qnaAdmin/listQna.do'">목록</button>
											<c:choose>
												<c:when test="${qna.answerContent!=null}">
													<button type="button" class="btn btn-primary" onclick="answerQna('${qna.qnaNo}', event)">답변수정</button>
												</c:when>
												<c:otherwise>
													<button type="button" class="btn btn-primary" onclick="answerQna('${qna.qnaNo}', event)">답변</button>
												</c:otherwise>
											</c:choose>
			                                <button type="button" class="btn btn-danger" onclick="deleteQna('${qna.qnaNo}', event)">삭제</button>
										</div>
	                                </div>
	                            </div>
	                        </div>
	                       
                        </div>
                    </div>
                </main>
                <form method="post"	name="qnaInfo"></form>
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
