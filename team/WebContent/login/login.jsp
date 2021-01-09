<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Anime Template">
    <meta name="keywords" content="Anime, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>로그인</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Mulish:wght@300;400;500;600;700;800;900&display=swap"
    rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="../css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="../css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="../css/plyr.css" type="text/css">
    <link rel="stylesheet" href="../css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="../css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="../css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="../css/style.css" type="text/css">
    <link rel="stylesheet" href="../css/login.css" type="text/css">
</head>
<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

	<!-- Header -->
	<jsp:include page="../inc/header.jsp" />
    

    <!-- Normal Breadcrumb Begin -->
    <section class="normal-breadcrumb set-bg" data-setbg="../img/normal-breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="normal__breadcrumb__text">
                        <h2>Login</h2>
                        <p>Welcome to the official Anime blog.</p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Normal Breadcrumb End -->

    <!-- Login Section Begin -->
    <section class="login spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <div class="login__form">
                        <h3>Login</h3>
                        <form action="${contextPath}/user/login.do" method="post">
                            <div class="input__item">
                                <input type="text"  name="userID" required autofocus placeholder="ID" />
                                <span class="icon_profile"></span>
                            </div>
                            <div class="input__item">
                                <input type="password"  name="userPW" required autofocus  placeholder="PASSWORD"/>
                                <span class="icon_lock"></span>
                            </div>
                           
                            <button type="submit" class="site-btn">Login Now</button>
                             	<a href="${contextPath}/user/findId.do" class="forget_pass1">Forgot ID</a>&nbsp&nbsp
                        	<a href="${contextPath}/login/pwFind.jsp" class="forget_pass1">Forgot PW</a>
                        </form>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="login__register">
                        <h3>Dont’t Have An Account?</h3>
                        <a href="${contextPath}/user/signupForm.do" class="primary-btn">Register Now</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    
	    <c:choose>
		<c:when test='${msg=="id"}'>
			<script>
				window.onload = function(){
					window.alert("존재하지 않는 아이디 입니다.");
				}
			</script>
		</c:when>
		<c:when test='${msg=="pw"}'>
			<script>
				window.onload = function(){
					window.alert("비밀번호가 일치하지 않습니다.");
				}
			</script>
		</c:when>
	</c:choose>
    <!-- Login Section End -->

   <jsp:include page="../inc/footer.jsp" />

</body>

</html>