package dto;

public class Dto {

	private int 게임판위치;
	private String 도시이름;
	private int 빈땅가격;
	private int 별장가격;
	private int 빌딩가격;
	private int 호텔가격;
	private int 빈땅통행료;
	private int 별장통행료;
	private int 빌딩통행료;
	private int 호텔통행료;
	private int 플레이어번호;
	private String 플레이어닉네임;
	private int 소유자금;
	private int 현재위치;
	private int 턴;
	private int 무인도;
	private int 순서;
	private int 건물종류번호;
	private String 건물종류;
	private int 열쇠번호;
	private String 열쇠이름;
	private String 열쇠내용;
	private int 결과번호;
	private String 게임결과;
	private int 게임정보번호;
	
	public Dto() {	}

	public int get게임판위치() {
		return 게임판위치;
	}

	public void set게임판위치(int 게임판위치) {
		this.게임판위치 = 게임판위치;
	}

	public String get도시이름() {
		return 도시이름;
	}

	public void set도시이름(String 도시이름) {
		this.도시이름 = 도시이름;
	}

	public int get빈땅가격() {
		return 빈땅가격;
	}

	public void set빈땅가격(int 빈땅가격) {
		this.빈땅가격 = 빈땅가격;
	}

	public int get별장가격() {
		return 별장가격;
	}

	public void set별장가격(int 별장가격) {
		this.별장가격 = 별장가격;
	}

	public int get빌딩가격() {
		return 빌딩가격;
	}

	public void set빌딩가격(int 빌딩가격) {
		this.빌딩가격 = 빌딩가격;
	}

	public int get호텔가격() {
		return 호텔가격;
	}

	public void set호텔가격(int 호텔가격) {
		this.호텔가격 = 호텔가격;
	}

	public int get빈땅통행료() {
		return 빈땅통행료;
	}

	public void set빈땅통행료(int 빈땅통행료) {
		this.빈땅통행료 = 빈땅통행료;
	}

	public int get별장통행료() {
		return 별장통행료;
	}

	public void set별장통행료(int 별장통행료) {
		this.별장통행료 = 별장통행료;
	}

	public int get빌딩통행료() {
		return 빌딩통행료;
	}

	public void set빌딩통행료(int 빌딩통행료) {
		this.빌딩통행료 = 빌딩통행료;
	}

	public int get호텔통행료() {
		return 호텔통행료;
	}

	public void set호텔통행료(int 호텔통행료) {
		this.호텔통행료 = 호텔통행료;
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

	public int get열쇠번호() {
		return 열쇠번호;
	}

	public void set열쇠번호(int 열쇠번호) {
		this.열쇠번호 = 열쇠번호;
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

	public int get결과번호() {
		return 결과번호;
	}

	public void set결과번호(int 결과번호) {
		this.결과번호 = 결과번호;
	}

	public String get게임결과() {
		return 게임결과;
	}

	public void set게임결과(String 게임결과) {
		this.게임결과 = 게임결과;
	}

	public int get게임정보번호() {
		return 게임정보번호;
	}

	public void set게임정보번호(int 게임정보번호) {
		this.게임정보번호 = 게임정보번호;
	}

	@Override
	public String toString() {
		return "Dto [게임판위치=" + 게임판위치 + ", 도시이름=" + 도시이름 + ", 빈땅가격=" + 빈땅가격 + ", 별장가격=" + 별장가격 + ", 빌딩가격=" + 빌딩가격
				+ ", 호텔가격=" + 호텔가격 + ", 빈땅통행료=" + 빈땅통행료 + ", 별장통행료=" + 별장통행료 + ", 빌딩통행료=" + 빌딩통행료 + ", 호텔통행료=" + 호텔통행료
				+ ", 플레이어번호=" + 플레이어번호 + ", 플레이어닉네임=" + 플레이어닉네임 + ", 소유자금=" + 소유자금 + ", 현재위치=" + 현재위치 + ", 턴=" + 턴
				+ ", 무인도=" + 무인도 + ", 순서=" + 순서 + ", 건물종류번호=" + 건물종류번호 + ", 건물종류=" + 건물종류 + ", 열쇠번호=" + 열쇠번호 + ", 열쇠이름="
				+ 열쇠이름 + ", 열쇠내용=" + 열쇠내용 + ", 결과번호=" + 결과번호 + ", 게임결과=" + 게임결과 + ", 게임정보번호=" + 게임정보번호 + "]";
	}
	
	
	
}
