<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <c:set var="userTel" value="${userTel}" />
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>전화번호 중복확인</title>
<script>
	function result() {
		opener.document.userForm.userTel.value = document.checkform.userTel.value;
		opener.document.userForm.telCheckState.value = 1;
		window.close();
	}
	
</script>
</head>
<body>
	<div>
		<form action="${contextPath}/user/telCheck.do" method="post" name="checkform">
			<div>
				<input type="text" class="form-control" name="userTel" id=userTel value="${userTel}" maxlength="20" required>
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
		<c:when test='${msg=="used"}'>
			<script>
				window.onload = function() {
					window.alert("이미 사용중 입니다.");
				}
			</script>
		</c:when>
		<c:when test='${msg=="allow"}'>
			<script>
				window.onload = function() {
					window.alert("사용가능 합니다.");
				}
			</script>
		</c:when>
	</c:choose>
</body>
</html>