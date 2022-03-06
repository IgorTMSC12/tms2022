package task4;

public enum TypeEngine {
    GAS_ENGINE("Бензиновый двигатель"),
    DIESEL_ENGINE("Дизельный двигатель"),
    ELECTRICAL_ENGINE("Электрический двигатель");

    private String name;

    TypeEngine(String name) {
        this.name = name;
    }
}
