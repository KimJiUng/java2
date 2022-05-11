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
<!----------------------------------검색 계산 처리----------------------------------->
	<%
		request.setCharacterEncoding("UTF-8"); // 한글 인코딩 타입 설정
		// 검색에서 입력받은 데이터 요청하기
		String key = request.getParameter("key");
		String keyword = request.getParameter("keyword");
	
		// 세션을 이용한 검색처리 저장
		
		// 검색이 있을 경우
		if(keyword!=null){
			session.setAttribute("key", key);
			session.setAttribute("keyword", keyword);
		}else{ // 검색이 없을 경우
			key = (String)session.getAttribute("key");
			keyword = (String)session.getAttribute("keyword");
		}
		
		
		
	%>


<!----------------------------------페이징 계산 처리----------------------------------->
	<%
		// 1. 게시물 전체 개수
		int totalrow = BoardDao.boardDao.gettotalrow(key,keyword);
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
		// 5. 게시물 호출
		ArrayList<Board> boardlist = BoardDao.boardDao.getboardlist(startrow,listsize,key,keyword);
	%>
<!-- --------------------------------------------------------------------------- -->

	<%@include file="../header.jsp" %>
	<% 
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String today = format.format(date);
		
	%>
	<div class="container">
		<h4 class="boardlist-title">자유게시판</h4>
		<div class="row boardlist-topbtn">
			<div class="col-md-1 offset-10">
				<a href="boardlist.jsp?key=&keyword="><button class="form-control">전체글</button></a>
			</div>
			<div class="col-md-1">
				<button class="form-control">인기글</button>
			</div>
		</div>
<!-- -------------------------------게시물 출력 구역-------------------------------- -->
		<table class="table table-hover text-center">
			<tr>
				<th width="10%"> 번호 </th> 
				<th width="50%"> 제목 </th> 
				<th width="15%"> 작성자 </th> 
				<th width="15%"> 작성일 </th>
				<th width="10%"> 조회수 </th> 
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
		<div class="col-md-2 offset-10">
			<%if(loginid!=null){ %>
				<a href="boardwrite.jsp"><button class="form-control">글쓰기</button></a>
			<%} else{ %>
				<span class="boardlist-write">로그인 후 글쓰기가 가능합니다.</span>
			<%} %>
		</div>

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


<!-- -------------------------------검색 입력 구역-------------------------------- -->
		<form action="" class="col-md-4 offset-4 d-flex justify-content-center">
			<div class="col-md-3">	<!-- 키워드 선택 -->
				<select class="form-select" name="key">
				
					<option <%if(session.getAttribute("key").equals("btitle")) {%> selected="selected" <%} %> value="btitle">제목</option>	<!-- key = 필드명 -->
					<option <%if(session.getAttribute("key").equals("bcontent")) {%> selected="selected" <%} %> value="bcontent">내용</option>
					<option <%if(session.getAttribute("key").equals("mid")) {%> selected="selected" <%} %> value="mid">작성자</option>
				</select>
			</div>
			<div class="col-md-7">	<!-- 검색 입력창 -->
				<input type="text" class="form-control" name="keyword" value="<%=session.getAttribute("keyword")%>">	<!-- keyword = 해당필드의 값 --> 
			</div>
			<div class="col-md-2">	<!-- 검색 버튼 -->
				<input type="submit" class="form-control" value="검색">
			</div>
		</form>


	</div>
	<%@include file="../footer.jsp" %>
	
	
</body>
</html>