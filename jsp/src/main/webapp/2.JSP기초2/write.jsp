<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%String timecheck =(String)session.getAttribute("timecheck"); %>
	<%String blank =(String)session.getAttribute("blank"); %>
	<%String length =(String)session.getAttribute("length"); %>
	<form action="writecontroller.jsp" method="get">
		<input type="text" name="title" placeholder="제목"><br>
		<textarea rows="5" cols="10" name="content" placeholder="내용"></textarea><br>
		<input type="submit" value="쓰기">
	</form>
	<a href="main.jsp"><button>목록보기</button></a>
	<p <%if(timecheck==null) {%> hidden="" <%} %>>5분이내에 게시글을 올릴수 없습니다.</p>
	<p <%if(blank==null) {%> hidden="" <%} %>>빈칸을 채워주세요.</p>
	<p <%if(length==null) {%> hidden="" <%} %>>제목은 1~100글자, 내용은 1~1000글자까지 가능합니다.</p>
</body>
</html>