package controller.product;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class wishlistadd
 */
@WebServlet("/product/wishlistadd")
public class wishlistadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public wishlistadd() {
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
		int snum =0;
		int selectamount =0;
		if(field==null) {
			snum = Integer.parseInt(request.getParameter("snum"));
			selectamount = Integer.parseInt(request.getParameter("samount"));
		}
		boolean check = ProductDao.productDao.wishlistcheck(mnum, snum,selectamount,pnum);
		if(check) {
			Wishlist wishlist = new Wishlist(0, pnum, mnum, snum, selectamount);
			boolean result = ProductDao.productDao.wishlistadd(wishlist);
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
