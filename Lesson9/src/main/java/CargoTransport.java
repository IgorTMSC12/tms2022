public class CargoTransport extends GroundTransport {
    private int loadCapacity;

    public CargoTransport(int power, int maximumSpeed, int weight, String brand, int numberWheels,
                          int fuelConsumption, int loadCapacity) {
        super(power, maximumSpeed, weight, brand, numberWheels, fuelConsumption);
        this.loadCapacity = loadCapacity;
    }

    public void cargoLoading(int cargo) {
        if (cargo >= 0 && cargo <= loadCapacity) {
            System.out.println("Грузовик загружен");
        } else {
            System.out.println("Вам нужен грузовик побольше");
        }
    }

    @Override
    public void info() {
        super.info();
        String result = "Грузоподъёмность = " + loadCapacity + ",\n" +
                "Мощность (кВ) = " + getPower() * 0.75;
        System.out.println(result);
    }
}
