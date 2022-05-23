package dto;

public class Orderdetail {
	
	private int orderdetailnum;
	private int orderdetailactive;
	private String scolor;
	private String ssize;
	private String pname;
	private int pprice;
	private float pdiscount;
	private int samount;
	private int totalprice;
	private int ordernum;
	
	public Orderdetail() {
		// TODO Auto-generated constructor stub
	}

	public Orderdetail(int orderdetailnum, int orderdetailactive, String scolor, String ssize, String pname, int pprice,
			float pdiscount, int samount, int totalprice, int ordernum) {
		super();
		this.orderdetailnum = orderdetailnum;
		this.orderdetailactive = orderdetailactive;
		this.scolor = scolor;
		this.ssize = ssize;
		this.pname = pname;
		this.pprice = pprice;
		this.pdiscount = pdiscount;
		this.samount = samount;
		this.totalprice = totalprice;
		this.ordernum = ordernum;
	}

	public int getOrderdetailnum() {
		return orderdetailnum;
	}

	public void setOrderdetailnum(int orderdetailnum) {
		this.orderdetailnum = orderdetailnum;
	}

	public int getOrderdetailactive() {
		return orderdetailactive;
	}

	public void setOrderdetailactive(int orderdetailactive) {
		this.orderdetailactive = orderdetailactive;
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

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPprice() {
		return pprice;
	}

	public void setPprice(int pprice) {
		this.pprice = pprice;
	}

	public float getPdiscount() {
		return pdiscount;
	}

	public void setPdiscount(float pdiscount) {
		this.pdiscount = pdiscount;
	}

	public int getSamount() {
		return samount;
	}

	public void setSamount(int samount) {
		this.samount = samount;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public int getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(int ordernum) {
		this.ordernum = ordernum;
	}

	@Override
	public String toString() {
		return "Orderdetail [orderdetailnum=" + orderdetailnum + ", orderdetailactive=" + orderdetailactive
				+ ", scolor=" + scolor + ", ssize=" + ssize + ", pname=" + pname + ", pprice=" + pprice + ", pdiscount="
				+ pdiscount + ", samount=" + samount + ", totalprice=" + totalprice + ", ordernum=" + ordernum + "]";
	}
	
	
	
}
