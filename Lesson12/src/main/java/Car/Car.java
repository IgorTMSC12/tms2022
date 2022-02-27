package Car;

import java.util.Random;

public class Car {
    private BrandCarType brandCar;
    private int speed;
    private int price;

    public Car(BrandCarType brandCar, int speed, int price) {
        this.brandCar = brandCar;
        this.speed = speed;
        this.price = price;
    }

    public BrandCarType getBrandCar() {
        return brandCar;
    }

    @Override
    public String toString() {
        return "Car.Car{" +
                "brandCar=" + brandCar +
                ", speed=" + speed +
                ", price=" + price +
                '}';
    }

    public void start() throws MyException {
        Random random = new Random();
        int number = random.nextInt(21);
        if (!((number % 2) == 0)) {
            System.out.println("Автомобиль с маркой " + brandCar.getBrandCar() + " завёлся");
        } else {
            throw new MyException("автомобиль с маркой " + brandCar.getBrandCar() + " не завелся");
        }


    }
}
