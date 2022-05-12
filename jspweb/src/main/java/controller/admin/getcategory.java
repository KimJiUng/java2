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

/**
 * Servlet implementation class getcategory
 */
@WebServlet("/admin/getcategory")
public class getcategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public getcategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Category> clist = ProductDao.productDao.getclist();
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String html = ""; // 응답할 문자열
		for(Category temp : clist) {
			html += "<option value=\""+temp.getCg_num()+"\">"+temp.getCg_name()+"</option>";
		}
		out.print(html);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
