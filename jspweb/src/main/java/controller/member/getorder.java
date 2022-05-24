package controller.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import dao.MemberDao;
import dao.ProductDao;
import dto.Orderdetail;
import dto.Porder;

/**
 * Servlet implementation class getorder
 */
@WebServlet("/member/getorder")
public class getorder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getorder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid = (String)request.getSession().getAttribute("loginid");
		int mnum = MemberDao.memberDao.getmember(mid).getMnum();
		response.setCharacterEncoding("UTF-8");
		JSONArray jsonArray = ProductDao.productDao.getorderdetail1(mnum);
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
//		ArrayList<Porder> olist = ProductDao.productDao.getorderdetail(mnum);	
//		
//		PrintWriter out = response.getWriter();
//		String html = "";
//		int ordernum=0;
//		html += "<tr><th width=\"10%\";>상품이미지</th><th>상품정보</th><th>판매가</th><th>수량</th><th>비고</th></tr>";
//		for(Porder temp : olist) {
//			if(ordernum == temp.getOrdernum()) {
//				html += "<tr><td><img width=\"100%;\" src=\"../admin/productimg/"+temp.getPimg()+"\"</td><td>"+temp.getPname()+"<br><span> 색상 : "+temp.getScolor()+" 사이즈 : "+temp.getSsize()+"</span></td><td>"+temp.getPprice()+"</td><td>"+temp.getSamount()+"</td>"
//						+"<td><button>배송조회</button><button>교환,반품신청</button><button>리뷰작성</button></td></tr>";
//			}else {
//				html += "<tr><td colspan=\"2\">주문번호 : "+temp.getOrdernum()+"</td><td colspan=\"3\">주문일 : "+temp.getOrderdate()+"</td></tr>";
//				html += "<tr><td><img width=\"100%;\" src=\"../admin/productimg/"+temp.getPimg()+"\"</td><td>"+temp.getPname()+"<br><span> 색상 : "+temp.getScolor()+" 사이즈 : "+temp.getSsize()+"</span></td><td>"+temp.getPprice()+"</td><td>"+temp.getSamount()+"</td>"
//						+"<td><button>배송조회</button><button>교환,반품신청</button><button>리뷰작성</button></td></tr>";
//			}
//			ordernum = temp.getOrdernum();
//		}
//		out.print(html);
//		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
