package task5;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle.getSquare());

        Triangle triangle = new Triangle();
        System.out.println(triangle.getSquare());

        Line line = new Line();

        Figures[] figures = new Figures[]{rectangle, triangle, line};
        for (int i = 0; i < figures.length; i++) {

        }
    }
}
