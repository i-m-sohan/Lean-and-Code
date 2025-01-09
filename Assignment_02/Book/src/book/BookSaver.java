package book;

import java.io.FileWriter;
import java.io.IOException;

public class BookSaver {
    public void save(Book book) {
        String filename = book.getTitle() + " - " + book.getAuthor() + "_progress.txt";  
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("Title: " + book.getTitle() + "\n");
            writer.write("Author: " + book.getAuthor() + "\n");
        } catch (IOException e) {
            System.out.println("Error saving the current page: " + e.getMessage());
        }
    }
}
