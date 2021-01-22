<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
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

				<!-- 영화등록 -->
				<article class="product">

					<form action="${contextPath}/adminMovieServlet/insertMovie.do"
						method="post" enctype="multipart/form-data">
						<table class="table">
							<colgroup>
								<col style="width: 120px" />
								<col />
							</colgroup>
							<tr>
								<th class="align-middle"><label for="movieName" class="m-0">제목</label></th>
								<td><input class="form-control" type="text"
									name="movieName" id="movieName" required /></td>
							</tr>
							<tr>
								<th class="align-middle"><label for="movieDirector" class="m-0">감독</label></th>
								<td><input class="form-control" type="text"
									name="movieDirector" id="movieDirector" required /></td>
							</tr>
							<tr>
								<th class="align-middle"><label for="actorName" class="m-0">주연</label></th>
								<td><input class="form-control" type="text"
									name="actorName" id="actorName" required /></td>
							</tr>
							<tr>
								<th class="align-middle"><label for="movieReleaseDate"
									class="m-0">개봉일</label></th>
								<td><input class="form-control" type="text"
									name="movieReleaseDate" id="movieReleaseDate" required /></td>
							</tr>
							<tr>
								<th class="align-middle"><label for="movieTime" class="m-0">상영시간</label></th>
								<td><input class="form-control" type="text"
									name="movieTime" id="movieTime" required /></td>
							</tr>

							<tr>
								<th class="align-middle"><label for="movieLink" class="m-0">연결주소</label></th>
								<td><input class="form-control" type="text"
									name="movieLink" id="movieLink" required /></td>
							</tr>
							<tr>
								<th class="align-middle"><label for="movieCategoryNo"
									class="m-0">장르1</label></th>
								<td>
									<div class="form-inline">
										<select class="form-control" name="movieCategoryNo1"
											id="movieCategoryNo1" required>
											<c:forEach var="category" items="${categoryList}"> 
	 											<option value="${category.movieCategoryNo}">${category.movieCategoryName}</option>
	 										</c:forEach>
										</select>
									</div>
								</td>
							</tr>
							<tr>
								<th class="align-middle"><label for="movieCategoryNo"
									class="m-0">장르2</label></th>
								<td>
									<div class="form-inline">
										<select class="form-control" name="movieCategoryNo2"
											id="movieCategoryNo2" required>
											<c:forEach var="category" items="${categoryList}"> 
	 											<option value="${category.movieCategoryNo}">${category.movieCategoryName}</option>
	 										</c:forEach>
										</select>
									</div>
								</td>
							</tr>
							<tr>
								<th class="align-middle"><label for="moviePrice"
									class="m-0">가격</label></th>
								<td>
									<div class="form-inline">
										 <input class="form-control" type="text"
												name="moviePrice" id="moviePrice" required />
									</div>
								</td>
							</tr>
							<tr>
								<th class="align-middle">
									<label for="movieContent" class="m-0">영화 줄거리</label>
								</th>
								<td>
									<textarea class="form-control" name="movieContent" id="movieContent" cols="40" rows="13" required></textarea>
								</td>
							</tr>
							<tr>
								<th class="align-middle"><label class="m-0">이미지</label></th>
								<td>
									<div class="custom-file">
										<input class="custom-file-input" type="file" name="movieImage"
											id="movieImage" onchange="showPreview(this, 'image')"
											required /> 
										<label class="custom-file-label" for="movieImage">선택된 파일 없음</label>
									</div>
								</td>
							</tr>
						</table>
						<div class="text-center my-5">
							<button type="button" class="btn btn-secondary"
								onclick="history.back()">취소</button>
							<button type="submit" class="btn btn-primary">상품 등록하기</button>
						</div>
					</form>
				</article>
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
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" crossorigin="anonymous"></script>
	<script	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
	<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
	<script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
	<script src="${contextPath}/admin/dist/assets/demo/datatables-demo.js"></script>
	<script src="${contextPath}/admin/dist/assets/demo/chart-area-demo.js"></script>
	<script src="${contextPath}/admin/dist/assets/demo/chart-bar-demo.js"></script>
	<script src="${contextPath}/admin/dist/js/scripts.js"></script>
	<script src="${contextPath}/admin/dist/js/bs-custom-file-input.js"></script>
	<script>	
	$(document).ready(function() {
		bsCustomFileInput.init()
	});
	</script>
	
</body>
</html>
