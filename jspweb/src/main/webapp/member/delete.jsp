<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% String mid = (String)session.getAttribute("loginid"); %>
	
	<%@include file="../header.jsp" %>
	<%if(loginid==null){ %>
	
	<div class="container">
	로그인 이후 이용 가능
	<%} else{%>
		<div class="row">
			<div class="col-md-3">
				<%@include file="infosidebar.jsp" %>
			</div>
			<div class="col-md-9">
				<div class="col-md-2 offset-3">
					<div class="text-center">
						<h3>회원탈퇴</h3>
					</div>
						<div class="my-3">
							<input type="password" class="form-control" id="mpassword" name="mpassword" placeholder="비밀번호 확인">
						</div>
						<div class="my-3">
							<button id="btnconfirm" class="form-control" onclick="passwordcheck('<%=mid %>')" >확인</button>
						</div>
						<div class="my-3">
							<span id="checkmsg"></span>
						</div>
						<div class="my-3">
							<button id="btndelete" class="btn btn-primary" style="display: none;" onclick="mdelete('<%=mid%>')">탈퇴</button>
						</div>
					</div>
			</div>
		</div>
	</div>
	<%} %>
	<script src="../js/info.js" type="text/javascript"></script>
	<%@include file="../footer.jsp" %>
</body>
</html>