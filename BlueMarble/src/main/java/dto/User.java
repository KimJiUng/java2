package dto;

public class User {

	private String name;
	private int dice;
	private int turn;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String name, int dice, int turn) {
		super();
		this.name = name;
		this.dice = dice;
		this.turn = turn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDice() {
		return dice;
	}

	public void setDice(int dice) {
		this.dice = dice;
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", dice=" + dice + ", turn=" + turn + "]";
	}
	
	
}
