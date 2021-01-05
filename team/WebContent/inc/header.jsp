<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
    <!-- Header Section Begin -->
    <header class="header">
        <div class="container">
            <div class="row">
                <div class="col-lg-2">
                    <div class="header__logo">
                        <a href="../main/index.jsp">
                            <img src="${contextPath }/img/logo.png" alt="">
                        </a>
                    </div>
                </div>
                <div class="col-lg-8">
                    <div class="header__nav">
                        <nav class="header__menu mobile-menu">
                            <ul>
                            	<li ><a href="../main/index.jsp">홈</a></li>
                            	<li ><a href="#">이벤트</a></li>
                                <li ><a href="#">고객센터</a></li>
                                <li><a href="#">카테고리 <span class="arrow_carrot-down"></span></a>
                                    <ul class="dropdown">
                                        <li><a href="#">액션</a></li>
                                        <li><a href="#">코미디</a></li>
                                        <li><a href="#">드라마</a></li>
  
                                    </ul>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
                <div class="col-lg-2">
                    <div class="header__right">
                        <a href="#" class="search-switch"><span class="icon_search"></span></a>
                        <a href="#" ><span class="icon_cart"></span></a>
                       <!-- 위시리스트 아이콘 입니다 -->
                       <!--  <a href="#" ><span class="icon_star"></span></a> -->
	                      <c:choose>
		                       <c:when test="${sessionScope.userID!=null}">		
		                        <a href="${contextPath}/user/logout.do" ><span class="icon_lock-open"></span></a>
	                        	<c:if test='${userID=="admin"}'>
	                       			<a href="${contextPath}/adminPage/dashBoard.do" ><span class="icon_datareport"></span></a>
								</c:if>
	                       		<a href="#"><span class="icon_profile"></span></a>
	                       		<p style="color: white;">${sessionScope.userID}님 로그인중</p>
		                       	
		                       </c:when>
		                       <c:otherwise>
		                       		<a href="../login/login.jsp"><span class="icon_profile"></span></a>
		                       </c:otherwise>
	                       </c:choose>
                    </div>
                </div>
            </div>
            <div id="mobile-menu-wrap"></div>
        </div>
    </header>
    <!-- Header End -->
    