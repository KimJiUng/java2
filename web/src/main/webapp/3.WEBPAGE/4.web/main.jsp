<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<!-- 현재 위치(파일)에 다른 파일 포함하기 -->
	<%@include file="header.jsp" %>
	<br><br><br><br><br><br>
	<!-- 캐러셀 : 이미지 슬라이드 -->
	<div id="cs" class="carousel slide" data-bs-ride="carousel" data-bs-interval="2000">
	
		<!-- 슬라이드 위치 표시 : 인디케이터 -->
		<div class="carousel-indicators">
			<button data-bs-target="#cs" data-bs-slide-to="0" class="active"></button>
			<button data-bs-target="#cs" data-bs-slide-to="1"></button>
			<button data-bs-target="#cs" data-bs-slide-to="2"></button>
			<button data-bs-target="#cs" data-bs-slide-to="3"></button>
		</div>
		<div class="carousel-inner"> <!-- 캐러셀 내용물 -->
			<div class="carousel-item active"><img alt="" src="img/1650269392_0.jpg.webp"> </div>
			<div class="carousel-item"><img alt="" src="img/1650337222_0.jpg.webp"> </div>
			<div class="carousel-item"><img alt="" src="img/1650339327_0.jpg.webp"> </div>
			<div class="carousel-item"><img alt="" src="img/1650414456_0.jpg.webp"> </div>
		</div>
		
		<!-- 이미지 이동 버튼 -->
		<button class="carousel-control-prev" data-bs-target="#cs" data-bs-slide="prev">
			<span class="carousel-control-prev-icon"></span>
		</button>
		<button class="carousel-control-next" data-bs-target="#cs" data-bs-slide="next">
			<span class="carousel-control-next-icon"></span>
		</button>
	</div>	<!-- 캐러셀 끝 -->
	<br><br>
	
	<div class="container text-center">
		<hr>	<!-- 실선 -->
			<h3> New ARRIVAL </h3>
			<p>신상품</p>
	</div>
	
	<div class="container">
		<div class="row">
			<%for(int i=0; i<8; i++){ %>
			<div class="col-md-3 col-sm-6">	<!-- col-md-3 : col-md : 760px 이상시 col-sm : 570px 이상일경우 -->
				<div class="card">	<!-- 카드형식 -->
					<img class="card-img-top" alt="" src="img/3aeb8bccb7b68dd4e459369e83d58cc6.webp">	<!-- 이미지 -->
					<div class="card-body">
						<p class="item"> 
							<span class="title">[1+1] 스탠다드 세미 오버핏 7부 무지티 </span>
							<br>
							<span class="content">
							(M/L/XL)<br>
							7부 신상 인기 1위!<br>
							구김없고 목늘어짐 걱정 끝!<br>
							</span>
							<br>
							<span class="price1"> 44,000원 </span> 
							<span class="price2"> 31,800원 </span> 
							<br>
							<span class="badge bg-warning text-dark my-3">주문폭주</span>
							<span class="badge bg-danger text-dark my-3">품절임박</span>
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