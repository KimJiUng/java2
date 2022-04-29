<%@page import="Dao.BoardDao"%>
<%@page import="Dao.MemberDao"%>
<%@page import="Dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   <%
   		// 컨트롤 페이지로 사용
   		
   		// request : 요청 [서버 --> 클라이언트]
   			// 요청시 사용되는 한글 인코딩 변환[설정]
   		request.setCharacterEncoding("UTF-8");
   		String id = request.getParameter("id");
	   	String password = request.getParameter("password");
	   	String name = request.getParameter("name");
	   	
	 	// 변수 3개 -> 객체화(dto)
	   	Member member = new Member(0, id, password, name);
	   	
	   	// 객체(dto) -> dao(DB)
	   	
	   	if(request.getParameter("id").isEmpty() || request.getParameter("password").isEmpty() || request.getParameter("name").isEmpty()){
	   		response.sendRedirect("signup.jsp");
	   		session.setAttribute("blank", "true");
	   		session.setAttribute("idcheck", null);
			session.setAttribute("length", null);
	   	}else{
	   		if(id.length()<1 || id.length()>10 || password.length()<1 || password.length()>10 || name.length()<1 || name.length()>10 ){
		   		response.sendRedirect("signup.jsp");
		   		session.setAttribute("length", "true");
		   		session.setAttribute("idcheck", null);
				session.setAttribute("blank", null);
		   	}else{
		   		boolean result = MemberDao.memberDao.idcheck(id);
			   	if(result){
			   		response.sendRedirect("signup.jsp");
			   		session.setAttribute("idcheck", "true");
					session.setAttribute("length", null);
					session.setAttribute("blank", null);
			   	}else{
			   		boolean result2 = MemberDao.memberDao.signup(member);
				   	if(result2){
				   		response.sendRedirect("main.jsp");
				   		session.setAttribute("length", null);
				   		session.setAttribute("idcheck", null);
						session.setAttribute("blank", null);
				   		// response.sendRedirect("이동할 페이지")
				   	}	
			   	}
		   	}
	   	}
	   	
	   	
	   	
	   	
   %>