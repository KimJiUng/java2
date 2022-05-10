package controller.board;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import dao.ReplyDao;
import dto.Reply;

/**
 * Servlet implementation class Replyupdate
 */
@WebServlet("/board/Replyupdate")
public class Replyupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Replyupdate() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Instant now = Instant.now();
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();

			if(session.getAttribute("loginid")==null) {
				response.getWriter().print(4);
				return;
			}else {
				if(request.getParameter("reupdatecontent").equals("")) {
					response.getWriter().print(3);
					return;
				}else {
					int rnum = Integer.parseInt(request.getParameter("rnum"));
					String reupdatecontent = request.getParameter("reupdatecontent");
					String loginid = (String)session.getAttribute("loginid");
					int mnum = MemberDao.memberDao.getmember(loginid).getMnum();
					ArrayList<Reply> midreplylist = ReplyDao.replyDao.getmidreply(mnum);
					for(Reply temp : midreplylist) {
						Date writetime = format.parse(temp.getRdate());
						if(Math.abs(writetime.toInstant().until(now, ChronoUnit.SECONDS))<10) {
							System.out.println(Math.abs(writetime.toInstant().until(now, ChronoUnit.SECONDS)));
							response.getWriter().print(5);
							return;
						}
					}
					boolean result = ReplyDao.replyDao.reupdate(reupdatecontent,rnum);
					if(result) {
						response.getWriter().print(1);
					}else {
						response.getWriter().print(2);
					}
				}
				
			}
		} catch(Exception e) {}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
