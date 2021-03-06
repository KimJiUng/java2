package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mysql.cj.xdevapi.JsonArray;

import dto.Cart;
import dto.Category;
import dto.Order;
import dto.Orderdetail;
import dto.Porder;
import dto.Product;
import dto.Stock;
import dto.Wishlist;

public class ProductDao extends Dao {

	public static ProductDao productDao = new ProductDao();
	
/////////////////////////////////////////////////////// 카테고리 //////////////////////////////////////////////////////////////
	
	// 카테고리 등록 [C]
	public boolean csave(String cg_name) {
		try {
			String sql = "insert into category(cg_name) value('"+cg_name+"')";
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("카테고리 등록 실패 오류 : "+e);}
		return false;
	}
	
	// 카테고리 호출 [R]
	public ArrayList<Category> getclist() {
		try {
			ArrayList<Category> clist = new ArrayList<Category>();
			String sql = "select * from category";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Category category = new Category(rs.getInt(1), rs.getString(2));
				clist.add(category);
			}
			return clist;
		}catch(Exception e) {System.out.println("카테고리 호출 실패 오류 : "+e);}
		return null;
	}
	
	// 카테고리 호출 
		public Category getcategory(int cg_num) {
			try {
				String sql = "select * from category where cg_num="+cg_num;
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				if(rs.next()) {
					Category category = new Category(rs.getInt(1), rs.getString(2));
					return category;
				}
			}catch(Exception e) {System.out.println("카테고리 호출 실패 오류 : "+e);}
			return null;
		}
	
	// 카테고리 수정 [U]
	public boolean cupdate() {
		try {
			
		}catch(Exception e) {System.out.println("카테고리 수정 실패 오류 : "+e);}
		return false;
	}
	
	// 카테고리 삭제 [D]
	public boolean cdelete() {
		try {
			
		}catch(Exception e) {System.out.println("카테고리 삭제 실패 오류 : "+e);}
		return false;
	}
	
	
//////////////////////////////////////////////////////////////////// 제품 ///////////////////////////////////////////////////////////
	// 제품 등록 메소드
	public boolean psave(Product product) {
		try {
			String sql = "insert into product(pname,pprice,pdiscount,pimg,cg_num) values(?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, product.getPname());
			ps.setInt(2, product.getPprice());
			ps.setFloat(3, product.getPdiscount());
			ps.setString(4, product.getPimg());
			ps.setInt(5, product.getCg_num());
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("제품 등록 실패 오류 : "+e);}
		return false;
	}
	
	// 제품 출력 메소드
	public ArrayList<Product> getplist() {
		try {
			ArrayList<Product> plist = new ArrayList<Product>();
			String sql = "select * from product";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Product product = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getFloat(4), rs.getInt(5), rs.getString(6), rs.getInt(7));
				plist.add(product);
			}
			return plist;
		}catch(Exception e) {System.out.println("제품 출력 실패 오류 : "+e);}
		return null;
	}
	
	// 개별 제품 출력 메소드
	public Product getproduct(int pnum) {
		try {
			String sql = "select * from product where pnum="+pnum;
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Product product = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getFloat(4), rs.getInt(5), rs.getString(6), rs.getInt(7));
				return product;
			}
		}catch(Exception e) {System.out.println("개별 제품 출력 실패 오류 : "+e);}
		return null;
	}
	
	// 제품 수정 메소드
	public boolean pupdate(Product product) {
		try {
			
		}catch(Exception e) {System.out.println("제품 수정 실패 오류 : "+e);}
		return false;
	}
	
	// 제품 삭제 메소드
	public boolean pdelete(int pnum) {
		try {
			String sql = "delete from product where pnum="+pnum;
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("제품 삭제 실패 오류 : "+e);}
		return false;
	}
	
	// 제품 상태 변경 메소드
	public boolean pactivechange(int pactive, int pnum) {
		try {
			String sql = "update product set pactive="+pactive+" where pnum="+pnum;
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("제품 상태 변경 오류 : "+e);}
		return false;
	}
	
