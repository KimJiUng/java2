<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>

	<%@include file="../header.jsp" %>
	<%String logincheck =(String)session.getAttribute("logincheck"); %>
	<div class="container">
		<form action="logincontroller.jsp" method="post">
			아이디 : <input type="text" id="mid" placeholder="아이디">
			<br>
			비밀번호 : <input type="password" id=mpassword placeholder="비밀번호">
			<br>
			<input type="submit" value="로그인">
		</form>
		<p <%if(logincheck==null) {%> hidden="" <%} %>>아이디,비밀번호가 일치하지 않습니다.</p>
	</div>
	
	<%@include file="../footer.jsp" %>

</body>
</html>