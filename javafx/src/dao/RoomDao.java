package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.Room;
import dto.Roomlive;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RoomDao {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public static RoomDao roomDao = new RoomDao();
	
	public RoomDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC","root","1234");
		} catch(Exception e) {
			System.out.println("RoomDao ���� : "+e);
		}			
	}
	
	// 1. �� ���� �޼ҵ�
	public boolean roomadd(Room room) {
		try {
			String sql = "insert into room(roomname,roomip) values(?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, room.getRoomname());
			ps.setString(2, room.getRoomip());
			ps.executeUpdate();
			return true;
		} catch(Exception e) {
			System.out.println("roomadd error : "+ e);
		}
		return false;
	}
	
	// 2. ���ȣ[=��Ʈ��ȣ] ȣ�� �޼ҵ�
	public int getroomnum() {
		try {
			// ���� �ֱٿ� ��ϵ� �� ��ȣ ��������
			String sql = "select max(roomnum) from room"; // max(�ʵ��) : �ش� �ʵ��� ���� �ֱٰ�
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch(Exception e) {
			System.out.println("getroomnum error : "+e);
		}
		return 0;
	}
	
	// 3. ��� �� ȣ�� �޼ҵ� [tableview -> observableList]
	public ObservableList<Room> roomlist(){
		ObservableList<Room> roomlist = FXCollections.observableArrayList();
		try {
			String sql = "select * from room order by roomnum desc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String sql2 ="select * from roomlive";
				PreparedStatement ps2 = con.prepareStatement(sql2);
				ResultSet rs2;
				rs2 = ps2.executeQuery();
				int i=0;
				while(rs2.next()) {
					i++;
				}
				
				Room room = new Room(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						i);
				roomlist.add(room);
			}
			return roomlist;
		} catch(Exception e){
			System.out.println("roomlist error : "+e);
		}
		return null;
	}
	
	// 4. ä�ù� ���� ��� �߰�
	public boolean addroomlive(Roomlive roomlive) {
		try {
			String sql = "insert into roomlive(roomnum,mid)values(?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, roomlive.getRoomnum());
			ps.setString(2, roomlive.getMid());
			ps.executeUpdate();
			return true;
		} catch(Exception e) {
			System.out.println("ä�ù� ���Ӹ�� �߰� ���� : "+e);
		}
		return false;
	}
	
	// 5. ä�ù� ���ӵ� ��� ��� ȣ��
	public ArrayList<Roomlive> getRoomlivelist(int roomnum){
		ArrayList<Roomlive> roomlivelist = new ArrayList<>();
		try {
			String sql = "select * from roomlive where roomnum=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, roomnum);
			rs = ps.executeQuery();
			while(rs.next()) {
				Roomlive roomlive = new Roomlive(rs.getInt(1), rs.getInt(2), rs.getString(3));
				roomlivelist.add(roomlive);
			}
			return roomlivelist;
		} catch(Exception e) {
			System.out.println("ä�ù� ��� ȣ�� �޼ҵ� ���� : "+e);
		}
		return null;
	}
	
	// 6. ä�ù� ���� ��� ����
	public boolean roomlivedelete(String mid) {
		try {
			String sql = "delete from roomlive where mid=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.executeUpdate();
			return true;
		} catch(Exception e) {
			System.out.println("ä�ù� ���� ��� ���� ���� : "+e);
		}
		return false;
	}
	
	// 7. ä�ù� ���� [���� : �ش���� ���Ӹ���� 0���϶�]
	public boolean roomdelete(int roomnum) {
		try {
			String sql = "select * from roomlive where roomnum=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, roomnum);
			rs = ps.executeQuery();
			if(rs.next()) {
				return false;
			}else {
				String sql2 = "delete from room where roomnum=?";
				ps = con.prepareStatement(sql2);
				ps.setInt(1, roomnum);
				ps.executeUpdate();
				return true;
			}
		} catch(Exception e) {
			System.out.println("ä�ù� ���� ���� : "+e);
		}
		return false;
	}
	
	
	
}
