<%@page import="dao.ReplyDao"%>
<%@page import="dto.Reply"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.Board"%>
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
		String id = (String)session.getAttribute("loginid");
		int bnum = Integer.parseInt(request.getParameter("bnum"));
		String viewcheck = (String)session.getAttribute("view");
		boolean vcheck = false;
		if(viewcheck==null){
			vcheck = true;
		}else if(viewcheck.equals(id+bnum)){
			vcheck = false;
		}else{
			vcheck = true;
		}
		if(vcheck){
			session.setAttribute("view", id+bnum);
			session.setMaxInactiveInterval(60*60*24);
			boolean result = BoardDao.boardDao.increview(bnum);
		}
		Board board = BoardDao.boardDao.getboard(bnum);
		

	%>
	<div class="container">
		
			
		
		<%if(request.getParameter("result")!=null && request.getParameter("result").equals("2")){%>
			삭제 실패! 관리자에게 문의
		<%} %>
		<div class="row">
			
			
			<%if(board.getMid().equals(loginid)) {%>
				<div class="col-md-2 offset-6">
					<a href="boardwrite.jsp?bnum=<%=bnum %>&update=1"><button class="form-control">수정하기</button></a>
				</div>
				<div class="col-md-2">
					<a href="../board/Bdelete?bnum=<%=bnum%>"><button class="form-control">삭제하기</button></a>
				</div>
			<%} %>
			<div class="col-md-2">
				<a href="boardlist.jsp"><button class="form-control">목록보기</button></a>
			</div>
		</div>
		
		
		<h2 class="boardview_title"><%=board.getBtitle() %></h2>
		<table class="table">
			<tr>
				<td width="25%">번호 : <%=board.getBnum() %></td> 
				<td width="25%">작성자 : <%=board.getMid() %></td>
				<td width="25%">작성일 : <%=board.getBdate() %></td> 
				<td width="25%">조회수 : <%=board.getBview() %></td>
			</tr>
			<%if(board.getBfile()!=null) {%>
			<tr> <td colspan="4">첨부파일 <span style="font-size: 13px;"><a href="Filedown?bfile=<%=board.getBfile() %>"><%=board.getBfile() %></a></span></td> </tr>
			<%} else{ %>
			<tr> <td colspan="4">첨부파일 <span style="font-size: 13px;">첨부파일 없음</span></td> </tr>
			<%} %>
			<tr> 
				<td colspan="4">
					<div class="boardview_content">
						<%=board.getBcontent() %>
					</div>
				</td>
			</tr>
			
		</table>
		<h4 class="boardview_title">댓글</h4>
		
		<%if(loginid != null ) { %>
			<div class="row">
				<div class="col-md-10">
					<textarea class="form-control my-1" rows=3 type="text" id="rcontent"></textarea>
				</div>
				<div class="col-md-2">	<!-- p : padding / m: margin -->
					<button class="form-control py-4 my-1" onclick="replywrite(<%=bnum%>)">등록</button>
				</div>
			</div>
		<%} else { %>
			<div class="row">
				<div class="col-md-10">
					<textarea disabled="disabled" class="form-control my-1" placeholder="* 로그인 후 댓글 작성이 가능합니다." rows=3 type="text" id="rcontent"></textarea>
				</div>
				<div class="col-md-2">	<!-- p : padding / m: margin -->
					<button disabled="disabled" class="form-control py-4 my-1" onclick="replywrite(<%=bnum%>)">등록</button>
				</div>
			</div>
		<%} %>
		<table class="table" id="replytable">
			
			<%ArrayList<Reply> replylist = ReplyDao.replyDao.getreply(bnum);
			for(Reply temp : replylist) {%>
				<tr>
					<%if(temp.getRcontent().equals("삭제된 댓글 입니다.")){ %>
						<td class="replywriter" width="10%"></td> 
						<td width="80%" colspan="2"><%=temp.getRcontent() %><br>
					<%} else{ %>
						<td class="replywriter" width="10%"><%=temp.getMid() %><br><span class="replydate"><%=temp.getRdate() %></span></td> 
						<td width="80%" colspan="2"><%=temp.getRcontent() %><br>
						<%if(loginid!=null && loginid.equals(temp.getMid())) {%>
							<button onclick="replyupdateview(<%=temp.getRnum() %>)" class="btn replybtn">수정</button>
							<button onclick="replydelete(<%=temp.getRnum() %>,<%=temp.getRindex() %>)" class="btn replybtn">삭제</button>
						<%} %>
						<%if(loginid != null) {%>
							<button onclick="rereplyview(<%=temp.getRnum() %>, <%=temp.getBnum() %>)" class="btn replybtn">댓글</button>
						<%} %>
						</td>
					<%} %> 
					<td></td>
				</tr>
				
				<!-- 대댓글 입력창 -->
				<tr id="rereply">
					<td></td>
					<td colspan="2" id=<%=temp.getRnum() %>></td>
				</tr>
				<!-- 대댓글 출력창 -->
				<%ArrayList<Reply> replylist2 = ReplyDao.replyDao.getrereply(bnum,temp.getRnum());
				for(Reply temp2 : replylist2) {%>
					<tr>
						<td></td>
						<%if(temp2.getRcontent().equals("삭제된 댓글 입니다.")){ %>
							<td class="replywriter" width="10%"></td> 
							<td width="80%" colspan="2"><%=temp2.getRcontent() %><br>
						<%}else{ %>
							<td class="replywriter" width="10%"><%=temp2.getMid() %><br><span class="replydate"><%=temp2.getRdate() %></span></td> 
							<td width="80%" colspan="2"><%=temp2.getRcontent() %><br>
								<%if(loginid!=null && loginid.equals(temp2.getMid())) {%>
									<button onclick="replyupdateview(<%=temp2.getRnum() %>)" class="btn replybtn">수정</button>
									<button onclick="replydelete(<%=temp2.getRnum() %>,<%=temp2.getRindex() %>)" class="btn replybtn">삭제</button>
								<%} %>
							</td>
						<%} %>
						
					</tr>
					<!-- 대댓글 입력창 -->
					<tr id="rereply">
						<td></td>
						<td colspan="2" id=<%=temp2.getRnum() %>></td>
					</tr>
				<%} %>
			<%} %>
		</table>
		


		
		
	</div>
	<%@include file="../footer.jsp" %>
	<script src="/jspweb/js/board.js" type="text/javascript"></script>
</body>
</html>