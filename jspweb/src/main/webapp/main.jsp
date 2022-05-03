<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<%
	session.setAttribute("logincheck", null);
	%>
	<%@include file="header.jsp" %>
	
	<div class="container">
		<div <%if(loginid==null){ %> hidden="" <%} %>><%=loginid %>님 안녕하세요 ~</div>
		<a href="/jspweb/member/logout.jsp" <%if(loginid==null){ %> hidden="" <%} %>><button>로그아웃</button></a>
	</div>
	
	<script src="/jspweb/js/main.js" type="text/javascript"></script>
	<%@include file="footer.jsp" %>

</body>
</html>