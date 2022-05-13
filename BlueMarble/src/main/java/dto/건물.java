package dto;

public class 건물 {

	private int 건물번호;
	private int 건물종류번호;
	private int 플레이어번호;
	private int 게임판번호;
	private int 게임정보번호;
	
	public 건물() {	}

	public 건물(int 건물번호, int 건물종류번호, int 플레이어번호, int 게임판번호, int 게임정보번호) {
		super();
		this.건물번호 = 건물번호;
		this.건물종류번호 = 건물종류번호;
		this.플레이어번호 = 플레이어번호;
		this.게임판번호 = 게임판번호;
		this.게임정보번호 = 게임정보번호;
	}

	public int get건물번호() {
		return 건물번호;
	}

	public void set건물번호(int 건물번호) {
		this.건물번호 = 건물번호;
	}

	public int get건물종류번호() {
		return 건물종류번호;
	}

	public void set건물종류번호(int 건물종류번호) {
		this.건물종류번호 = 건물종류번호;
	}

	public int get플레이어번호() {
		return 플레이어번호;
	}

	public void set플레이어번호(int 플레이어번호) {
		this.플레이어번호 = 플레이어번호;
	}

	public int get게임판번호() {
		return 게임판번호;
	}

	public void set게임판번호(int 게임판번호) {
		this.게임판번호 = 게임판번호;
	}

	public int get게임정보번호() {
		return 게임정보번호;
	}

	public void set게임정보번호(int 게임정보번호) {
		this.게임정보번호 = 게임정보번호;
	}

	@Override
	public String toString() {
		return "건물 [건물번호=" + 건물번호 + ", 건물종류번호=" + 건물종류번호 + ", 플레이어번호=" + 플레이어번호 + ", 게임판번호=" + 게임판번호 + ", 게임정보번호="
				+ 게임정보번호 + "]";
	}
	
	
	
}
