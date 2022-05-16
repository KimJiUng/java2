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
import dto.Product;
import dto.Stock;

/**
 * Servlet implementation class getstock
 */
@WebServlet("/admin/getstock")
public class getstock extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getstock() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pnum = Integer.parseInt(request.getParameter("pnum"));
		String field = request.getParameter("field");
		Product product = ProductDao.productDao.getproduct(pnum);
		ArrayList<Stock> slist = ProductDao.productDao.getstocklist(pnum);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String html = ""; // 응답할 문자열
		html += "<h4>"+product.getPname()+"</h4>";
		html += "<table class=\"table\"><tr><th>색상</th><th>사이즈</th><th>수량</th><th>등록일</th><th>수정일</th></tr>";
		if(field!=null && field.equals("update")) {
			if(slist.isEmpty()) {
				html += "<td colspan=\"5\">등록된 재고 없음</td>";
			}else {
				for(Stock temp : slist) {
					html += "<tr><td>"+temp.getScolor()+"</td><td>"+temp.getSsize()+"</td><td>"+temp.getSamount()+"</td><td>"+temp.getSfirstdate()+"</td><td>"+temp.getSupdatedate()+"</td><td><button onclick=\"showupdate('"+temp.getSnum()+"','"+temp.getScolor()+"','"+temp.getSsize()+"','"+temp.getSamount()+"')\">수정</button></td><td><button>삭제</button></td></tr>";
				}
			}
		}else {
			if(slist.isEmpty()) {
				html += "<td colspan=\"5\">등록된 재고 없음</td>";
			}else {
				for(Stock temp : slist) {
					html += "<tr><td>"+temp.getScolor()+"</td><td>"+temp.getSsize()+"</td><td>"+temp.getSamount()+"</td><td>"+temp.getSfirstdate()+"</td><td>"+temp.getSupdatedate()+"</td></tr>";
				}
			}
		}
		html += "</table>";
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
