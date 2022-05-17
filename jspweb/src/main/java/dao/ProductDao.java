package dao;

import java.util.ArrayList;

import dto.Category;
import dto.Product;
import dto.Stock;

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
	
}
