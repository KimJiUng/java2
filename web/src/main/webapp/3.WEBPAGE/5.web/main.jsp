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
	<div class="col-md-9 offset-2 content">	<!-- 본문 -->
		<div>	<!-- 캐러셀 -->
			<div id="cs" class="carousel slide carousel-fade" data-bs-ride="carousel" data-bs-interval="1000">	<!-- 캐러셀 -->
														<!-- data-bs-interval : 밀리초 -->
				<!-- 캐러셀 [내용위치] 하단 버튼 : 인디케이터 -->
				<div class="carousel-indicators">
					<button type="button" data-bs-target="#cs" data-bs-slide-to="0" class="active"></button>
					<button type="button" data-bs-target="#cs" data-bs-slide-to="1"></button>
					<button type="button" data-bs-target="#cs" data-bs-slide-to="2"></button>
				</div>
				
				<div class="carousel-inner">
					<!-- 캐러셀 내용 -->
					<div class="carousel-item active"><img alt="" src="img/캐러셀1.PNG" width="100%"></div>
					<div class="carousel-item"><img alt="" src="img/캐러셀2.PNG" width="100%"></div>
					<div class="carousel-item"><img alt="" src="img/캐러셀3.PNG" width="100%"></div>
				</div>
				<!-- 캐러셀 이동 이전 버튼 -->
				<button type="button" class="carousel-control-prev" data-bs-target="#cs" data-bs-slide="prev">
					<span class="carousel-control-prev-icon"></span>
				</button>
				<!-- 캐러셀 이동 다음 버튼 -->
				<button type="button" class="carousel-control-next" data-bs-target="#cs" data-bs-slide="next">
					<span class="carousel-control-next-icon"></span>
				</button>
			</div>
		</div>
		<div class="container text-center my-5">
			<h4>BEST SELLER</h4>
			<p class="maintxt">#베스트셀러</p>
		</div>
		<div>	<!-- 제품 -->
			<div class="row">
				<%for(int i=0; i<5; i++){ %>
				<div class="col-md-4">
					<div class="card">
						<img class="card-img" alt="" src="img/제품1.jpg">
						<div class="card-body">
							<span class="bodytxt">[1+1+1]아이스 쿨링 반팔티</span><br>
							<span class="bodyprice">22,900원</span>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="card">
						<img class="card-img" alt="" src="img/제품2.webp">
						<div class="card-body">
							<span class="bodytxt">[1+1]플레인 와이드 밴딩팬츠</span><br>
							<span class="bodyprice">29,800원</span><br>
							<span class="bodytxt2">2 color / 2 size</span>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="card">
						<img class="card-img" alt="" src="img/제품3.webp">
						<div class="card-body">
							<span class="bodytxt">[1+1]롱&숏 맞춤 레이어드 반팔티</span><br>
							<span class="bodyprice">23,900원</span><br>
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