package book;

public class BookNavigator {
	private Book book;
	private int currentPage;
	
	public BookNavigator() {
		this.book = new Book();
		this.currentPage = 1;
	}
	public BookNavigator(Book book) {
		this.book = book;
	}
	public BookNavigator(Book book, int currentPage) {
		this.currentPage = currentPage;
	}
	
	public void goToNextPage() {
		this.currentPage++;
	}
	public void goToPrevPage() {
		this.currentPage--;
	}
	public void goToPage(int pageNumber) {
		this.currentPage = pageNumber;
	}
	
	public String getCurrentPage() {
		return "Current Page";
	}
}
