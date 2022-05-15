<%@page import="dto.건물"%>
<%@page import="dao.건물Dao"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="dto.플레이어"%>
<%@page import="dao.플레이어Dao"%>
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
	<%
	int 게임번호 = 1;
	ArrayList<게임판> 게임판리스트 = 게임판Dao.게임판Dao.게임판리스트();
	ArrayList<플레이어> plist = 플레이어Dao.플레이어Dao.getplayers(게임번호);
	DecimalFormat decimalFormat = new DecimalFormat("#,###원"); 
	%>
	<h1> 부 루 마 블 </h1>
	<div id="headtable">
	<%for(플레이어 player : plist) {%>
		<%if(player.get턴()==1) {%>
		<span><%=player.get플레이어닉네임() %>님의 턴</span>
		<input type="text" id="playernum" hidden="" value=<%=player.get플레이어번호() %>>
		<input type="text" id="gamenum" hidden="" value=<%=게임번호 %>>
		<%session.setAttribute("player", player.get플레이어번호()); %>	
		<%} %>
	<%} %>
	</div>
		<div class="row">
			<div class="col-md-9 offset-1">
			
				<div class="row" id="gemetable">
				<%
				for(int i=1; i<=121; i++){
					for(게임판 temp : 게임판리스트){
						if(i%11==1 && (temp.get게임판위치()+(i/11))==20 ){ %>
							<div class="gameboard col-md-1 offset-1"><%=temp.get게임판위치() %><br><%=temp.get도시이름() %><br>
							<%for(플레이어 player : plist){ %>
							<%if(temp.get게임판위치()==player.get현재위치()){ %>
								<span <%if(player.get순서()==1){ %>
								style="color: red;"
								<%} else if(player.get순서()==2){ %>
								style="color: blue;"
								<%} else if(player.get순서()==3){ %>
								style="color: green;"
								<%} else if(player.get순서()==4){ %>
								style="color: purple"
								<%} %>
								><%=player.get플레이어닉네임() %></span><br>
							<%} else{ } }%>
							</div>
						<%}else if(i>1 && i<12 &&temp.get게임판위치()-i==19){  %>
							<div class="gameboard col-md-1"><%=temp.get게임판위치() %><br><%=temp.get도시이름() %><br>
							<%for(플레이어 player : plist){ %>
							<%if(temp.get게임판위치()==player.get현재위치()){ %>
								<span <%if(player.get순서()==1){ %>
								style="color: red;"
								<%} else if(player.get순서()==2){ %>
								style="color: blue;"
								<%} else if(player.get순서()==3){ %>
								style="color: green;"
								<%} else if(player.get순서()==4){ %>
								style="color: purple"
								<%} %>
								><%=player.get플레이어닉네임() %></span><br>
							<%} else{ } }%>
							</div>
						<%}else if(i%11==0 && (temp.get게임판위치()-(i/11))==29) {%>
							<div class="gameboard col-md-1"><%=temp.get게임판위치() %><br><%=temp.get도시이름() %><br>
							<%for(플레이어 player : plist){ %>
							<%if(temp.get게임판위치()==player.get현재위치()){ %>
								<span <%if(player.get순서()==1){ %>
								style="color: red;"
								<%} else if(player.get순서()==2){ %>
								style="color: blue;"
								<%} else if(player.get순서()==3){ %>
								style="color: green;"
								<%} else if(player.get순서()==4){ %>
								style="color: purple"
								<%} %>
								><%=player.get플레이어닉네임() %></span><br>
							<%} else{ } }%>
							</div>
						<%}else if(i>111 && i<121 && temp.get게임판위치()+i==121) { %>
							<div class="gameboard col-md-1"><%=temp.get게임판위치() %><br><%=temp.get도시이름() %><br>
							<%for(플레이어 player : plist){ %>
							<%if(temp.get게임판위치()==player.get현재위치()){ %>
								<span <%if(player.get순서()==1){ %>
								style="color: red;"
								<%} else if(player.get순서()==2){ %>
								style="color: blue;"
								<%} else if(player.get순서()==3){ %>
								style="color: green;"
								<%} else if(player.get순서()==4){ %>
								style="color: purple"
								<%} %>
								><%=player.get플레이어닉네임() %></span><br>
							<%} else{ } }%>
							</div>
						<%} %>	
									
					<%} %>
					<%if((i>12 && i<110) && (i%11>1 && i%11<11) ) {%>
					<div class="gameboard col-md-1" style="border: none;"></div>
					<%} %>
					
				<%} %>
				</div>
			</div>
			
			<div class="col-md-1">
			<%for(플레이어 player : plist){ %>
				<%if(player.get턴()==1) {%>
					<button onclick="throwDice(<%=player.get플레이어번호()%>,1)">주사위</button><br>
					주사위 1 값 : <span id = "dice1"></span><br>
					주사위 2 값 : <span id = "dice2"></span><br>
					총합 : <span id = "sum"></span><br>
					<button onclick="turnend()">턴 종료</button>
				<%}else{ } %>
			<%} %>
				
			</div>
			
	</div>
	
	<div class="container">
		<div>
			<h3>플레이어 목록</h3>
			<input id="nickname" type="text" placeholder="닉네임"> <button type="button" onclick="player(1)">등록</button>
		</div>
		<div id = "playertable">
			<%ArrayList<플레이어> plist2 = 플레이어Dao.플레이어Dao.getplayers(1); %>
			
			<%for(플레이어 temp : plist2){ %>
			번호 : <span><%=temp.get플레이어번호() %></span> 닉네임 : <span><%=temp.get플레이어닉네임() %> </span> <span>순서 : <%=temp.get순서() %></span>
			보유자금 : <span><%=decimalFormat.format(temp.get소유자금()) %></span>
				<%if(temp.get무인도()!=0){ %>
					<span>무인도 탈출까지 남은 턴 : <%=temp.get무인도() %></span>
				<%} %>
			<br>
			<%} %>
		</div>
	</div>
	
	<button hidden="" id="paymodal" data-bs-toggle="modal"  data-bs-target="#activemodal"></button>
	<!-- 상태변경 부트스트랩 - 모달 구역 -->
	<div class="modal" tabindex="-1" id="activemodal" data-bs-backdrop="static" data-bs-keyboard="false">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title">통행료 지불</h5>	<!-- 모달 헤더 -->
	      </div>
	      <div class="modal-body">
	        <p>지불할 통행료 :<span id="pay"></span> 원</p>	<!-- 모달 바디 -->
	        <%int pay = (Integer)request.getAttribute("pay"); %>
	        <input type="hidden" id="modalinput">
	      </div>
	      <div class="modal-footer">	<!-- 모달 푸터 -->
	      	<button type="button" class="btn btn-primary" onclick="pay()">지불</button>
	        <button type="button" id="giveup" class="btn btn-secondary" data-bs-dismiss="modal" onclick="giveup()">게임포기</button>
	        <button type="button" hidden="" id="modalclosebtn" data-bs-dismiss="modal"></button>
	        
	      </div>
	    </div>
	  </div>
	</div>

	
	<button id="buymodal" data-bs-toggle="modal"  data-bs-target="#buymodal1">asdsadasd</button>
	
	<!-- Modal -->
	<div class="modal" tabindex="-1" id="buymodal1" data-bs-backdrop="static" data-bs-keyboard="false">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">도시 구매</h5>
	      </div>
	      <div class="modal-body"> <!-- 모달 바디 --> 
		        <input type="hidden" id="modalinput">
		        <div id="modal_contents"></div>
	      </div>
	      <div class="modal-footer">
	     	<button type="button" class="btn btn-primary" onclick="buy()">구매</button>
	        <button type="button" id="modalclosebtn" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
	      </div>
	    </div>
	  </div>
	</div>	






	<!-- 부트스트랩 JavaScript cdn -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- jQuery 최신 -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="/BlueMarble/js/main.js" type="text/javascript"></script>
</body>
</html>