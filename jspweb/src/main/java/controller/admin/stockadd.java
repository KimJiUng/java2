package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import dto.Stock;

/**
 * Servlet implementation class stockadd
 */
@WebServlet("/admin/stockadd")
public class stockadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public stockadd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int pnum = Integer.parseInt(request.getParameter("pnum"));
		String scolor = request.getParameter("scolor");
		String ssize = request.getParameter("ssize");
		int samount = Integer.parseInt(request.getParameter("samount"));
		ArrayList<Stock> slist = ProductDao.productDao.getstocklist(pnum);
		for(Stock stock : slist) {
			if(stock.getScolor().equals(scolor) && stock.getSsize().equals(ssize)) {
				response.getWriter().print(2);
				return;
			}
		}
		boolean result = ProductDao.productDao.ssave(pnum, scolor, ssize, samount);
		if(result) {
			response.getWriter().print(1);
		}else {
			response.getWriter().print(3);
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
