package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;

/**
 * Servlet implementation class login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String mid = request.getParameter("mid");
		String mpassword = request.getParameter("mpassword");
		int result = MemberDao.memberDao.login(mid, mpassword);
		System.out.println("asd"+result);
		if (result==1) { // 로그인 성공
			// 로그인 성공시 세션 부여 [ 세션 : 서버에 메모리 할당 => 모든 페이지에서 동일한 메모리 사용 가능 ]
			HttpSession session = request.getSession(); // 1. Http 내장 세션 호출
			session.setAttribute("loginid", mid); 	// 2. 세션에 값 저장
			response.sendRedirect("/jspweb/main.jsp");
		}else if(result==2) {	// 아이디 혹은 비밀번호 다름
			response.sendRedirect("/jspweb/member/login.jsp?result=2");
		}else { // DB 오류
			response.sendRedirect("/jspweb/error.jsp");
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
