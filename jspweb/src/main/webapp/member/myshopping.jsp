<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="/jspweb/css/myshopping.css">
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
			<div class="col-md-9">
				<h4 class="boardlist-title">주문현황</h4>
				<table class="table" id="ordertable">
					
				</table>
			</div>
		</div>
	</div>
	<%} %>
	<%@include file="../footer.jsp" %>
	<script src="/jspweb/js/myshopping.js" type="text/javascript"></script>
</body>
</html>