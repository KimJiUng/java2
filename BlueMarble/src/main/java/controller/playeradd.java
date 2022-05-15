package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.플레이어Dao;
import dto.플레이어;

/**
 * Servlet implementation class player
 */
@WebServlet("/playeradd")
public class playeradd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public playeradd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String nickname = request.getParameter("nickname");
		int gamenum = Integer.parseInt(request.getParameter("gamenum"));
		ArrayList<플레이어> plist = 플레이어Dao.플레이어Dao.getplayers(gamenum);
		if(plist.size()>3) {
			response.getWriter().print(2);
			return;
		}else {
			for(플레이어 temp : plist) {
				if(temp.get플레이어닉네임().equals(nickname)) {
					response.getWriter().print(3);
					return;
				}
			}
		}
		boolean result = 플레이어Dao.플레이어Dao.플레이어등록(nickname, gamenum);
		if(result) {
			ArrayList<플레이어> plist2 = 플레이어Dao.플레이어Dao.getplayers(gamenum);
			int playernum=0;
			for(플레이어 temp : plist2) {
				if(temp.get플레이어닉네임().equals(nickname)) {
					playernum = temp.get플레이어번호();
				}
			}
			boolean result2 =  플레이어Dao.플레이어Dao.순서정하기(plist2.size(), playernum);
			if(result2) {
				response.getWriter().print(1);
			}	
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