//////////////////////////////////////////////////////////재고 ////////////////////////////////////////////////////////////////////
	
	// 제품의 재고 등록
	public boolean ssave(int pnum, String scolor, String ssize, int samount) {
		try {
			String sql = "insert into stock(scolor, ssize, samount,pnum) values(?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, scolor);
			ps.setString(2, ssize);
			ps.setInt(3, samount);
			ps.setInt(4, pnum);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("재고 등록 실패 오류 : "+e);}
		return false;
	}
	
	// 제품의 재고 호출
	public ArrayList<Stock> getstocklist(int pnum) {
		try {
			ArrayList<Stock> slist = new ArrayList<Stock>();
			String sql = "select * from stock where pnum="+pnum;
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Stock stock = new Stock(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7) );
				slist.add(stock);
			}
			return slist;
		}catch(Exception e) {System.out.println("재고리스트 호출 실패 오류 : "+e);}
		return null;
	}
	
	// 제품번호로 재고 호출
	public Stock getstock(int snum) {
		try {
			String sql = "select * from stock where snum="+snum;
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				Stock stock = new Stock(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7) );
				return stock;
			}
		}catch(Exception e) {System.out.println("재고 호출 실패 오류 : "+e);}
		return null;
	}
	
	// 제품의 재고 수정
	public boolean supdate(Stock stock) {
		try {
			String sql = "update stock set scolor=? , ssize=?, samount=? where snum=?";
			ps =con.prepareStatement(sql);
			ps.setString(1, stock.getScolor());
			ps.setString(2, stock.getSsize());
			ps.setInt(3, stock.getSamount());
			ps.setInt(4, stock.getSnum());
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("재고 수정 실패 오류 : "+e);}
		return false;
	}
	
	// 제품의 재고 삭제
	public boolean sdelete(int snum) {
		try {
			String sql = "delete from stock where snum="+snum;
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("재고 삭제 실패 오류 : "+e);}
		return false;
	}
	
	// 제품의 색상별 사이즈 출력
	public ArrayList<String> getsize(int pnum, String color){
		try {
			ArrayList<String> sizelist = new ArrayList<String>();
			String sql = "SELECT * from product join stock on product.pnum = stock.pnum where stock.pnum="+pnum+" and scolor='"+color+"'";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				sizelist.add(rs.getString(10));
			}
			return sizelist;
		}catch(Exception e) {System.out.println("사이즈 출력 오류 : "+e);}
		return null;
	}
	
////////////////////////////////////// 찜하기 ////////////////////////////////////////////
	// 관심상품 등록
	public boolean wishlistadd(Wishlist wishlist) {
		try {
			if(wishlist.getSnum()==0) {
				String sql = "insert into wishlist(pnum,mnum,wamount) values(?,?,?)";
				ps = con.prepareStatement(sql);
				ps.setInt(1, wishlist.getPnum());
				ps.setInt(2, wishlist.getMnum());
				ps.setInt(3, wishlist.getWamount());
			}else {
				String sql = "insert into wishlist(pnum,mnum,snum,wamount) values(?,?,?,?)";
				ps = con.prepareStatement(sql);
				ps.setInt(1, wishlist.getPnum());
				ps.setInt(2, wishlist.getMnum());
				ps.setInt(3, wishlist.getSnum());
				ps.setInt(4, wishlist.getWamount());
			}
			ps.executeUpdate();
			return true;	// 등록
			
		}catch(Exception e) {System.out.println("찜하기 오류 : "+e);}
		return false;	// 오류
	}
	
	// 관심상품 삭제
	public boolean wishlistdelete(int wnum) {
		try {
			String sql = "delete from wishlist where wnum=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, wnum);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("관심상품 삭제 오류 :"+e);}
			return false;
	}
	
	// 관심상품 불러오기
	public ArrayList<Wishlist> getwishlist(int mnum){
		try {
			ArrayList<Wishlist> wlist = new ArrayList<Wishlist>();
			String sql = "select * from wishlist where mnum="+mnum;
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Wishlist wishlist = new Wishlist(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
				wlist.add(wishlist);
			}
			return wlist;		
		}catch(Exception e) {System.out.println("관심상품 불러오기 오류 : "+e);}
		return null;
	}
	
	// 관심상품에 등록된 상품인지 확인
	public boolean wishlistcheck(int mnum, int snum,int amount,int pnum) {
		try {
			String sql;
			if(amount==0) {
				sql = "select * from wishlist where mnum="+mnum+" and pnum="+pnum;
			}else {
				sql = "select * from wishlist where mnum="+mnum+" and snum="+snum;	
			}
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return false;
			}else {
				return true;
			}
		}catch(Exception e) {System.out.println("관심상품 확인 오류 : "+e);}
		return false;
	}
	

