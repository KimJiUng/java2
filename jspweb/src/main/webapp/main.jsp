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
		메인페이지
	</div>
	
	<script src="/jspweb/js/main.js" type="text/javascript"></script>
	<%@include file="footer.jsp" %>

</body>
</html>