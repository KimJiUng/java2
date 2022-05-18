package controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDao;
import dto.Product;
import dto.Stock;

/**
 * Servlet implementation class selectoption
 */
@WebServlet("/product/selectoption")
public class selectoption extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectoption() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pnum = Integer.parseInt(request.getParameter("pnum"));
		int snum = Integer.parseInt(request.getParameter("snum"));
		String color = request.getParameter("color");
		String size = request.getParameter("size");
		DecimalFormat decimalFormat = new DecimalFormat("#,###원");
		Product product = ProductDao.productDao.getproduct(pnum);
		ArrayList<Stock> slist = ProductDao.productDao.getstocklist(pnum);
		response.setCharacterEncoding("UTF-8");
		float saverate = 1;
		PrintWriter out = response.getWriter();
		String html = "";	

		int realprice=(int)(product.getPprice()*(100-product.getPdiscount() ) )/100;
		int savemoney = (int)Math.ceil((realprice*saverate/100)/10)*10; 
		for(Stock stock : slist) {
			if(stock.getScolor().equals(color) && stock.getSsize().equals(size)) {
				if(stock.getSamount()==0) {
					response.getWriter().print(0);
					return;
				}
				html += 
						"<tr><td style=\"font-size: 13px;\">"+product.getPname()+"<br><span class=\"sizecolor\">- 색상 : "+stock.getScolor()+" / 사이즈 : "+size+"</span></td>"
						+ "<input type=\"hidden\" id=\""+snum+"\" value=\""+snum+"\">"
						+ "<td><div class=\"row g-0\">"
						+ "<div class=\"col-md-7\">"
						+ "<input style=\"background-color: white;\" readonly=\"readonly\" id=\"samount"+snum+"\" value=\"1\" type=\"text\" class=\"form-control fc amount_input\" >"
						+ "</div>"
						+ "<div class=\"col-md-4\">"
						+ "<button onclick=\"amountup("+snum+")\" class=\"amount_btn\">▲</button>"
						+ "<button onclick=\"amountdown("+snum+")\" class=\"amount_btn\">▼</button>"
						+ "</div>"
						+ "<div class=\"col-md-1\">"
						+ "<button onclick=\"cancel("+snum+")\" class=\"cansel_btn\">X</button>\r\n"
						+ "</div>"
						+ "</div>"
						+ "</td>"
						+ "<td style=\"font-size: 13px;\">"+decimalFormat.format( (product.getPprice()*(100-product.getPdiscount() ) )/100)
						+ "<br>(<span id=\"savepoint\">적</span>"+decimalFormat.format(savemoney)+")</td>"
						+ "</tr>";
				
			}
		}
		out.print(html+"@@"+snum+"@@"+realprice+"@@"+savemoney);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
