<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<%
    
    request.setCharacterEncoding("UTF-8");
    String id = request.getParameter("mid");
   	String password = request.getParameter("mpassword");
   	System.out.println(id);
   	System.out.println(password);
   	boolean result = MemberDao.memberDao.login(id, password);
   	if(result){
   		response.sendRedirect("/jspweb/main.jsp");
   		session.setAttribute("loginid", id);
   		session.setAttribute("logincheck", null);
   		// 서블릿 내장객체 : session
   			// 서버내 필드생성 // 모든 페이지[파일]에서 접근할 수 있는 메모리
   			// 브라우저마다 메모리별도 생성
   	}else{
 		session.setAttribute("logincheck", "a");
 		response.sendRedirect("/jspweb/member/login.jsp");
   	}
    %>