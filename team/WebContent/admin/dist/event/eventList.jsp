<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>        
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="eventListCount" value="${eventMap.eventListCount}"/>
<c:set var="eventList" value="${eventMap.eventList}"/>


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
                    	<div class="breadcrumb-item">
                        <div class="col-6"><h1 class="mt-4">이벤트</h1></div>
                        <div class="col-6 eventbutton" >
                        	<button type="button" class="btn btn-primary" onclick="location.href='${contextPath}/eventAdmin/addEvent.do'">이벤트 등록</button></div> 
                        </div>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table mr-1"></i>
                                	이벤트 관리             	
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr align="center">
                                                <th style="width: 8%;">번호</th>
                                                <th style="width: 12%;">이미지</th>
                                                <th style="width: 50%;">제목</th>
                                                <th style="width: 10%;">작성일</th>
                                                <th style="width: 15%;">관리</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<c:choose>
                                       			<c:when test="${eventListCount==0}">			
													<tr align="center">
														<td colspan="5">등록된 이벤트 없습니다.</td>
													</tr>
												</c:when>
												<c:otherwise>	
													<c:forEach var="event" items="${eventList}">
													<fmt:formatDate var="eventFmtDate" value="${event.eventWriteDate}" pattern="yyyy-MM-dd HH:mm"/>
			                                            <tr class="eventlist" onclick="readEvent('${event.eventNo}', event)">
			                                                <td>${event.eventNo}</td>
			                                                <td><img src="${contextPath}/files/event/${event.eventNo}/${event.eventImage}"></td>
			                                                <td>${event.eventTitle}</td>
			                                                <td>${eventFmtDate}</td>
			                                                <td>
			                                                	<button type="button" class="btn btn-warning" onclick="modifyEvent('${event.eventNo}', event)">수정</button>
			                                                	<button type="button" class="btn btn-danger" onclick="deleteEvent('${event.eventNo}', event)">삭제</button>
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
        <script type="text/javascript">
        function readEvent(eventNo,event) {
        	event.stopPropagation();
			var form = document.eventInfo;
        	form.action = "${contextPath}/eventAdmin/readEvent.do?eventNo=" + eventNo;
        	form.submit();
        }
        function modifyEvent(eventNo,event) {
        	event.stopPropagation();
			var form = document.eventInfo;
        	form.action = "${contextPath}/eventAdmin/modifyEvent.do?eventNo=" + eventNo;
        	form.submit();
        }
        function deleteEvent(eventNo,event) {
        	event.stopPropagation();
			var form = document.eventInfo;
        	form.action = "${contextPath}/eventAdmin/deleteEvent.do?eventNo=" + eventNo;
        	form.submit();
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
