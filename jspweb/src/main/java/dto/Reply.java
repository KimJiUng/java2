package dto;

import dao.MemberDao;

public class Reply {

	private int rnum;
	private int bnum;
	private int mnum;
	private String rcontent;
	private String rdate;
	private int rindex;
	private String mid;
	
	public Reply() {}

	public Reply(int rnum, int bnum, int mnum, String rcontent, String rdate, int rindex, String mid) {
		this.rnum = rnum;
		this.bnum = bnum;
		this.mnum = mnum;
		this.rcontent = rcontent;
		this.rdate = rdate;
		this.rindex = rindex;
		this.mid = MemberDao.memberDao.getmid(mnum);
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public int getBnum() {
		return bnum;
	}

	public void setBnum(int bnum) {
		this.bnum = bnum;
	}

	public int getMnum() {
		return mnum;
	}

	public void setMnum(int mnum) {
		this.mnum = mnum;
	}

	public String getRcontent() {
		return rcontent;
	}

	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public int getRindex() {
		return rindex;
	}

	public void setRindex(int rindex) {
		this.rindex = rindex;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	@Override
	public String toString() {
		return "Reply [rnum=" + rnum + ", bnum=" + bnum + ", mnum=" + mnum + ", rcontent=" + rcontent + ", rdate="
				+ rdate + ", rindex=" + rindex + ", mid=" + mid + "]";
	}

	
	
	
}
