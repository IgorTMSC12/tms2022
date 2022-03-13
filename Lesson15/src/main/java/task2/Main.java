package task2;

public class Main {
    public static void main(String[] args) {
        String name = "OK";
        Animal name1 = new Animal("Dog");
        Number name2 = 15;
        GenericClass<String, Animal, Number> genericClass = new GenericClass<>(name, name1, name2);
        genericClass.info();
        System.out.println(genericClass.getT());
        System.out.println(genericClass.getV());
        System.out.println(genericClass.getK());
    }
}

//2) Обобщенный класс с тремя параметрами
//     * Создать обобщенный класс с тремя параметрами (T, V, K).
//     * Класс содержит три переменные типа (T, V, K), конструктор, принимающий на вход параметры
//       типа (T, V, K),
//     * методы возвращающие значения трех переменных. Создать метод, выводящий на консоль имена классов
//       для трех переменных класса.
//     * Наложить ограничения на параметры типа: T должен реализовать интерфейс Comparable (String),
//     * V должен реализовать интерфейс Serializable и расширять класс Animal, K должен расширять класс Number
