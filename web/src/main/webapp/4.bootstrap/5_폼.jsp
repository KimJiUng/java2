<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%@include file="1_설치.jsp" %>
	<form>	<!-- 부트스트랩 사용전 -->
		<label> 이름 </label>
		<input type="text" placeholder="이름">
		<label> 이메일 </label>
		<input type="text" placeholder="이메일">
		<button type="submit">확인</button>
	</form>

	<form>	<!-- 컨트롤 묶음 : form-group -->
		<div class="form-group">
			<label> 이름 </label>
			<input type="text" placeholder="이름">
		</div>
		<div class="form-group">
			<label> 이메일 </label>
			<input type="text" placeholder="이메일">
		</div>
		<div class="form-group">
			<button type="submit">확인</button>
		</div>
	</form>
	
	<!-- form-control : 컨트롤 형식 -->
	<input type="text" class="form-control">
	<input type="password" class="form-control">
	<input type="datetime-local" class="form-control">
	<textarea class="form-control" rows="5" cols="5" ></textarea>
	<div class="form-check">
		<input type="checkbox" class="form-check-input">
	</div>
	<div class="form-check">
		<input type="radio" class="form-check-input">
	</div>
	<div class="container row"> <!-- class="클래스명1 클래스명2 클래스명3" -->
		<div class="col-md-2"> <input type="text" class="form-control"> </div>
		<div class="col-md-2 offset-3"> <input type="text" class="form-control"> </div>
		<div class="col-md-2 offset-3"> <input type="text" class="form-control"> </div>
	</div>
	
	<button type="button">버튼</button>
	<button type="button" class="btn">버튼</button>
	<button type="button" class="btn btn-primary">버튼</button>
	<button type="button" class="btn btn-secondary">버튼</button>
	<button type="button" class="btn btn-info">버튼</button>
	<button type="button" class="btn btn-success">버튼</button>
	
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<img alt="" src="../img/강아지.jpg" width="100%">
			</div>
			<div class="col-md-3">
				<img alt="" src="../img/강아지.jpg" width="100%" style="border-radius: 50px;">
			</div>
			<div class="col-md-3">
				<img alt="" src="../img/강아지.jpg" width="100%">
			</div>
			<div class="col-md-3">
				<img alt="" src="../img/강아지.jpg" width="100%">
			</div>
			<div class="col-md-3">
				<img alt="" src="../img/강아지.jpg" width="100%">
			</div>
		</div>
	</div>
	
</body>
</html>