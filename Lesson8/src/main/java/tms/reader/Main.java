package tms.reader;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        FullName fullName = new FullName("Игорь", "Михаевич", "Александрович");
        Birthday birthday = new Birthday(27, "октябрь", 1997);
        Reader reader = new Reader(fullName, 115, Constant.ENERGY_FACULTY, birthday,
                "+375259334585");

        FullName fullName1 = new FullName("Дарья", "Гончарик", "Юрьевна");
        Birthday birthday1 = new Birthday(19, "май", 1998);
        Reader reader1 = new Reader(fullName1, 173, Constant.ARCHITECTURE_FACULTY, birthday1,
                "+375449751357");

        FullName fullName2 = new FullName("Никита", "Тихон", "Сергеевич");
        Birthday birthday2 = new Birthday(7, "июня", 2002);
        Reader reader3 = new Reader(fullName1, 173, Constant.AUTOMOTIVE_FACULTY, birthday1,
                "+375449324351");

        Reader[] readers = {reader, reader1, reader3};
        System.out.println(Arrays.toString(readers));

        System.out.println(reader.takeBook(11));
        System.out.println(reader.takeBook("Энциклопедия", "Словарь", "Приключения"));

        Book book = new Book("Энциклопедия", "Достоевский");
        Book book1 = new Book("Словарь", "Пушкин");
        Book book2 = new Book("Приключения", "Достоевский");

        System.out.println(reader.takeBook(book, book1, book2));
        System.out.println(reader.returnBook(37));
        System.out.println(reader.returnBook("Энциклопедия", "Словарь", "Приключения"));
    }
}
