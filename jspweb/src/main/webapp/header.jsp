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
	<%
		String loginid =(String)session.getAttribute("loginid"); // 세션 호출 (기본타입 = Object)
	%> 
	
	
	
	<div class="fixed-top">
		<div class="container">
			<!-- 공통 -->
			<div class="col-md-5 offset-5">
				<h3><a href="/jspweb/main.jsp">Home</a></h3>
			</div>
			<!-- 로그인 안된 상태 -->
			<%if(loginid==null){ %>
			<div class="row">
				<div class="col-md-1 offset-10">
					<a href="/jspweb/member/signup.jsp">회원가입</a>
				</div>
				<div class="col-md-1">
					<a href="/jspweb/member/login.jsp">로그인</a>
				</div>
			</div>
			<%} %>
			<!-- 만약에 로그인된 상태 -->
			<%if(loginid!=null) {%>
			<div class="row">
				<div class="col-md-1 offset-9">
					<span><%=loginid %>님</span>
				</div>
				<div class="col-md-1">
					<a href="/jspweb/member/memberinfo.jsp">회원정보</a>
				</div>
				<div class="col-md-1">
					<a href="Logout">로그아웃</a>
				</div>
			</div>
			<%} %>
		</div>
	</div>
	<br><br><br><br><br><br>
	<!-- 부트스트랩 js cdn -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<!-- 사용자 정의 js -->
	<script src="/jspweb/js/main.js" type="text/javascript"></script>
	<!-- jquery 최신 cdn -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	
</body>
</html>