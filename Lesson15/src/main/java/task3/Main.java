package task3;

public class Main {
    public static void main(String[] args) {
        MinMax<Integer> minMax = new MinMax<>(new Integer[]{33, 2, 55, 5});
        minMax.MinMaxInfo();
    }
}

//3)Написать обобщенный класс MinMax, который содержит методы для нахождения минимального и максимального
//  элемента массива.
//     * Массив является переменной класса. Массив должен передаваться в класс через конструктор.
//     * Написать метод принимающий MinMax объект и печатающий информацию об элементах.
