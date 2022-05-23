package controller.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dao.MemberDao;
import dao.ProductDao;
import dto.Cart;
import dto.Order;
import dto.Orderdetail;
import dto.Product;
import dto.Stock;

/**
 * Servlet implementation class saveorder
 */
@WebServlet("/product/saveorder")
public class saveorder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public saveorder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid = (String)request.getSession().getAttribute("loginid");
		int mnum = MemberDao.memberDao.getmember(mid).getMnum();
		
		String json = request.getParameter("orderjson");	// json 객체 형변환
		// json 객체내 key 이용한 value 호출
		try {
		JSONObject jsonObject = new JSONObject(json);
		String ordername = jsonObject.getString("ordername");
		String orderphone = jsonObject.getString("orderphone");
		String orderaddress = jsonObject.getString("orderaddress");
		int ordertotalpay = jsonObject.getInt("ordertotalpay");
		int mpoint = jsonObject.getInt("mpoint");
		String orderrequest = jsonObject.getString("orderrequest");
		String cartnum_list = jsonObject.getString("cartnum_list");
		int csize = Integer.parseInt(cartnum_list.split("@@")[1]);
		String cnumlist = cartnum_list.split("@@")[0];
		ArrayList<Integer> cart_numlist = new ArrayList<>();
		for(int i=0; i<csize; i++){
			cart_numlist.add(Integer.parseInt(cnumlist.split(",")[i]));
		}
		
		
		Order order = new Order(0, null, ordername, orderphone, orderaddress, ordertotalpay, 0, orderrequest, 0, mnum);
		int result = ProductDao.productDao.saveorder(order);
		if(result!=0) {
			boolean check = true;
			int sumsavemoney = 0;
			for(int cartnum : cart_numlist) {
				Cart cart = ProductDao.productDao.getcart1(cartnum);
				Stock stock =  ProductDao.productDao.getstock(cart.getSnum());
				Product product = ProductDao.productDao.getproduct(cart.getPnum());
				int ordernum = result;
				int samount = cart.getCart_selectamount();
				String pname = product.getPname();
				float pdiscount = product.getPdiscount();
				int pprice = product.getPprice();
				String scolor = stock.getScolor();
				String ssize = stock.getSsize();
				int price =(int)(product.getPprice()*(100-product.getPdiscount() ) )/100;				 
				int totalprice = price * samount;
				float saverate = 1;
				int savemoney = (int)Math.ceil((price*saverate/100)/10)*10;
				sumsavemoney += savemoney;
				Orderdetail orderdetail = new Orderdetail(0, 0, scolor, ssize, pname, pprice, pdiscount, samount, totalprice, ordernum);
				boolean result2 = ProductDao.productDao.saveorderdetail(orderdetail);
				if(result2) {
					boolean result3 = ProductDao.productDao.cartdelete(cartnum);
					if(result3) {
						
					}else {
						check= false;
					}
				}else {
					check= false;
				}
			}
			if(check) {
				response.getWriter().print(1);
			}else {
				response.getWriter().print(2);
			}
		}else {
			
		}
		
		}catch(Exception e) {System.out.println(e);}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
