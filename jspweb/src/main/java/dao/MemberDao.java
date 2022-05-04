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
	
	// 개별 회원정보 출력 [ 인수 : 세션에 저장된 회원 id ]
	public Member getmember(String mid) {
		try {
			String sql = "select * from member where mid='"+mid+"'";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				// 패스워드 제외(보안상)한 검색된 레코드의 모든 필드의 값 객체화
				Member member = new Member(rs.getInt(1), rs.getString(2), null, rs.getString(4), 
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9));
				return member;
			}
		} catch(Exception e) {System.out.println("회원정보 출력 오류 : "+e);}
		return null;
	}
	
	// 회원 탈퇴
	public boolean delete(String mid) {
		try {
			String sql = "delete from member where mid='"+mid+"'";
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("회원탈퇴 오류  : "+e);}
		return false;
	}
	
	// 회원 수정
	public boolean update(Member member) {
		try {
			if(member.getMpassword()==null) {
				String sql = "update member set mname=?, mphone=?, memail=?, maddress=? where mnum=?";
				ps=con.prepareStatement(sql);
				ps.setString(1, member.getMname());
				ps.setString(2, member.getMphone());
				ps.setString(3, member.getMemail());
				ps.setString(4, member.getMaddress());
				ps.setInt(5, member.getMnum());
			}else {
				String sql = "update member set mname=?, mpassword=?, mphone=?, memail=?, maddress=? where mnum=?";
				ps=con.prepareStatement(sql);
				ps.setString(1, member.getMname());
				ps.setString(2, member.getMpassword());
				ps.setString(3, member.getMphone());
				ps.setString(4, member.getMemail());
				ps.setString(5, member.getMaddress());
				ps.setInt(6, member.getMnum());
			}
			ps.executeUpdate();
			return true;
		} catch(Exception e) {System.out.println("회원 수정 오류 : "+e);}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
