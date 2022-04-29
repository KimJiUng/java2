<%@page import="Dto.Board"%>
<%@page import="Dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<a href="main.jsp"><button>목록보기</button></a>
	<%
	int bnum = Integer.parseInt(request.getParameter("bnum"));
	session.setAttribute("bnum", bnum);
	Board board = BoardDao.boardDao.get(bnum);
	
	// 만약 로그인된 정보와 작성자가 동일할 경우 삭제/수정 표시
	String loginid = (String)session.getAttribute("loginid");

	if(loginid!=null && loginid.equals(board.getBwriter())){%>
		<a href="bupdate.jsp?bnum=<%=bnum%>"></button>수정</button></a>
		<a href="bdeletecontroller.jsp?bnum=<%=bnum%>"></button>삭제</button></a>
	<%} %>	
	


	
	

	<div> 제목 : <%=board.getBtitle() %> </div>
	<div> 작성자 : <%=board.getBwriter() %> </div>
	<div> 작성일 : <%=board.getBdate() %> </div>
	<div> 내용 : <%=board.getBcontent() %> </div>
	
</body>
</html>