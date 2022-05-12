package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import dto.Category;

/**
 * Servlet implementation class categorycheck
 */
@WebServlet("/admin/categorycheck")
public class categorycheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public categorycheck() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String categoryname = request.getParameter("cg_name");
		ArrayList<Category> clist = ProductDao.productDao.getclist();
		for(Category category : clist) {
			if(category.getCg_name().equals(categoryname)) {
				response.getWriter().print(1);
				return;
			}
		}
		response.getWriter().print(2);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
