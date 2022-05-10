<%@page import="dto.Reply"%>
<%@page import="dao.ReplyDao"%>
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
</head>
<body>

	<%@include file="../header.jsp" %>
	<% 
		ArrayList<Board> boardlist = BoardDao.boardDao.getboardlist();
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String today = format.format(date);
		int pagenum;
		if(request.getParameter("page")!=null){
			pagenum = Integer.parseInt(request.getParameter("page"));	
		}else{
			pagenum = 0;
		}
		
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
				<%ArrayList<Reply> replylist = ReplyDao.replyDao.getreply(temp.getBnum());
				
				int i=0;
				for(Reply reply : replylist){
					ArrayList<Reply> rereplylist = ReplyDao.replyDao.getrereply(temp.getBnum(),reply.getRnum());
					for(Reply rereply : rereplylist){
						if(!rereply.getRcontent().equals("삭제된 댓글 입니다.")){
							i++;	
						}	
					}
					if(!reply.getRcontent().equals("삭제된 댓글 입니다.")){
						i++;	
					}
				}%>
				<!-- 
					행을 클릭했을때 [ js ]
						<tr onclick="location.href='boardview.jsp'">
					상세 이동시 [ 식별번호 같이 이동 ]
						// 1. HTML : <a href='파일명(경로).jsp?변수명=값'>
						// 2. JS : "location.href='파일명(경로).jsp?변수명=값'">
						// 3. java : response.sendRedirect("파일명(경로).jsp?변수명=값");
				 -->
				<tr onclick="location.href='boardview.jsp?bnum=<%=temp.getBnum() %>'">
					<td><%=temp.getBnum() %></td>
					<td><%=temp.getBtitle() %>
					<%if(i!=0) {%>
						<span class="board-replycount">
						<%=i %>
						</span>
					<%} %>
					</td>
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
		<nav aria-label="...">
		  <ul class="pagination justify-content-center">
		  	<%if(pagenum<11) {%>
		    <li class="page-item disabled">
		    <%} else{ %>
		    <li class="page-item">
		    <%} %>
		      <a class="page-link" href="boardlist.jsp?page=<%=pagenum-10%>" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
		    <%for(int i=1; i<(boardlist.size()/10)+1; i++) {%>
		    	<%if(i<11) {%>
		    		<%if((pagenum/10)<1) {%>
		    			<li class="page-item"><a class="page-link" href="boardlist.jsp?page=<%=pagenum+i%>"><%=pagenum+i%></a></li>
		    		<%}else{ %>
		    			<li class="page-item"><a class="page-link" href="boardlist.jsp?page=<%=(pagenum/10)*10+i%>"><%=(pagenum/10)*10+i%></a></li>
		    		<%} %>
		    		
		    	<%pagenum++;} %>
		    	
		    <%} %>
		    <%if(((pagenum/10)+1)>((boardlist.size()/10)+1)) {%>
		    <li class="page-item disabled">
		    <%} else{ %>
		    <li class="page-item">
		    <%} %>
		      <a class="page-link" href="boardlist.jsp?page=<%=pagenum+10%>" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
		  </ul>
		</nav>
	</div>
	<%@include file="../footer.jsp" %>
	
	
</body>
</html>