package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Dto.Board;

public class BoardDao {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public static BoardDao boardDao = new BoardDao(); 
	
	public BoardDao() {
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
	
	public boolean write(Board board) {
		try {
			String sql = "insert into board(btitle, bcontent, bwriter, bdate) values(?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getBtitle());
			ps.setString(2, board.getBcontent());
			ps.setString(3, board.getBwriter());
			ps.setString(4, board.getBdate());
			ps.executeUpdate();
			return true;
		} catch(Exception e) {System.out.println("글쓰기 오류 : "+e);}
		return false;
	}
	
	public ArrayList<Board> getboard(){
		try {
			ArrayList<Board> blist = new ArrayList<>();
			String sql = "select * from board";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Board board = new Board(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				blist.add(board);
			}
			return blist;
		}catch (Exception e) {System.out.println("전체글 불러오기 오류 : "+e);}
		return null;
	}
	
	public Board get(int bnum) {
		try {
			String sql = "select * from board where bnum=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, bnum);
			rs = ps.executeQuery();
			if(rs.next()) {
				Board board = new Board(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				return board;
			}
		}catch (Exception e) {System.out.println("개별글 불러오기 오류 : "+e);}
		return null;
	}
	
	public boolean delete(int bnum) {
		try {
			String sql = "delete from board where bnum=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, bnum);
			ps.executeUpdate();
			return true;
		} catch(Exception e) {System.out.println("글삭제 오류 : "+e);}
		return false;
	}
	
	public boolean update(String btitle, String bcontent, int bnum) {
		try {
			String sql = "update board set btitle=? , bcontent=? where bnum=? ";
			ps = con.prepareStatement(sql);
			ps.setString(1, btitle);
			ps.setString(2, bcontent);
			ps.setInt(3, bnum );
			ps.executeUpdate();
			return true;
		} catch(Exception e) {System.out.println("수정 오류 : "+ e);}
		return false;
	}
	
}
