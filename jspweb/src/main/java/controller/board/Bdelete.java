package controller.board;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dto.Board;

/**
 * Servlet implementation class Bdelete
 */
@WebServlet("/board/Bdelete")
public class Bdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bdelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bnum = Integer.parseInt(request.getParameter("bnum")); 
		Board board = BoardDao.boardDao.getboard(bnum);
		boolean result = BoardDao.boardDao.delete(bnum);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");	// 응답 파일타입 = HTML
		PrintWriter out = response.getWriter();	// HTML 내보내기 메소드 사용
		if(result) {
			System.out.println("fdafdsfdsa");
			String bfile = board.getBfile();
			if(bfile==null) {
				
			}else {
				
				// 삭제 성공시 해당 파일도 서버에서 지우기
				String uploadpath = request.getSession().getServletContext().getRealPath("/board/upload/"+bfile);
				File file = new File(uploadpath);
				file.delete();	// 파일 삭제하기 (file 클래스내 제공되는 delete() 메소드 = 파일 삭제시 사용)
				// 1. HTML 내보내기
//				out.println("<html>");
//				out.println("<body>");
//				out.println("</body>");
//				out.println("</html>");
					
			}
			// 2. JS 내보내기
			out.println("<script>");
			out.println("alert('해당 게시물이 삭제 되었습니다.');");
			out.println("location.href='boardlist.jsp'");
			out.println("</script>");	
	

		}else {
			out.println("<script>");
			out.println("alert('해당 게시물 삭제 실패했습니다. [관리자에게 문의]');");
			out.println("history.back();");	// js [history.back() : 이전 페이지로 가기 메소드 ]
			out.println("</script>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
