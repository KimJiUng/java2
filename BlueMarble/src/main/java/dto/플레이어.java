package dto;

public class 플레이어 {

	private int 플레이어번호;
	private String 플레이어닉네임;
	private int 소유자금;
	private int 현재위치;
	private int 턴;
	private int 무인도;
	private int 순서;
	private int 게임정보번호;
	
	public 플레이어() {
		// TODO Auto-generated constructor stub
	}

	public 플레이어(int 플레이어번호, String 플레이어닉네임, int 소유자금, int 현재위치, int 턴, int 무인도, int 순서, int 게임정보번호) {
		super();
		this.플레이어번호 = 플레이어번호;
		this.플레이어닉네임 = 플레이어닉네임;
		this.소유자금 = 소유자금;
		this.현재위치 = 현재위치;
		this.턴 = 턴;
		this.무인도 = 무인도;
		this.순서 = 순서;
		this.게임정보번호 = 게임정보번호;
	}

	public int get플레이어번호() {
		return 플레이어번호;
	}

	public void set플레이어번호(int 플레이어번호) {
		this.플레이어번호 = 플레이어번호;
	}

	public String get플레이어닉네임() {
		return 플레이어닉네임;
	}

	public void set플레이어닉네임(String 플레이어닉네임) {
		this.플레이어닉네임 = 플레이어닉네임;
	}

	public int get소유자금() {
		return 소유자금;
	}

	public void set소유자금(int 소유자금) {
		this.소유자금 = 소유자금;
	}

	public int get현재위치() {
		return 현재위치;
	}

	public void set현재위치(int 현재위치) {
		this.현재위치 = 현재위치;
	}

	public int get턴() {
		return 턴;
	}

	public void set턴(int 턴) {
		this.턴 = 턴;
	}

	public int get무인도() {
		return 무인도;
	}

	public void set무인도(int 무인도) {
		this.무인도 = 무인도;
	}

	public int get순서() {
		return 순서;
	}

	public void set순서(int 순서) {
		this.순서 = 순서;
	}

	public int get게임정보번호() {
		return 게임정보번호;
	}

	public void set게임정보번호(int 게임정보번호) {
		this.게임정보번호 = 게임정보번호;
	}

	@Override
	public String toString() {
		return "플레이어 [플레이어번호=" + 플레이어번호 + ", 플레이어닉네임=" + 플레이어닉네임 + ", 소유자금=" + 소유자금 + ", 현재위치=" + 현재위치 + ", 턴=" + 턴
				+ ", 무인도=" + 무인도 + ", 순서=" + 순서 + ", 게임정보번호=" + 게임정보번호 + "]";
	}
	
	
	
	
	
}
