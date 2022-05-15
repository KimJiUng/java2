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
 * Servlet implementation class turnend
 */
@WebServlet("/turnend")
public class turnend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public turnend() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("턴종룔ㄹ");
		int playernum = Integer.parseInt(request.getParameter("playernum"));
		int gamenum = Integer.parseInt(request.getParameter("gamenum"));
		ArrayList<플레이어> plist = 플레이어Dao.플레이어Dao.getplayers(gamenum);
		int order =0;
		for(플레이어 player : plist) {
			if(player.get플레이어번호()==playernum) {
				order = player.get순서();
				boolean result = 플레이어Dao.플레이어Dao.턴시작종료(playernum);
				if(result){
				}else {
					response.getWriter().print(2);
					return;
				}
			}
			
			
		}
		
		if(order==4) {
			for(플레이어 player : plist) {
				if(player.get순서()==1) {
					boolean result = 플레이어Dao.플레이어Dao.턴시작종료(player.get플레이어번호());
					if(result) {
					}else {
						response.getWriter().print(2);
						return;
					}
				}
				
			}
		}else {
			for(플레이어 player : plist) {
				if(player.get순서()==order+1) {
					boolean result = 플레이어Dao.플레이어Dao.턴시작종료(player.get플레이어번호());
					if(result) {
					}else {
						response.getWriter().print(2);
						return;
					}
				}
			}
		}
		response.getWriter().print(1);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
