public class Car {
    private String number;
    private int year;

    public Car(String number, int year) {
        this.number = number;
        this.year = year;
    }

    public String getNumber() {
        return number;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "number='" + number + '\'' +
                ", year=" + year +
                '}';
    }
}
