package dto;

public class 건물종류 {

	private int 건물종류번호;
	private String 건물종류;
	
	public 건물종류() {
		// TODO Auto-generated constructor stub
	}

	public 건물종류(int 건물종류번호, String 건물종류) {
		super();
		this.건물종류번호 = 건물종류번호;
		this.건물종류 = 건물종류;
	}

	public int get건물종류번호() {
		return 건물종류번호;
	}

	public void set건물종류번호(int 건물종류번호) {
		this.건물종류번호 = 건물종류번호;
	}

	public String get건물종류() {
		return 건물종류;
	}

	public void set건물종류(String 건물종류) {
		this.건물종류 = 건물종류;
	}

	@Override
	public String toString() {
		return "건물종류 [건물종류번호=" + 건물종류번호 + ", 건물종류=" + 건물종류 + "]";
	}
	
	
	
	
}
