<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="userNo" value="${sessionScope.userNo}"/>
<%--String userNo = (String)session.getAttribute("userNo"); --%>

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
	<link
		href="https://fonts.googleapis.com/css2?family=Oswald:wght@300;400;500;600;700&display=swap"
		rel="stylesheet">
	<link
		href="https://fonts.googleapis.com/css2?family=Mulish:wght@300;400;500;600;700;800;900&display=swap"
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
</head>

<body>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>

	<!-- Header Section Begin -->
	<jsp:include page="../inc/header.jsp" />
	<!-- Header End -->

	<!-- Blog Details Section Begin -->
	<section class="blog-details spad">
		<div class="container">
			<div class="row d-flex justify-content-center">
				<div class="col-12">
					<div class="blog__details__title">
						<h2>장바구니</h2>
					</div>
				</div>
				<div class="col-8">
					<table class="table table-hover">
						<thead>
							<p style="color: white;">${userID} 님의 장바구니에 담긴 상품입니다.</p>
							<tr style="color: white;">
								<th scope="col">#</th>
								<th width="15%" scope="col" style="text-align: center">영화</th>
								<th width="50%" scope="col">제목</th>
								<th width="20%" scope="col">가격</th>
								<th width="15%">
								<button>
									<a href="${contextPath}/ordersvlt/allDelCart.do?userNo=${userNo}">
										전체 삭제
									</a></button>
								</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${myCartList == null}">
										<tr>
											<td colspan="5" align="center">장바구니에 담긴 상품이 없습니다.</td>
										</tr>
								</c:when>
								
								<c:when test="${myCartList != null}">
									<c:forEach var="cartListInf" items="${myCartList}" varStatus="status">
										<tr style="color: white;">
											<td scope="row" style="vertical-align: middle">${status.index+1}</td>
											<td><img src="${cartListInf.movieImage}" class="cart_thumbnail"/></td>
											<td style="vertical-align: middle">${cartListInf.movieName}</td>
											<td style="vertical-align: middle">
												<fmt:formatNumber type="number" maxFractionDigits="3" value="${cartListInf.moviePrice}"/>
											</td>
											<td style="vertical-align: middle; text-align: center;">
												<a class="icon_trash" href="${contextPath}/ordersvlt/delCart.do?userNo=${userNo}&movieNo=${cartListInf.movieNo}"></a>
											</td>
										</tr>
									</c:forEach>
								</c:when>
							</c:choose>
							
							<tr style="color: white;">
								<td colspan="3" align="right">총 결제 금액 :</td>
								
								<td>
									<fmt:formatNumber type="number" maxFractionDigits="3" value="${TotalPrice}"/>원
								</td>
								<td><button>
									<a href="${contextPath}/ordersvlt/pay.do">
										결제하기
									</a>
									</button>
								</td>
							</tr>
						</tbody>
					</table>
					<div class="col-12">
                    <div class="blog__details__content">
                        <div class="blog__details__text" style="color: white; font-size: 10px">
                        	만 14세 이상 회원만 구매 가능합니다.<br>
							미성년자의 콘텐츠 구매 시 법정대리인의 동의를 받아야 하며, 동의를 받지 않은 경우 법정 대리인이 이를 취소할 수 있습니다.<br>
							상품 구매 후 사용 내역이 없는 경우 7일 이내에 고객센터를 통해 이용신청의 철회가 가능하며, 7일이 경과한 이후에는 위약금을 제하고 환불 가능합니다.<br>
							이미 다운로드 및 스트리밍하여 사용한 상품에 대해서는 결제취소 및 청약철회가 불가능하며, 여러 개의 콘텐츠로 구성된 상품의 경우에는 사용하지 않는 부분에 한해 환불이 가능합니다.<br>
							상품에 표시된 정보 ∙ 광고의 내용과 다르거나 계약내용이 다르게 이행된 경우 구매일로부터 3개월 이내 또는 그 사실을 안 날 또는 알 수 있었던 날부터 30일 이내 청약철회가 가능합니다.<br>
							청약철회일로부터 3일 이내 결제 수단과 동일한 방법으로 환불 처리됩니다. 단, 관련업체(신용카드, 휴대전화 등)의 사정에 따라 변경될 수 있습니다.
                        </div>
                    </div>
				</div>
			</div>
		</div>
	</section>
	<!-- Blog Details Section End -->

	<!-- Footer Section Begin -->
	<jsp:include page="../inc/footer.jsp" />
	<!-- Footer Section End -->


	<!-- Js Plugins -->
	<script src="../js/jquery-3.3.1.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/player.js"></script>
	<script src="../js/jquery.nice-select.min.js"></script>
	<script src="../js/mixitup.min.js"></script>
	<script src="../js/jquery.slicknav.js"></script>
	<script src="../js/owl.carousel.min.js"></script>
	<script src="../js/main.js"></script>

</body>

</html>