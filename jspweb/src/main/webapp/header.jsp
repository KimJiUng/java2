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

	<!-- 폰트어썸[ 아이콘 ]  -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
	
</head>
<body>
	<%
		String loginid =(String)session.getAttribute("loginid"); // 세션 호출 (기본타입 = Object)
	%> 

	<div class="fixed-top bg-white">
		<div class="container">
			<div class="py-4">
				<div class="row">
					<div class="col-md-4">
						<a class="header-logo" href="/jspweb/main.jsp">EZEN SHOP</a>
					</div>
					<div class="col-md-4 offset-4">
						<!-- 로그인 안된 상태 -->
						
						<div class="d-flex justify-content-end">
							<ul class="nav">
								<%if(loginid==null){ %>
									<li><a class="hearder-topmenu" href="/jspweb/member/login.jsp">로그인</a></li>
									<li><a class="hearder-topmenu" href="/jspweb/member/signup.jsp">회원가입</a></li>
								<%} else if(loginid.equals("admin")){ %>
									<li><a class="hearder-topmenu" href="/jspweb/admin/dashboard.jsp">관리자</a></li>
								<%} else{ %>
									<li><span class="hearder-toploginid"><%=loginid %>님</span></li>
									<li><a class="hearder-topmenu" href="/jspweb/member/info.jsp">회원정보</a></li>
									<li><a class="hearder-topmenu" href="/jspweb/member/myshopping.jsp">나의쇼핑</a></li>
									<li><a class="hearder-topmenu" href="/jspweb/Logout">로그아웃</a></li>
								<%} %>
								<li><a class="hearder-topmenu" href="/jspweb/board/boardlist.jsp?key=&keyword=">자유게시판</a></li>
								<li><a class="hearder-topmenu" href="/jspweb/board/chatting.jsp">채팅방</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div> <!-- 상단메뉴 끝 -->
			
			<!-- 공통 -->
		
			<div class="navbar navbar-expand-md navbar-light bg-white">
				
				<ul class="navbar-nav col-md-12 justify-content-between">
					<li class="nav-item"><a href="#">BIG SIZE</a></li>
					<li class="nav-item"><a href="#" style="color: #00D8FF;">MUSCLE-FIT</a></li>
					<li class="nav-item"><a href="#" style="color: #0100FF;">1+1 이벤트</a></li>
					<li class="nav-item dropdown">
						<a href="#">아우터</a>
						<!-- 드롭다운 -->
						<div class="dropdown-menu">
							<a class="dropdown-item" href="#">드랍다운 메뉴</a>
							<a class="dropdown-item" href="#">드랍다운 메뉴</a>
							<a class="dropdown-item" href="#">드랍다운 메뉴</a>
							<a class="dropdown-item" href="#">드랍다운 메뉴</a>
							<a class="dropdown-item" href="#">드랍다운 메뉴</a>
						</div>
					</li>
					<li class="nav-item dropdown">
						<a href="#">상의</a>
						<!-- 드롭다운 -->
						<div class="dropdown-menu">
							<a class="dropdown-item" href="#">드랍다운 메뉴</a>
							<a class="dropdown-item" href="#">드랍다운 메뉴</a>
							<a class="dropdown-item" href="#">드랍다운 메뉴</a>
							<a class="dropdown-item" href="#">드랍다운 메뉴</a>
							<a class="dropdown-item" href="#">드랍다운 메뉴</a>
						</div>
					</li>
					<li class="nav-item dropdown">
						<a href="#">바지</a>
						<!-- 드롭다운 -->
						<div class="dropdown-menu">
							<a class="dropdown-item" href="#">드랍다운 메뉴</a>
							<a class="dropdown-item" href="#">드랍다운 메뉴</a>
							<a class="dropdown-item" href="#">드랍다운 메뉴</a>
							<a class="dropdown-item" href="#">드랍다운 메뉴</a>
							<a class="dropdown-item" href="#">드랍다운 메뉴</a>
						</div>
					</li>
					<li class="nav-item"><a href="#">슈즈</a></li>
					<li class="nav-item"><a href="#">악세사리</a></li>
					<li class="nav-item"><a href="#">BEST</a></li>
					<li class="nav-item"><a href="#">트레이닝</a></li>
					<li class="nav-item"><a href="#" style="color: #FFBB00;">모델처럼입자</a></li>
					<li class="nav-item"><a href="#" style="color: #FF0000;">50% 할인</a></li>
					<li class="nav-item"><input type="text" class="header-input" size="13"><a href="#"><i class="fas fa-search"></i></a></li>
					<li class="nav-item"><a href="#"><i class="fas fa-shopping-cart"></i><span class="shoppingbox">3</span></a></li>
				</ul>
			</div>
			
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