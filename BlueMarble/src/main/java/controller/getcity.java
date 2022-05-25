package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.건물Dao;
import dao.플레이어Dao;
import dto.게임판;

/**
 * Servlet implementation class getcity
 */
@WebServlet("/getcity")
public class getcity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getcity() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DecimalFormat decimalFormat = new DecimalFormat("#,###원"); 
		response.setCharacterEncoding("UTF-8");
		int playernum = Integer.parseInt(request.getParameter("playernum"));
		int location = 플레이어Dao.플레이어Dao.getplayer(playernum).get현재위치();
		게임판 building = 건물Dao.건물Dao.도시정보출력(location);
		PrintWriter out = response.getWriter();
		String html = ""; // 응답할 문자열
		if(location==5 || location==15 || location==25 || location==32 || location==39) {
			html = "<p>"+building.get도시이름()+"</p>"
					+ "<input type=\"radio\" id=\"buildingclass1\"> <span>가격 : "+decimalFormat.format(building.get빈땅가격())+"</span> <span>통행료 : "+decimalFormat.format(building.get빈땅통행료())+"</span><br>";
		}else {
			html = "<p>"+building.get도시이름()+"</p>"
					+"<input type=\"radio\" name=\"buildingclass\" value=\"1\" id=\"buildingclass1\">빈땅 <span>가격 : "+decimalFormat.format(building.get빈땅가격())+"</span> <span>통행료 : "+decimalFormat.format(building.get빈땅통행료())+"</span><br>"
					+ "<input type=\"radio\" name=\"buildingclass\" value=\"2\" id=\"buildingclass2\">별장 <span>가격 : "+decimalFormat.format(building.get별장가격())+"</span> <span>통행료 : "+decimalFormat.format(building.get별장통행료()) +"</span><br>"
					+ "<input type=\"radio\" name=\"buildingclass\" value=\"3\" id=\"buildingclass3\">빌딩 <span>가격 : "+decimalFormat.format(building.get빌딩가격())+"</span> <span>통행료 : "+decimalFormat.format(building.get빌딩통행료())+"</span><br>"
					+ "<input type=\"radio\" name=\"buildingclass\" value=\"4\" id=\"buildingclass4\">호텔 <span>가격 : "+decimalFormat.format(building.get호텔가격())+"</span> <span>통행료 : "+decimalFormat.format(building.get호텔통행료()) +"</span><br>";
		}
		out.print(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
