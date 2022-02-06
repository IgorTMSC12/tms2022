package by.tms.car;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("BMW", "Diesel");
        //При заправлен баке.
        car1.startCar();
        car1.goCar();
        car1.offCar();

        //В классе FuelTank в переменной volumeTank поставить 0. это при пустом баке, мы не сможем завестись.
    }
}
