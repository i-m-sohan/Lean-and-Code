package book;

public class Main {
    public static void main(String[] args) {
    	
        Book learnAndCodeBook = new Book("Learn and Code", "John Doe",1,2);
        BookNavigator bookNavigator = new BookNavigator(learnAndCodeBook);
        
        System.out.println("Title : "+learnAndCodeBook.getTitle() + "\n"+"Author : "+ learnAndCodeBook.getAuthor() + "\n"+
        		"Location : " + learnAndCodeBook.getLocation());
        bookNavigator.goToNextPage();
        bookNavigator.goToPage(45);

        Printer printer = new PlainTextPrinter();
        String page = bookNavigator.getCurrentPage();
        printer.printPage(page);

        BookSaver bookSaver = new BookSaver();
        bookSaver.save(learnAndCodeBook);

    }
}

