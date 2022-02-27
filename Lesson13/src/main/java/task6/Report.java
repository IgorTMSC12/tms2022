package task6;

public class Report {
    public void generateReport(Employee[] employee) {
        for (int i = 0; i < employee.length; i++) {
            System.out.printf("| " + employee[i].getFullname() + "\t | \t" + "%.2f." + "|" + "\n", employee[i].getSalary());
        }
    }
}
