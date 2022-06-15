package task1;

public class Main {
    public static void main(String[] args) {
        Product notebook1 = new Notebook("HP", 1500);
        System.out.println(notebook1);
        Product notebook2 = notebook1.clone();
        System.out.println(notebook2);
    }
}
