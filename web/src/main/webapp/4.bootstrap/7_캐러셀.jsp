<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<style type="text/css">
		.carousel-item{ /* 이미 정의된 부트스트랩 클래스 수정*/ 
			width: 100%;
			height: 100%;
		}
		
		
	</style>

</head>
<body>
	
	<!-- 이미지 슬라이드 : 캐러셀 -->
	<%@include file="1_설치.jsp" %>
	<div class="container"> <!-- 박스권 -->
	
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
				<div class="carousel-item active"><img alt="" src="../img/강아지.jpg"></div>
				<div class="carousel-item"><img alt="" src="../팬더.jpg"></div>
				<div class="carousel-item"><img alt="" src="../img/강아지.jpg"></div>
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


</body>
</html>