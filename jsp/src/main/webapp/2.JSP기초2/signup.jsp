<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%String idcheck =(String)session.getAttribute("idcheck"); %>
	<%String length =(String)session.getAttribute("length"); %>
	<%String blank =(String)session.getAttribute("blank"); %>
	<form action="signupcontroller.jsp" method="post">
		<input type="text" name="id" placeholder="아이디">
		<input type="password" name="password" placeholder="비밀번호">
		<input type="text" name="name" placeholder="이름">
		<input type="submit" value="회원가입"> 
	</form>
	<p <%if(idcheck==null) {%> hidden="" <%} %>>중복된 아이디입니다.</p>
	<p <%if(length==null) {%> hidden="" <%} %>>아이디,비밀번호,이름은 1~10글자까지 가능합니다.</p>
	<p <%if(blank==null) {%> hidden="" <%} %>>빈칸을 모두 채워주세요.</p>
</body>
</html>