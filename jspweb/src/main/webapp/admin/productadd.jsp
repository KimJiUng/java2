<%@page import="dao.ProductDao"%>
<%@page import="dto.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link href="/jspweb/css/productadd.css" rel="stylesheet">
</head>
<body>

	
	<div class="container" style="margin-left: 200px;">
		<h3 class="admin_title">제품 등록 페이지</h3>
		<!-- 폼에서 첨부파일 보낼시 enctype="multipart/form-data" 사용 -->
		<div class="row">
			<form id="addform" class="col-md-8">
				<div class="row productaddlist">
					<div class="col-md-3">
						<span> 제품명 </span>
					</div>
					<div class="col-md-9">
						<input class="form-control" type="text" name="pname"  placeholder="제품명">
					</div>
				</div>
				<div class="row productaddlist">
					<div class="col-md-3">
						<span> 가격 </span>
					</div>
					<div class="col-md-9">
						<input class="form-control" type="text" name="pprice" placeholder="가격">
					</div>
				</div>
				<div class="row productaddlist">
					<div class="col-md-3">
						<span> 할인율 </span>
					</div>
					<div class="col-md-9">
						<input class="form-control" type="text" name="pdiscount" placeholder="할인율">
					</div>
				</div>
				<div class="row productaddlist">
					<div class="col-md-3">
						<span> 카테고리 </span>
					</div>
					<div class="col-md-3">
						<button class="form-control" type="button" onclick="categorybtn()">카테고리추가</button>
					</div>
					<!-- 버튼 클릭시 카테고리 입력창 표시되는 구역 -->
					<div class="col-md-6" id = "categoryinput"></div>
				</div>
				<div class="col-md-9 offset-3 productaddlist">
					<!-- DB내 카테고리 개수만큼 select 버튼이 표시되는 구역 -->
					<select class="form-control" name="cg_num" id = "categorybox"></select>
				</div>
				
				<div class="row productaddlist">
					<div class="col-md-3">
						<span> 대표이미지 </span>
					</div>
					<div class="col-md-9">
						<input class="form-control" type="file" name="pimg" id="pimg" placeholder="제품 이미지">
					</div>
				</div>
				<div class="row productaddlist">
					<div class="col-md-2 offset-3">
						<button class="form-control" type="button" onclick="productadd()">등록</button>
					</div>
					<div class="col-md-2">
						<input class="form-control" type="reset" value="초기화">
					</div>
				</div>
			</form>
			<div class="col-md-4">
			<h5>대표 이미지 미리보기</h5>
			<img id="preview" width="100%">
		</div>
		</div>
		
		
	</div>
	
	<!-- 사용자 정의 js 호출 -->
	<script src="/jspweb/js/productadd.js" type="text/javascript"></script>

</body>
</html>