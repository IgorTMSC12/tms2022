package tms.reader;

import lombok.ToString;

import java.util.Arrays;

@ToString
public class Reader {
    private FullName fullName;
    private int libraryCardNumber;
    private String faculty;
    private Birthday birthday;
    private String numberPhone;
    private Book book;

    public Reader(FullName fullName, int libraryCardNumber, String faculty, Birthday birthday, String numberPhone) {
        this.fullName = fullName;
        this.libraryCardNumber = libraryCardNumber;
        this.faculty = faculty;
        this.birthday = birthday;
        this.numberPhone = numberPhone;
    }

    public String takeBook(int getBook) {
        String a = " взял ";
        String result = metod1(getBook, a);
        return result;
    }

    public String takeBook(String... book) {
        String[] books = book;
        String result = fullName + " взял книги: " + Arrays.toString(books);
        return result;
    }

    public String takeBook(Book... books) {
        String result = fullName + " взял книги: " + Arrays.toString(books);
        return result;
    }

    public String returnBook(int countBook) {
        String a = " вернул ";
        String result = metod1(countBook, a);
        return result;
    }

    public String metod1(int countBook, String a) {
        String result;
        if (countBook % 10 == 1 && countBook % 100 != 11) {
            result = fullName + a + countBook + " книгу";
        } else if (countBook % 10 >= 2 && countBook % 10 <= 4) {
            if (countBook % 100 >= 12 && countBook % 100 <= 14) {
                result = fullName + a + countBook + " книг";
            } else {
                result = fullName + a + countBook + " книги";
            }
        } else {
            result = fullName + a + countBook + " книг";
        }
        return result;
    }

    public String returnBook(String... book) {
        String[] books = book;
        String result = fullName + " вернул книги: " + Arrays.toString(books);
        return result;
    }

}