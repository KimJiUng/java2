<%@page import="dto.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

	<!-- 사용자 정의 css -->
	<link href="/jspweb/css/main.css" rel="stylesheet">
	<link href="/jspweb/css/admin.css" rel="stylesheet">

	<!-- 폰트어썸[ 아이콘 ]  -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">

</head>
<body>
	
	
	<!-- marquee : 텍스트 슬라이드(전광판) // 속성 : scrollamount : 속도 -->
	<marquee scrollamount="10">공지사항 표시되는 위치 [제품 관리 철저히]</marquee>
	<!-- 사이드바 -->
	<div id="sidebar">
		<ul>	<!-- 사이드바 목록 -->
			<li><h6>EZEN SHOP <br> 관리자 모드</h6></li>
			<li><button onclick="pagechange('productlist')">제품 목록</button> </li>
			<li><button onclick="pagechange('productadd')">제품 등록</button> </li>
			<li><button onclick="pagechange('productstock')">제품 재고</button> </li>
			<li><button onclick="#">주문 현황</button> </li>
			<li><button onclick="#">주문 배송</button> </li>
			<li><button onclick="#">매출 관리</button> </li>
			<li><a href="/jspweb/main.jsp">홈페이지로 이동</a> </li>
			<li><a href="/jspweb/Logout">로그아웃</a> </li>
		</ul>
		<!-- 사이드바 열기/닫기 버튼 -->
		<span class="sidebarbtn" id="sidebarbtn"> |||| </span>
	</div>

<!--------------------------------- 페이지 전환시 페이지가 포함되는 구역 ------------------------>
	<div class="container" id="mainbox">
		관리자 메인 페이지	
	</div>
	
<!--------------------------------- 관리자 메인페이지 구역 ------------------------------------>
	<div id="dashboard">
		<h3>관리자 메인페이지</h3>
	</div>

	<!-- 부트스트랩 js cdn -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<!-- jquery 최신 cdn -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- 사용자 정의 js -->
	<script src="/jspweb/js/main.js" type="text/javascript"></script>
	<script src="/jspweb/js/dashboard.js" type="text/javascript"></script>
	<script src="/jspweb/js/productadd.js" type="text/javascript"></script>
	<script type="text/javascript" src="/jspweb/js/productlist.js"></script>


</body>
</html>