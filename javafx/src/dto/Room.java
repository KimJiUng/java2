package dto;

public class Room {

	private int roomnum;
	private String roomname;
	private String roomip;
	private int mcount; // ���� �� �ο��� [db���� ���� �ʵ�]
	
	public Room() {}
	
	public Room(int roomnum, String roomname, String roomip, int mcount) {
		this.roomnum = roomnum;
		this.roomname = roomname;
		this.roomip = roomip;
		this.mcount = mcount;
	}
	
	public int getMcount() {
		return mcount;
	}

	public void setMcount(int mcount) {
		this.mcount = mcount;
	}

	public int getRoomnum() {
		return roomnum;
	}

	public void setRoomnum(int roomnum) {
		this.roomnum = roomnum;
	}

	public String getRoomname() {
		return roomname;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	public String getRoomip() {
		return roomip;
	}

	public void setRoomip(String roomip) {
		this.roomip = roomip;
	}
	
	
	
	
	
}
