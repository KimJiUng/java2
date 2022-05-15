package dao;

import java.sql.PreparedStatement;
import java.util.ArrayList;

import dto.플레이어;

public class 플레이어Dao extends Dao{

	public static 플레이어Dao 플레이어Dao = new 플레이어Dao();
	
	// 플레이어 등록
	public boolean 플레이어등록(String 닉네임, int 게임정보번호) {
		try {
			String sql = "insert into 플레이어(닉네임,게임정보번호) values('"+닉네임+"',"+게임정보번호+")";
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("플레이어 등록 오류 : "+ e);}
		return false;
	}
	
	// 게임방에 등록된 플레이어 불러오기
	public ArrayList<플레이어> getplayers(int 게임정보번호){
		try {
			ArrayList<플레이어> plist = new ArrayList<플레이어>();
			String sql = "select * from 플레이어 where 게임정보번호="+게임정보번호+" order by 순서 asc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				플레이어 플레이어 = new 플레이어(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
				plist.add(플레이어);
			}
			return plist;
			}catch(Exception e) {System.out.println("플레이어 불러오기 오류 : "+e);}
		
		return null;
	}
	
	// 플레이어 번호로 플레이어정보 가져오기
	public 플레이어 getplayer(int 플레이어번호) {
		try {
			String sql = "select * from 플레이어 where 플레이어번호="+플레이어번호;
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				플레이어 플레이어 = new 플레이어(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
				return 플레이어;
			}
		}catch(Exception e) {System.out.println("플레이어 정보 오류 : "+e);}
		return null;
	}

	
	// 플레이어 순서 정하기
	public boolean 순서정하기(int 순서, int 플레이어번호) {
		try {
			String sql = "update 플레이어 set 순서="+순서+" where 플레이어번호="+플레이어번호;
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("플레이어 순서정하기 오류 : "+ e);}
		return false;
	}
	
	// 턴 시작/종료
	public boolean 턴시작종료(int 플레이어번호){
		try {
			String sql = "select 턴 from 플레이어 where 플레이어번호="+플레이어번호;
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				String sql2;
				if(rs.getInt(1)==0) {
					sql2 = "update 플레이어 set 턴=1 where 플레이어번호="+플레이어번호;
				}else {
					sql2 = "update 플레이어 set 턴=0 where 플레이어번호="+플레이어번호;
				}
				PreparedStatement ps2 = con.prepareStatement(sql2);
				ps2.executeUpdate();
				return true;
			}
		}catch(Exception e) {System.out.println("턴계산 오류 : "+e);}
		return false;
	}
	
	// 플레이어 위치 움직이기
	public boolean moveplayer(int 플레이어번호,int 현재위치,int 주사위합계) {
		try {
			String sql = "update 플레이어 set 현재위치=? where 플레이어번호=?";
			ps = con.prepareStatement(sql);
			if(현재위치+주사위합계>40) {
				ps.setInt(1, 현재위치+주사위합계-40);
			}else {
				ps.setInt(1, 현재위치+주사위합계);
			}
			ps.setInt(2, 플레이어번호);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("플레이어 위치 움직이기 오류 : "+e);}
		return false;
	}
	
	// 플레이어 금액 변동
	public boolean changemoney(int 플레이어번호, int 변동금액) {
		try {
			int 소유자금 = getplayer(플레이어번호).get소유자금();
			String sql = "update 플레이어 set 소유자금="+소유자금+변동금액+" where 플레이어번호="+플레이어번호;
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("금액 변동 오류 : "+e);}
		return false;
	}
	
	
}
