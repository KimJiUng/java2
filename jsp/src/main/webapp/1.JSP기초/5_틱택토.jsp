<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%! 
	String 승리알 =" ";
	String[] 게임판 = {" "," "," ", " "," ", " "," ", " "," "};  
	String name ="";
	%>

	<%
		if(request.getParameter("num") !=null){
			int num = Integer.parseInt(request.getParameter("num"));
			게임판[num] = "O";
			while(true) {
				Random random = new Random();
				int 위치 = random.nextInt(9);
					if(게임판[위치].equals(" ")) { 
						게임판[위치] = "X";
						break; 
					}
			} 
			for(int i=0; i<=6; i+=3) {
				if(게임판[i].equals(게임판[i+1]) && 게임판[i+1].equals(게임판[i+2])) {
					승리알=게임판[i]; 
				}
			}
			for(int i=0; i<=2; i++) {
				if(게임판[i].equals(게임판[i+3]) && 게임판[i+3].equals(게임판[i+6])) {
					승리알=게임판[i];
				}
			}
			if(게임판[0].equals(게임판[4]) && 게임판[4].equals(게임판[8])) {
				승리알=게임판[4];
			}	
			if(게임판[2].equals(게임판[4]) && 게임판[4].equals(게임판[6])) {
				승리알=게임판[4];
			}
		}
		
		if(request.getParameter("초기화")!=null){
			name = request.getParameter("초기화");
			if(name.equals("초기화")){
				for(int i=0; i<9; i++){
					게임판[i] = " ";
				}
				승리알 = " ";
			}
		}
		
				

	%>
	
	<h3>틱택토 게임</h3>
	
	<table>
	<tr>
		<%for(int i=0; i<9; i++) {%>
			<td>
				<form action="5_틱택토.jsp" method="get">
				<input type="text" name=num value="<%=i %>" hidden="">
				<input type="submit" value="<%=게임판[i]%>" 
				
				<%if(게임판[i].equals("X") || 게임판[i].equals("O")){ %>
					disabled="disabled"
				<% }%>
				>
				</form>	
			</td>
			<%if(i%3==2) {%>
				</tr>
			<%} %>
		<%} %>
	</table>
	
	<%if(승리알.equals("X")){ %>
	<span>컴퓨터 승리!</span>
	<%} %>
	<%if(승리알.equals("O")){ %>
	<span>유저 승리!</span>
	<%} %>
	<form action="5_틱택토.jsp" method="get">
		<input type="submit" value="초기화" name="초기화">
	</form>
</body>
</html>