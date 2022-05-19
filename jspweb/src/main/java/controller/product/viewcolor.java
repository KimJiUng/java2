package controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import dto.Stock;

/**
 * Servlet implementation class viewcolor
 */
@WebServlet("/product/viewcolor")
public class viewcolor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewcolor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		int pnum = Integer.parseInt(request.getParameter("pnum"));
		ArrayList<Stock> slist = ProductDao.productDao.getstocklist(pnum);
		Set<String> color = new TreeSet<>();
		for(Stock stock : slist) {
			color.add(stock.getScolor()); 
		}
		PrintWriter out = response.getWriter();
		String html = "";
		html += "<option class=\"info_t\">- [필수] 옵션 선택 -</option>";
		for(String temp : color) {
			html += "<option value=\""+temp+"\" class=\"info_t\">"+temp+"</option>";		
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
