<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title> ��� </title>
	<style type="text/css">
		a{text-decoration: none; color: black;}
		a:hover {color: orange;}
		*{
			padding: 0px;
			margin: 0px;
		}
		#header {
			width: 1150px; /* ���α��� */
			margin: 0 auto; /* �ڽ��� ��� ���� */
			height: 100px;	/* ���α���*/ 
		}
		#logo{float: left; margin: 20px 0 0 20px;}
		#menus{float:right;}
		#topmenu{
			text-align: right;
			margin-top: 20px;
		}
		#main_menu{
			margin-top: 20px;
			font-family: "�ü�";
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
		<div id="logo"><a href="1_index.jsp"> <img alt="" src="img/��ܷΰ�.png"> </a></div>		<!-- �ΰ� -->
		<div id="menus">			<!-- �޴� -->
			<div id ="topmenu">		<!-- ��ܸ޴� -->
				<a href="6_login.jsp">�α���</a> | 
				<a href="7_signup.jsp">ȸ������</a> | 
				<a href="8_board.jsp">��������</a>
			</div>
			<ul id="main_menu">		<!-- ���θ޴� -->
				<li> <a href="#">�����̷�</a> </li>
				<li> <a href="#">��������</a> </li>
				<li> <a href="#">�����۰�</a> </li>
				<li> <a href="#">������1</a> </li>
				<li> <a href="#">������2</a> </li>
			</ul>
		</div>		
	</div>


</body>
</html>