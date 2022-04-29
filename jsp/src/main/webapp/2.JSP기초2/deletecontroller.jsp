<%@page import="Dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	String id = (String)session.getAttribute("loginid");
    	boolean result = MemberDao.memberDao.delete(id);
    	if(result){
    		response.sendRedirect("main.jsp");
       		session.setAttribute("loginid", null);
    	}else{
       		response.sendRedirect("main.jsp");
       	}
    
    %>