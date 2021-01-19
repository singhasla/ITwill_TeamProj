<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>KakaoPay</title>
<script type="text/javascript"	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript"	src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>

</head>
<body>

	<script>
		var IMP = window.IMP; // 생략가능
		IMP.init('imp33781906'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용

		IMP.request_pay({
			pg : 'kakao', // version 1.1.0부터 지원.
			pay_method : 'card',
			merchant_uid : 'merchant_' + new Date().getTime(),
			name : '[${firstMN}] 외 ${totalcount-1}건 결제',
			amount : '${totalprice}'
		}, function(rsp) {
			if (rsp.success) {
				var msg = '결제가 완료되었습니다. ';
				msg += '결제 금액 : ' + rsp.paid_amount;
				
				//성공시 이동할 페이지
                location.href='<%=request.getContextPath()%>/ordersvlt/paycomplt.do';
			
			} else {
				var msg = '결제에 실패하였습니다. ';
				msg += '에러내용 : ' + rsp.error_msg;
				
				//실패시 이동할 페이지
                location.href='<%=request.getContextPath()%>/ordersvlt/cart.do';
			}
			alert(msg);
		});
	</script>

</body>
</html>