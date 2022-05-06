package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BoardDao;
import dao.MemberDao;
import dto.Board;
import dto.Member;

/**
 * Servlet implementation class Write
 */
@WebServlet("/board/Write")
public class Write extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Write() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 저장 경로 [ \ : 제어문자 -> 경로 사용시 \\ , / ]
			// 1. 개발중인 프로젝트 경로
			// String uploadpath = "C:\\Users\\504\\git\\java2\\jspweb\\src\\main\\webapp\\board\\upload";
			// 2. 서버 폴더 경로
				// 서버 경로 찾기 : request.getSession().getServletContext().getRealPath("경로");
			String uploadpath = request.getSession().getServletContext().getRealPath("/board/upload");
			
		// 첨부파일 업로드
		MultipartRequest multi = new MultipartRequest(
				request,		// 요청 방식
				uploadpath, 	// 파일 저장 경로
				1024*1024*10, 	// 파일 최대 용량 허용 범위
				"UTF-8", 		// 인코딩타입
				new DefaultFileRenamePolicy() );	// 동일한 파일명이 있을경우 자동 이름 변환
		
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("loginid");
		Member member = MemberDao.memberDao.getmember(mid);
		String btitle = multi.getParameter("btitle");
		String bcontent = multi.getParameter("bcontent");
		String bfile = multi.getFilesystemName("bfile");
		int mnum = member.getMnum();
		Board board = new Board(0, btitle, bcontent, mnum, 0, null, bfile, mid);
		boolean result = BoardDao.boardDao.write(board);
		if(result) {
			response.sendRedirect("/jspweb/board/boardlist.jsp");
		}else {
			response.sendRedirect("/jspweb/board/boardwrite.jsp?result=2");
		}
		doGet(request, response);
	}

}
