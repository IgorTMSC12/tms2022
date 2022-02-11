package tms.reader;

import java.util.Arrays;

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
        String result;
        if (getBook % 10 == 1 && getBook % 100 != 11) {
            result = fullName + " взял " + getBook + " книгу";
        } else if (getBook % 10 >= 2 && getBook % 10 <= 4) {
            if (getBook % 100 >= 12 && getBook % 100 <= 14) {
                result = fullName + " взял " + getBook + " книг";
            } else {
                result = fullName + " взял " + getBook + " книги";
            }
        } else {
            result = fullName + " взял " + getBook + " книг";
        }
        return result;
    }

    public String takeBook(String... book) {
        String[] books = book;
        String result = fullName + " взял книги: " + Arrays.toString(books);
        return result;
    }

    public String takeBook(Book... book) {
        Book[] books = book;
        String result = fullName + " взял книги: " + Arrays.toString(books);
        return result;
    }

    public String returnBook(int countBook) {
        String result;
        if (countBook % 10 == 1 && countBook % 100 != 11) {
            result = fullName + " вернул " + countBook + " книгу";
        } else if (countBook % 10 >= 2 && countBook % 10 <= 4) {
            if (countBook % 100 >= 12 && countBook % 100 <= 14) {
                result = fullName + " вернул " + countBook + " книг";
            } else {
                result = fullName + " вернул " + countBook + " книги";
            }
        } else {
            result = fullName + " вернул " + countBook + " книг";
        }
        return result;
    }

    public String returnBook(String... book) {
        String[] books = book;
        String result = fullName + " вернул книги: " + Arrays.toString(books);
        return result;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "fullName=" + fullName +
                ", libraryCardNumber=" + libraryCardNumber +
                ", faculty='" + faculty + '\'' +
                ", birthday=" + birthday +
                ", numberPhone=" + numberPhone +
                '}';
    }
}
