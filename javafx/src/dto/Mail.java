package dto;

public class Mail {

	private int mailnum;
	private String msendid;
	private String mreciveid;
	private String mcontent;
	private String maildate;
	
	public Mail() {	}
	
	public Mail(int mailnum, String msendid, String mreciveid, String mcontent, String maildate) {
		this.mailnum = mailnum;
		this.msendid = msendid;
		this.mreciveid = mreciveid;
		this.mcontent = mcontent;
		this.maildate = maildate;
	}

	public int getMailnum() {
		return mailnum;
	}

	public void setMailnum(int mailnum) {
		this.mailnum = mailnum;
	}

	public String getMsendid() {
		return msendid;
	}

	public void setMsendid(String msendid) {
		this.msendid = msendid;
	}

	public String getMreciveid() {
		return mreciveid;
	}

	public void setMreciveid(String mreciveid) {
		this.mreciveid = mreciveid;
	}

	public String getMcontent() {
		return mcontent;
	}

	public void setMcontent(String mcontent) {
		this.mcontent = mcontent;
	}

	public String getMaildate() {
		return maildate;
	}

	public void setMaildate(String maildate) {
		this.maildate = maildate;
	}
	
	
	
	
}
