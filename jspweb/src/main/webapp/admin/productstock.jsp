<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>

	<h3>제품 재고</h3>
	카테고리 목록
	<select id="categorybox"> <!-- 카테고리 목록이 출력되는 부분 -->
		
	</select>
	제품 목록
	<select id="productbox"> <!-- 제품 목록이 출력되는 부분 -->
		
	</select>
	
	
	<br><br><br>
	<form style="display: none;" id="stockbox">
		색상 <input type="text" id="scolor">
		사이즈 <input type="text" id="ssize">
		수량 <input type="text" id="samount">
		<button type="button" onclick="stockadd()">재고 추가</button>
	</form>
	<h4><span id="productname"></span></h4>
	<br><br><br>
	<div id="stocktable"></div>
	


	<script src="/jspweb/js/productstock.js" type="text/javascript"></script>
</body>
</html>