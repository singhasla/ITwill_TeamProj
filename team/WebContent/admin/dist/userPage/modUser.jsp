<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>        
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="user" value="${userVO}" />
<c:set var="result" value="${result}" />
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
       	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
		<script  src="${contextPath}/admin/dist/userJS/moduser.js"></script>
    </head>
    <body class="sb-nav-fixed">
    <!-- 헤더 -->
	<jsp:include page="../adminInc/header.jsp"/>
	
        <div id="layoutSidenav">
        <!-- 사이드 메뉴 -->
        	<jsp:include page="../adminInc/sidenav.jsp"/>
        	
            <div id="layoutSidenav_content">
			<article class="user">
			<div style="margin-left: 100px; margin-right: 100px;">
				<fmt:formatDate var="userFormattedDate" value="${user.userWriteDate}" pattern="yyyy-MM-dd HH:mm"/>
				<fmt:formatDate var="userUpdate" value="${user.userUpdate}" pattern="yyyy-MM-dd HH:mm"/>
				<form action="${contextPath}/adminPage/updateUser.do" method="post" name="userForm">
					<input type="hidden" name="nicknameCheckState" value="0" />
					<input type="hidden" name="telCheckState" value="0" />
					<table class="table"  >
						<colgroup>
							<col style="width: 120px" />
							<col />
						</colgroup>
						<tr>
							<th class="align-middle">
								<label for="userID" class="m-0">아이디</label>
							</th>
							<td>
								<input class="form-control" type="text" name="userID" id="userID" value="${user.userID}" required readonly />
							</td>
						</tr>
						<tr>
							<th class="align-middle">
								<label for="userName" class="m-0">이름</label>
							</th>
							<td>
								<input class="form-control" type="text" name="userName" id="userName" value="${user.userName}" required readonly />
							</td>
						</tr>
						<tr>
							<th class="align-middle">
								<label for="userNickname" class="m-0">닉네임</label>
							</th>
							<td>
								<div class="input-group">
									<input class="form-control" type="text" name="userNickname" id="userNickname" value="${user.userNickname}" onkeyup="resetCheck2()" required />
									<div class="input-group-append">
										<!-- <button class="btn btn-secondary" type="button" onclick="nickCheck()">중복체크</button> -->
									</div>
								</div>
							</td>
						</tr>
						<tr>
							<th class="align-middle">
								<label for="userWriteDate" class="m-0">가입일</label>
							</th>
							<td>
								<input class="form-control" type="text" name="userWriteDate" id="userWriteDate" value="${userFormattedDate}" required readonly="readonly" />
							</td>
						</tr>
						<tr>
							<th class="align-middle">
								<label for="userTel" class="m-0">전화번호</label>
							</th>
							<td>
								<input class="form-control" type="text" name="userTel" id="userTel" value="${user.userTel}" placeholder="010-0000-0000" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" onkeyup="resetCheck3()" required />
							</td>
						</tr>
						<tr>
							<th class="align-middle">
								<label for="userEmail" class="m-0">이메일</label>
							</th>
							<td>
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text">@</span>
									</div>
									<input type="email" class="form-control" name="userEmail" id="userEmail" value="${user.userEmail}" required readonly>
								</div>
							</td>
						</tr>
						<tr>
							<th class="align-middle">
								<label for="userAddr1" class="m-0">우편번호</label>
							</th>
							<td>
								<div class="input-group">
									<input type="text" class="form-control" name="userAddr1" id="sample4_postcode" value="${user.userAddr1}"  />
									<div class="input-group-append">
										<button class="btn btn-secondary" type="button" onclick="sample4_execDaumPostcode()">우편번호 검색</button>
									</div>
								</div>
							</td>
						</tr>
						<tr>
							<th class="align-middle">
								<label for="userAddr2" class="m-0">도로명주소</label>
							</th>
							<td>
								<input class="form-control" type="text" name="userAddr2" id="sample4_roadAddress" value="${user.userAddr2}"  />
							</td>
						</tr>
						<tr>
							<th class="align-middle">
								<label for="userAddr3" class="m-0">지번주소</label>
							</th>
							<td>
								<input class="form-control" type="text" name="userAddr3" id="sample4_jibunAddress" value="${user.userAddr3}"  />
							</td>
						</tr>
						<tr>
							<th class="align-middle">
								<label for="userAddr4" class="m-0">상세주소</label>
								<span id="guide" style="color:#999;display:none"></span>
							</th>
							<td>
								<input class="form-control" type="text" name="userAddr4" id="sample4_extraAddress" value="${user.userAddr4}"  />
							</td>
						</tr>
						<tr>
							<th class="align-middle">
								<label for="userWriteDate" class="m-0">회원 수정일</label>
							</th>
							<td>
								<input class="form-control" type="text" name="userWriteDate" id="userWriteDate" value="${userUpdate}"  readonly="readonly" />
							</td>
						</tr>
					</table>
					<div class="text-center my-5">
						<button type="button" class="btn btn-secondary" onclick="history.back()">취소</button>
						<button type="submit" class="btn btn-warning">수정하기</button>
					</div>
				</form>
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