////////////////////////////////////// 장바구니 //////////////////////////////////////////////
	// 장바구니 추가
	public boolean cartadd(Cart cart) {
		try {
			String sql = "insert into cart(pnum,mnum,snum,cart_selectamount) values(?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, cart.getPnum());
			ps.setInt(2, cart.getMnum());
			ps.setInt(3, cart.getSnum());
			ps.setInt(4, cart.getCart_selectamount());
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("장바구니 담기 오류 : "+e);}
		return false;
	}
	
	// 장바구니 삭제
	public boolean cartdelete(int cart_num) {
		try {
			String sql = "delete from cart where cart_num="+cart_num;
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("장바구니 삭제 오류 : "+e);}
		return false;
	}
	
	// 장바구니 전체삭제
		public boolean cartdeleteall(int mnum) {
			try {
				String sql = "delete from cart where mnum="+mnum;
				ps = con.prepareStatement(sql);
				ps.executeUpdate();
				return true;
			}catch(Exception e) {System.out.println("장바구니 전체 삭제 오류 : "+e);}
			return false;
		}
	
	// 장바구니 불러오기
		public ArrayList<Cart> getcart(int mnum){
			try {
				ArrayList<Cart> clist = new ArrayList<Cart>();
				String sql = "select * from cart where mnum="+mnum;
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()) {
					Cart cart = new Cart(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
					clist.add(cart);
				}
				return clist;		
			}catch(Exception e) {System.out.println("장바구니 불러오기 오류 : "+e);}
			return null;
		}

	// 장바구니 개별 불러오기
		public Cart getcart1(int cart_num){
			try {
				String sql = "select * from cart where cart_num="+cart_num;
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				if(rs.next()) {
					Cart cart = new Cart(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
					return cart;
				}
						
			}catch(Exception e) {System.out.println("장바구니 개별 불러오기 오류 : "+e);}
			return null;
		}
		
		
		
	// 장바구니 수량 변경
	public boolean updatecart(int cart_num,int cart_selectamount) {
		try {
			String sql = "update cart set cart_selectamount="+cart_selectamount+" where cart_num="+cart_num;
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("장바구니 수량 변경 오류 : "+e);}
		return false;
	}
	
	// 장바구니 옵션 변경
	public boolean updateoptioncart(int cart_num,int snum) {
		try {
			String sql = "update cart set snum="+snum+" , cart_selectamount=1 where cart_num="+cart_num;
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("장바구니 옵션 변경 오류 : "+e);}
		return false;
	}
	
	// 장바구니에 있는 물품인지 확인
	public boolean cartcheck(int mnum, int snum) {
		try {
			String sql = "select * from cart where mnum="+mnum+" and snum="+snum;
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return false;
			}else {
				return true;
			}
		}catch(Exception e) {System.out.println("장바구니 확인 오류 : "+e);}
		return false;
	}
	
	
