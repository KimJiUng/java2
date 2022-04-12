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

	// �ʵ�
	private Connection con; // DB ���� Ŭ����
	private PreparedStatement ps; // ����� DB�� SQL ����
	private ResultSet rs; // SQL ��� ���ڵ� ��������
	
	public static MailDao mailDao = new MailDao();
	
	public ArrayList<String> viewlist = new ArrayList<>();
	
	// ������
	public MailDao() { // �����ڿ��� �����ϴ� ���� : ��ü ������ �ٷ� DB�� �����ϱ� ����
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC","root","1234");
			
		} catch(Exception e) {
			System.out.println("(MailDao)DB ���� ���� : "+e);
		}
	}
	
	// �޼ҵ�
	
	// 1. ���� ������
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
			System.out.println("���������� ���� : "+e);
		}
	}
	// 2. ���� Ȯ��
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
			System.out.println("���� Ȯ�� ���� : "+e);
		}
		return null;
	}
	
}
