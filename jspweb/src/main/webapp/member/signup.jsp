<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>

	<%@include file="../header.jsp" %>
	<div class="container">
		<div class="col-md-4 offset-4">
			<div class="text-center" style="border-bottom: solid 1px gray;">
				<h3>회원가입페이지</h3>
			</div>
			<br><br>
			<form action="">
				<div class="row">
					<div class="col-md-3 py-1" id="signupfield">
						<p>아이디<span style="color: red; font-size: 12px;">*</span></p>
					</div>
					<div class="col-md-9 py-1">
						<input type="text" class="form-control" id="mid" placeholder="아이디">
					</div>
					<div class="col-md-9 offset-3 py-1">
						<span class="signuptext" id="idcheck"></span>
					</div>
					<br>
					<div class="col-md-3 py-1" id="signupfield">
						<p>비밀번호<span style="color: red; font-size: 12px;">*</span></p>
					</div>
					<div class="col-md-9 py-1">
						<input type="password" class="form-control" id="mpassword" placeholder="비밀번호">
					</div>
					<div class="col-md-9 offset-3 py-1">
						<input type="password" class="form-control" id="mpasswordcheck" placeholder="비밀번호확인">
					</div>
					<div class="col-md-9 offset-3 py-1">
						<span class="signuptext" id="passwordcheck"></span>
					</div>
					<br>
					<div class="col-md-3 py-1" id="signupfield">
						<p>이름<span style="color: red; font-size: 12px;">*</span></p>
					</div>
					<div class="col-md-9 py-1">
						<input type="text" class="form-control" id="mname" placeholder="이름">
					</div>
					<div class="col-md-9 offset-3 py-1">
						<span class="signuptext" id="namecheck"></span>
					</div>
					<br>
					<div class="col-md-3 py-1" id="signupfield">
						<p>전화번호<span style="color: red; font-size: 12px;">*</span></p>
					</div>
					<div class="col-md-9 py-1">
						<input type="text" class="form-control" id="mphone" placeholder="전화번호">
					</div>
					<div class="col-md-9 offset-3 py-1">
						<span class="signuptext" id="phonecheck"></span>
					</div>
					<br>
					<div class="col-md-3 py-1" id="signupfield">
						<p>이메일<span style="color: red; font-size: 12px;">*</span></p>
					</div>
					<div class="col-md-9 py-1">
						<input type="text" class="form-control" id="memail" placeholder="이메일">
					</div>
					<div class="col-md-1 offset-3 py-1">
						<span>@</span>
					</div>
					<div class="col-md-4 py-1">
						<input type="text" class="form-control" id="memailaddress">
					</div>
					<div class="col-md-4 py-1">
						<select class="form-control" id="emailselect">
							<option value="">직접입력</option>
							<option value="naver.com">naver.com</option>
							<option value="nate.com">nate.com</option>
							<option value="daum.com">daum.com</option>
						</select>
					</div>
					<div class="col-md-9 offset-3 py-1">
						<span class="signuptext" id="emailcheck"></span>
					</div>
					<br>
					<div class="col-md-3 py-1" id="signupfield">
						<p>주소<span style="color: red; font-size: 12px;">*</span></p>
					</div>
					<div class="col-md-9 py-1">
						<div class="row">
							<div class="col-md-6">
								<input class="form-control" type="text" id="sample4_postcode" placeholder="우편번호">
							</div>
							<div class="col-md-6">
								<input class="form-control" type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기">
							</div>
						</div>
					</div>
					<div class="col-md-9 offset-3 py-1">
						<div class="row">
							<div class="col-md-6">
								<input class="form-control" type="text" id="sample4_roadAddress" placeholder="도로명주소">
							</div>
							<div class="col-md-6">
								<input class="form-control" type="text" id="sample4_jibunAddress" placeholder="지번주소">
								<span id="guide" style="color:#999;display:none"></span>
							</div>
						</div>
					</div>
					<div class="col-md-9 offset-3 py-1">
						<input class="form-control" type="text" id="sample4_detailAddress" placeholder="상세주소">
					</div>
					<div class="col-md-9 offset-3 py-1">
						<span class="signuptext" id="addresscheck"></span>
					</div>
					<br>
					<div class="py-1">
						<button class="form-control" onclick="signup()" type="button">가입하기</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="/jspweb/js/signup.js" type="text/javascript"></script>
	<%@include file="../footer.jsp" %>

</body>
</html>