///////////////////////////////////////// 주문 ///////////////////////////////////////////////
	
	// 주문 저장
	public int saveorder(Order order) {
		try {
			String sql = "insert into porder(ordername,orderphone,orderaddress,ordertotalpay,orderrequest,mnum) values(?,?,?,?,?,?)";
			ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, order.getOrdername());
			ps.setString(2, order.getOrderphone());
			ps.setString(3, order.getOrderaddress());
			ps.setInt(4, order.getOrdertotalpay());
			ps.setString(5, order.getOrderrequest());
			ps.setInt(6, order.getMnum());
			ps.executeUpdate();
			// DB에 저장후 생성된 PK값 빼오기
			rs = ps.getGeneratedKeys();
			if(rs.next()) {
				return rs.getInt(1);
			}
		}catch(Exception e) {System.out.println("주문 저장 오류 : "+e);}
		return 0;
	}
	
	// 주문 디테일 저장
	public boolean saveorderdetail(Orderdetail orderdetail) {
		try {
			String sql = "insert into porderdetail(scolor,ssize,pname,pprice,pdiscount,samount,totalprice,ordernum,pimg,cg_name) values(?,?,?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, orderdetail.getScolor());
			ps.setString(2, orderdetail.getSsize());
			ps.setString(3, orderdetail.getPname());
			ps.setInt(4, orderdetail.getPprice());
			ps.setFloat(5, orderdetail.getPdiscount());
			ps.setInt(6, orderdetail.getSamount());
			ps.setInt(7, orderdetail.getTotalprice());
			ps.setInt(8, orderdetail.getOrdernum());
			ps.setString(9, orderdetail.getPimg());
			ps.setString(10, orderdetail.getCg_name());
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("주문 디테일 저장 오류 : "+e);}
		return false;
	}
	// 오늘 주문 불러오기
	public ArrayList<Orderdetail> getorderlist() {
		try {
			ArrayList<Orderdetail> odlist = new ArrayList<Orderdetail>();
			String sql = "SELECT B.*, substring_index(A.orderdate,' ', 1) FROM porder A, porderdetail B where A.ordernum = B.ordernum and substring_index(A.orderdate,' ', 1)=substring_index(now(),' ',1) and orderdetailactive=3";
			ps =con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Orderdetail orderdetail = new Orderdetail(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getFloat(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getString(11), rs.getString(12));
				odlist.add(orderdetail);
			}
			return odlist;
		}catch(Exception e) {System.out.println("오늘 주문 불러오기 오류 : "+e);}
		return null;
	}
	
	
	// 주문 불러오기 (ArrayList)
	public ArrayList<Porder> getorderdetail(int mnum){
		try {
			ArrayList<Porder> olist = new ArrayList<Porder>();
			String sql = "SELECT porder.ordernum, porder.orderdate, porder.ordertotalpay, porderdetail.orderdetailactive, porderdetail.scolor, porderdetail.ssize, porderdetail.pname, porderdetail.pprice, porderdetail.pdiscount, porderdetail.samount, porderdetail.totalprice, porderdetail.pimg"
					+ "  FROM porder join porderdetail on porder.ordernum = porderdetail.ordernum where mnum="+mnum;
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Porder porder = new Porder(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getFloat(9), rs.getInt(10), rs.getInt(11), rs.getString(12));
				olist.add(porder);
			}
			return olist;
		}catch(Exception e) {System.out.println("주문 불러오기 오류 : "+e);}
		return null;
	}
	
	// 주문 불러오기 (JSON)
	public JSONArray getorderdetail1(int mnum){
		try {
			String sql = "SELECT porder.ordernum, porder.orderdate, porder.ordertotalpay, porderdetail.orderdetailactive, porderdetail.scolor, porderdetail.ssize, porderdetail.pname, porderdetail.pprice, porderdetail.pdiscount, porderdetail.samount, porderdetail.totalprice, porderdetail.pimg, porderdetail.orderdetailnum"
					+ "  FROM porder join porderdetail on porder.ordernum = porderdetail.ordernum where mnum="+mnum+" order by ordernum desc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			JSONArray jsonArray = new JSONArray();	// 상위 리스트 [여러개의 하위 리스트]
			JSONArray JA = new JSONArray();			// 하위 리스트
			int oldordernum = -1;	// 이전 데이터의 주문번호 변수
			while(rs.next()) {
				JSONObject jsonObject = new JSONObject();
				
				jsonObject.put("ordernum", rs.getInt(1));
				jsonObject.put("orderdate", rs.getString(2));
				jsonObject.put("ordertotalpay", rs.getInt(3));
				jsonObject.put("orderdetailactive", rs.getInt(4));
				jsonObject.put("scolor", rs.getString(5));
				jsonObject.put("ssize", rs.getString(6));
				jsonObject.put("pname", rs.getString(7));
				jsonObject.put("pprice", rs.getInt(8));
				jsonObject.put("pdiscount", rs.getFloat(9));
				jsonObject.put("samount", rs.getInt(10));
				jsonObject.put("totalprice", rs.getInt(11));
				jsonObject.put("pimg", rs.getString(12));
				jsonObject.put("orderdetailnum", rs.getInt(13));
		
				// 동일한 주문번호끼리 묶음 처리
				// { 키 : 값 }
				// { "ordernum" : [ 키 : 값 , 키 : 값 ] , "ordernum" : [ 키 : 값 , 키 : 값 ] }
				if(oldordernum == rs.getInt(1)) {	// 이전 주문번호와 현재 주문번호가 같으면
					JA.put(jsonObject);		// 하위리스트에 데이터 담기
				}else {
					JA = new JSONArray();	// 하위리스트 초기화
					JA.put(jsonObject);		// 하위리스트에 데이터 담기
					jsonArray.put(JA);		// 상위리스트에 하위리스트 추가
				}
				oldordernum = rs.getInt(1);	// 이전 주문번호에 현재 주문번호 넣기
				
			}
			return jsonArray;
			
		}catch(Exception e) {System.out.println("주문 불러오기 오류 : "+e);}
		return null;
	}
	
	// 주문 디테일 삭제
	public boolean orderdetaildelete(int orderdetailnum, int active) {
		try {
			String sql = "update porderdetail set orderdetailactive = "+active+" where orderdetailnum="+orderdetailnum;
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("주문 디테일 삭제 오류 : "+e);}
		return false;
	}
	
	
	// 막대차트 자료 가져오기
	public JSONArray getchart() {
		try {
			String sql = "SELECT substring_index(orderdate, ' ', 1) as 날짜 , sum(ordertotalpay) FROM porder group by 날짜 order by 날짜 desc";
			ps =con.prepareStatement(sql);
			rs = ps.executeQuery();
			JSONArray jsonArray = new JSONArray();
			while(rs.next()) {
				JSONObject jo = new JSONObject();
				jo.put("date", rs.getString(1));
				jo.put("value", rs.getInt(2));
				jsonArray.put(jo);
			}
			return jsonArray;
		}catch(Exception e) {System.out.println("막대차트 자료 가져오기 오류 : "+e);}
		return null;
	}
	
	
	// 원형차트 자료 가져오기
	public JSONArray getpiechart() {
		try {
			String sql = "SELECT count(samount),cg_name FROM porderdetail group by cg_name";
			ps =con.prepareStatement(sql);
			ResultSet rs2 =ps.executeQuery();						
			JSONArray jsonArray = new JSONArray();
			while(rs2.next()) {
				JSONObject jo = new JSONObject();
				jo.put("category", rs2.getString(2));
				jo.put("value", rs2.getInt(1));
				jsonArray.put(jo);
			}
			return jsonArray;
		}catch(Exception e) {System.out.println("원형차트 자료 가져오기 오류 : "+e);}
		
		return null;
	}
	// 라인차트 자료 가져오기
	public JSONArray getlinechart() {
		try {
			String sql = "select B.pname as 제품이름, sum(B.samount) as 판매수량,substring_index(A.orderdate,' ',1) as 날짜 from porder A join porderdetail B on A.ordernum = B.ordernum group by 제품이름,날짜";
			ps =con.prepareStatement(sql);
			ResultSet rs3 =ps.executeQuery();						
			JSONArray jsonArray = new JSONArray();
			while(rs3.next()) {
				JSONObject jo = new JSONObject();
				jo.put("date", rs3.getString(3));
				jo.put("value", rs3.getInt(2));
				jo.put("pname", rs3.getString(1));
				jsonArray.put(jo);
			}
			return jsonArray;
		}catch(Exception e) {System.out.println("라인차트 자료 가져오기 오류 : "+e);}
		
		return null;
	}
	
}
