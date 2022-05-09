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
		<div class="text-center">
			<h3>글 상세보기</h3>
		</div>
		<%if(request.getParameter("result")!=null && request.getParameter("result").equals("2")){%>
			삭제 실패! 관리자에게 문의
		<%} %>
		<a href="boardlist.jsp">목록보기</a>
		<%if(board.getMid().equals(loginid)) {%>
			<a href="boardwrite.jsp?bnum=<%=bnum %>&update=1">수정하기</a>
			<a href="../board/Bdelete?bnum=<%=bnum%>">삭제하기</a>
		<%} %>
		<br><br>
		<table class="table">
			<tr>
				<td>번호</td> <td><%=board.getBnum() %></td> <td>작성자</td> <td><%=board.getMid() %></td>
				<td>작성일</td> <td><%=board.getBdate() %></td> <td>조회수</td> <td><%=board.getBview() %></td>
			</tr>
			
			<tr> <td>제목</td> <td><%=board.getBtitle() %></td> </tr>
			<%if(board.getBfile()!=null) {%>
			<tr> <td>첨부파일</td> <td><a href="Filedown?bfile=<%=board.getBfile() %>"><%=board.getBfile() %></a></td> </tr>
			<%} else{ %>
			<tr> <td>첨부파일</td> <td>첨부파일 없음</td> </tr>
			<%} %>
			<tr> <td>내용</td> <td><%=board.getBcontent() %></td> </tr>
			
		</table>


		
		
	</div>
	<%@include file="../footer.jsp" %>

</body>
</html>