<%@page import="dto.Member"%>
<%@page import="dao.MemberDao"%>
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
		<div class="row">
			<div class="col-md-3">
				<%@include file="infosidebar.jsp" %>
			</div>
			<div class="col-md-9">
				<div class="col-md-4 offset-2">
					<div class="text-center">
						<h3>회원정보</h3>
					</div>
					<%
						// 1. 세션 호출 [회원id 저장]
						String mid = (String)session.getAttribute("loginid");
						// 2. DB 메소드 호출
						Member member = MemberDao.memberDao.getmember(mid);
						// 3. HTML에 객체 표현식
					%>
					<div class="my-3">회원번호 : <%=member.getMnum() %></div>
					<div class="my-3">아이디 : <%=member.getMid() %></div>
					<div class="my-3">이름 : <%=member.getMname() %></div>
					<div class="my-3">전화번호 : <%=member.getMphone() %></div>
					<div class="my-3">이메일 : <%=member.getMemail() %></div>
					<div class="my-3">주소 : <%=member.getMaddress() %></div>
					<div class="my-3">포인트 : <%=member.getMpoint() %></div>
					<div class="my-3">가입날짜 : <%=member.getMsince() %></div>
				</div>
			</div>
		</div>
	</div>
	<%} %>
	<%@include file="../footer.jsp" %>
</body>
</html>