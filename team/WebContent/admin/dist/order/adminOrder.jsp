<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="action" value="${action}" /><!-- orderList.do / sales.do -->
<c:set var="orderList" value="${orderList}" />
<c:set var="periodList" value="${periodList}" />
<fmt:formatNumber type="number" maxFractionDigits="3" value="${periodSales}" var="periodSales" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>관리자 페이지입니다</title>
<link href="${contextPath}/admin/dist/css/styles.css" rel="stylesheet" />
<link
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
	rel="stylesheet" crossorigin="anonymous" />
<link rel="stylesheet" href="${contextPath}/css/elegant-icons.css"
	type="text/css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js"
	crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
	<!-- 헤더 -->
	<jsp:include page="../adminInc/header.jsp" />
	<div id="layoutSidenav">
		<!-- 사이드 메뉴 -->
		<jsp:include page="../adminInc/sidenav.jsp" />
		<div id="layoutSidenav_content">
			<main>
			<div class="container-fluid">
				<h1 class="mt-4">주문관리 (총 매출액 <fmt:formatNumber value="${totalSales}" type="number" maxFractionDigits="3"/>원)</h1>
				
				<div class="card mb-4">
					<div class="card-header">
						<i class="fas fa-table mr-1"></i> ORDER DataTable
					</div>
					
					<!-- 매출액 -->
					<form action="${contextPath}/adminOrdersvlt/sales.do" method="post">
						<div class="row card-body">
							<div class="col-sm-12 col-md-3" id="dataTable_filter">
								<label>검색할 시작 결제일</label> <input type="date" name="start"
									max="3000-12-31" min="1000-01-01" class="form-control" />
							</div>
							<div class="col-sm-12 col-md-3" id="dataTable_filter">
								<label>검색할 종료 결제일</label> <input type="date" name="end"
									max="3000-12-31" min="1000-01-01" class="form-control" />
							</div>
							<div class="col-sm-12 col-md-1" id="dataTable_filter">
								<button style="margin-top: 32px" type="submit"
									class="form-control">검색</button>
							</div>
							<div class="col-sm-12 col-md-2" id="dataTable_filter">
								<label>해당 결제일 내 매출금액</label> 
								<input type="text" name="total1" value="${periodSales}" class="form-control" readonly="readonly">
							</div>
							<!-- 
									<div class="col-sm-12 col-md-2" id="dataTable_filter">
										<input type="text" name="total2" class="form-control" readonly="readonly">
										<button style="margin-top: 32px;" type="submit" class="form-control">총 매출액</button>
									</div>
								-->
						</div>
					</form>

					<div class="card-body">
						<div class="table-responsive">
							<table class="table table-bordered" id="dataTable" width="100%"
								cellspacing="0">
								<thead>
									<tr style="text-align: center;">
										<th style="width: 7%">주문번호</th>
										<th style="width: 15%">결제일</th>
										<th style="width: 5%">userNo</th>
										<th style="width: 15%">아이디</th>
										<th style="width: 5%">movieNo</th>
										<th style="width: 25%">영화이름</th>
										<th style="width: 11%">상품금액</th>
										<th style="width: 11%">결제상태<br>(0:결제대기,<br>1:결제완료)
										</th>
										<th style="width: 6%">삭제</th>
									</tr>
								</thead>

								<tbody>
									<c:if test="${action ne '/sales.do'}">
										<c:choose>
											<c:when test="${orderList==null}">
												<tr>
													<td style="text-align: center; font-size: 30px;"
														colspan="9">결제 내역이 없습니다.</td>
												</tr>
											</c:when>
											<c:otherwise>
												<c:forEach var="order" items="${orderList}">
													<tr>
														<td>${order.orderNo}</td>
														<td><fmt:formatDate value="${order.orderWriteDate}"
																type="both" pattern="yyyy-MM-dd hh:mm:ss" /></td>
														<td>${order.userNo}</td>
														<td>${order.userID}</td>
														<td>${order.movieNo}</td>
														<td>${order.movieName}</td>
														<td><fmt:formatNumber value="${order.moviePrice}" type="number" maxFractionDigits="3"/></td>
														<td>${order.orderStatus}</td>
														<td style="vertical-align: middle; text-align: center;">
															<a class="icon_trash"
															href="${contextPath}/adminOrdersvlt/delOrder.do?orderNo=${order.orderNo}"></a>
														</td>
													</tr>
												</c:forEach>
											</c:otherwise>
										</c:choose>
									</c:if>
									<c:if test="${action eq '/sales.do'}">
										<c:choose>
											<c:when test="${periodList==null}">
												<tr>
													<td style="text-align: center; font-size: 30px;"
														colspan="8">해당 기간내 결제된 내역이 없습니다.</td>
												</tr>
											</c:when>
											<c:otherwise>
												<c:forEach var="period" items="${periodList}">
													<tr>
														<td>${period.orderNo}</td>
														<td><fmt:formatDate value="${period.orderWriteDate}"
																type="both" pattern="yyyy-MM-dd hh:mm:ss" /></td>
														<td>${period.userNo}</td>
														<td>${period.userID}</td>
														<td>${period.movieNo}</td>
														<td>${period.movieName}</td>
														<td><fmt:formatNumber value="${period.moviePrice}" type="number" maxFractionDigits="3"/></td>
														<td>${period.orderStatus}</td>
														<td style="vertical-align: middle; text-align: center;">
															<a class="icon_trash"
															href="${contextPath}/adminOrdersvlt/delOrder.do?orderNo=${period.orderNo}"></a>
														</td>
													</tr>
												</c:forEach>
											</c:otherwise>
										</c:choose>
									</c:if>

								</tbody>
							</table>
						</div>

					</div>
				</div>
			</div>
			</main>
			<footer class="py-4 bg-light mt-auto">
				<div class="container-fluid">
					<div
						class="d-flex align-items-center justify-content-between small">
						<div class="text-muted">Copyright &copy; Your Website 2020</div>
						<div>
							<a href="#">Privacy Policy</a> &middot; <a href="#">Terms
								&amp; Conditions</a>
						</div>
					</div>
				</div>
			</footer>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="${contextPath}/admin/dist/js/scripts.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
		crossorigin="anonymous"></script>
	<script src="${contextPath}/admin/dist/assets/demo/chart-area-demo.js"></script>
	<script src="${contextPath}/admin/dist/assets/demo/chart-bar-demo.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"
		crossorigin="anonymous"></script>
	<script src="${contextPath}/admin/dist/assets/demo/datatables-demo.js"></script>
</body>
</html>
