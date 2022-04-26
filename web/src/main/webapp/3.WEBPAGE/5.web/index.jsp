<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

	<!-- 부트스트랩 css 포함 -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	
	<!-- 사용자가 정의한 css 포함 -->
	<link href="css/index.css" rel="stylesheet">
	
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">

</head>
<body>

	<div class="col-md-10 offset-2 fixed-top pd-1 px-5 pt-5">
		<div class="col-md-7 offset-5 d-flex justify-content-end ">	<!-- 헤더 메뉴 -->
			<ul class="nav">
				<li class="tophead"><a href="login.jsp">LOGIN</a></li>
				<li class="tophead"><a href="#">JOIN</a></li>
				<li class="tophead"><a href="#">CART</a></li>
				<li class="tophead"><a href="#">MY PAGE</a></li>
				<li class="tophead"><a href="#">SNS</a></li>
				<li class="tophead"><a href="#">BOOKMARK</a></li>
			</ul>
		</div>
	</div>
	<div class="row">
		<div class="col-md-2 sidemenu">	<!-- 사이드바 -->
			<h3 class="px-4"><a href="index.jsp">HUNS </a></h3>
			<ul>
				<li class="sidebar"><a href="#">BEST</a></li>
				<li class="sidebar"><a href="#">NEW</a></li>
				<li class="sidebar"><a href="#">당일배송</a></li>
				<li class="sidebar"><a href="#">1+1/코디세트</a></li>
			</ul>
			<ul>
				<li class="sidebar"><a href="#">아우터</a></li>
				<li class="sidebar"><a href="#">상의</a></li>
				<li class="sidebar"><a href="#">셔츠</a></li>
				<li class="sidebar"><a href="#">니트/가디건</a></li>
				<li class="sidebar"><a href="#">팬츠</a></li>
				<li class="sidebar"><a href="#">트레이닝</a></li>
				<li class="sidebar"><a href="#">신발</a></li>
				<li class="sidebar"><a href="#">악세사리</a></li>
				<li class="sidebar"><a href="#">세일</a></li>
			</ul>
			<ul>
				<li class="sidebar"><a href="#">NOTICE</a></li>
				<li class="sidebar"><a href="#">Q&A</a></li>
				<li class="sidebar"><a href="#">REVIEW</a></li>
				<li class="sidebar"><a href="#">EVENT</a></li>
			</ul>
			<div>
				<input type="text"><a href="#"> <i class="fas fa-search"></i> </a>
			</div>
			<div>
				<p class="sidebartxt1">고객센터　070-7710-4745<br>
				카카오채널 @훈스 </p>
				<p class="sidebartxt2">MON - FRI AM9 - PM4<br>
				(LUNCH TIME PM12:30 - PM13:30)<br>
				SAT, SUN, HOLIDAY CLOSE<br>
				업무시간외 문의는<br>
				Q＆A 게시판을 이용부탁드립니다.<br><br>
				우리은행 1005-504-072722<br>
				예금주 : (주)유엔미컴퍼니<br>
				</p>
			</div>
		</div>
		<%@include file="main.jsp" %>
		<br><br><br><br><br><br>
	<div class="container">
		<div class="footer col-md-9 offset-2">	<!-- 푸터 -->
			<div class="row">
				<div class="col-md-2 offset-1">
					<span class="footerhead">SHOP INFO.</span><br><br>
					<span><a href="#">ABOUT US</a></span><br>
					<span><a href="#">AGREEMENT</a></span><br>
					<span><a href="#">PRIVACY POLICY</a></span><br>
					<span><a href="#">SHOPPING GUIDE</a></span><br>
				</div>
				<div class="col-md-3">
					<span class="footerhead">CUSTOMER CENTER.</span><br><br>
					<span id="phone">070-7710-4745</span><br><br>
					<span class="my-3"><a href="#">카카오채널 : @훈스</a></span><br>
					<span>
						MON - FRI AM9 - PM4<br>
						(LUNCH TIME PM12:30 - PM13:30)<br>
						SAT, SUN, HOLIDAY CLOSE<br>
					</span>
					<span id="qa">
						업무시간외 문의는<br>
						Q＆A 게시판을 이용부탁드립니다.<br><br>
					</span>
					<span class="footerhead">BANK ACCOUNT.</span><br><br>
					<span>
						우리은행 1005-504-072722<br>
						예금주 : (주)유엔미컴퍼니
					</span>
				</div>
				<div class="col-md-6">
					<span class="footerhead">COMPANY INFO.</span><br><br>
					<p>
						COMPANY : (주)유엔미컴퍼니 CEO : 유재갑 TEL : 070-7710-4745<br>
						BUSINESS NUMBER : 693-81-01950 / 2021-경기하남-0552 [사업자정보확인]<br>
						ADDRESS : 13024 경기도 하남시 하남대로 506 (하산곡동) 2층<br>
						ADMIN : 김미연 (youandme3800@naver.com) HOSTING : (주)CAFE24<br>
						온라인 전자상거래 안전 서비스 <a href="#">[서비스가입사실확인]</a><br>
					</p>
					<span id="a"> 반품주소 / CJ대한통운(1588-1255)</span>
					<p>
						CJ대한통운 반품주소 : 우편번호 05839) 서울시 송파구 충민로52 CJ대한통운 잠실유정대리점<br>
						타택배이용 반품주소 : 우편번호 12729) 경기도 광주시 초월읍 산수로 625-12 A동 3층<br>
						※타택배 이용시 로젠택배,롯데택배불가(반송될수 있습니다)※<br>
					</p>
					<span id="a">Copyright  (주)유엔미컴퍼니. All rights reserved.<a href="#">by uuniq.</a></span>
				</div>
			</div>
		</div>
	</div>
	</div>
	
	<!-- 부트스트랩 js -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>


</body>
</html>