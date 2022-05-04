package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import dto.Member;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("loginid");
		int mnum = Integer.parseInt(request.getParameter("mnum")); // 수정 식별 대상
		String mname = request.getParameter("mname");
		String mphone = request.getParameter("mphone");
		String memail = request.getParameter("memail");
		String memailaddress = request.getParameter("memailaddress");
			String email = memail + "@"+ memailaddress;
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String address3 = request.getParameter("address3");
		String address4 = request.getParameter("address4");
			String address = address1+"_"+address2+"_"+address3+"_"+address4;
		Member member = null;
		// 패스워드 체크 [유효성검사]
		String oldpassword = request.getParameter("oldpassword");
		String newpassword = request.getParameter("newpassword");
		if(oldpassword.equals("") || newpassword.equals("")) { // 패스워드 변경이 없을때
			// 객체화
			member = new Member(mnum, null, null, mname, mphone, email, address, 0, null);
			boolean result2 = MemberDao.memberDao.update(member);
			if(result2) {
				response.sendRedirect("/jspweb/member/update.jsp?result=1");
			}else {
				response.sendRedirect("/jspweb/member/update.jsp?result=2");
			}
		}else { // 패스워드 변경이 있을때
			// 기존 패스워드 체크
			int result = MemberDao.memberDao.login(mid,oldpassword);
			if(result==1) { // 기존 패스워드가 동일하면
				member = new Member(mnum, null, newpassword, mname, mphone, email, address, 0, null);
				boolean result2 = MemberDao.memberDao.update(member);
				if(result2) {
					response.sendRedirect("/jspweb/member/update.jsp?result=1");
				}else {
					response.sendRedirect("/jspweb/member/update.jsp?result=2");
				}
			}else { // 기존 패스워드가 동일하지 않으면
				response.sendRedirect("/jspweb/member/update.jsp?result=3");
			}
		}
		
			
		
		
	}

}
