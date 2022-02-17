package tms.reader;

import lombok.ToString;

@ToString
public class Book {
    private String nameBook;
    private String authorBook;

    public Book(String nameBook, String authorBook) {
        this.nameBook = nameBook;
        this.authorBook = authorBook;
    }

}
