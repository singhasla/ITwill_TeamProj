<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <c:set var="userID" value="${userID}" />
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>id 중복확인</title>
<script>
	function result() {
		opener.document.userForm.userID.value = document.checkform.userID.value;
		opener.document.userForm.idCheckState.value = 1;
		window.close();
	}
	
</script>
</head>
<body>
	<div>
		<form action="${contextPath}/user/idCheck.do" method="post" name="checkform">
			<div>
				<input type="text" class="form-control" name="userID" id="userID" value="${userID}" maxlength="20" required>
				<div >
					<button type="submit" class="btn btn-secondary">중복확인</button>
				</div>
			</div>
		</form>
	</div>
	<c:if test='${msg=="allow"}'>
		<div class="text-center">
			<button type="button" class="btn btn-primary" onclick="result()">사용하기</button>
		</div>
	</c:if>
	
	<c:choose>
		<c:when test='${msg=="char"}'>
			<script>
				window.onload = function() {
					window.alert("아이디를 4~12자까지 입력해주세요.");
				}
			</script>
		</c:when>
		<c:when test='${msg=="used"}'>
			<script>
				window.onload = function() {
					window.alert("사용중인 아이디 입니다.");
				}
			</script>
		</c:when>
		<c:when test='${msg=="allow"}'>
			<script>
				window.onload = function() {
					window.alert("사용가능한 아이디 입니다.");
				}
			</script>
		</c:when>
	</c:choose>
</body>
</html>