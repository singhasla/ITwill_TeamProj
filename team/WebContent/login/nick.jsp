<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <c:set var="userNickname" value="${userNickname}" />
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>nickName 중복확인</title>
<script>
	function result() {
		opener.document.userForm.userNickname.value = document.checkform.userNickname.value;
		opener.document.userForm.nicknameCheckState.value = 1;
		window.close();
	}
	
</script>
</head>
<body>
	<div>
		<form action="${contextPath}/user/nickCheck.do" method="post" name="checkform">
			<div>
				<input type="text" class="form-control" name="userNickname" id="userNickname" value="${userNickname}" maxlength="20" required>
				<div align="center">
					<c:if test='${msg=="allow"}'>
						<div class="text-center">
							<button type="button" class="btn btn-primary" onclick="result()">사용하기</button>
							<button type="submit" class="btn btn-secondary">중복확인</button>
						</div>
					</c:if>
					<c:if test='${msg=="used"}'>
						<div class="text-center">
							<button type="submit" class="btn btn-secondary">중복확인</button>
						</div>
					</c:if>
				</div>
			</div>
		</form>
	</div>

	
	<c:choose>
		<c:when test='${msg=="used"}'>
			<script>
				window.onload = function() {
					window.alert("사용중인 닉네임 입니다.");
				}
			</script>
		</c:when>
		<c:when test='${msg=="allow"}'>
			<script>
				window.onload = function() {
					window.alert("사용가능한 닉네임  입니다.");
				}
			</script>
		</c:when>
	</c:choose>
</body>
</html>