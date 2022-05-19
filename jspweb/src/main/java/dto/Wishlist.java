package dto;

public class Wishlist {
	
	private int wnum;
	private int pnum;
	private int mnum;
	private int snum;
	private int wamount;

	
	public Wishlist() {
		// TODO Auto-generated constructor stub
	}


	public Wishlist(int wnum, int pnum, int mnum, int snum, int wamount) {
		super();
		this.wnum = wnum;
		this.pnum = pnum;
		this.mnum = mnum;
		this.snum = snum;
		this.wamount = wamount;
	}


	public int getWnum() {
		return wnum;
	}


	public void setWnum(int wnum) {
		this.wnum = wnum;
	}


	public int getPnum() {
		return pnum;
	}


	public void setPnum(int pnum) {
		this.pnum = pnum;
	}


	public int getMnum() {
		return mnum;
	}


	public void setMnum(int mnum) {
		this.mnum = mnum;
	}


	public int getSnum() {
		return snum;
	}


	public void setSnum(int snum) {
		this.snum = snum;
	}


	public int getWamount() {
		return wamount;
	}


	public void setWamount(int wamount) {
		this.wamount = wamount;
	}


	@Override
	public String toString() {
		return "Wishlist [wnum=" + wnum + ", pnum=" + pnum + ", mnum=" + mnum + ", snum=" + snum + ", wamount="
				+ wamount + "]";
	}
	
	
}
