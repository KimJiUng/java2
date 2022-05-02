<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>

	<%@include file="../header.jsp" %>
	<div class="container">
		<h3>회원가입페이지</h3>
		<form action="">
			아이디 : <input type="text" id="mid" placeholder="아이디">
			<span id="idcheck"></span>
			<br>
			비밀번호 : <input type="password" id="mpassword" placeholder="비밀번호">
			<br>
			비밀번호확인 : <input type="password" id="mpasswordcheck" placeholder="비밀번호확인">
			<span id="passwordcheck"></span>
			<br>
			이름 : <input type="text" id="mname" placeholder="이름">
			<span id="namecheck"></span>
			<br>
			전화번호 : <input type="text" id="mphone" placeholder="전화번호">
			<span id="phonecheck"></span>
			<br>
			이메일 : <input type="text" id="memail" placeholder="이메일">
			<span id="emailcheck"></span>
			<br>
			<input type="text" id="sample4_postcode" placeholder="우편번호">
			<br>
			<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
			<input type="text" id="sample4_roadAddress" placeholder="도로명주소">
			<input type="text" id="sample4_jibunAddress" placeholder="지번주소">
			<span id="guide" style="color:#999;display:none"></span>
			<input type="text" id="sample4_detailAddress" placeholder="상세주소">
			<input type="text" id="sample4_extraAddress" placeholder="참고항목">
			<button onclick="signup()" type="button">가입하기</button>
			<span id="signupcheck"></span>
		</form>
	</div>
	
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="/jspweb/js/signup.js" type="text/javascript"></script>
	<%@include file="../footer.jsp" %>

</body>
</html>