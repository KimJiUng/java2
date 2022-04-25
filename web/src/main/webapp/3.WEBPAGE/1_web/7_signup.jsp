<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<style type="text/css">
		#join{
			width: 600px;
			margin: 0 auto;
			border-bottom: solid 1px gray;
			border-top: solid 1px gray;
			padding: 30px;
		}
		li{ list-style-type: none;} /* 글머리 제거 */
		h3{text-align: center;}
		#btn{padding : 20px; width: 300px; margin-right: 120px; float: right; }
		#btn input{width: 100px; height: 40px;}
		.cols{ padding: 5px;}
		.cols li{ display: inline-block;}
		.col1{width: 150px;}
		.col2 input, select{ width: 200px; height: 25px;}
		.email input{height: 25px; width: 130px;}
		.hello{vertical-align: top;} /* 세로 정렬 */
		#contents{
			width: 1150px;
			margin: 0 auto;
			padding: 100px;
		}
	</style>
	
</head>
<body>
	<%@include file="2_header.jsp" %> <!-- 헤더 -->
	<%@include file="3_mainimage.jsp" %> <!-- 헤더이미지 -->
	<!-- 본문 -->
	<div id="contents">
		<h3> 회원 가입 폼 </h3>
		<form>
			<ul id="join"> <!-- 전체 -->
				<li> <!-- 행 -->
					<ul class="cols">
						<li class="col1"> 아이디</li> <!-- 열 -->
						<li class="col2"><input type="text"> </li>
					</ul>
				 </li>
				<li>
					<ul class="cols">
						<li class="col1">비밀번호</li>
						<li class="col2"><input type="password"></li>
					</ul> 
				</li>
				<li>
				 	<ul class="cols">
				 		<li class="col1">비밀번호 확인</li>
				 		<li class="col2"><input type="password"></li>
				 	</ul>
				</li>
				<li>
					<ul class="cols">
						<li class="col1">이메일 </li>
						<li class="email"><input type="text"> @ 
					<select> 
						<option> 직접입력 </option>
						<option> naver.com </option>
						<option> nate.com </option> 
					</select> 
						</li>
					</ul>
				</li>
				<li>
					<ul class="cols">
						<li class="col1">이메일 수신</li>
						<li  ><input type="radio" name="mail" checked="checked"> 비수신
							<input type="radio" name="mail"> 수신</li>
					</ul>	 
				</li>
				<li>
					<ul class="cols">
						<li class="col1">가입 경로</li>
						<li><input type="checkbox" name="root"> 친구추천
							<input type="checkbox" name="root"> 인터넷 검색
							<input type="checkbox" name="root" checked="checked"> 기타</li>
					</ul>	
			 	</li>
				<li>
					<ul class="cols">
						<li class="col1 hello">인사말</li>
						<li class="col2"><textarea rows="6" cols="40"></textarea></li>
					</ul>
				</li>
			</ul>
		</form>
		<div id="btn">
			<input type="submit" value="저장하기">
			<input type="reset" value="취소하기">
		</div>
	</div>
	<%@include file="5_footer.jsp" %> <!-- 헤더 -->

</body>
</html>