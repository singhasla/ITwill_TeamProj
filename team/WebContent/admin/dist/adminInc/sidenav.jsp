<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">Core</div>
                            <a class="nav-link" href="${contextPath}/adminPage/dashBoard.do">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                               		 회원관리
                            </a>
                            <a class="nav-link" href="${contextPath}/adminOrdersvlt/orderList.do">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                               		 주문관리
                            </a>
                             <a class="nav-link" href="${contextPath}/adminMovieServlet/movie.do">
                                <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                             		영화관리
                            </a>
                            <div class="sb-sidenav-menu-heading">Event</div>
                            <a class="nav-link" href="${contextPath}/eventAdmin/listEvent.do">
                                <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                               		 이벤트
                            </a>
                            <div class="sb-sidenav-menu-heading">CustomerService</div>
                            <a class="nav-link" href="${contextPath}/noticeAdmin/listNotice.do">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                               		 공지사항
                            </a>
                            <a class="nav-link" href="${contextPath}/faqAdmin/listFaq.do">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                               		 FAQ
                            </a>
                            <a class="nav-link" href="${contextPath}/qnaAdmin/listQna.do">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                               		 문의내역
                            </a>
                           
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                     	<a class="nav-link" href="${contextPath}/mainServlet/main.do">
                            <div class="sb-nav-link-icon">
                            	<i class="fas fa-book-open"></i>
                            	메인 홈페이지<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;바로가기
                            </div>
                            	 
                        </a>
                        <div class="small">Logged in as:</div>
                        	관리자페이지	
                    </div>
                </nav>
            </div>