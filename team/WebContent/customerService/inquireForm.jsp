<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
    <meta charset="UTF-8">
    <meta name="description" content="Anime Template">
    <meta name="keywords" content="Anime, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Anime | Template</title>

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
    <link rel="stylesheet" href="../css/customerService.css" type="text/css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>


<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

	<!-- Header -->
	<jsp:include page="../inc/header.jsp" />
 	
 	<!-- InquireForm Section Begin -->
    <section class="blog-details spad">
	    <div class="container">
		    <div class="row d-flex justify-content-center">
	            <div class="col-lg-8">
	                <div class="blog__details__title">
	                    <h2>고객센터</h2>
	                </div>
	            </div>
			    <div class="col-lg-12">
			        <div class="blog__details__content">
			     		<ul class="blog__details__btns">
	                        <li class="blog__details__btns__item">
	                            <h5><a href="notice.jsp">공지사항</a></h5>
	                        </li>
	                        <li class="blog__details__btns__item">
	                            <h5><a href="faq.jsp">자주 묻는 질문</a></h5>
	                        </li>
	                        <li class="blog__details__btns__item">
	                            <h5><a href="inquireForm.jsp">문의하기</a></h5>
	                        </li>
                        </ul>
                        <div class="blog__details__form">
	                        <h4>고객 문의</h4>
	                        <form action="#">
	                            <div style="margin-top: 45px;">
	                                <div class="col-lg-12">
	                                	<span style="color: #ffffff;">이름</span>
	                                	<input type="text" placeholder="Name">
	                                </div>
	                                 <!--  
	                                <div class="col-lg-6">
	                                	<span style="color: #ffffff;">이메일</span>
										<input type="text" placeholder="Email"><em>@</em>
										<input type="text">
										<select>
									        <option value="0">직접입력</option>
									        <option value="naver.com">naver.com</option>
									        <option value="daum.net">daum.net</option>
									        <option value="nate.com">nate.com</option>
									        <option value="gmail.com">gmail.com</option>
										</select>
	                                </div>
	                                <div class="col-lg-12">
	                                	<span style="color: #ffffff;">연락처</span>
	                                	<select>
	                                		<option value="">010</option>
	                                		<option value="">011</option>
	                                		<option value="">016</option>
	                                		<option value="">017</option>
	                                		<option value="">018</option>
	                                		<option value="">019</option>
	                                	</select>
	                                	-<input type="text">
	                                	-<input type="text">
	                                </div>-->
	                                <div class="col-lg-12">
	                                	<span style="color: #ffffff;">문의 제목</span>
										<input type="text" placeholder="제목을 입력해주세요">
	                                </div>
	                                <div class="col-lg-12">
	                                	<span style="color: #ffffff;">문의 내용</span>
	                                    <textarea placeholder="문의 내용을 입력해주세요"></textarea>
	                                    <button type="submit" class="site-btn">확인</button>
	                                    <button type="reset" class="site-btn">취소</button>
	                                </div>
	                            </div>
	                        </form>
	                    </div>
	                </div>
	            </div>
	        </div>
		</div>
    </section>
    <!-- InquireForm Section End -->
	
	
	<!-- footer영역 -->
	<jsp:include page="../inc/footer.jsp" />

</body>
</html>