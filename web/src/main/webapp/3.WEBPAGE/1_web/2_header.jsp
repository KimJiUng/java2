<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title> 헤더 </title>
	<style type="text/css">
		a{text-decoration: none; color: black;}
		a:hover {color: orange;}
		*{
			padding: 0px;
			margin: 0px;
		}
		#header {
			width: 1150px; /* 가로길이 */
			margin: 0 auto; /* 박스권 가운데 정렬 */
			height: 100px;	/* 세로길이*/ 
		}
		#logo{float: left; margin: 20px 0 0 20px;}
		#menus{float:right;}
		#topmenu{
			text-align: right;
			margin-top: 20px;
		}
		#main_menu{
			margin-top: 20px;
			font-family: "궁서";
			font-size: 20px;
		}
		#main_menu li{
			display: inline; 
			margin-left: 80px;
		}
	
	</style>
</head>
<body>

	<div id="header">
		<div id="logo"><a href="1_index.jsp"> <img alt="" src="img/상단로고.png"> </a></div>		<!-- 로고 -->
		<div id="menus">			<!-- 메뉴 -->
			<div id ="topmenu">		<!-- 상단메뉴 -->
				<a href="6_login.jsp">로그인</a> | 
				<a href="7_signup.jsp">회원가입</a> | 
				<a href="8_board.jsp">공지사항</a>
			</div>
			<ul id="main_menu">		<!-- 메인메뉴 -->
				<li> <a href="#">사진이론</a> </li>
				<li> <a href="#">사진구도</a> </li>
				<li> <a href="#">사진작가</a> </li>
				<li> <a href="#">갤러리1</a> </li>
				<li> <a href="#">갤러리2</a> </li>
			</ul>
		</div>		
	</div>


</body>
</html>