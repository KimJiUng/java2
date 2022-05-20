package controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import dao.ProductDao;
import dto.Cart;
import dto.Product;
import dto.Stock;
import dto.Wishlist;

/**
 * Servlet implementation class cartadd
 */
@WebServlet("/product/cartadd")
public class cartadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cartadd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String mid = request.getParameter("mid");
		int mnum = MemberDao.memberDao.getmember(mid).getMnum();
		int pnum = Integer.parseInt(request.getParameter("pnum"));
		int snum = Integer.parseInt(request.getParameter("snum"));
		int selectamount = Integer.parseInt(request.getParameter("samount"));
		boolean check = ProductDao.productDao.cartcheck(mnum, snum);
		if(check) {
			Stock stock = ProductDao.productDao.getstock(snum);
			if(stock.getSamount()==0) {
				response.getWriter().print(0);
				return;
			}
			Cart cart = new Cart(0, pnum, mnum, snum, selectamount);
			boolean result = ProductDao.productDao.cartadd(cart);
			System.out.println(result);
			if(result) {
				response.getWriter().print(1);
			}else {
				response.getWriter().print(2);
			}
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
