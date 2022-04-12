package dto;

public class Reply {

	private int rnum;
	private String rwriter;
	private String rdate;
	private String rcontent;
	private int bnum;
	private int pnum;
	
	public Reply() {}

	public Reply(int rnum, String rwriter, String rdate, String rcontent, int bnum, int pnum) {
		this.rnum = rnum;
		this.rwriter = rwriter;
		this.rdate = rdate;
		this.rcontent = rcontent;
		this.bnum = bnum;
		this.pnum = pnum;
	}

	public int getPnum() {
		return pnum;
	}

	public void setPnum(int pnum) {
		this.pnum = pnum;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public String getRwriter() {
		return rwriter;
	}

	public void setRwriter(String rwriter) {
		this.rwriter = rwriter;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public String getRcontent() {
		return rcontent;
	}

	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}


	public int getBnum() {
		return bnum;
	}


	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	
	
	
	
	
}
