package dto;

public class Wishlist {
	
	private int wnum;
	private int pnum;
	private int mnum;
	private String wcolor;
	private String wsize;
	private int wamount;
	private int wrealprice;
	private int wsavemoney;
	
	public Wishlist() {
		// TODO Auto-generated constructor stub
	}

	public Wishlist(int wnum, int pnum, int mnum, String wcolor, String wsize, int wamount, int wrealprice,
			int wsavemoney) {
		super();
		this.wnum = wnum;
		this.pnum = pnum;
		this.mnum = mnum;
		this.wcolor = wcolor;
		this.wsize = wsize;
		this.wamount = wamount;
		this.wrealprice = wrealprice;
		this.wsavemoney = wsavemoney;
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

	public String getWcolor() {
		return wcolor;
	}

	public void setWcolor(String wcolor) {
		this.wcolor = wcolor;
	}

	public String getWsize() {
		return wsize;
	}

	public void setWsize(String wsize) {
		this.wsize = wsize;
	}

	public int getWamount() {
		return wamount;
	}

	public void setWamount(int wamount) {
		this.wamount = wamount;
	}

	public int getWrealprice() {
		return wrealprice;
	}

	public void setWrealprice(int wrealprice) {
		this.wrealprice = wrealprice;
	}

	public int getWsavemoney() {
		return wsavemoney;
	}

	public void setWsavemoney(int wsavemoney) {
		this.wsavemoney = wsavemoney;
	}

	@Override
	public String toString() {
		return "Wishlist [wnum=" + wnum + ", pnum=" + pnum + ", mnum=" + mnum + ", wcolor=" + wcolor + ", wsize="
				+ wsize + ", wamount=" + wamount + ", wrealprice=" + wrealprice + ", wsavemoney=" + wsavemoney + "]";
	}
	
	
	
	
}
