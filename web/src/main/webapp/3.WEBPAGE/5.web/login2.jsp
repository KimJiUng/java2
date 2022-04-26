<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<!-- 부트스트랩 css 포함 -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	
	<!-- 사용자가 정의한 css 포함 -->
	<link href="css/index.css" rel="stylesheet">
	
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
</head>
<body>
	<div class="container login">
		<div class="col-md-3 offset-5">
			<div class="mainhead text-center">
				<h4>LOGIN</h4>
			</div>
			<br><br>
			<div class="my-4">
				<div class="row">
					<div class="col-md-8">
						<input class="form-control" type="text" placeholder="아이디">
						<input class="form-control" type="password" placeholder="비밀번호" >
					</div>
					<div class="col-md-4">
						<input class="form-control" id="login" type="submit" value="LOGIN" >
					</div>	
				</div>
					
				<ul class="nav" id="findid">
					<li><input type="checkbox" class="form-check-input">아이디 저장 <i id="lock" class="fa fa-lock fa-1x"></i> 보안접속</li>
					<li> |  아이디찾기</li>
					<li> |  비밀번호찾기</li>
				</ul>
				<div class="row">
					<div class="col-md-6 my-2">
						<a href="#"><img alt="" src="img/네이버.PNG"></a>
					</div>
					<div class="col-md-6 my-2">
						<a href="#"><img alt="" src="img/페이스북.PNG"></a>
					</div>
					<div class="col-md-6 my-2">
						<a href="#"><img alt="" src="img/카카오.PNG"></a>
					</div>
					<div class="col-md-6 my-2">
						<a href="#"><img alt="" src="img/애플.PNG"></a>
					</div>
				</div>
				<input class="form-control" id="login" type="submit" value="JOIN US" >
			</div>
			<div id="botbox" class="my-4">
				<p>비회원의 경우, 주문시의 주문번호로 주문조회가 가능합니다.</p>
				<div class="row">
					<div class="col-md-6">
						주문자명
					</div>
					<div class="col-md-6">
						<input class="form-control my-2"  type="text">
					</div>
					<div class="col-md-6">
						주문번호
					</div>
					<div class="col-md-6">
						<input class="form-control my-2"  type="text" placeholder="하이픈(-) 포함">
					</div>
					<div class="col-md-6">
						비회원주문 비밀번호
					</div>
					<div class="col-md-6">
						<input class="form-control my-2"  type="text">
					</div>
				
				<button class="form-control my-2" >비회원 로그인</button>
				</div>
			</div>
		</div>
		
	</div>
</body>
</html>