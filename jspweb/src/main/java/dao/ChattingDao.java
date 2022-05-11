package dao;

import java.util.ArrayList;

import dto.Chatting;

public class ChattingDao extends Dao {

	public static ChattingDao chattingDao = new ChattingDao();
	
	// 1. 채팅 db에 저장
	public boolean chatting(String id, String chat) {
		try {
			String sql = "insert into chatting(nickname,chatting) values(?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, chat);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("채팅 저장 오류 : "+e);}
		return false;
	}
	
	// 2. 채팅 불러오기
	public ArrayList<Chatting> getclist(){
		try {
			ArrayList<Chatting> clist = new ArrayList<Chatting>();
			String sql = "select * from chatting";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Chatting chatting = new Chatting(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				clist.add(chatting);
			}
			return clist;
		}catch(Exception e) {System.out.println("채팅 불러오기 오류 : "+e);}
		return null;
	}
}
