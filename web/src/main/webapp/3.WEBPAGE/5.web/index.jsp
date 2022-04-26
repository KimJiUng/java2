<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

	<!-- ��Ʈ��Ʈ�� css ���� -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	
	<!-- ����ڰ� ������ css ���� -->
	<link href="css/index.css" rel="stylesheet">
	
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">

</head>
<body>

	<div class="col-md-10 offset-2 fixed-top pd-1 px-5 pt-5">
		<div class="col-md-7 offset-5 d-flex justify-content-end ">	<!-- ��� �޴� -->
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
		<div class="col-md-2 sidemenu">	<!-- ���̵�� -->
			<h3 class="px-4"><a href="index.jsp">HUNS </a></h3>
			<ul>
				<li class="sidebar"><a href="#">BEST</a></li>
				<li class="sidebar"><a href="#">NEW</a></li>
				<li class="sidebar"><a href="#">���Ϲ��</a></li>
				<li class="sidebar"><a href="#">1+1/�ڵ�Ʈ</a></li>
			</ul>
			<ul>
				<li class="sidebar"><a href="#">�ƿ���</a></li>
				<li class="sidebar"><a href="#">����</a></li>
				<li class="sidebar"><a href="#">����</a></li>
				<li class="sidebar"><a href="#">��Ʈ/�����</a></li>
				<li class="sidebar"><a href="#">����</a></li>
				<li class="sidebar"><a href="#">Ʈ���̴�</a></li>
				<li class="sidebar"><a href="#">�Ź�</a></li>
				<li class="sidebar"><a href="#">�Ǽ��縮</a></li>
				<li class="sidebar"><a href="#">����</a></li>
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
				<p class="sidebartxt1">�����͡�070-7710-4745<br>
				īī��ä�� @�ƽ� </p>
				<p class="sidebartxt2">MON - FRI AM9 - PM4<br>
				(LUNCH TIME PM12:30 - PM13:30)<br>
				SAT, SUN, HOLIDAY CLOSE<br>
				�����ð��� ���Ǵ�<br>
				Q��A �Խ����� �̿��Ź�帳�ϴ�.<br><br>
				�츮���� 1005-504-072722<br>
				������ : (��)���������۴�<br>
				</p>
			</div>
		</div>
		<%@include file="main.jsp" %>
		<br><br><br><br><br><br>
	<div class="container">
		<div class="footer col-md-9 offset-2">	<!-- Ǫ�� -->
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
					<span class="my-3"><a href="#">īī��ä�� : @�ƽ�</a></span><br>
					<span>
						MON - FRI AM9 - PM4<br>
						(LUNCH TIME PM12:30 - PM13:30)<br>
						SAT, SUN, HOLIDAY CLOSE<br>
					</span>
					<span id="qa">
						�����ð��� ���Ǵ�<br>
						Q��A �Խ����� �̿��Ź�帳�ϴ�.<br><br>
					</span>
					<span class="footerhead">BANK ACCOUNT.</span><br><br>
					<span>
						�츮���� 1005-504-072722<br>
						������ : (��)���������۴�
					</span>
				</div>
				<div class="col-md-6">
					<span class="footerhead">COMPANY INFO.</span><br><br>
					<p>
						COMPANY : (��)���������۴� CEO : ���簩 TEL : 070-7710-4745<br>
						BUSINESS NUMBER : 693-81-01950 / 2021-����ϳ�-0552 [���������Ȯ��]<br>
						ADDRESS : 13024 ��⵵ �ϳ��� �ϳ���� 506 (�ϻ�) 2��<br>
						ADMIN : ��̿� (youandme3800@naver.com) HOSTING : (��)CAFE24<br>
						�¶��� ���ڻ�ŷ� ���� ���� <a href="#">[���񽺰��Ի��Ȯ��]</a><br>
					</p>
					<span id="a"> ��ǰ�ּ� / CJ�������(1588-1255)</span>
					<p>
						CJ������� ��ǰ�ּ� : �����ȣ 05839) ����� ���ı� ��η�52 CJ������� ��������븮��<br>
						Ÿ�ù��̿� ��ǰ�ּ� : �����ȣ 12729) ��⵵ ���ֽ� �ʿ��� ����� 625-12 A�� 3��<br>
						��Ÿ�ù� �̿�� �����ù�,�Ե��ù�Ұ�(�ݼ۵ɼ� �ֽ��ϴ�)��<br>
					</p>
					<span id="a">Copyright  (��)���������۴�. All rights reserved.<a href="#">by uuniq.</a></span>
				</div>
			</div>
		</div>
	</div>
	</div>
	
	<!-- ��Ʈ��Ʈ�� js -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>


</body>
</html>