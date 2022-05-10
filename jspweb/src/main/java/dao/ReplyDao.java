package dao;

import java.sql.PreparedStatement;
import java.util.ArrayList;

import dto.Reply;

public class ReplyDao extends Dao {

	public static ReplyDao replyDao = new ReplyDao();
	
	// 1. 댓글 작성 메소드
	public boolean replywrite(Reply reply) {
		try {
			String sql = "insert into reply(bnum,mnum,rcontent,rindex) values(?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, reply.getBnum());
			ps.setInt(2, reply.getMnum());
			ps.setString(3, reply.getRcontent());
			ps.setInt(4, reply.getRindex());
			ps.executeUpdate();
			return true;
		} catch(Exception e) {System.out.println("댓글 작성 오류 : "+e);}
		return false;
	}
	
	// 2. 댓글 불러오기 메소드
	public ArrayList<Reply> getreply(int bnum){
		try {
			ArrayList<Reply> replylist = new ArrayList<Reply>();
			String sql = "select * from reply where bnum="+bnum+" and rindex=0";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Reply reply = new Reply(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), MemberDao.memberDao.getmid(rs.getInt(3)));
				replylist.add(reply);
			}
			return replylist;
		}catch(Exception e) {System.out.println("댓글 불러오기 오류 : "+e);}
		return null;
	}
	
	// 3. 댓글 수정 메소드
	public boolean reupdate(String rcontent, int rnum) {
		try {
			String sql = "update reply set rcontent=? where rnum=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, rcontent);
			ps.setInt(2, rnum);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("댓글 수정 오류 : "+e);}
		return false;
	}
	
	// 4. 댓글 삭제 메소드
	public boolean redelete(int rnum,int rindex) {
		try {
			String sql = "update reply set rcontent='삭제된 댓글 입니다.' where rnum="+rnum;
			ps= con.prepareStatement(sql);
			ps.executeUpdate();
			if(rindex==0) { // 상위 댓글인경우
				replydelete3(rnum);
			}else {	// 하위 댓글인 경우
				replydelete2(rnum,rindex);
			}
			
			return true;
		}catch(Exception e) {System.out.println("댓글 삭제 오류 : "+e);}
		return false;
	}
	
	// 4-2. 대댓글 삭제할때 상위 댓글 판단
	public void replydelete2(int rnum, int rindex) {
		try {
			String sql = "select * from reply where rnum="+rindex;
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				if(rs.getString(4).equals("삭제된 댓글 입니다.")) {
					String sql2 = "delete from reply where rnum=?";
					PreparedStatement ps2;
					ps2 = con.prepareStatement(sql2);
					ps2.setInt(1, rindex);
					ps2.executeUpdate();
				}
			}
			
		} catch(Exception e) {System.out.println("댓글 삭제2 오류 : "+e);}
	}
	
	// 4-3.댓글 삭제할때 하위 댓글 판단
	public void replydelete3(int rnum) {
		try {
			ArrayList<Integer> reply = new ArrayList<Integer>();
			String sql = "select * from reply where rindex="+rnum;
			ps =con.prepareStatement(sql);
			rs = ps.executeQuery();
			boolean recheck = true;
			while(rs.next()) {
				if(!rs.getString(4).equals("삭제된 댓글 입니다.")) {
					recheck=false;
				}
				reply.add(rs.getInt(1));
			}
			if(recheck) {
				reply.add(rnum);
				for(int a : reply) {
					String sql2 = "delete from reply where rnum=?";
					PreparedStatement ps2;
					ps2 = con.prepareStatement(sql2);
					ps2.setInt(1, a);
					ps2.executeUpdate();
				}
				
			}
		}catch(Exception e) {System.out.println("댓글 삭제3 오류 : "+e);}
	}
	
	
	// 5. 로그인된 아이디가 작성한 댓글 불러오기
	public ArrayList<Reply> getmidreply(int mnum){
		try {
			ArrayList<Reply> midreplylist = new ArrayList<Reply>();
			String sql = "select * from reply where mnum="+mnum;
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Reply reply = new Reply(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), MemberDao.memberDao.getmid(rs.getInt(3)));
				midreplylist.add(reply);
			}
			return midreplylist;
		}catch(Exception e) {System.out.println("로그인된 아이디 댓글 불러오기 오류 : "+e);}
		return null;
	}
	
	// 6. 대댓글 불러오기 메소드
	public ArrayList<Reply> getrereply(int bnum, int rnum){
		try {
			ArrayList<Reply> replylist = new ArrayList<Reply>();
			String sql = "select * from reply where bnum="+bnum+" and rindex="+rnum;
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Reply reply = new Reply(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), MemberDao.memberDao.getmid(rs.getInt(3)));
				replylist.add(reply);
			}
			return replylist;
		}catch(Exception e) {System.out.println("대댓글 불러오기 오류 : "+e);}
		return null;
	}
	
	
}
