package tms.reader;

public class Birthday {
    private int day;
    private String moth;
    private int year;

    public Birthday(int day, String moth, int year) {
        this.day = day;
        this.moth = moth;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Birthday{" +
                "fay=" + day +
                ", moth='" + moth + '\'' +
                ", year=" + year +
                '}';
    }
}
