<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>

	<%@include file="../header.jsp" %>
	
	<div class="container">
		<table class="table">
			<tr>
				<th>체크박스</th> <th>이미지</th> <th>상품정보</th> <th>판매가</th> <th>수량</th> 
				<th>적립금</th> <th>배송구분</th> <th>배송비</th> <th>합계</th> <th>선택</th>
			</tr>
		</table>
		<h4>wishlist</h4>
		<table class="table wishlisttable">
		</table>
	</div>
	
	
	<%@include file="../footer.jsp" %>
	<script src="/jspweb/js/cart.js" type="text/javascript"></script>
</body>
</html>