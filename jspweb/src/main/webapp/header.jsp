<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ezen 쇼핑몰</title>
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

	<!-- 사용자 정의 css -->
	<link href="/jspweb/css/main.css" rel="stylesheet">

</head>
<body>
	<%String loginid =(String)session.getAttribute("loginid"); %>
	<div class="container">
		헤더페이지 [모든 페이지에서 사용되기 때문에 -> 최상위에서 절대 경로]<br>
		<a href="/jspweb/main.jsp">home</a><br>
		<a href="/jspweb/member/login.jsp" <%if(loginid!=null){ %> hidden="" <%} %>>로그인</a><br>
		<a href="/jspweb/member/signup.jsp">회원가입</a><br>
		<br><br><br>
	</div>
	<!-- 부트스트랩 js cdn -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<!-- 사용자 정의 js -->
	<script src="/jspweb/js/main.js" type="text/javascript"></script>
	<!-- jquery 최신 cdn -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	
</body>
</html>