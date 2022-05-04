<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>

	<%@include file="../header.jsp" %>
	<%
	String logincheck = null;
	logincheck =(String)session.getAttribute("logincheck");
	%>
	
	<div class="container">
		<div class="col-md-4 offset-4">
			<div class="text-center" style="border-bottom: solid 1px gray;">
				<h3>로그인페이지</h3>
			</div>
			<br><br>
			<form action="../Login" method="post">
				<input class="form-control" type="text" name="mid" placeholder="아이디"><br>
				<input class="form-control" type="password" name=mpassword placeholder="비밀번호"><br>
				<input class="form-control" type="submit" value="로그인">
				
				<!-- 만약에 로그인 실패시 -->
				<%
					String result = request.getParameter("result");
					if(result!=null && result.equals("2")){
				%>
					<span class="signuptext">동일한 회원정보가 없습니다.</span>
				<%	} %>
			</form>
			
		</div>
	</div>
	
	<%@include file="../footer.jsp" %>

</body>
</html>