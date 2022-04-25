<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<!-- ���� ��ġ(����)�� �ٸ� ���� �����ϱ� -->
	<%@include file="header.jsp" %>
	<br><br><br><br><br><br>
	<!-- ĳ���� : �̹��� �����̵� -->
	<div id="cs" class="carousel slide" data-bs-ride="carousel" data-bs-interval="2000">
	
		<!-- �����̵� ��ġ ǥ�� : �ε������� -->
		<div class="carousel-indicators">
			<button data-bs-target="#cs" data-bs-slide-to="0" class="active"></button>
			<button data-bs-target="#cs" data-bs-slide-to="1"></button>
			<button data-bs-target="#cs" data-bs-slide-to="2"></button>
			<button data-bs-target="#cs" data-bs-slide-to="3"></button>
		</div>
		<div class="carousel-inner"> <!-- ĳ���� ���빰 -->
			<div class="carousel-item active"><img alt="" src="img/1650269392_0.jpg.webp"> </div>
			<div class="carousel-item"><img alt="" src="img/1650337222_0.jpg.webp"> </div>
			<div class="carousel-item"><img alt="" src="img/1650339327_0.jpg.webp"> </div>
			<div class="carousel-item"><img alt="" src="img/1650414456_0.jpg.webp"> </div>
		</div>
		
		<!-- �̹��� �̵� ��ư -->
		<button class="carousel-control-prev" data-bs-target="#cs" data-bs-slide="prev">
			<span class="carousel-control-prev-icon"></span>
		</button>
		<button class="carousel-control-next" data-bs-target="#cs" data-bs-slide="next">
			<span class="carousel-control-next-icon"></span>
		</button>
	</div>	<!-- ĳ���� �� -->
	<br><br>
	
	<div class="container text-center">
		<hr>	<!-- �Ǽ� -->
			<h3> New ARRIVAL </h3>
			<p>�Ż�ǰ</p>
	</div>
	
	<div class="container">
		<div class="row">
			<%for(int i=0; i<8; i++){ %>
			<div class="col-md-3 col-sm-6">	<!-- col-md-3 : col-md : 760px �̻�� col-sm : 570px �̻��ϰ�� -->
				<div class="card">	<!-- ī������ -->
					<img class="card-img-top" alt="" src="img/3aeb8bccb7b68dd4e459369e83d58cc6.webp">	<!-- �̹��� -->
					<div class="card-body">
						<p class="item"> 
							<span class="title">[1+1] ���Ĵٵ� ���� ������ 7�� ����Ƽ </span>
							<br>
							<span class="content">
							(M/L/XL)<br>
							7�� �Ż� �α� 1��!<br>
							������� ��þ��� ���� ��!<br>
							</span>
							<br>
							<span class="price1"> 44,000�� </span> 
							<span class="price2"> 31,800�� </span> 
							<br>
							<span class="badge bg-warning text-dark my-3">�ֹ�����</span>
							<span class="badge bg-danger text-dark my-3">ǰ���ӹ�</span>
						</p>
					</div>
				</div>
			</div>
			<%} %>
		</div>
	</div>
	
	<%@include file="footer.jsp" %>
</body>
</html>