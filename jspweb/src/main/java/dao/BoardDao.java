package dao;

import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import dto.Board;

public class BoardDao extends Dao {

	public BoardDao() {
		super();
	}
	public static BoardDao boardDao = new BoardDao();
	
	// 1. 게시물 쓰기 메소드
	public boolean write(Board board) {
		try {
			String sql = "insert into board(btitle,bcontent,mnum,bfile) values(?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getBtitle());
			ps.setString(2, board.getBcontent());
			ps.setInt(3, board.getMnum());
			ps.setString(4, board.getBfile());
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("게시물 작성 오류 : "+e);}
		return false;
	}
	
	// 2. 모든 게시물 출력 메소드
	public ArrayList<Board> getboardlist(int startrow, int listsize, String key, String keyword ) {
		try {
			ArrayList<Board> boardlist = new ArrayList<Board>();
			String sql;
			
			// 만약에 작성자 검색일 경우
			if(key.equals("mid")) {
				key = "mnum";
				if(MemberDao.memberDao.getmember(keyword)==null) {
					keyword = "";
				}else {
					keyword = MemberDao.memberDao.getmember(keyword).getMnum()+"";
				}
				
			}
			
			
			// 검색이 없을 경우
			if(keyword==null || keyword.equals("")) {
				sql = "select * from board order by bnum desc limit "+startrow+","+listsize;
			}else { // 검색이 있을 경우
				sql = "select * from board where "+key+" like '%"+keyword+"%' order by bnum desc limit "+startrow+","+listsize;
			}
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String mid = MemberDao.memberDao.getmid(rs.getInt(4));
				Board board = new Board(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7), mid);
				boardlist.add(board);
			}
			return boardlist;
		}catch(Exception e) {System.out.println("게시물 불러오기 오류 : "+e);}
		return null;
	}
	
	// 2-2. 모든 게시물 개수 출력 메소드
		public int gettotalrow(String key, String keyword){
			try {
				// 만약에 작성자 검색일 경우
				if(key.equals("mid")) {
					key = "mnum";
					if(MemberDao.memberDao.getmember(keyword)==null) {
						keyword = "";
					}else {
						keyword = MemberDao.memberDao.getmember(keyword).getMnum()+"";
					}
					
				}
				String sql;
				if(keyword==null || keyword.equals("")) {
					sql = "select count(*) from board";
				}else {
					sql = "select count(*) from board where "+key+" like '%"+keyword+"%'";
				}
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				if(rs.next()) {
					return rs.getInt(1);
				}
			}catch(Exception e) {System.out.println("게시물 개수 출력 오류 : "+e);}
			return 0;
		}
	
	
	
	// 3. 개별 게시물 출력 메소드 [ 인수 : 게시물 번호 ]
	public Board getboard(int bnum) {
		try {
			String sql = "select * from board where bnum='"+bnum+"'";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				String mid = MemberDao.memberDao.getmid(rs.getInt(4));
				Board board = new Board(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7), mid);
				return board;
			}
		}catch(Exception e) {System.out.println("개별 게시물 출력 오류 : "+e);}
		return null;
	}
	
	// 4. 게시물 수정 메소드
	public boolean update(Board board) {
		try {
			String sql = "update board set btitle=?, bcontent=?, bfile=? where bnum=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getBtitle());
			ps.setString(2, board.getBcontent());
			ps.setString(3, board.getBfile());
			ps.setInt(4, board.getBnum());
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("게시물 수정 오류 : "+e);}
		return false;
	}
	
	// 5. 게시물 삭제 메소드
	public boolean delete(int bnum) {
		try {
			String sql = "delete from board where bnum='"+bnum+"'";
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("게시물 삭제 오류 : "+e);}
		return false;
	}
	
	// 5-2. 파일 삭제 메소드
	public boolean filedelete(int bnum) {
		try {
			String sql = "update board set bfile=null where bnum="+bnum;
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("파일 삭제 오류 : "+e);}
		return false;
	}
	
	// 6. 게시물 조회 증가 메소드
	public boolean increview(int bnum) {
		try {
			String sql = "select bview from board where bnum=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, bnum);
			rs = ps.executeQuery();
			if(rs.next()) {
				PreparedStatement ps2;
				String sql2 = "update board set bview=? where bnum=?";
				ps2 = con.prepareStatement(sql2);
				ps2.setInt(1, (rs.getInt(1)+1));
				ps2.setInt(2, bnum);
				ps2.executeUpdate();
				return true;
			}
		}catch(Exception e) {System.out.println("조회수 증가 오류 : "+e); }
		return false;
	}


	
	
	
	// = [같다] : 모두 동일한 데이터 검색
	// like 
	
}
