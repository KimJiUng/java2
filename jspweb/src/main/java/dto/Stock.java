package dto;

public class Stock {

	private int snum;
	private String scolor;
	private String ssize;
	private int samount;
	private String sfirstdate;
	private String supdatedate;
	private int pnum;
	
	public Stock() {}

	public Stock(int snum, String scolor, String ssize, int samount, String sfirstdate, String supdatedate, int pnum) {
		this.snum = snum;
		this.scolor = scolor;
		this.ssize = ssize;
		this.samount = samount;
		this.sfirstdate = sfirstdate;
		this.supdatedate = supdatedate;
		this.pnum = pnum;
	}

	public int getSnum() {
		return snum;
	}

	public void setSnum(int snum) {
		this.snum = snum;
	}

	public String getScolor() {
		return scolor;
	}

	public void setScolor(String scolor) {
		this.scolor = scolor;
	}

	public String getSsize() {
		return ssize;
	}

	public void setSsize(String ssize) {
		this.ssize = ssize;
	}

	public int getSamount() {
		return samount;
	}

	public void setSamount(int samount) {
		this.samount = samount;
	}

	public String getSfirstdate() {
		return sfirstdate;
	}

	public void setSfirstdate(String sfirstdate) {
		this.sfirstdate = sfirstdate;
	}

	public String getSupdatedate() {
		return supdatedate;
	}

	public void setSupdatedate(String supdatedate) {
		this.supdatedate = supdatedate;
	}

	public int getPnum() {
		return pnum;
	}

	public void setPnum(int pnum) {
		this.pnum = pnum;
	}

	@Override
	public String toString() {
		return "Stock [snum=" + snum + ", scolor=" + scolor + ", ssize=" + ssize + ", samount=" + samount
				+ ", sfirstdate=" + sfirstdate + ", supdatedate=" + supdatedate + ", pnum=" + pnum + "]";
	}
	
	
	
}
