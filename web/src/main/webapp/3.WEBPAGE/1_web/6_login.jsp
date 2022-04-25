<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<style type="text/css">
		table{
			margin: 10px auto;
		}
		h3{ text-align: center;}
		#login{width: 100px; height: 80px;}
		input { width: 200px; height: 30px;}
		#contents{
			width: 1150px;
			margin: 0 auto;	
			padding: 100px;
		}
	</style>
</head>
<body>

	<%@include file="2_header.jsp" %> <!-- 헤더 -->
	<%@include file="3_mainimage.jsp" %> <!-- 헤더이미지 -->
	<!-- 본문 -->
	<div id="contents">
		<h3> 로그인 </h3>
		<table>
			<tr><td>아이디</td><td><input type="text"></td><td rowspan="2"><input id="login" type="submit" value="로그인"></td></tr>
			<tr><td>비밀번호</td><td><input type="password"></td></tr>
		</table>
	</div>
	<%@include file="5_footer.jsp" %> <!-- 헤더 -->
	
	
	
	

</body>
</html>