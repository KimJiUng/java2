<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<style type="text/css">
	
		@font-face {
	    font-family: 'SANJUGotgam';
	    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2112@1.0/SANJUGotgam.woff') format('woff');
	    font-weight: normal;
	    font-style: normal;
		}
		
		#header{height: 150px;}
		#box{ width: 1100px; margin: 0 auto;}
		#logo{float: left; margin: 50px 0 0 50px;}
		#menus{float: right; text-align: right;}
		#menus li{display: inline;}
		li{list-style-type: none;}
		a{text-decoration: none; color: black;}
		#main_menu li{
			font-family:'SANJUGotgam';
			margin: 50px 0 0 80px;
			font-size: 20px;
		}
		#top_menu{margin: 30px 0px;}
		#top_menu li{margin-left: 10px;}
	</style>
</head>
<body>
	<div id="header"> <!-- ��� ��ü -->
		<div id="box">	<!-- ��� �� �ڽ��� -->
			<div id="logo">	<!-- �ΰ� -->
				<img alt="" src="img/logo.png">
			</div>
			<div id="menus">	<!-- �޴� -->
				<ul id="top_menu">	<!-- ��ܸ޴� -->
					<li>������(jykim)�� | </li>
					<li><a href="#">�α׾ƿ�</a> | </li>
					<li><a href="#">��������</a> </li>
				</ul>
				<ul id="main_menu">	<!-- �ϴܸ޴� -->
					<li><a href="index.jsp">Home</a></li>
					<li><a href="#">�⼮��</a></li>
					<li><a href="#">��ǰ������</a></li>
					<li><a href="#">�Խ���</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>