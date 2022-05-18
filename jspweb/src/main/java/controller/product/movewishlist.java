package controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import dao.ProductDao;
import dto.Product;
import dto.Stock;
import dto.Wishlist;

/**
 * Servlet implementation class movewishlist
 */
@WebServlet("/product/movewishlist")
public class movewishlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public movewishlist() {
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
		String field = request.getParameter("field");

		float saverate = 1;
		Product product = ProductDao.productDao.getproduct(pnum);
		int price =(int)(product.getPprice()*(100-product.getPdiscount() ) )/100;
		int savemoney = (int)Math.ceil((price*saverate/100)/10)*10;
		Wishlist wishlist = new Wishlist(0, pnum, mnum, scolor, ssize, selectamount, price, savemoney);
		boolean result = ProductDao.productDao.wishlistadd(wishlist);
		if(result) {
			response.getWriter().print(1);
		}else {
			response.getWriter().print(2);
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