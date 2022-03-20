import java.util.*;

public class Main {
    public static void main(String[] args) {
        //task1();
        //task2();
        //task3();
        //task4();
        task5();
    }

    //1) Вывести список чисел, умноженных на 2. Список чисел задаем рандомно.
    public static void task1() {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int number = random.nextInt(1000);
            list.add(number);
        }
        list.stream().map(x -> x * 2).forEach(System.out::println);
    }

    //2) Определение количества четных чисел в потоке данных.
    //     * Создаем коллекцию Set<Integer> в которую добавляем рандомно 50 чисел от 0 до 100
    public static void task2() {
        Set<Integer> setList = new HashSet<>();
        Random random = new Random();
        while (true) {
            setList.add(random.nextInt(100));
            if (setList.size() == 50) {
                break;
            }
        }
        System.out.println(setList);
        int count = (int) setList.stream().filter(x -> x % 2 == 0).count();
        System.out.println("Количество чётных чисел: " + count);
    }

    //3) Вывести список имен, но с первой заглавной буквой. список имен: "john", "arya", "sansa"
    public static void task3() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("john");
        arrayList.add("arya");
        arrayList.add("sansa");
        arrayList.stream().map(x -> x.substring(0, 1).toUpperCase() + x.substring(1)).forEach(System.out::println);
    }

    //4) Создаем класс Car с полями number (номер авто) и year (год выпуска).
    //     * List<Car> cars = Arrays.asList(
    //     *             new Car("AA1111BX", 2007),
    //     *             new Car("AK5555IT", 2010),
    //     *             new Car(null, 2012),
    //     *             new Car("", 2015),
    //     *             new Car("AI3838PP", 2017));
    //     *
    //     * Необходимо вывести все не пустые номера машин, выпущенных после 2010 года
    public static void task4() {
        List<Car> list = Arrays.asList(
                new Car("AA1111BX", 2007),
                new Car("AK5555IT", 2010),
                new Car(null, 2012),
                new Car("", 2015),
                new Car("AI3838PP", 2017));
        list.stream().filter(x -> x.getYear() > 2010 && !(x.getNumber() == null) && !(x.getNumber().length() == 0))
                .forEach(System.out::println);
    }

    //5) Задан список сотрудников, которые хранятся в коллекции List<p3.Person>.
    //     * Объект p3.Person содержит имя и фамилию(по желанию другие данные)
    //     *  a) написать метод, который отображает все фамилии, начинающиеся на букву "Д".
    //     *     Внимание! метод должен вернуть объект Optional<String>.
    //     *  b*)Со звездочкой. Написать метод, который будет выводить в столбик первую букву фамилии и рядом количество сотрудников,
    //     *  у которых фамилия начинается с этой буквы.
    //     *  Пример: Антонов, Петров, Сидоров, Александров...
    //     *  на экран выведет:
    //     *  A - 2 сотрудника
    //     *  П - 1 сотрудник
    //     *  С - 1 сотрудник
    public static void task5() {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("Igor", "Lenkovets"));
        list.add(new Person("Andrey", "Ivanov"));
        list.add(new Person("Andrey", "Dorosh"));
        list.add(new Person("Andrey", "Dybovskiy"));
        getLastnameByLetter(list);
        employeeCount(list);
    }

    public static void getLastnameByLetter(ArrayList<Person> list) {
        list.stream().filter(x -> x.getLastname().substring(0, 1).equalsIgnoreCase("D"))
                .forEach(System.out::println);
    }

    public static void employeeCount(ArrayList<Person> list) {
        list.stream().map(x -> x.getLastname().substring(0, 1) + " - ").forEach(System.out::println);
    }
}
