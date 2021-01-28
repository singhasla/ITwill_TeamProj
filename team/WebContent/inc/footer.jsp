<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- Footer Section Begin -->
<footer class="footer">
    <div class="page-up">
        <a href="#" id="scrollToTopButton"><span class="arrow_carrot-up"></span></a>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="footer__nav">
                    <ul>
                        <li class="active"><a href="${contextPath}/index.jsp">홈</a></li>
                        <li><a href="${contextPath}/notice/listNotice.do">고객센터</a></li>
                        <li><a href="#">이용약관</a></li>
                        <li><a href="#">개인정보처리방침</a></li>
                        <li><a href="#">법적고지</a></li>
                        <li><a href="${contextPath}/eventServlet/listEvent.do">이벤트</a></li>
                        <li><a href="${contextPath}/notice/listNotice.do">공지사항</a></li>
                        
                    </ul>
                </div>
            </div>
          </div>
      </div>
  </footer>
  <!-- Footer Section End -->

  <!-- Search model Begin -->
  <div class="search-model">
    <div class="h-100 d-flex align-items-center justify-content-center">
        <div class="search-close-switch"><i class="icon_close"></i></div>
        <form action="${contextPath}/detailServlet/search.do" method="post" class="search-model-form" >
            <input type="text" name="search" id="search-input" placeholder="Search here.....">
        </form>
    </div>
</div>
<!-- Search model end -->

<!-- Js Plugins -->
<script src="${contextPath}/js/jquery-3.3.1.min.js"></script>
<script src="${contextPath}/js/bootstrap.min.js"></script>
<script src="${contextPath}/js/player.js"></script>
<script src="${contextPath}/js/jquery.nice-select.min.js"></script>
<script src="${contextPath}/js/mixitup.min.js"></script>
<script src="${contextPath}/js/jquery.slicknav.js"></script>
<script src="${contextPath}/js/owl.carousel.min.js"></script>
<script src="${contextPath}/js/main.js"></script>