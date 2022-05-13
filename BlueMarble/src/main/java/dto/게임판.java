package dto;

public class 게임판 {

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
	
	public 게임판() {	}
	
	public 게임판(int 게임판위치, String 도시이름, int 빈땅가격, int 별장가격, int 빌딩가격, int 호텔가격, int 빈땅통행료, int 별장통행료, int 빌딩통행료,
			int 호텔통행료) {
		this.게임판위치 = 게임판위치;
		this.도시이름 = 도시이름;
		this.빈땅가격 = 빈땅가격;
		this.별장가격 = 별장가격;
		this.빌딩가격 = 빌딩가격;
		this.호텔가격 = 호텔가격;
		this.빈땅통행료 = 빈땅통행료;
		this.별장통행료 = 별장통행료;
		this.빌딩통행료 = 빌딩통행료;
		this.호텔통행료 = 호텔통행료;
	}

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

	@Override
	public String toString() {
		return "게임판 [게임판위치=" + 게임판위치 + ", 도시이름=" + 도시이름 + ", 빈땅가격=" + 빈땅가격 + ", 별장가격=" + 별장가격 + ", 빌딩가격=" + 빌딩가격
				+ ", 호텔가격=" + 호텔가격 + ", 빈땅통행료=" + 빈땅통행료 + ", 별장통행료=" + 별장통행료 + ", 빌딩통행료=" + 빌딩통행료 + ", 호텔통행료=" + 호텔통행료
				+ "]";
	}
	
	
	
	
}
