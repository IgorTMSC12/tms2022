public class CivilTransport extends AirTransport {
    private int numberPassengers;
    private boolean availabilityBusinessClass;

    public CivilTransport(int power, int maximumSpeed, int weight, String brand, int wingsPan,
                          int minimumRunWay, int numberPassengers, boolean availabilityBusinessClass) {
        super(power, maximumSpeed, weight, brand, wingsPan, minimumRunWay);
        this.numberPassengers = numberPassengers;
        this.availabilityBusinessClass = availabilityBusinessClass;
    }

    public void passengerInput(int passenger) {
        if (passenger >= 0 && passenger <= numberPassengers) {
            System.out.println("Самолёт загружен");
        } else {
            System.out.println("Вам нужен самолёт побольше");
        }
    }

    @Override
    public void info() {
        super.info();
        String result = "Количество пассажиров = " + numberPassengers + ",\n" +
                "Наличие бизнес класса = " + availabilityBusinessClass + ",\n" +
                "Мощность (кВ) = " + getPower() * 0.75;
        System.out.println(result);
    }
}
