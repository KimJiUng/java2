package dto;

public class Member {

	private int mnum;
	private String mid;
	private String mpassword;
	private String mname;
	private String mphone;
	private String memail;
	private String maddress;
	private int mpoint;
	private String msince;
	
	public Member() {}
	
	public Member(int mnum, String mid, String mpassword, String mname, String mphone, String memail, String maddress,
			int mpoint, String msince) {
		this.mnum = mnum;
		this.mid = mid;
		this.mpassword = mpassword;
		this.mname = mname;
		this.mphone = mphone;
		this.memail = memail;
		this.maddress = maddress;
		this.mpoint = mpoint;
		this.msince = msince;
	}

	public int getMnum() {
		return mnum;
	}

	public void setMnum(int mnum) {
		this.mnum = mnum;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpassword() {
		return mpassword;
	}

	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMphone() {
		return mphone;
	}

	public void setMphone(String mphone) {
		this.mphone = mphone;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public String getMaddress() {
		return maddress;
	}

	public void setMaddress(String maddress) {
		this.maddress = maddress;
	}

	public int getMpoint() {
		return mpoint;
	}

	public void setMpoint(int mpoint) {
		this.mpoint = mpoint;
	}

	public String getMsince() {
		return msince;
	}

	public void setMsince(String msince) {
		this.msince = msince;
	}

	@Override
	public String toString() {
		return "Member [mnum=" + mnum + ", mid=" + mid + ", mpassword=" + mpassword + ", mname=" + mname + ", mphone="
				+ mphone + ", memail=" + memail + ", maddress=" + maddress + ", mpoint=" + mpoint + ", msince=" + msince
				+ "]";
	}
	
	
	
	
	
}
