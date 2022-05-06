<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="dao.MemberDao"%>
<%@page import="dto.Board"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@include file="../header.jsp" %>
	<% 
		ArrayList<Board> boardlist = BoardDao.boardDao.getboardlist();
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String today = format.format(date);
		
	%>
	<div class="container">
		<div class="text-center">
			<h3>자유게시판</h3>
		</div>
		<%if(loginid!=null){ %>
		<a href="boardwrite.jsp">글쓰기</a>
		<%} %>
		<table class="table table-hover">
			<tr>
				<th> 번호 </th> <th> 제목 </th> <th> 작성자 </th> <th> 조회수 </th> <th> 작성일 </th>
			</tr>
			<!-- for문 -->
			<%for(Board temp : boardlist) {%>
				
				<tr onclick="location.href='boardview.jsp?bnum=<%=temp.getBnum() %>'">
					<td><%=temp.getBnum() %></td>
					<td><%=temp.getBtitle() %></a></td>
					<td><%=MemberDao.memberDao.getmid(temp.getMnum()) %></td>
					<td><%=temp.getBview() %></td>
					<% if(today.equals(temp.getBdate().split(" ")[0])) { %>
						<td><%=temp.getBdate().split(" ")[1] %></td>
					<%} else{ %>
						<td><%=temp.getBdate().split(" ")[0] %></td>
					<%} %>
				</tr>
			<%} %>
		</table>
	</div>
	<%@include file="../footer.jsp" %>
	
	
</body>
</html>