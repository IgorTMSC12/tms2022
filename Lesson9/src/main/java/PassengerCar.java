public class PassengerCar extends GroundTransport {
    private String typeBody;
    private int numberPassengers;

    public PassengerCar(int power, int maximumSpeed, int weight, String brand,
                        int numberWheels, int fuelConsumption, String typeBody, int numberPassengers) {
        super(power, maximumSpeed, weight, brand, numberWheels, fuelConsumption);
        this.typeBody = typeBody;
        this.numberPassengers = numberPassengers;
    }

    public void driveKilometers(int time) {
        if (time >= 0) {
            double kilometers = getMaximumSpeed() * time / 60;
            String result = "Двигаясь с максимальной скоростью " + getMaximumSpeed() + " км/ч, машина проедете " +
                    kilometers + " километров.";
            System.out.println(result);
            fuelConsumption(time);
        } else {
            System.out.println("Ошибка, вы ввели не правильное время.");
        }
    }

    private void fuelConsumption(int time) {
        double fuel = (double) getMaximumSpeed() * time * getFuelConsumption() / (60 * 100);
        String result = "Расход топлива за время " + time + " минут, равен " + fuel + " литров";
        System.out.println(result);
    }

    @Override
    public void info() {
        super.info();
        String result = "Тип автомобиля = " + typeBody + ",\n" +
                "Количество пассажиров = " + numberPassengers + ",\n" +
                "Мощность (кВ) = " + getPower() * 0.75;
        System.out.println(result);
    }
}
