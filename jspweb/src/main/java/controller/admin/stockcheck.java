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
 * Servlet implementation class stockcheck
 */
@WebServlet("/admin/stockcheck")
public class stockcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public stockcheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("삭제");
		int pnum = Integer.parseInt(request.getParameter("pnum"));
		String field = request.getParameter("field");
		ArrayList<Stock> slist = ProductDao.productDao.getstocklist(pnum);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String html = "";
		int samount =0;
		if(field!=null && field.equals("stockdelete")) {
			int snum = Integer.parseInt(request.getParameter("snum"));
			Stock stock = ProductDao.productDao.getstock(snum);
			if(stock.getSamount()==0) {
				html += "<span>정말 삭제하시겠습니까?</span>";
			}else {
				samount = stock.getSamount();
				html += "<span>해당 상품의 재고가 "+samount+"개 남아있습니다.<br> 정말 삭제하시겠습니까?</span>";
			}
		}else {
			for(Stock stock : slist) {
				samount += stock.getSamount();
			}
			if(samount==0) {
				html += "<span>정말 삭제하시겠습니까?</span>";
			}else {
				html += "<span>해당 상품의 재고가 "+samount+"개 남아있습니다.<br> 정말 삭제하시겠습니까?</span>";
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
