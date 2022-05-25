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
	
	
	
	
	<!-- 취소 모달 -->
	<div class="modal" tabindex="-1" id="cancelmodal">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title">취소 요청</h5>	<!-- 모달 헤더 -->
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body"> <!-- 모달 바디 -->
				취소 요청 사유<br>
				<input class="form-control" type="text">
	      </div>
	      <div class="modal-footer">	<!-- 모달 푸터 -->
	      	<button type="button" class="btn btn-primary" onclick="cancel()">취소신청</button>
	        <button type="button" id="modalclosebtn" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	
	
	<%} %>
	<%@include file="../footer.jsp" %>
	<script src="/jspweb/js/myshopping.js" type="text/javascript"></script>
</body>
</html>