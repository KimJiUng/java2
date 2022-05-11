<%@page import="dao.ChattingDao"%>
<%@page import="dto.Chatting"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<%@include file="../header.jsp" %>
	<br><br><br><br><br><br><br><br>
	<div class="container">
		<div class="col-md-4 offset-4">
			<h3 class="bigtext">채팅</h3>
			<div style="border: 1px solid black; overflow-y:scroll; height : 500px; " id="tablescroll" >
			
				
					<span id="chattingtable">
					<%ArrayList<Chatting> clist = ChattingDao.chattingDao.getclist(); 
					for(int i=0; i<clist.size(); i++) {%>
						<div class="row" style="margin-bottom: 10px;">
							<%if(i!=0 && clist.get(i).getNickname().equals(clist.get(i-1).getNickname())){%>
								
								<div class="col-md-8 offset-4">
									<span style="font-size: 13px;"><%=clist.get(i).getChatting() %></span>
									<span style="font-size: 10px; color: gray;" id="cdate<%=i %>"><%=clist.get(i).getCdate().split(" ")[1].substring(0, 5) %></span>
								</div>
							<%} else{%>
								<div class="col-md-4">
									<span style="font-size: 15px; font-weight: bold;"><%=clist.get(i).getNickname() %></span>
								</div>
								<div class="col-md-8">
									<span style="font-size: 13px;"><%=clist.get(i).getChatting() %></span>
									<span style="font-size: 10px; color: gray;"><%=clist.get(i).getCdate().split(" ")[1].substring(0, 5) %></span>
								</div>
								
							<%} %>
							
						</div>
						
					<%} %>
					</span>
					
			</div>
			<div class="row">
				<div class="col-md-3"><input type="text" class="form-control" name="talk_id" id="talk_id" placeholder="닉네임" value=""></div>
				<div class="col-md-6"><input type="text" class="form-control" name="talk_input" id="talk_input" placeholder="내용"></div>
				<div class="col-md-3"><button type="button" class="form-control" onclick="sendtalk()">전송</button></div>
			</div>
		
		
		</div>
	</div>
	<script src="/jspweb/js/chatting.js" type="text/javascript"></script>
	<%@include file="../footer.jsp" %>
</body>
