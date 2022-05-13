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

@WebServlet("/admin/selectcolor")
public class selectcolor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public selectcolor() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String color = request.getParameter("color");
		int pnum = Integer.parseInt(request.getParameter("pnum"));
		ArrayList<String> sizelist = ProductDao.productDao.getsize(pnum, color);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String html = ""; 
		for(String temp : sizelist) {
			html += "<option value=\""+temp+"\">"+temp+"</option>";
		}
		out.print(html);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
