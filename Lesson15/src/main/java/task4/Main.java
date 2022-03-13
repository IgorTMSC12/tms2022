package task4;

public class Main {
    public static void main(String[] args) {
        Calcuator calcuator = new Calcuator();
        System.out.println(calcuator.multiply(5, 7));
        System.out.println(calcuator.divide(5, 7));
        System.out.println(calcuator.sum(5, 7));
        System.out.println(calcuator.subtraction(5, 7));
    }
}

//4)Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы - sum,
//  multiply, divide,
//     * subtraction. Параметры этих методов  - два числа разного типа, над которыми должна быть произведена
//       операция.
