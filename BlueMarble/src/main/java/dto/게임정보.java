package dto;

public class 게임정보 {

	private int 게임정보번호;
	
	public 게임정보() {
		// TODO Auto-generated constructor stub
	}

	public 게임정보(int 게임정보번호) {
		super();
		this.게임정보번호 = 게임정보번호;
	}

	public int get게임정보번호() {
		return 게임정보번호;
	}

	public void set게임정보번호(int 게임정보번호) {
		this.게임정보번호 = 게임정보번호;
	}

	@Override
	public String toString() {
		return "게임정보 [게임정보번호=" + 게임정보번호 + "]";
	}
	
	
}
