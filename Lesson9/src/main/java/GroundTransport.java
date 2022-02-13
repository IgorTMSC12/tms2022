public class GroundTransport extends Transport {
    private int numberWheels;
    private int fuelConsumption;

    public GroundTransport(int power, int maximumSpeed, int weight, String brand,
                           int numberWheels, int fuelConsumption) {
        super(power, maximumSpeed, weight, brand);
        this.numberWheels = numberWheels;
        this.fuelConsumption = fuelConsumption;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    @Override
    public void info() {
        super.info();
        String result = "Количество колёс = " + numberWheels + ",\n" +
                "Расход топлива (л/100км) = " + fuelConsumption + ",";
        System.out.println(result);
    }
}
