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
import dto.Category;
import dto.Product;

/**
 * Servlet implementation class getproduct
 */
@WebServlet("/admin/getproduct")
public class getproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getproduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String field = request.getParameter("field");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String html = ""; // 응답할 문자열
		if(field!=null && field.equals("update")) {
			int pnum = Integer.parseInt(request.getParameter("pnum"));
			Product product = ProductDao.productDao.getproduct(pnum);
			html += "이름 : "+product.getPname()+"가격 : "+product.getPprice()+"할인율 : "+product.getPdiscount()
			+"카테고리 : <select class=\"form-control\" name=\"cg_num\" id = \"categorybox\"></select>";
		}else {
			int cg_num = Integer.parseInt(request.getParameter("cg_num"));
			ArrayList<Product> plist = ProductDao.productDao.getplist();
			html += "<option value=\"0\">제품 선택</option>";
			for(Product temp : plist) {
				if(temp.getCg_num()==cg_num) {
					html += "<option value=\""+temp.getPnum()+"\">"+temp.getPname()+"</option>";
				}
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
