<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zxx">
<head>
    <meta charset="UTF-8">
    <meta name="description" content="Anime Template">
    <meta name="keywords" content="Anime, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>회원가입</title>
    
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
    
    <script type="text/javascript">
	  //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
    	
    	
    </script>
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
                        <h2>Sign Up</h2>
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
                    		<h3 >Sign Up</h3>
                    	</div>
                        <form action="#">
                            <div class="input__item" style="margin-left: 50px;">
                                <input type="text" placeholder="아이디">
                                <span class="icon_profile"></span>
                            </div>
                            <div class="input__item" style="margin-left: 50px;">
                                <input type="text" placeholder="비밀번호">
                                <span class="icon_lock"></span>
                            </div>
                            <div class="input__item" style="margin-left: 50px;">
                                <input type="text" placeholder="비밀번호 확인">
                                <span class="icon_lock"></span>
                            </div>
                            <div class="input__item" style="margin-left: 50px;">
                                <input type="text" placeholder="사용자 이름">
                                <span class="icon_profile"></span>
                            </div>
							<div class="input__item" style="margin-left: 50px;">
                                <input type="text" placeholder="닉네임">
                                <span class="icon_profile"></span>
                            </div>
                            <div class="input__item" style="margin-left: 50px;">
                                <input type="text" placeholder="Email address">
                                <span class="icon_mail"></span>
                            </div>
                            
                            <div class="input__item" style="margin-left: 50px;">
                            	<label for="address">주소</label> <br />
                            	<input type="text" id="sample4_postcode"   placeholder="우편번호" name="address" readonly="readonly">
                            	<button type="button" onclick="sample4_execDaumPostcode()"> 우편번호 찾기 </button>
                            	<!-- <input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br> -->
                            </div>
        
                            <div class="input__item" style="margin-left: 50px;">
                            	<input type="text" id="sample4_roadAddress"  placeholder="도로명주소" name="userAddr1" readonly="readonly">
                            	<input type="text" id="sample4_jibunAddress"  placeholder="지번주소" name="address2" readonly="readonly">
								<span id="guide" style="color:#999;display:none"></span>
								<input type="text" id="sample4_extraAddress" placeholder="상세주소" name="address3">
                            </div>
				  	     	<div style="margin-left: 140px;">
                            	<button type="submit" class="site-btn" >Login Now</button>	
                           	</div>
                        </form>
                    </div>
            </div>
        </div>
    </section>
    <!-- Signup Section End -->

    <jsp:include page="../inc/footer.jsp" />

</body>

</html>