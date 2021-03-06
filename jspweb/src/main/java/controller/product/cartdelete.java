package controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import dao.ProductDao;

/**
 * Servlet implementation class cartdelete
 */
@WebServlet("/product/cartdelete")
public class cartdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cartdelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cart_num = Integer.parseInt(request.getParameter("cart_num"));
		if(cart_num==0) {
			String mid = request.getParameter("mid");
			int mnum = MemberDao.memberDao.getmember(mid).getMnum();
			boolean result2 =ProductDao.productDao.cartdeleteall(mnum);
			if(result2) {
				response.getWriter().print(3);
			}else {
				response.getWriter().print(4);
			}
		}else {
			boolean result = ProductDao.productDao.cartdelete(cart_num);
			if(result) {
				response.getWriter().print(1);
			}else {
				response.getWriter().print(2);
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
