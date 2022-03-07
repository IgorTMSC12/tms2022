package task4;

public enum TypeTank {
    GAS_TANK("Бензиновый бак"),
    DIESEL_TANK("Дизельный бак"),
    ELECTRICAL_TANK("Электрическая батарея");

    private String name;

    TypeTank(String name) {
        this.name = name;
    }
}
