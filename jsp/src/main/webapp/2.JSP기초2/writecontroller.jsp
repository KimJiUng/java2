<%@page import="Dao.BoardDao"%>
<%@page import="Dto.Board"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	request.setCharacterEncoding("UTF-8");
    	String title = request.getParameter("title");
    	String content = request.getParameter("content");
    	String writer = (String)session.getAttribute("loginid");
    	Date now = new Date();
    	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    	String date = sf.format(now);
    		// 작성자는 로그인 성공시 세션에서 가져오기
    		// 세션 호출시 기본자료형이 object -> 형변환
    	Board board = new Board(0,title,content,writer,date);
    	String time = (String)session.getAttribute("time");
    	boolean pass = false;
    	if(request.getParameter("title").isEmpty() || request.getParameter("content").isEmpty() ){
    		response.sendRedirect("write.jsp");
			session.setAttribute("blank", "true");
    	}else{
    		if(title.length()<1 || title.length()>100 || content.length()<1 || content.length()>1000){
    			response.sendRedirect("write.jsp");
    			session.setAttribute("blank", null);
    			session.setAttribute("length", "a");
    			
    		}else{
    			if(session.getAttribute("time")!=null){
            		int wm = Integer.parseInt(time.split(" ")[1].split(":")[1]);
                	int pm = Integer.parseInt(date.split(" ")[1].split(":")[1]);
                	if(pm>=wm){
                		if((pm-wm)<5){
                			response.sendRedirect("write.jsp");
                			session.setAttribute("timecheck", "a");
                			session.setAttribute("blank", null);
                			System.out.print("5분");
                		}else{
                			pass = true;
                		}
                	}else if(pm<wm){
                		if((wm-pm)>55){
                			response.sendRedirect("write.jsp");
                			session.setAttribute("timecheck", "a");
                			session.setAttribute("blank", null);
                			System.out.print("5분");
                		}else{
                			pass = true;
                		}
                	}
            	}else{
            		pass = true;
            	}
    		}
    	}
    	if(pass){
    		boolean result = BoardDao.boardDao.write(board);
        	if(result){
        		response.sendRedirect("main.jsp");
        		session.setAttribute("time", date);
        		session.setAttribute("blank", null);
        		session.setAttribute("timecheck", null);
        		System.out.print("글작성완료");
        	}	
    	}
    	
    	
    	
    	
    		
    %>