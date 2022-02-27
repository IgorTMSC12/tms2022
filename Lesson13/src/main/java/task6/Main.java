package task6;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Л.Н. Толстой", 250);
        Employee employee1 = new Employee("И.Н. Николаев", 340);
        Employee[] employees = new Employee[]{employee, employee1};
        Report report = new Report();
        report.generateReport(employees);
    }
}

//6)Создать класс Employee, у которого есть переменные класса - String fullname, double salary.
//     * Создать массив содержащий несколько объектов этого типа. Создать класс Report (по возможности интерфейс),
//     * который будет содержать метод generateReport, в котором выводится информация о зарплате всех сотрудников.
//     * Используйте форматировании строк(https://javarush.ru/quests/lectures/questmultithreading.level02.lecture06)
//     * Пусть salary будет выровнено по правому краю, десятичное значение имеет 2 знака после запятой и по одной
//       первой букве имени и отчества через точки.
//     * Пример: | Л.Н. Толстой		|		200.34|
