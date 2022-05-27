<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

	<link href="/jspweb/css/chatting.css" rel="stylesheet">
	
</head>
<body>

	<%@include file="../header.jsp" %>
	<br><br><br><br><br><br><br><br>
	<%if(loginid==null) {%>
		<div class="container text-center">
			<h3>로그인 후 이용가능합니다.</h3>
		</div>
	<%} else{ %>
	<div class="container">
		<input type="hidden" id="mid" value="<%=loginid%>">
		<div class="col-sm-6 offset-3 chattingbox">	<!-- 채팅 관련 구역 -->
			<div class="row">
				<div class="col-sm-4">	<!-- 접속자 목록 표시 구역 -->
					<h5 class="enter_title">접속자 목록</h5>
					
					<div id="enterlist" class="row my-2">	<!-- 접속자 정보 표시 구역 -->
						
					</div>
							
				</div>
				<div class="col-sm-8 ">	<!-- 채팅창 -->
					<div id="contentbox" class="contentbox">	<!-- 메세지 표시 구역 -->
						<br>
						<div class="secontent my-2">	<!-- 보낸 메세지 -->
							<span class="date">오전 10:07</span>
							<span class="content">안녕하세요</span>
						</div>
						
						<div class="alarm">
							<span>유재석님이 입장 하셨습니다.</span>
						</div>
						
						<div class="row g-0 my-2">	<!-- g-0 : div 간 여백제거 --> 
							<div class="col-sm-2 mx-2">
								<img class="rounded-circle" alt="" src="../img/토끼.jpg" width="100%;">
							</div>
							<div class="col-sm-9">
								<div class="recontent">	<!-- 받는 메세지 -->
									<div class="member_name"> 유재석</div>
									<span class="content">안녕하세요</span>
									<span class="date">오전 10:07</span>
								</div>
							</div>
						</div>
						
					</div>
					
					<div class="row g-0">	<!-- 입력 상자 혹은 전송 버튼 -->
						<div class="col-sm-10">	<!-- 입력창 -->
							<textarea maxlength="100;" id="incontent" rows="3" cols="" class="form-control" onkeyup="enterkey('<%=loginid%>')"></textarea>
						</div>
						<div class="col-sm-2">	<!-- 전송버튼 -->
							<button style="height: 100%;" class="form-control" onclick="sendbtn('<%=loginid%>')">전송</button>
						</div>
					</div>
					<div class="btnbox">
						<span>첨부파일</span>
						<span>이모티콘</span>
					</div>
					
					
				</div>
			</div>
		</div>
		
	</div>
	<%} %>
	
	<%@include file="../footer.jsp" %>
	<script src="/jspweb/js/chatting2.js" type="text/javascript"></script>
</body>
</html>