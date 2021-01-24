<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="movieList" value="${movieList}"/>
<!DOCTYPE html>
<html lang="en">
    <head>
    
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        
        <style>
			.cut { width:450px; white-space:nowrap; overflow:hidden; text-overflow:ellipsis; }
		</style>
	
	
        <title>관리자 페이지입니다</title>
        <link href="${contextPath}/admin/dist/css/styles.css" rel="stylesheet" />
        <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
        <link rel="stylesheet" href="${contextPath}/css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="${contextPath}/css_Jo/style_Jo.css" type="text/css">
        
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
    <!-- 헤더 -->
	<jsp:include page="../adminInc/header.jsp"/>
        <div id="layoutSidenav">
        <!-- 사이드 메뉴 -->
        	<jsp:include page="../adminInc/sidenav.jsp"/>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">
                        <h1 class="mt-4">영화관리</h1>
                        
                        
                        
                        
                        <div class="text-right headerBtn">
							<button type="button" class="btn btn-primary btn-sm"
									onclick="location.href='${contextPath}/adminMovieServlet/addMovie.do'"
									style="position: relative;  top: -40px;">
									상품 등록
							</button>
							<button type="button" class="btn btn-secondary btn-sm"
									onclick="location.href='${contextPath}/adminMovieServlet/listProductCategory.do'"
									style="position: relative; top: -40px;">
									카테고리 관리
							</button>
						</div>
                        
                        
                        
                        
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table mr-1"></i>
                                MOVIE DataTable
                            </div>
                            <div class="card-body">
                            
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr style="text-align: center;">
                                            	<th>#</th>
                                                <th style="width: 5%">No.</th>
                                                <th style="width: 20%">제목</th>
                                                <th style="width: 39%">줄거리</th>
                                                <th style="width: 7%">장르1</th>
                                                <th style="width: 7%">장르2</th>
                                                <th style="width: 10%">가격</th>
                                                <th style="width: 6%">수정</th>
                                                <th style="width: 6%">삭제</th>

                                        <tbody>
                                        	<c:choose>
                                       			<c:when test="${movieList==null}">			
													<tr>
														<td style="text-align: center; font-size: 30px;" colspan="8">
															등록된 영화가 없습니다.
														</td>
													</tr>
												</c:when>
												<c:otherwise>	
													<c:forEach var="movie" items="${movieList}" varStatus="stat">
			                                            <tr>
			                                            	<td>${stat.index}</td>
			                                                <td>${movie.movieNo}</td>
			                                                <td>${movie.movieName}</td>
			                                                <td><div class="cut">${movie.movieContent}</div></td>
			                                                <td>${movie.movieCategoryNo1}</td>
			                                                <td>${movie.movieCategoryNo2}</td>
			                                                <td>${movie.moviePrice}</td>
			                                                <td style="vertical-align: middle; text-align: center;">
																<a class="icon_tools" href="${contextPath}/adminMovieServlet/modifyMovie.do?movieNo=${movie.movieNo}"></a>
															</td>
			                                                <td style="vertical-align: middle; text-align: center;">
																<a class="icon_trash" href="#"></a>
															</td>
			                                            </tr>
			                      					</c:forEach>
	                                   			</c:otherwise>
                                            </c:choose>
                                        </tbody>
                                    </table>
                                </div>
                                
                            </div>
                        </div>
                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2020</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="${contextPath}/admin/dist/js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="${contextPath}/admin/dist/assets/demo/chart-area-demo.js"></script>
        <script src="${contextPath}/admin/dist/assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
        <script src="${contextPath}/admin/dist/assets/demo/datatables-demo.js"></script>
    </body>
</html>
