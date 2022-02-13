public class Transport {
    private int power;
    private int maximumSpeed;
    private int weight;
    private String brand;

    public Transport(int power, int maximumSpeed, int weight, String brand) {
        this.power = power;
        this.maximumSpeed = maximumSpeed;
        this.weight = weight;
        this.brand = brand;
    }

    public int getPower() {
        return power;
    }

    public int getMaximumSpeed() {
        return maximumSpeed;
    }

    public void info() {
        String result = "Мощность (л/с) = " + power + ",\n" +
                "Максимальнаяя скорость (км/ч) = " + maximumSpeed + ",\n" +
                "Масса (кг) = " + weight + ",\n" + "Марка = " + brand + ",";
        System.out.println(result);
    }
}
