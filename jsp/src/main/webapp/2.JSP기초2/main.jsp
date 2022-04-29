<%@page import="Dao.BoardDao"%>
<%@page import="Dto.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원제 게시판</title>
</head>
<body>
	
	<h3> 회원제 게시판 </h3>
	<a href="signup.jsp"><button>회원가입</button></a> 
	
	<%
		session.setAttribute("idcheck", null);
		session.setAttribute("length", null);
		session.setAttribute("blank", null);
		boolean login = false;
		ArrayList<Board> blist = BoardDao.boardDao.getboard();
		String loginid =(String)session.getAttribute("loginid");
		if(loginid != null){ login=true; // 로그인 성공시  %>
		
		<div><%=loginid %>님 안녕하세요 ~</div>
		<a href="write.jsp"><button>글쓰기</button></a>
		<a href="logout.jsp"><button>로그아웃</button></a>
		<a href="deletecontroller.jsp"><button>회원탈퇴</button></a>
	<% 	}%>
	
	
	<form action="logincontroller.jsp" method="post" <%if(login) {%>
	hidden=""
	<%} %>
	>
		<input type="text" name="id" placeholder="아이디">
		<input type="password" name="password" placeholder="비밀번호">
		<input type="submit" value="로그인">
	</form>

	
	<table>
		<tr>
			<th>번호</th> <th>제목</th> <th>내용</th> <th>작성일</th> <th>작성자</th>
		</tr>
		
		<!-- 반복문 -->
		<% for(Board temp : blist) {%>
		<tr>
			<td><%=temp.getBnum() %></td> 
			<td><a href="view.jsp?bnum=<%=temp.getBnum()%>"><%=temp.getBtitle() %></a></td> 
			<td><%=temp.getBcontent() %></td> <td><%=temp.getBdate() %></td> <td><%=temp.getBwriter() %></td>
		</tr>
		<%} %>
		
	</table>

</body>
</html>