package book;

public class BookLocation {
	private Integer shelfNumber;
	private Integer roomNumber;
	
	public BookLocation() {
	}
	public BookLocation(int shelfNumber,int roomNumber){
		this.shelfNumber = shelfNumber;
		this.roomNumber = roomNumber;
	}
	public void setShelfNumber(int shelfNumber) {
		this.shelfNumber = shelfNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public int getShelfNumber() {
		return this.shelfNumber;
	}
	public int getRoomNumber() {
		return this.roomNumber;
	}
}
