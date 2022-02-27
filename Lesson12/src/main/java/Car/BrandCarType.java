package Car;

public enum BrandCarType {
    AUDI("Audi"),
    BMW("BMW"),
    OPEL("Opel"),
    MERCEDES("Mercedes");

    private String brandCar;

    public String getBrandCar() {
        return brandCar;
    }

    BrandCarType(String brandCar) {
        this.brandCar = brandCar;
    }
}
