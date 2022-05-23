<%@page import="dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>Testing</title>
</head>
<body>
    <fieldset>
    <%User user = (User)session.getAttribute("dice"); %>
    <%if(user==null) {%>
    <%}else{ %>
    <%System.out.println("user : "+user.toString() ); %>
    <%} %>
        <textarea id="messageWindow" rows="10" cols="50" readonly></textarea>
        <br/>
        <input id="inputMessage" type="text"/>
        <input type="submit" value="send" onclick="send()" onKeypress="javascript:if(event.keyCode==13) {onclick_send()}" />
        <button type="button" onclick="dice()">주사위</button>
        <div id="playerarea">
        	<input disabled="disabled" id="player1" type="text" value="player1"> 주사위 합계 : <input disabled="disabled" type="text" id="player1dice" value="0"><br>
        	<input disabled="disabled" id="player2" type="text" value="player2"> 주사위 합계 : <input disabled="disabled" type="text" id="player2dice" value="0"><br>
        	<input disabled="disabled" id="player3" type="text" value="player3"> 주사위 합계 : <input disabled="disabled" type="text" id="player3dice" value="0"><br>
        </div>
    </fieldset>
</body>
  
  <!-- jquery 최신 cdn -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script type="text/javascript" src="/BlueMarble/js/chatting.js"></script>
</html>