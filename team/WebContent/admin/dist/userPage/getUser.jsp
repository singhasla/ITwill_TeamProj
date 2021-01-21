<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>        
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="user" value="${userVO}" />
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>관리자 페이지입니다-(회원수정)</title>
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
			<article class="user">
			<div style="margin-left: 100px; margin-top: 50px;"><h1>회원상세</h1></div>
			<div style="margin-left: 80px; margin-right: 80px; margin-top: 50px;">
				<fmt:formatDate var="userFormattedDate" value="${user.userWriteDate}" pattern="yyyy-MM-dd HH:mm"/>
				<fmt:formatDate var="userUpdate" value="${user.userUpdate}" pattern="yyyy-MM-dd HH:mm"/>
				<table class="table read-table table-layout-fixed">
				<colgroup>
					<col style="width:120px" />
					<col />
				</colgroup>
				<tbody>
					<tr>
						<th>아이디</th>
						<td>${user.userID}</td>
					</tr>
					<tr>
						<th>가입일</th>
						<td>${userFormattedDate}</td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td>${user.userPW}</td>
					</tr>
					<tr>
						<th>이름</th>
						<td>${user.userName}</td>
					</tr>
					<tr>
						<th>닉네임</th>
						<td>${user.userNickname}</td>
					</tr>
					<tr>
						<th>이메일</th>
						<td>${user.userEmail}</td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td>${user.userTel}</td>
					</tr>
					<tr>
						<th>우편번호</th>
						<td>${user.userAddr1}</td>
					</tr>
					<tr>
						<th>주소</th>
						<td>${user.userAddr2}</td>
					</tr>
					<tr>
						<th>상세주소</th>
						<td>${user.userAddr3}</td>
					</tr>
					<tr>
						<th>추가</th>
						<td>${user.userAddr4}</td>
					</tr>

					<tr>
						<th>회원 수정일</th>
						<td>${userUpdate}</td>
					</tr>
				</tbody>
				</table>
					<div class="text-center my-5">
						<button type="button" class="btn btn-secondary" onclick="location.href='${contextPath}/adminPage/dashBoard.do'">목록</button>
						<button type="button" class="btn btn-warning" onclick="location.href='${contextPath}/adminPage/modUser.do?userID=${user.userID}'">수정</button>
						<button type="button" class="btn btn-danger">삭제</button>
					</div>
				
				</div>
			</article>


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
