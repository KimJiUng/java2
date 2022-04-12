package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import controller.login.Login;
import dto.Mail;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MailDao {

	// 필드
	private Connection con; // DB 연결 클래스
	private PreparedStatement ps; // 연결된 DB내 SQL 조작
	private ResultSet rs; // SQL 결과 레코드 가져오기
	
	public static MailDao mailDao = new MailDao();
	
	public ArrayList<String> viewlist = new ArrayList<>();
	
	// 생성자
	public MailDao() { // 생성자에서 연동하는 이유 : 객체 생성시 바로 DB와 연동하기 위해
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC","root","1234");
			
		} catch(Exception e) {
			System.out.println("(MailDao)DB 연동 실패 : "+e);
		}
	}
	
	// 메소드
	
	// 1. 쪽지 보내기
	public void send(String mreciveid, String mcontent) {
		try {
			String sql = "insert into mail(msendid,mreciveid,mcontent) values(?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, Login.member.getMid());
			ps.setString(2, mreciveid);
			ps.setString(3, mcontent);
			ps.executeUpdate();
			return;
		} catch(Exception e) {
			System.out.println("쪽지보내기 오류 : "+e);
		}
	}
	// 2. 쪽지 확인
	public ObservableList<Mail> recive() {
		try {
			ObservableList<Mail> list = FXCollections.observableArrayList();
			String sql = "select * from mail where mreciveid=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, Login.member.getMid());
			rs = ps.executeQuery();
			while(rs.next()) {
				Mail mail = new Mail(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				list.add(mail);
			}
			return list;
		} catch(Exception e) {
			System.out.println("쪽지 확인 오류 : "+e);
		}
		return null;
	}
	
}
