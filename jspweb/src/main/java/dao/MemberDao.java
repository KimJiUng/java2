package dao;

import dto.Member;

public class MemberDao extends Dao {


	
	public static MemberDao memberDao = new MemberDao();
	
	
	// 아이디,이메일 중복체크
	public boolean check(String table,String value) {
		try {
			String sql = "select * from member where "+table+"=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, value);
			rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		}catch (Exception e) {System.out.println("idcheck 오류 : "+e);	}
		return false;
	}
	
	// 회원가입
	public boolean signup(Member member) {
		try {
			String sql = "insert into member(mid,mpassword,mname,mphone,memail,maddress) values(?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getMid());
			ps.setString(2, member.getMpassword());
			ps.setString(3, member.getMname());
			ps.setString(4, member.getMphone());
			ps.setString(5, member.getMemail());
			ps.setString(6, member.getMaddress());
			ps.executeUpdate();
			return true;
		}catch (Exception e) {System.out.println("회원가입 오류 : "+e);	}
		return false;
		
	}
	
	// 로그인
	public int login(String id, String password) {
		try {
			String sql = "select * from member where mid=? and mpassword=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if(rs.next()) {
				return 1;
			}
			return 2;
		} catch(Exception e) {System.out.println("로그인 오류 : "+e);}
		return 3;
	}
	
	
}
