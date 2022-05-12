package dto;

public class Product {

	private int pnum;
	private String pname;
	private int pprice;
	private float pdiscount;
	private int pactive;
	private String pimg;
	private int cg_num;
	
	public Product() {}

	public Product(int pnum, String pname, int pprice, float pdiscount, int pactive, String pimg, int cg_num) {
		this.pnum = pnum;
		this.pname = pname;
		this.pprice = pprice;
		this.pdiscount = pdiscount;
		this.pactive = pactive;
		this.pimg = pimg;
		this.cg_num = cg_num;
	}

	public int getPnum() {
		return pnum;
	}

	public void setPnum(int pnum) {
		this.pnum = pnum;
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

	public int getPactive() {
		return pactive;
	}

	public void setPactive(int pactive) {
		this.pactive = pactive;
	}

	public String getPimg() {
		return pimg;
	}

	public void setPimg(String pimg) {
		this.pimg = pimg;
	}

	public int getCg_num() {
		return cg_num;
	}

	public void setCg_num(int cg_num) {
		this.cg_num = cg_num;
	}

	@Override
	public String toString() {
		return "Product [pnum=" + pnum + ", pname=" + pname + ", pprice=" + pprice + ", pdiscount=" + pdiscount
				+ ", pactive=" + pactive + ", pimg=" + pimg + ", cg_num=" + cg_num + "]";
	}
	
	
}
