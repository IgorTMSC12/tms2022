package task4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static final String TEXT = "Lesson14/src/main/resources/textTask3.txt";

    public static void main(String[] args) throws Exception {
        Car car = new Car("BMW", TypeEngine.GAS_ENGINE, 8,
                TypeTank.GAS_TANK, 40, 100, 15000);
        FileOutputStream fileInputStream = new FileOutputStream("Lesson14/src/main/resources/saveTask4.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileInputStream);
        objectOutputStream.writeObject(car);

        FileInputStream fileInputStream1 = new FileInputStream("Lesson14/src/main/resources/saveTask4.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream1);
        Car car1 = (Car) objectInputStream.readObject();
        System.out.println(car1);
    }
}
//4) Сериализовать объект Автомобиль(Марка, Двигатель(тип двигателя, количество цилиндров),
//   бак(тип топлива, объем), скорость, цена). Количество цилиндров не должно сереализоватся в
//   файл(это конфедициальная информация)
//     * После сериализации произвести обратный процесс(из потока в объект) и вывести на консоль
