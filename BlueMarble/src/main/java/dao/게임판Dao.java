package dao;

import java.util.ArrayList;

import dto.게임판;

public class 게임판Dao extends Dao{

	public 게임판Dao() {
		super();
	}
	public static 게임판Dao 게임판Dao = new 게임판Dao();

	public ArrayList<게임판> 게임판리스트 (){
		try {
			ArrayList<게임판> 게임판리스트 = new ArrayList<>();
			String sql = "select * from 게임판";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				게임판 게임판 = new 게임판(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10));
				게임판리스트.add(게임판);
			}
			return 게임판리스트;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
