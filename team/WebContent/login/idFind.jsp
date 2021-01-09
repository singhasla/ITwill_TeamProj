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
    <title>아이디 찾기</title>
    
   	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
 

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
    <link rel="stylesheet" href="../css/signup.css" type="text/css">
   

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
                        <h2>Find ID</h2>
                        <p>Welcome to the official Anime blog.</p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Normal Breadcrumb End -->

    <!-- Signup Section Begin -->
    <section class="signup spad">
        <div class="container">
            <div >
                    <div class="join__form">
                    	<div  style="margin-left: 160px;">
                    		<h3 >Find ID</h3>
                    	</div>
                    	<c:choose>
	                    	<c:when test="${userID == null }">
		                        <form action="${contextPath}/user/idfindAct.do" method="post"  name="userForm" onsubmit="return check();">
		                            <div class="input__item" style="margin-left: 50px;">
		                                <input type="text" placeholder="이름을 입력해주세요" name="userName" id="userName" required="required">
		                                <span class="icon_lock"></span>
		                            </div>
		                            <div class="input__item" style="margin-left: 50px;">
		                                <input type="text" placeholder="이메일을 입력해주세요" name="userEmail" id="userEmail" required="required">
		                                <span class="icon_mail"></span>
		                            </div>
		
						  	     	<div style="margin-left: 140px;">
		                            	<button type="submit" class="site-btn" >아이디 찾기 </button>	
		                           	</div>
		                        </form>
	                        </c:when>
	                        <c:otherwise>
          						
									<div >
										<h3 style="color: white; margin-left: 90px;" >고객님의 아이디는</h3>
										<h2 class="p-3 text-danger" style="color: white; margin-left: 150px;">${userID}</h2>
										<h3 style="color: white; margin-left: 167px;" >입니다.</h3>
									</div>
									<a class="site-btn" style="margin-left: 98px;" href="${contextPath}/user/loginPage.do">로그인 페이지로 이동하기</a>
								
	                        </c:otherwise>
                        </c:choose>
                    </div>
            </div>
        </div>
    </section>
    
    <c:choose>
	<c:when test='${msg=="no"}'>
		<script>
			window.onload = function(){
				window.alert("회원정보가 존재하지 않습니다.");
			}
		</script>
	</c:when>
</c:choose>
    <!-- Signup Section End -->

    <jsp:include page="../inc/footer.jsp" />

</body>

</html>