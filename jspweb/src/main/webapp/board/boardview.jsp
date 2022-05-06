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
		int bnum = Integer.parseInt(request.getParameter("bnum")); 
		Board board = BoardDao.boardDao.getboard(bnum);
		boolean result = BoardDao.boardDao.increview(bnum);
		if(result){
			System.out.println("조회수증가");
		}else{
			System.out.println("조회수증가오류");
		}
		
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
			<a href="boardwrite.jsp">수정하기</a>
			<a href="../board/Bdelete?bnum=<%=bnum%>">삭제하기</a>
		<%} %>
		<br><br>
		
		작성자 :	<%=board.getMid() %> <br>
		조회수 : 	<%=board.getBview()+1 %><br>
		작성일 : 	<%=board.getBdate() %><br>
		제목 : <%=board.getBtitle() %><br>
		내용 : <%=board.getBcontent() %><br>
		첨부파일 : <%=board.getBfile() %><br>

		
	</div>
	<%@include file="../footer.jsp" %>

</body>
</html>