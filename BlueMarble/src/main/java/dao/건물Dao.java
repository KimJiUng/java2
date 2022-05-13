package dao;

import dto.게임판;

public class 건물Dao extends Dao {

	public static 건물Dao 건물Dao = new 건물Dao();
	
	

	
	// 1. 도시 정보 출력
	public 게임판 도시정보출력(int 게임판위치) {
		try {
			String sql = "select * from 게임판 where="+게임판위치;
			ps = con.prepareStatement(sql);
			if(rs.next()) {
				게임판 게임판 = new 게임판(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10));
				return 게임판;
			}
		}catch(Exception e) {System.out.println("도시정보출력 오류 : "+e);}
		return null;
	}
	
	// 2. 도시구매
	public boolean 도시구매(int 플레이어번호, int 게임판위치, int 건물종류번호, int 게임정보번호) {
		try {
			String sql = "insert into 건물(플레이어번호,건물종류번호,게임판위치,게임정보번호) values(?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, 플레이어번호);
			ps.setInt(2, 건물종류번호);
			ps.setInt(3, 게임판위치);
			ps.setInt(4, 게임정보번호);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("도시구매 오류 : "+e);}
		return false;
	}
	
	// 3. 건물 판매
	public int 건물판매(int 게임판위치,int 건물종류번호) {
		try {
			String sql = "select * from 게임판 left join 건물 on 건물.게임판위치 = 게임판.게임판위치 where 게임판.게임판위치="+게임판위치+" and 건물.건물종류번호="+건물종류번호;
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				if(rs.getInt(11)==1) {
					return rs.getInt(3);
				}else if(rs.getInt(11)==2) {
					return rs.getInt(4);
				}else if(rs.getInt(11)==3) {
					return rs.getInt(5);
				}else if(rs.getInt(11)==4) {
					return rs.getInt(6);
				}
			}
			
		}catch(Exception e) {System.out.println("건물판매 오류 : "+e);}
		return 0;
	}
	
	// 4. 통행료 출력
	public int 통행료출력(int 게임판위치) {
		try {
			int 통행료 = 0;
			String sql = "select * from 게임판 left join 건물 on 건물.게임판위치 = 게임판.게임판위치 where 게임판.게임판위치="+게임판위치;
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getInt(11)==1) {
					통행료 += rs.getInt(7);
				}else if(rs.getInt(11)==2) {
					통행료 += rs.getInt(8);
				}else if(rs.getInt(11)==3) {
					통행료 += rs.getInt(9);
				}else if(rs.getInt(11)==4) {
					통행료 += rs.getInt(10);
				}
			}
			return 통행료;
		}catch(Exception e) {System.out.println("통행료 출력 오류 : "+e);}
		return 0;
	}
	
	
	
}
