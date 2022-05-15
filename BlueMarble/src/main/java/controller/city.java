package controller;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.건물Dao;
import dto.건물;

/**
 * Servlet implementation class city
 */
@WebServlet("/city")
public class city extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public city() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int playernum = Integer.parseInt(request.getParameter("playernum"));
		int location = Integer.parseInt(request.getParameter("location"));
		int gamenum = Integer.parseInt(request.getParameter("gamenum"));
		건물 building = 건물Dao.건물Dao.getbuilding(location, gamenum);
		if(building==null) {
			String city = 건물Dao.건물Dao.도시정보출력(location).get도시이름();
			if(city.equals("황금열쇠")) {
				response.getWriter().print(3); return;
			}else if(city.equals("무인도")) {
				response.getWriter().print(4); return;
			}else if(city.equals("우주여행")) {
				response.getWriter().print(5); return;
			}else if(city.equals("사회복지기금수령처")) {
				response.getWriter().print(6); return;
			}else if(city.equals("사회복지기금 접수처")) {
				response.getWriter().print(7); return;
			}else if(city.equals("출발")) {
				response.getWriter().print(8); return;
			}
			response.getWriter().print(1); return;
		}else {
			if(building.get플레이어번호()!=playernum) {
				int pay = 건물Dao.건물Dao.통행료출력(location);
				response.getWriter().print(pay); return;
				
			}else {
				response.getWriter().print(2); return;
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
