package dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import controller.board.Boardcontroller;
import controller.login.Login;
import dto.Board;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BoardDao {
	
	// �ʵ�
	private Connection con; // DB ���� Ŭ����
	private PreparedStatement ps; // ����� DB�� SQL ����
	private ResultSet rs; // SQL ��� ���ڵ� ��������
	
	public static BoardDao boardDao = new BoardDao();
	
	public ArrayList<String> viewlist = new ArrayList<>();
	
	// ������
	public BoardDao() { // �����ڿ��� �����ϴ� ���� : ��ü ������ �ٷ� DB�� �����ϱ� ����
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC","root","1234");
			
		} catch(Exception e) {
			System.out.println("(BoardDao)DB ���� ���� : "+e);
		}
	}
	
	// �޼ҵ�
		// 1. �۾��� �޼ҵ�
	public boolean write(Board board) {
		try {
			String sql = "insert into board(btitle, bcontent,bwrite,mnum) values(?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getBtitle());
			ps.setString(2, board.getBcontent());
			ps.setString(3, board.getBwrite());
			ps.setInt(4, board.getMnum());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("�۾��� SQL ���� : "+e);
		}
		return false;
	}
	
		// 2. ��� �� ȣ�� �޼ҵ�
	public ObservableList<Board> list() {
		try {
			ObservableList<Board> boardlist = FXCollections.observableArrayList();
			String sql = "select * from board order by bnum desc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
				// rs : �˻������ ���ڵ带 �ϳ��� ��ȯ 
					// rs.next() : �˻������ ���� ���ڵ�
					// rs.get�ڷ���(�ش��ʵ������ȣ) : �� ���ڵ忡�� �ش� �ʵ��� ������ ��������
			while(rs.next()) { // ���� ���ڵ尡 ���������� �ݺ�
				// ��üȭ
				
				Board board = new Board(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getInt(6),
						rs.getInt(7));
				// ����Ʈ�� �߰�
				boardlist.add(board);
			}
			return boardlist; // ������ ����Ʈ ��ȯ
		} catch(Exception e){
			System.out.println("ȣ�� SQL ���� : "+e);
		}
		return null; // ���н� null
	}
	
		// 3. �� ���� �޼ҵ�
	public boolean delete(int bnum) {
		try {
			String sql = "delete from board where bnum=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, bnum);
			ps.executeUpdate();
			
			String sql2 = "delete from reply where bnum=?";
			ps=con.prepareStatement(sql2);
			ps.setInt(1, bnum);
			ps.executeUpdate();
			
			return true;
		} catch(Exception e) {
			System.out.println("�ۻ��� SQL ���� : "+e);
		}
		return false;
	}
	
		// 4. �� ���� �޼ҵ�
	public boolean update(int bnum, String title, String content) {
		try {
			String sql = "update board set btitle=?, bcontent=? where bnum=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, content);
			ps.setInt(3, bnum);
			ps.executeUpdate();
			return true;
		} catch(Exception e) {
			System.out.println("�� ���� SQL ���� : "+e);
		}
		return false;
	}
	
		// 5. ��ȸ�� ���� �޼ҵ�
	public boolean viewplus() {
		try {
			load();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String now = Login.member.getMid()+format.format(new Date())+Boardcontroller.board.getBnum();
			if(Boardcontroller.board!=null) {
				boolean p = false;
				for(int i=0; i<viewlist.size(); i++) {
					if(viewlist.get(i).equals(now)) {
						p=true;
					}
				}
				if(p==true) {

				}else {
					Boardcontroller.board.setBview(Boardcontroller.board.getBview()+1);
					i = Login.member.getMid()+format.format(new Date())+Boardcontroller.board.getBnum();
					save();
				}
				String sql = "update board set bview=? where bnum=?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, Boardcontroller.board.getBview());
				ps.setInt(2, Boardcontroller.board.getBnum());
				ps.executeUpdate();
			}
			
			return true;
		} catch(Exception e) {
			System.out.println("��ȸ�� SQL ���� : "+e);
		}
		return false;
	}
	
	public String i;
	// ���� ����
	public void save() {
			
		try {
			FileOutputStream outputStream = new FileOutputStream("D:/java/��ȸ��.txt", true);
			String a = i+"\n";
			outputStream.write(a.getBytes());
			
		}catch(Exception e) {
			System.out.println("�˸�)) ���� ���� ����(�����ڿ��� ����)");
		}
	}
	// ���� �ҷ�����
	public void load() {
		try {
			FileInputStream fileInputStream = new FileInputStream("D:/java/��ȸ��.txt");
			byte[] bytes = new byte[1024];
			fileInputStream.read(bytes);
			String file = new String(bytes);
			String[] view = file.split("\n");
			
			int i=0; // �ε�����
			for(String temp : view) { 
				if(i+1==view.length) break;			
				viewlist.add(temp);
				i++; // �ε��� ����
			}
			
		} catch(Exception e) {
			System.out.println("�˸�)) ���� �ε� ����(�����ڿ��� ����)");
		}
	}
	
	// 6. ��¥�� �Խù� �� ��ȯ
	public Map<String, Integer> datetotal(String table){
		try {
			Map<String, Integer> map = new HashMap<>();
			String sql = "SELECT substring_index("+table.charAt(0)+"date,' ',1), "
					+ "count(*) FROM "+table+" group by "
					+ "substring_index("+table.charAt(0)+"date,' ',1) ";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				map.put(rs.getString(1), rs.getInt(2));
			}
			return map;
		}catch(Exception e) {
			System.out.println("��¥�� �Խù� �� ��ȯ ���� : "+ e);
		}
		return null;
	}

	
	
}
