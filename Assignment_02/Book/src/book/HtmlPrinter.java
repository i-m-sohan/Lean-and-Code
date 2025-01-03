package book;

public class HtmlPrinter implements Printer {

    @Override
    public void printPage(String page) {
        System.out.println("<div style=\"single-page\">" + page + "</div>");
    }
}