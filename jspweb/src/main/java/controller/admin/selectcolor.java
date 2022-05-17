package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import dto.Stock;

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
		String field = request.getParameter("field");
		ArrayList<String> sizelist = ProductDao.productDao.getsize(pnum, color);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String html = ""; 
		if(field!=null && field.equals("productview")) {
			ArrayList<Stock> slist = ProductDao.productDao.getstocklist(pnum);
			Map<String, String> map = new TreeMap<String, String>();
//			html += "<option>- [필수] 옵션 선택 -</option>";
//			for(String temp : sizelist) {
//				
//				html += "<option class=\"info_t\" value=\""+temp+"\">"+temp+"</option>";
//			}
//			out.print(html);
			
			html += "<option>- [필수] 옵션 선택 -</option>";
			for(Stock stock : slist) {
				if(stock.getScolor().equals(color)) {
					if(stock.getSamount()==0) {
						html += "<option class=\"info_t\" value=\""+stock.getSsize()+","+stock.getSnum()+"\">"+stock.getSsize()+"[품절]</option>";
						map.put(stock.getSsize(), "품절");
					}else {
						html += "<option class=\"info_t\" value=\""+stock.getSsize()+","+stock.getSnum()+"\">"+stock.getSsize()+"["+stock.getSamount()+"개]</option>";
						map.put(stock.getSsize(), stock.getSamount()+"개");
					}
				}
			}
			out.print(html);
		}else {
			html += "<option>사이즈 선택</option>";
			for(String temp : sizelist) {
				html += "<option value=\""+temp+"\">"+temp+"</option>";
			}
			out.print(html);
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
