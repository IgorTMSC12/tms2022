package task2;

public enum TypeSeasons {
    SUMMER(20),
    WINTER(-10),
    AUTUMN(7),
    SPRING(6);

    private final int averageTemperature;

    TypeSeasons(int averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    @Override
    public String toString() {
        return "TypeSeasons{" +
                "averageTemperature=" + averageTemperature +
                '}';
    }
}
