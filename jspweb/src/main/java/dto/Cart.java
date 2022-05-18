package dto;

public class Cart {
	
	private int cart_num;
	private int pnum;
	private int mnum;
	private int snum;
	private int cart_selectamount;
	
	public Cart() {
		
	}

	public Cart(int cart_num, int pnum, int mnum, int snum, int cart_selectamount) {
		super();
		this.cart_num = cart_num;
		this.pnum = pnum;
		this.mnum = mnum;
		this.snum = snum;
		this.cart_selectamount = cart_selectamount;
	}

	public int getCart_num() {
		return cart_num;
	}

	public void setCart_num(int cart_num) {
		this.cart_num = cart_num;
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

	public int getCart_selectamount() {
		return cart_selectamount;
	}

	public void setCart_selectamount(int cart_selectamount) {
		this.cart_selectamount = cart_selectamount;
	}

	@Override
	public String toString() {
		return "Cart [cart_num=" + cart_num + ", pnum=" + pnum + ", mnum=" + mnum + ", snum=" + snum
				+ ", cart_selectamount=" + cart_selectamount + "]";
	}
	
	
	
}
