package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;

/**
 * Servlet implementation class pactivechange
 */
@WebServlet("/admin/pactivechange")
public class pactivechange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public pactivechange() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pactive =Integer.parseInt(request.getParameter("pactive"));
		int pnum =Integer.parseInt(request.getParameter("pnum"));
		boolean result = ProductDao.productDao.pactivechange(pactive, pnum);
		if(result) {
			response.getWriter().print(1);
		}else {
			response.getWriter().print(2);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
