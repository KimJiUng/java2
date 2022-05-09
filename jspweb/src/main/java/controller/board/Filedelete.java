package controller.board;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;

/**
 * Servlet implementation class Filedelete
 */
@WebServlet("/board/Filedelete")
public class Filedelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Filedelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 게시물번호 요청
		int bnum = Integer.parseInt(request.getParameter("bnum"));
		String bfile = BoardDao.boardDao.getboard(bnum).getBfile();
		// 2. [DB변경] 해당 게시물 번호의 게시물 첨부파일 필드를 null로 변경
		boolean result = BoardDao.boardDao.filedelete(bnum);
		// 3. [파일삭제] 서버내 첨부파일은 삭제
		if(result) {
			File file = new File(request.getSession().getServletContext().getRealPath("/board/upload/"+bfile));
			file.delete();
			// js 에게 응답하기
			response.getWriter().print(1);
		}else {
			response.getWriter().print(2);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
