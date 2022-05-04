package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;

@WebServlet("/Passwordcheck")
public class Passwordcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Passwordcheck() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 통신된 페이지에게 변수의 데이터를 요청한다.
		String mid = request.getParameter("mid");
		String mpassword = request.getParameter("mpassword");
		// 2. 객체화 [ 변수가 많을 경우 ]
		// 3. DB 처리
		int result = MemberDao.memberDao.login(mid, mpassword);
		// 4. 결과
		if(result==1) {
			// 5. 통신된 페이지로 데이터 응답하기
			response.getWriter().print(1);
		}else {
			response.getWriter().print(2);
		}
		
		doGet(request, response);
	}

}
