package dto;

public class Board {

	private int bnum;
	private String btitle;
	private String bcontent;
	private int mnum;
	private int bview;
	private String bdate;
	private String bfile;
	private String mid;
	
	public Board() {}

	
	public Board(int bnum, String btitle, String bcontent, int mnum, int bview, String bdate, String bfile,
			String mid) {
		this.bnum = bnum;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.mnum = mnum;
		this.bview = bview;
		this.bdate = bdate;
		this.bfile = bfile;
		this.mid = mid;
	}

	

	public String getMid() {
		return mid;
	}


	public void setMid(String mid) {
		this.mid = mid;
	}


	public int getBnum() {
		return bnum;
	}

	public void setBnum(int bnum) {
		this.bnum = bnum;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public int getMnum() {
		return mnum;
	}

	public void setMnum(int mnum) {
		this.mnum = mnum;
	}

	public int getBview() {
		return bview;
	}

	public void setBview(int bview) {
		this.bview = bview;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public String getBfile() {
		return bfile;
	}

	public void setBfile(String bfile) {
		this.bfile = bfile;
	}

	@Override
	public String toString() {
		return "Board [bnum=" + bnum + ", btitle=" + btitle + ", bcontent=" + bcontent + ", mnum=" + mnum + ", bview="
				+ bview + ", bdate=" + bdate + ", bfile=" + bfile + "]";
	}
	
	
	
	
}
