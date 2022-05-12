<%@page import="dao.ProductDao"%>
<%@page import="dto.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>

	
	<div class="container" style="margin-left: 200px;">
		<h4>제품 등록 페이지</h4>
		<!-- 폼에서 첨부파일 보낼시 enctype="multipart/form-data" 사용 -->
		<form id="addform" enctype="multipart/form-data">
			카테고리 : <button type="button" onclick="categorybtn()">카테고리추가</button><br>
			<!-- 버튼 클릭시 카테고리 입력창 표시되는 구역 -->
			<div id = "categoryinput"></div>
			<!-- DB내 카테고리 개수만큼 select 버튼이 표시되는 구역 -->
			<select name="cg_num" id = "categorybox"></select>
			제품이름 : <input type="text" name="pname"  placeholder="제품명"><br>
			가격 : <input type="text" name="pprice" placeholder="가격"><br>
			할인율 : <input type="text" name="pdiscount" placeholder="할인율"><br>
			제품 이미지 : <input type="file" name="pimg" id="pimg" placeholder="제품 이미지"><br>
			<button type="button" onclick="productadd()">등록</button><input type="reset" value="초기화">
		</form>
	</div>
	
	<!-- 사용자 정의 js 호출 -->
	<script src="/jspweb/js/productadd.js" type="text/javascript"></script>

</body>
</html>