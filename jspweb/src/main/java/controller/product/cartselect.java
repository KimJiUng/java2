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
import dto.Cart;
import dto.Product;

/**
 * Servlet implementation class cartselect
 */
@WebServlet("/product/cartselect")
public class cartselect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cartselect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid = request.getParameter("mid");
		if(mid.equals("0")) {
			int cart_num = Integer.parseInt(request.getParameter("cart_num"));
			Cart cart = ProductDao.productDao.getcart1(cart_num);
			float saverate = 1;
			Product product = ProductDao.productDao.getproduct(cart.getPnum());
			int price =(int)((product.getPprice()*(100-product.getPdiscount() ) )/100);
			int savemoney = (int)Math.ceil((price*saverate/100)/10)*10;
			int sumprice = price *cart.getCart_selectamount();
			int sumsavemoney = savemoney *cart.getCart_selectamount();
			response.getWriter().print(sumprice+","+sumsavemoney);
		}else {
			int mnum = MemberDao.memberDao.getmember(mid).getMnum();
			ArrayList<Cart> clist = ProductDao.productDao.getcart(mnum);
			int sumprice = 0;
			int sumsave = 0;
			float saverate = 1;
			if(clist.isEmpty()) {
				response.getWriter().print(0);
			}else {
				for(Cart cart : clist) {
					Product product = ProductDao.productDao.getproduct(cart.getPnum());
					int price =(int)(product.getPprice()*(100-product.getPdiscount() ) )/100;
					int savemoney = (int)Math.ceil((price*saverate/100)/10)*10;
					sumprice += cart.getCart_selectamount()*price;
					sumsave += cart.getCart_selectamount()*savemoney;
				}
				response.getWriter().print(sumprice+","+sumsave);
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
