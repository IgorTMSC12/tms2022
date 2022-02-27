package Car;

public class Main {
    public static void main(String[] args) {
        Car car = new Car(BrandCarType.OPEL, 120, 10_000);
        try {
            car.start();
        } catch (MyException myException) {
            System.out.println(myException.getMessage());
        }
    }
}

//1) Можно добработать свой авто из предыдущей домашки, а можно заново сделать.
//     * Создать собственное исключение.
//     * - Создать класс Car.Car c полями (марка, скорость, цена), конструкторы (с параметрами и default)
//       гетеры-сетеры.
//     * Создать метод старт в котором пытаетесь завести автомобиль. В методе старт генерируете случайное
//       число от 0 до 20, если полученное число оказалось четным,
//     * то выбрасываете созданное ранее вами исключение и передаете его к месту откуда вызывали метод старт.
//       Если все хорошо и исключение не вылетело,
//     * то выводить в консоль сообщение что автомобиль с такой-то маркой завелся.
//     * В main создаете парочку автомобилей и пытаетесь их завести. И обрабатываете исключение которое может
//       вылететь при старте автомобиля
