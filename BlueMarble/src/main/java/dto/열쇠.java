package dto;

public class 열쇠 {

	private int 열쇠번호;
	private int 플레이어번호;
	private String 열쇠이름;
	private String 열쇠내용;
	
	public 열쇠() {
		// TODO Auto-generated constructor stub
	}

	public 열쇠(int 열쇠번호, int 플레이어번호, String 열쇠이름, String 열쇠내용) {
		super();
		this.열쇠번호 = 열쇠번호;
		this.플레이어번호 = 플레이어번호;
		this.열쇠이름 = 열쇠이름;
		this.열쇠내용 = 열쇠내용;
	}

	public int get열쇠번호() {
		return 열쇠번호;
	}

	public void set열쇠번호(int 열쇠번호) {
		this.열쇠번호 = 열쇠번호;
	}

	public int get플레이어번호() {
		return 플레이어번호;
	}

	public void set플레이어번호(int 플레이어번호) {
		this.플레이어번호 = 플레이어번호;
	}

	public String get열쇠이름() {
		return 열쇠이름;
	}

	public void set열쇠이름(String 열쇠이름) {
		this.열쇠이름 = 열쇠이름;
	}

	public String get열쇠내용() {
		return 열쇠내용;
	}

	public void set열쇠내용(String 열쇠내용) {
		this.열쇠내용 = 열쇠내용;
	}

	@Override
	public String toString() {
		return "열쇠 [열쇠번호=" + 열쇠번호 + ", 플레이어번호=" + 플레이어번호 + ", 열쇠이름=" + 열쇠이름 + ", 열쇠내용=" + 열쇠내용 + "]";
	}
	
	
	
	
}
