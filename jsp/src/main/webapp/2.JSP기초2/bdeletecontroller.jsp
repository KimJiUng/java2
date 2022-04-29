<%@page import="Dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	int bnum = Integer.parseInt(request.getParameter("bnum"));
    	boolean result = BoardDao.boardDao.delete(bnum);
    	if(result){
    		response.sendRedirect("main.jsp");
    		session.setAttribute("bnum", null);
    	}else{
    		response.sendRedirect("main.jsp");
    	}
    %>