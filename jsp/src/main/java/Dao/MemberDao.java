package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Dto.Member;

public class MemberDao {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public static MemberDao memberDao = new MemberDao();
	
	public MemberDao() {
		
		// jdbc : 자바 db 연동
			// 1. 프로젝트내 build path에 mysqljdbc.jar 추가
			// 2. 프로젝트내 webapp -> web-inf-lib -> mysqljdbc.jar 추가
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsptest?serverTimezone=UTC","root","1234");
			System.out.println("연동 성공");
		} catch(Exception e) {
			System.out.println("db 연결 오류 : "+e);
		}
	}
	
	public boolean signup(Member member) {
		try {
			String sql = "insert into member(mid,mpassword,mname) values(?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getMid());
			ps.setString(2, member.getMpassword());
			ps.setString(3, member.getMname());
			ps.executeUpdate();
			return true;
		} catch(Exception e) {System.out.println("회원가입 오류 : "+e);}
		return false;
	}
	
	public boolean idcheck(String id) {
		try {
			String sql = "select * from member where mid=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch(Exception e) {System.out.println("아이디 중복체크 오류 : "+e); }
		return false;
	}
	
	public boolean login(String id, String password) {
		try {
			String sql = "select * from member where mid=? and mpassword=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if(rs.next()) {
				System.out.println("로그인 성공");
				return true;
			}
		} catch(Exception e) {System.out.println("로그인 오류 : "+e);}
		return false;
	}
	
	public boolean delete(String id) {
		try {
			String sql = "delete from member where mid=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
			return true;
		} catch(Exception e) {System.out.println("회원탈퇴 오류 : "+e);}
		return false;
	}
}
