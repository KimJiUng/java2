package controller.board;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class Rereplywrite
 */
@WebServlet("/board/Rereplywrite")
public class Rereplywrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Rereplywrite() {
        super();

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
				if(request.getParameter("rercontent").equals("")) {
					response.getWriter().print(3);
					return;
				}else {
					int rindex = Integer.parseInt(request.getParameter("rnum"));
					int bnum = Integer.parseInt(request.getParameter("bnum"));
					String rercontent = request.getParameter("rercontent");
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
					Reply reply = new Reply(0, bnum, mnum, rercontent, null, rindex, loginid);
					boolean result = ReplyDao.replyDao.replywrite(reply);
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
