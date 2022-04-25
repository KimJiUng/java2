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
	<link href="CSS/main_css.css" rel="stylesheet">
	
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
	
</head>
<body>
	<div class="fixed-top bg-white">
		<div class="container"> <!-- �ڽ��� ���� -->
			<div class="py-3">	<!-- ��� �޴� -->
				<!-- p : ���� ����		py : ���Ʒ� ���� ����
					 m : �ٱ� ����		my : ���Ʒ� �ٱ� ���� 
				 -->
				<div class="row">	<!-- ���� ��ġ -->
					<div class="col-md-4 offset-4 text-center">	<!-- ��� �ΰ� -->
								<!-- text-center : �ڽ��ǳ� ���빰 ��� ���� -->
						<a href="main.jsp" class="header-logo"> �Ȼ� ���� ���θ� </a>	<!-- ��ũ -->
					</div>
					<div class="col-md-4 d-flex justify-content-end">	<!-- ��� �޴� -->
						<ul class="nav">	<!-- ���� ��ġ -->
							<li><a href="#">�α���</a> | </li>
							<li><a href="signup.jsp">ȸ������</a> | </li>
							<li><a href="#">��ٱ���</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="navbar navbar-expand-md navbar-light bg-white">	<!-- �� �޴� -->
				<!-- ������ �޴� ��ġ�� ��ư -->
				<button type="button" class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navcl">
					<span class="navbar-toggler-icon"></span>
				</button>
	
				<div class="collapse navbar-collapse" id="navcl">
					<ul class="navbar-nav col-md-12 d-flex justify-content-between">
						<li class="nav-item" class="nav-link"><a href="#">����Ʈ ��ǰ</a></li>
						<li class="nav-item" class="nav-link"><a href="#">��Ʈ</a></li>
						<li class="nav-item" class="nav-link"><a href="#">�ƿ���</a></li>
						<li class="nav-item" class="nav-link"><a href="#">����</a></li>
						<li class="nav-item" class="nav-link"><a href="#">��Ʈ</a></li>
						<li class="nav-item" class="nav-link"><a href="#">����</a></li>
						<li class="nav-item" class="nav-link"><a href="#">����</a></li>
						<li class="nav-item" class="nav-link"><a href="#">�Ź�</a></li>
						<li class="nav-item" class="nav-link"><a href="#">�Ǽ��縮</a></li>
						<li class="nav-item" class="nav-link"><a href="#">��Ÿ��</a></li>
						<li class="nav-item" class="nav-link"><a href="#">����</a></li>
						<li class="nav-item" class="nav-link"><a href="boardlist.jsp">������</a></li>
						<li class="nav-item" class="nav-link"><a href="#"> <i class="fas fa-search"></i> </a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	
	<!-- ��Ʈ��Ʈ�� js -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>