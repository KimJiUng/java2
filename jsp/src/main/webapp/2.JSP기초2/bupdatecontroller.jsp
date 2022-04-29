<%@page import="Dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
   		int bnum = (int)session.getAttribute("bnum");
    	String title = (String)request.getParameter("title");
    	String content = (String)request.getParameter("content");
    	
    	if(request.getParameter("title").isEmpty() || request.getParameter("content").isEmpty() ){
    		response.sendRedirect("write.jsp");
			session.setAttribute("blank", "true");
    	}else{
    		if(title.length()<1 || title.length()>100 || content.length()<1 || content.length()>1000){
    			response.sendRedirect("write.jsp");
    			session.setAttribute("blank", null);
    			session.setAttribute("length", "a");
    		}else{
    			boolean result = BoardDao.boardDao.update(title, content, bnum);
    	    	if(result){
    	    		response.sendRedirect("main.jsp");
    	    		session.setAttribute("bnum", null);
    	    		System.out.print("수정성공");
    	    	}else{
    	    		response.sendRedirect("main.jsp");
    	    		System.out.print("수정실패");
    	    	}
    		}
    	}
    	
    %>