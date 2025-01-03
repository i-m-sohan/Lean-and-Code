package book;

public class PlainTextPrinter implements Printer {

    @Override
    public void printPage(String page) {
        System.out.println(page);
    }
}

