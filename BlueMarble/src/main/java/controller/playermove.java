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
 * Servlet implementation class playermove
 */
@WebServlet("/playermove")
public class playermove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public playermove() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int playernum = Integer.parseInt(request.getParameter("playernum"));
		int sum = Integer.parseInt(request.getParameter("sum"));
		int gamenum = Integer.parseInt(request.getParameter("gamenum"));
		int currentlocation = 0;
		ArrayList<플레이어> plist = 플레이어Dao.플레이어Dao.getplayers(gamenum);
		for(플레이어 temp : plist) {
			if(temp.get플레이어번호()==playernum) {
				currentlocation = temp.get현재위치();
			}
		}
		
		boolean result = 플레이어Dao.플레이어Dao.moveplayer(playernum, currentlocation, sum);
		if(result) {
			플레이어 player = 플레이어Dao.플레이어Dao.getplayer(playernum);
			response.getWriter().print(player.get현재위치());
		}else {
			response.getWriter().print(0);
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
