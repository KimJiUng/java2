package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import controller.board.Boardcontroller;
import controller.login.Login;
import controller.product.Productcontrol;
import dto.Reply;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ReplyDao {

	private Connection con; // DB ������ ���Ǵ� Ŭ���� : DB ���� Ŭ����
	private PreparedStatement ps; // ����� DB�� SQL ���� �Ҷ� ���Ǵ� �������̽� : DB�����������̽�
	private ResultSet rs; // ������� �����ϴ� �������̽�
	
	public static ReplyDao replyDao = new ReplyDao();
	
	public ReplyDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC","root","1234");	
		} catch(Exception e) {
			System.out.println("Reply DB���� ���� : "+e);
		}

	}
	
	// ��� �ۼ� �޼ҵ�
	public boolean wirte(Reply reply,String a) {
		try {
			String sql = "insert into reply(rcontent,rwriter,"+a+"num) values(?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, reply.getRcontent());
			ps.setString(2, reply.getRwriter());
			if(a.equals("b")) {
				ps.setInt(3, reply.getBnum());
			}else {
				ps.setInt(3, reply.getPnum());
			}
			ps.executeUpdate();
			return true;
		} catch(Exception e) {
			System.out.println("��۾��� SQL ���� : "+e);
		}
		return false;
		
	}
	
	// ��� �ҷ����� �޼ҵ�
	public ObservableList<Reply> list(String a) {
		ObservableList<Reply> replylist = FXCollections.observableArrayList();
		try {
			String sql = "select * from reply";
			ps=con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				if(a.equals("b")) {
					if(rs.getInt(5)==Boardcontroller.board.getBnum()) {
						Reply reply = new Reply(
								rs.getInt(1), 
								rs.getString(2), 
								rs.getString(3), 
								rs.getString(4), 
								rs.getInt(5),
								rs.getInt(6));
						replylist.add(reply);
					}
				}
				else {
					if(rs.getInt(6)==Productcontrol.select.getPnum()) {
						Reply reply = new Reply(
								rs.getInt(1), 
								rs.getString(2), 
								rs.getString(3), 
								rs.getString(4), 
								rs.getInt(5),
								rs.getInt(6));
						replylist.add(reply);
					}
				}
			}
			return replylist;
		} catch(Exception e) {
			System.out.println("��� �ҷ����� SQL ���� : "+e);
		}
		return null;
	}
	
	// ��� ���� �޼ҵ�
	public boolean replyupdate(int rnum, String rcontent) {
		try {
			String sql = "update reply set rcontent=? where rnum=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, rcontent);
			ps.setInt(2, rnum);
			ps.executeUpdate();
			return true;
		} catch(Exception e) {
			System.out.println("��� ���� SQL ���� : "+e);
		}
		return false;
	}
	
	// ��� ���� �޼ҵ�
	public boolean replydelete(int rnum) {
		try {
			String sql = "delete from reply where rnum=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, rnum);
			ps.executeUpdate();
			return true;
		} catch(Exception e) {
			System.out.println("��ۻ��� SQL ���� : "+e);
		}
		
		return false;
	}
	
}
