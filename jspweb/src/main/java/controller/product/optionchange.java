package controller.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import dao.ProductDao;
import dto.Stock;

/**
 * Servlet implementation class optionchange
 */
@WebServlet("/product/optionchange")
public class optionchange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public optionchange() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cart_num = Integer.parseInt(request.getParameter("cart_num"));
		int pnum = Integer.parseInt(request.getParameter("pnum"));
		String color = request.getParameter("color");
		String size = request.getParameter("size").split(",")[0];
		String mid = (String)request.getSession().getAttribute("loginid");
		int mnum = MemberDao.memberDao.getmember(mid).getMnum();
		ArrayList<Stock> slist = ProductDao.productDao.getstocklist(pnum);
		for(Stock stock : slist) {
			if(stock.getScolor().equals(color) && stock.getSsize().equals(size)) {
				if(stock.getSamount()==0) {
					response.getWriter().print(0);
					return;
				}
				boolean check = ProductDao.productDao.cartcheck(mnum, stock.getSnum());
				if(check) {
					boolean result = ProductDao.productDao.updateoptioncart(cart_num, stock.getSnum());
					if(result) {
						response.getWriter().print(1+","+stock.getSnum());
						return;
					}else {
						response.getWriter().print(2);
						return;
					}
				}else {
					response.getWriter().print(3);
				}
				
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
