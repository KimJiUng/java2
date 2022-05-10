package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReplyDao;

/**
 * Servlet implementation class Replydelete
 */
@WebServlet("/board/Replydelete")
public class Replydelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Replydelete() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rnum = Integer.parseInt(request.getParameter("rnum"));
		int rindex = Integer.parseInt(request.getParameter("rindex"));
		boolean result = ReplyDao.replyDao.redelete(rnum,rindex);
		if(result) {
			response.getWriter().print(1);
		}else {
			response.getWriter().print(2);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
