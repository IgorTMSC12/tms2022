public class MilitaryTransport extends AirTransport {
    private boolean systemBailout;
    private int numberMissiles;

    public MilitaryTransport(int power, int maximumSpeed, int weight, String brand,
                             int wingsPan, int minimumRunWay, boolean systemBailout, int numberMissiles) {
        super(power, maximumSpeed, weight, brand, wingsPan, minimumRunWay);
        this.systemBailout = systemBailout;
        this.numberMissiles = numberMissiles;
    }

    public void shot() {
        if (numberMissiles != 0) {
            System.out.println("Ракета пошла");
        } else {
            System.out.println("Боевоприпасы отсутсвуют");
        }
    }

    public void ejection() {
        if (systemBailout) {
            System.out.println("Катапультирование прошло успешно");
        } else {
            System.out.println("У вас нет такой системы");
        }
    }

    @Override
    public void info() {
        super.info();
        String result = "Наличие систем катапультирования = " + systemBailout + ",\n" +
                "Количество ракет на борту = " + numberMissiles + ",\n" +
                "Мощность (кВ) = " + getPower() * 0.75;
        System.out.println(result);
    }
}

