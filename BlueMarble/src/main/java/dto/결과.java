package dto;

public class 결과 {

	private int 결과번호;
	private int 게임정보번호;
	private int 플레이어번호;
	private String 게임결과;
	
	public 결과() {
		// TODO Auto-generated constructor stub
	}

	public 결과(int 결과번호, int 게임정보번호, int 플레이어번호, String 게임결과) {
		super();
		this.결과번호 = 결과번호;
		this.게임정보번호 = 게임정보번호;
		this.플레이어번호 = 플레이어번호;
		this.게임결과 = 게임결과;
	}

	public int get결과번호() {
		return 결과번호;
	}

	public void set결과번호(int 결과번호) {
		this.결과번호 = 결과번호;
	}

	public int get게임정보번호() {
		return 게임정보번호;
	}

	public void set게임정보번호(int 게임정보번호) {
		this.게임정보번호 = 게임정보번호;
	}

	public int get플레이어번호() {
		return 플레이어번호;
	}

	public void set플레이어번호(int 플레이어번호) {
		this.플레이어번호 = 플레이어번호;
	}

	public String get게임결과() {
		return 게임결과;
	}

	public void set게임결과(String 게임결과) {
		this.게임결과 = 게임결과;
	}

	@Override
	public String toString() {
		return "결과 [결과번호=" + 결과번호 + ", 게임정보번호=" + 게임정보번호 + ", 플레이어번호=" + 플레이어번호 + ", 게임결과=" + 게임결과 + "]";
	}
	
	
	
	
	
}
