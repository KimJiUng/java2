package dao;

import java.util.ArrayList;

import dto.User;

public class UserDao extends Dao {

	public static UserDao userDao = new UserDao();
	
	// 유저 정보 불러오기
	public ArrayList<User> getuser(){
		try {
			ArrayList<User> ulist = new ArrayList<User>();
			String sql = "select * from user";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				User user = new User(rs.getString(2), rs.getInt(3), rs.getInt(4));
				ulist.add(user);
			}
			return ulist;
		}catch(Exception e) {}
		return null;
	}
	
}
