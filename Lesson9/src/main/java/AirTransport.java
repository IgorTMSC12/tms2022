public class AirTransport extends Transport {
    private int wingsPan;
    private int minimumRunWay;

    public AirTransport(int power, int maximumSpeed, int weight, String brand,
                        int wingsPan, int minimumRunWay) {
        super(power, maximumSpeed, weight, brand);
        this.wingsPan = wingsPan;
        this.minimumRunWay = minimumRunWay;
    }

    @Override
    public void info() {
        super.info();
        String result = "Размах крыльев (м) = " + wingsPan + ",\n" +
                "Минимальная длина взлётно-посадочной полосы для взлёта = " + minimumRunWay + ",";
        System.out.println(result);
    }
}
