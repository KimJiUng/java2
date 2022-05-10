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
 * Servlet implementation class Replywrite
 */
@WebServlet("/board/Replywrite")
public class Replywrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Replywrite() {
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
				if(request.getParameter("rcontent").equals("")) {
					response.getWriter().print(3);
					return;
				}else {
					int bnum = Integer.parseInt(request.getParameter("bnum"));
					String rcontent = request.getParameter("rcontent");
					if(rcontent.contains("<script>")) {
						response.getWriter().print(6);
						return;
					}
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
					Reply reply = new Reply(0, bnum, mnum, rcontent, null, 0, loginid);
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

		doGet(request, response);
	}

}
