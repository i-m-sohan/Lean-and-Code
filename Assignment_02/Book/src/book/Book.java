package book;

public class Book {
	private String author;
	private String title;
	private BookLocation location;
	
	public Book() {
	}
	public Book(String author,String title) {
		this.author = author;
		this.title = title;
		this.location = new BookLocation();
	}
	public Book(String author,String title,int shelfNumber,int roomNumber) {
		this.author = author;
		this.title = title;
		this.location = new BookLocation(shelfNumber, roomNumber);
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setLocation(int shelfNumber,int roomNumber) {
		this.location.setRoomNumber(roomNumber);
		this.location.setShelfNumber(shelfNumber);
	}
	
	public String getAuthor() {
		return this.author;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public Integer getShelfNumber() {
		return this.location.getShelfNumber();
	}
	
	public Integer getRoomNumber() {
		return this.location.getRoomNumber();
	}
	
	public String getLocation() {
		return "Shelf number  : " + this.location.getShelfNumber()+", Room Number : "+this.location.getRoomNumber();
	}
}
