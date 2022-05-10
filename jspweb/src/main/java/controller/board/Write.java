package controller.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
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
		try {

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Instant now = Instant.now();
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
		
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("loginid");
		Member member = MemberDao.memberDao.getmember(mid);
		String btitle = multi.getParameter("btitle");
		if(btitle.length()<1) {
			out.println("<script>");
			out.println("alert('제목을 입력해주세요.');");
			out.println("history.back();");	// js [history.back() : 이전 페이지로 가기 메소드 ]
			out.println("</script>");
			return;
		}
		if(btitle.contains("<script>")) {
			out.println("<script>");
			out.println("alert('테러하지 마세요.');");
			out.println("history.back();");	// js [history.back() : 이전 페이지로 가기 메소드 ]
			out.println("</script>");
			return;
		}
		String bcontent = multi.getParameter("bcontent");
		String bfile = multi.getFilesystemName("bfile");
		int mnum = member.getMnum();
		Board board = new Board(0, btitle, bcontent, mnum, 0, null, bfile, mid);
		ArrayList<Board> blist = BoardDao.boardDao.getboardlist();
		for(Board temp : blist) {
			if(temp.getMid()!=null && temp.getMid().equals(mid)) {
				Date writetime = format.parse(temp.getBdate());
				if(Math.abs(writetime.toInstant().until(now, ChronoUnit.MINUTES))<5) {
					System.out.println(Math.abs(writetime.toInstant().until(now, ChronoUnit.MINUTES)));
					out.println("<script>");
					out.println("alert('5분안에 새로운 글 작성은 불가능합니다.');");
					out.println("history.back();");
					out.println("</script>");
					return;
				}
			}
		}
	
		
		boolean result = BoardDao.boardDao.write(board);
		if(result) {
			response.sendRedirect("/jspweb/board/boardlist.jsp");
		}else {
			response.sendRedirect("/jspweb/board/boardwrite.jsp?result=2");
		}
		doGet(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
