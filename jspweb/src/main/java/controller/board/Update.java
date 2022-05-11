package controller.board;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BoardDao;
import dto.Board;


/**
 * Servlet implementation class Update
 */
@WebServlet(name = "Bupdate", urlPatterns = { "/board/Update" })
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");	// 응답 파일타입 = HTML
		PrintWriter out = response.getWriter();	// HTML 내보내기 메소드 사용
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
		
		String btitle = multi.getParameter("btitle");
		int bnum = Integer.parseInt(request.getParameter("bnum"));
		if(btitle.length()<1) {
			out.println("<script>");
			out.println("alert('제목을 입력해주세요.');");
			out.println("history.back();");	// js [history.back() : 이전 페이지로 가기 메소드 ]
			out.println("</script>");
			return;
		}
		if(btitle.contains("<script>")) {
			out.println("<script>");
			out.println("alert('제목에 스크립트 사용은 불가능합니다.');");
			out.println("history.back();");	// js [history.back() : 이전 페이지로 가기 메소드 ]
			out.println("</script>");
			return;
		}
		String bcontent = multi.getParameter("bcontent");
		if(bcontent.contains("window.alert")) {
			out.println("<script>");
			out.println("alert('테러하지 마세요.');");
			out.println("history.back();");	// js [history.back() : 이전 페이지로 가기 메소드 ]
			out.println("</script>");
			return;
		}
		String bfile = multi.getFilesystemName("bfile");
		
		// 기존 파일
		Board board2 = BoardDao.boardDao.getboard(bnum);
		String oldfile = board2.getBfile();
		if(bfile==null) { // 새로운 첨부파일이 없다.
			bfile = oldfile;
		}else { // 새로운 첨부파일이 있다.
			String fileuploadpath = request.getSession().getServletContext().getRealPath("/board/upload/"+oldfile);
			File file = new File(fileuploadpath);
			file.delete();	// 파일 삭제하기 (file 클래스내 제공되는 delete() 메소드 = 파일 삭제시 사용)
		}
		Board board = new Board(bnum, btitle, bcontent, 0, 0, null, bfile, null);
		boolean result = BoardDao.boardDao.update(board);
		if(result) {
			response.sendRedirect("/jspweb/board/boardview.jsp?bnum="+bnum);
		}else {
			response.sendRedirect("/jspweb/board/boardwrite.jsp?bnum="+bnum+"&update=1");
		}
		doGet(request, response);
	}

}
