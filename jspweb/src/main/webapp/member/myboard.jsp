<%@page import="dao.ReplyDao"%>
<%@page import="dto.Reply"%>
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
<!----------------------------------페이징 계산 처리----------------------------------->
	<%
		String key = request.getParameter("key");
		String keyword = request.getParameter("keyword");
		// 1. 게시물 전체 개수
		int totalrow=0;
		// 2. 현재 페이지 번호
		int currentpage = 1;
		// 요청받은 페이지 번호
			// 만약에 페이지번호 요청이 없으면
			if(request.getParameter("pagenum") == null){
				currentpage = 1;
			}else{
				int pagenum = Integer.parseInt(request.getParameter("pagenum"));
				currentpage = pagenum;
			}
		
		// 3. 페이지당 화면에 표시할 게시물 개수
		int listsize = 5;	// 추후에 사용자에게 입력을 받기
		
		// 4. 페이지당 게시물의 시작 번호
		int startrow = (currentpage-1)*listsize;
			// 1페이지 -> 0 // 2페이지 -> 0+listsize // 3페이지 -> 0+listsize*2
		int lastpage;	// 마지막 페이지 번호
		
		// 5. 게시물 호출
		ArrayList<Board> blist = BoardDao.boardDao.getboardlist(startrow,listsize,key,keyword);
		ArrayList<Board> boardlist = new ArrayList<>(); 
		for(Board temp : blist){
			if(temp.getMid().equals(loginid)){
				boardlist.add(temp);
				totalrow++;
			}
		}
		if(totalrow%listsize==0){
			lastpage = totalrow/listsize;
		}else{
			lastpage = (totalrow/listsize)+1;
		}
		// 5. 페이지 버튼 표시할 개수
		int pagesize = 5;
		// 6. 페이지 버튼 시작 번호
		int startbtn = ((currentpage-1)/pagesize)*pagesize+1;
		// 7. 페이지 버튼 끝 번호
		int endbtn = startbtn+(pagesize-1);
		if(endbtn>lastpage){	// 만약에 페이징 버튼이 마지막 페이지 번호보다 커지면
			endbtn = lastpage;
		}
	%>
<!-- --------------------------------------------------------------------------- -->

	<% 
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String today = format.format(date);	
	%>
	<div class="container">
	<%if(loginid==null){ %>

	로그인 이후 이용 가능
	<%} else{%>
		<div class="row">
			<div class="col-md-3">
				<%@include file="infosidebar.jsp" %>
			</div>
			<div class="col-md-9">
				<h4 class="boardlist-title">내가 쓴 글</h4>
<!-- -------------------------------게시물 출력 구역-------------------------------- -->
		<table class="table table-hover text-center">
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
					<td style="text-align: left;"><%=temp.getBtitle() %>
					<%if(i!=0) {%>
						<span class="board-replycount">
						<%=i %>
						</span>
					<%} %>
					</td>
					<td><%=MemberDao.memberDao.getmid(temp.getMnum()) %></td>
					<% if(today.equals(temp.getBdate().split(" ")[0])) { %>
						<td><%=temp.getBdate().split(" ")[1] %></td>
					<%} else{ %>
						<td><%=temp.getBdate().split(" ")[0] %></td>
					<%} %>
					<td><%=temp.getBview() %></td>
				</tr>
			<%} %>
		</table>


<!-- -------------------------------페이징 입력 구역-------------------------------- -->
		<div class="col-md-4 offset-4 d-flex justify-content-center">
									<!-- d-flex justify-content-center : 박스권 내에서 가운데 배치 -->
			<ul class="pagination">
			
				<!-- 이전 버튼 -->
				<%if(currentpage<=pagesize) {%>
				<li class="page-item disabled"><a class="page-link pagenum" href="boardlist.jsp">이전</a></li>
				<%}else{ %>
				<li class="page-item"><a class="page-link pagenum" href="boardlist.jsp?pagenum=<%=startbtn-1%>">이전</a></li>
				<%} %>
				<!-- 페이징 버튼 -->
				<%for(int i=startbtn; i<=endbtn; i++) {%>
					<%if(currentpage==i) {%>
						<li class="page-item active" aria-current="page"><a class="page-link pagenum" href="boardlist.jsp?pagenum=<%=i%>"><%=i %></a></li>
					<%} else{ %>
						<li class="page-item"><a class="page-link pagenum" href="boardlist.jsp?pagenum=<%=i%>"><%=i %></a></li>
					<%} %>
					
				<%} %>
				
				<!-- 다음 버튼 -->
				<%if(endbtn==lastpage) {%>
					<li class="page-item disabled"><a class="page-link pagenum" href="boardlist.jsp">다음</a></li>
				<%} else{ %>
					<li class="page-item"><a class="page-link pagenum" href="boardlist.jsp?pagenum=<%=endbtn+1%>">다음</a></li>
				<%} %>
			</ul>
		</div>
			</div>
		</div>
	<%} %>
	</div>
	<%@include file="../footer.jsp" %>
</body>
</html>