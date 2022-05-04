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
	
	<%
		// 1. 세션에 저장된 회원ID 출력
		String mid = (String)session.getAttribute("loginid");
		// 2. 회원정보 가져오기
		Member member = MemberDao.memberDao.getmember(mid);
	%>
	
	
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
					<%if(request.getParameter("result")!=null && request.getParameter("result").equals("1")){%>
						회원정보 수정이 완료되었습니다.	
					<%} else if(request.getParameter("result")!=null && request.getParameter("result").equals("2")){ %>
						회원정보수정 실패! 관리자에게 문의
					<%} else if(request.getParameter("result")!=null && request.getParameter("result").equals("3")){ %>
						비밀번호 수정 실패! 기존 비밀번호가 다릅니다.
					<%} %>
					<div class="text-center">
						<h3>회원수정</h3>
					</div>
					<form action="../Update" method="post">
						<input type="hidden" value="<%=member.getMnum()%>" name="mnum">
						<div class="my-3">아이디 : <%=member.getMid() %></div>
						<div class="my-3">비밀번호 : <button type="button" onclick="btnpasswordchange()">비밀번호 변경</button> </div>
							<div id="passwordbox" style="display: none;">
								<div class="row">
									<div class="col-md-4 py-1" id="signupfield">
										<p>기존 비밀번호</p>
									</div>
									<div class="col-md-8 py-1">
										<input type="password" name="oldpassword">
									</div>
									<div class="col-md-4 py-1" id="signupfield">
										<p>새로운 비밀번호</p>
									</div>
									<div class="col-md-8 py-1">
										<input type="password" name="newpassword">
									</div>
								</div>
							</div>
						
						<div class="row">
							<div class="col-md-3 py-1" id="signupfield">
								<p>이름</p>
							</div>
							<div class="col-md-9 py-1">
								<input type="text" class="form-control" name="mname" id="mname" value="<%=member.getMname() %>">
							</div>
							<div class="col-md-9 offset-3 py-1">
								<span class="signuptext" id="namecheck"></span>
							</div>
							
							<div class="col-md-3 py-1" id="signupfield">
								<p>전화번호</p>
							</div>
							<div class="col-md-9 py-1">
								<input type="text" class="form-control" name="mphone" id="mphone" value="<%=member.getMphone() %>">
							</div>
							<div class="col-md-9 offset-3 py-1">
								<span class="signuptext" id="phonecheck"></span>
							</div>
						
						
							<div class="col-md-3 py-1" id="signupfield">
								<p>이메일</p>
							</div>
							<div class="col-md-9 py-1">
								<input type="text" class="form-control" name="memail" id="memail" placeholder="이메일" value="<%=member.getMemail().split("@")[0]%>">
							</div>
							<div class="col-md-1 offset-3 py-1">
								<span>@</span>
							</div>
							<div class="col-md-4 py-1">
								<input type="text" class="form-control" name="memailaddress" id="memailaddress" value="<%=member.getMemail().split("@")[1]%>">
							</div>
							<div class="col-md-4 py-1">
								<select class="form-control" id="emailselect">
									<option value="">직접입력</option>
									<option value="naver.com">naver.com</option>
									<option value="nate.com">nate.com</option>
									<option value="daum.com">daum.com</option>
								</select>
							</div>
							<div class="col-md-9 offset-3 py-1">
								<span class="signuptext" id="emailcheck"></span>
							</div>
						
							<div class="col-md-3 py-1" id="signupfield">
								<p>주소</p>
							</div> 
							<div class="col-md-9 py-1">
								<div class="row">
									<div class="col-md-6">
										<input class="form-control" type="text" name="address1" id="sample4_postcode" placeholder="우편번호" value="<%=member.getMaddress().split("_")[0]%>">
									</div>
									<div class="col-md-6">
										<input class="form-control" type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기">
									</div>
								</div>
							</div>
							<div class="col-md-9 offset-3 py-1">
								<div class="row">
									<div class="col-md-6">
										<input class="form-control" type="text" name="address2" id="sample4_roadAddress" placeholder="도로명주소" value="<%=member.getMaddress().split("_")[1]%>">
									</div>
									<div class="col-md-6">
										<input class="form-control" type="text" name="address3" id="sample4_jibunAddress" placeholder="지번주소" value="<%=member.getMaddress().split("_")[2]%>">
										<span id="guide" style="color:#999;display:none"></span>
									</div>
								</div>
							</div>
							<div class="col-md-9 offset-3 py-1">
								<input class="form-control" type="text" name="address4" id="sample4_detailAddress" placeholder="상세주소" value="<%=member.getMaddress().split("_")[3] %>">
							</div>
							<div class="col-md-9 offset-3 py-1">
								<span class="signuptext" id="addresscheck"></span>
							</div>
						
						</div>
						<input class="btn btn-primary" type="submit" value="변경적용">
						<a href="/jspweb/member/update.jsp"><button class="btn btn-primary" type="button">변경취소</button></a>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%} %>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="/jspweb/js/signup.js" type="text/javascript"></script>
	<%@include file="../footer.jsp" %>
</body>
</html>