<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link href="css/index.css" rel="stylesheet">
</head>
<body>
	<div class="col-md-9 offset-2 content">	<!-- ���� -->
		<div>	<!-- ĳ���� -->
			<div id="cs" class="carousel slide carousel-fade" data-bs-ride="carousel" data-bs-interval="1000">	<!-- ĳ���� -->
														<!-- data-bs-interval : �и��� -->
				<!-- ĳ���� [������ġ] �ϴ� ��ư : �ε������� -->
				<div class="carousel-indicators">
					<button type="button" data-bs-target="#cs" data-bs-slide-to="0" class="active"></button>
					<button type="button" data-bs-target="#cs" data-bs-slide-to="1"></button>
					<button type="button" data-bs-target="#cs" data-bs-slide-to="2"></button>
				</div>
				
				<div class="carousel-inner">
					<!-- ĳ���� ���� -->
					<div class="carousel-item active"><img alt="" src="img/ĳ����1.PNG" width="100%"></div>
					<div class="carousel-item"><img alt="" src="img/ĳ����2.PNG" width="100%"></div>
					<div class="carousel-item"><img alt="" src="img/ĳ����3.PNG" width="100%"></div>
				</div>
				<!-- ĳ���� �̵� ���� ��ư -->
				<button type="button" class="carousel-control-prev" data-bs-target="#cs" data-bs-slide="prev">
					<span class="carousel-control-prev-icon"></span>
				</button>
				<!-- ĳ���� �̵� ���� ��ư -->
				<button type="button" class="carousel-control-next" data-bs-target="#cs" data-bs-slide="next">
					<span class="carousel-control-next-icon"></span>
				</button>
			</div>
		</div>
		<div class="container text-center my-5">
			<h4>BEST SELLER</h4>
			<p class="maintxt">#����Ʈ����</p>
		</div>
		<div>	<!-- ��ǰ -->
			<div class="row">
				<%for(int i=0; i<5; i++){ %>
				<div class="col-md-4">
					<div class="card">
						<img class="card-img" alt="" src="img/��ǰ1.jpg">
						<div class="card-body">
							<span class="bodytxt">[1+1+1]���̽� �� ����Ƽ</span><br>
							<span class="bodyprice">22,900��</span>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="card">
						<img class="card-img" alt="" src="img/��ǰ2.webp">
						<div class="card-body">
							<span class="bodytxt">[1+1]�÷��� ���̵� �������</span><br>
							<span class="bodyprice">29,800��</span><br>
							<span class="bodytxt2">2 color / 2 size</span>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="card">
						<img class="card-img" alt="" src="img/��ǰ3.webp">
						<div class="card-body">
							<span class="bodytxt">[1+1]��&�� ���� ���̾�� ����Ƽ</span><br>
							<span class="bodyprice">23,900��</span><br>
							<span class="bodytxt2">2 type / 3 color / 4 size</span>
						</div>
					</div>
				</div>
				<%} %>
			</div>
			<div class="container text-center my-5">
			<h4>INSTAGRAM</h4>
			<p class="maintxt">@hunsgram</p>
		</div>
		</div>
	</div>
</body>
</html>