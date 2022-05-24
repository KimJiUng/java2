package dto;

public class Porder {
	
	private int ordernum;
	private String orderdate;
	private int ordertotalpay;
	private int orderdetailactive;
	private String scolor;
	private String ssize;
	private String pname;
	private int pprice;
	private float pdiscount;
	private int samount;
	private int totalprice;
	private String pimg;
	
	public Porder() {
		// TODO Auto-generated constructor stub
	}

	
	
	



	public Porder(int ordernum, String orderdate, int ordertotalpay, int orderdetailactive, String scolor, String ssize,
			String pname, int pprice, float pdiscount, int samount, int totalprice, String pimg) {
		super();
		this.ordernum = ordernum;
		this.orderdate = orderdate;
		this.ordertotalpay = ordertotalpay;
		this.orderdetailactive = orderdetailactive;
		this.scolor = scolor;
		this.ssize = ssize;
		this.pname = pname;
		this.pprice = pprice;
		this.pdiscount = pdiscount;
		this.samount = samount;
		this.totalprice = totalprice;
		this.pimg = pimg;
	}

	public String getPimg() {
		return pimg;
	}



	public void setPimg(String pimg) {
		this.pimg = pimg;
	}


	public int getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(int ordernum) {
		this.ordernum = ordernum;
	}

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	public int getOrdertotalpay() {
		return ordertotalpay;
	}

	public void setOrdertotalpay(int ordertotalpay) {
		this.ordertotalpay = ordertotalpay;
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







	@Override
	public String toString() {
		return "Porder [ordernum=" + ordernum + ", orderdate=" + orderdate + ", ordertotalpay=" + ordertotalpay
				+ ", orderdetailactive=" + orderdetailactive + ", scolor=" + scolor + ", ssize=" + ssize + ", pname="
				+ pname + ", pprice=" + pprice + ", pdiscount=" + pdiscount + ", samount=" + samount + ", totalprice="
				+ totalprice + ", pimg=" + pimg + "]";
	}

	

	
	
	
}
