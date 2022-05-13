<%@page import="dao.게임판Dao"%>
<%@page import="dto.게임판"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- 사용자정의 css -->
	<link href="main.css" rel="stylesheet">
	<!-- 부트스트랩 CSS cdn -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<!-- 폰트어썸[ 아이콘 ]  -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
</head>
<body>

	<h1> 부 루 마 불 </h1>
	
		<div class="row">
			<div class="col-md-9 offset-1">
			
				<div class="row">
				<%
				
				ArrayList<게임판> 게임판리스트 = 게임판Dao.게임판Dao.게임판리스트();
				int i = 0;
				for(게임판 temp : 게임판리스트){
				%>
					<div class="gameboard col-md-1"><%=temp.get도시이름()%></div>
				<%} %>
				</div>
			</div>
			
			<div class="col-md-1">
			
			여기엔 주사위랑 이것저것 표시
		</div>
	</div>









	<!-- 부트스트랩 JavaScript cdn -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- jQuery 최신 -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="game.js"></script>
</body>
</html>