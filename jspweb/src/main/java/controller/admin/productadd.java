package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.ProductDao;
import dto.Category;
import dto.Product;

/**
 * Servlet implementation class productadd
 */
@WebServlet("/admin/productadd")
public class productadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public productadd() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 프로젝트(개발자PC) 폴더 저장 // 2. 서버(톰캣) 폴더에 저장하는 방식
		String uploadpath = request.getSession().getServletContext().getRealPath("/admin/productimg");
		MultipartRequest multi = new MultipartRequest(
				request,	// 요청 타입 
				uploadpath,	// 저장 폴더 위치 
				1024*1024*1024,	// 파일 최대 용량
				"UTF-8",					// 파일 인코딩 타입
				new DefaultFileRenamePolicy() // 보안 방식
				// DefaultFileRenamePolicy() : 파일명이 중복이면 파일명 뒤에 숫자 자동 부여 = 식별
				);
		request.setCharacterEncoding("UTF-8");
		
		int cg_num = Integer.parseInt(multi.getParameter("cg_num"));
		String pname = multi.getParameter("pname");
		int pprice = Integer.parseInt(multi.getParameter("pprice"));
		float pdiscount = Float.parseFloat(multi.getParameter("pdiscount"));
		String pimg = multi.getFilesystemName("pimg");	// 첨부파일 파일명은 요청시 .getFilesystemName
		Product product = new Product(0, pname, pprice, pdiscount, 0, pimg, cg_num);
		boolean result = ProductDao.productDao.psave(product);
		if(result) {
			response.getWriter().print(1);
		}else {
			response.getWriter().print(2);
		}
		doGet(request, response);
	}

}
