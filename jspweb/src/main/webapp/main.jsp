<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<%String loginid =(String)session.getAttribute("loginid"); %>
	<%@include file="header.jsp" %>
	<div class="container">
		<div><%=loginid %>님 안녕하세요 ~</div>
		<button onclick="logout" type="button">로그아웃</button>
	</div>
	<script src="/jspweb/js/main.js" type="text/javascript"></script>
	<%@include file="footer.jsp" %>

</body>
</html>