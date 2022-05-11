<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../header.jsp" %>
	<div class="container">
	<%if(loginid==null){ %>
	로그인 이후 이용 가능
	<%} else{%>
		<div class="row">
			<div class="col-md-3">
				<%@include file="infosidebar.jsp" %>
			</div>
			<div class="col-md-3">
				<h4 class="boardlist-title">주문현황</h4>
			</div>
		</div>
	</div>
	<%} %>
	<%@include file="../footer.jsp" %>
</body>
</html>