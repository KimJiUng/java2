package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import dto.Stock;

/**
 * Servlet implementation class selectsize
 */
@WebServlet("/admin/selectsize")
public class selectsize extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectsize() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String size = request.getParameter("size");
		int pnum = Integer.parseInt(request.getParameter("pnum"));
		String color = request.getParameter("color");
		ArrayList<Stock> slist = ProductDao.productDao.getstocklist(pnum);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String html = ""; 
		for(Stock stock : slist) {
			if(stock.getSsize().equals(size) && stock.getScolor().equals(color)) {
				if(stock.getSamount()==0) {
					html += "a,"+stock.getSupdatedate();
				}else {
					html += stock.getSamount()+","+stock.getSupdatedate();
				}
				
			}
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
