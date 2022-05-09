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
	<%if(loginid==null){ %>
	
	<div class="container">
	로그인 이후 이용 가능
	<%} else{%>
		<%
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String today = format.format(date);
		ArrayList<Board> boardlist = new ArrayList<>(); 
		ArrayList<Board> blist = BoardDao.boardDao.getboardlist();
		for(Board temp : blist){
			if(temp.getMid().equals(loginid)){
				boardlist.add(temp);
			}
		}
		System.out.println(boardlist.toString());
		%>
		<div class="row">
			<div class="col-md-3">
				<%@include file="infosidebar.jsp" %>
			</div>
			<div class="col-md-9">
				<div class="col-md-4 offset-2">
					<div class="text-center">
						<h3>내가 쓴 글</h3>
					</div>
				<%if(boardlist.isEmpty()) {%>
					<span>등록된 글이 없습니다.</span>
				<%} else { %>
				<table class="table table-hover">
					<tr>
						<th> 번호 </th> <th> 제목 </th> <th> 작성자 </th> <th> 조회수 </th> <th> 작성일 </th>
					</tr>
				<%for(Board temp : boardlist) {%>
					<tr onclick="location.href='/jspweb/board/boardview.jsp?bnum=<%=temp.getBnum() %>'">
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
			<%} %>
		</table>
				</div>
			</div>
		</div>
	</div>
	<%} %>
	<%@include file="../footer.jsp" %>
</body>
</html>