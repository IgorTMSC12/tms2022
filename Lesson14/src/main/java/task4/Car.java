package task4;

import java.io.Serializable;

public class Car implements Serializable {
    private String model;
    private Engine engine;
    private FuelTank fuelTank;
    private int speed;
    private int price;

    public Car(String model, TypeEngine engine, int numberCylinders, TypeTank fuelTank, int fuelVolume, int speed, int price) {
        this.model = model;
        this.engine = new Engine(engine, numberCylinders);
        this.fuelTank = new FuelTank(fuelTank, fuelVolume);
        this.speed = speed;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", engine=" + engine +
                ", fuelTank=" + fuelTank +
                ", speed=" + speed +
                ", price=" + price +
                '}';
    }

    class Engine implements Serializable {
        private TypeEngine typeEngine;
        private transient int numberСylinders;

        public Engine(TypeEngine typeEngine, int numberСylinders) {
            this.typeEngine = typeEngine;
            this.numberСylinders = numberСylinders;
        }

        @Override
        public String toString() {
            return "Engine{" +
                    "typeEngine=" + typeEngine +
                    ", numberСylinders=" + numberСylinders +
                    '}';
        }
    }

    static class FuelTank implements Serializable {
        private TypeTank typeTank;
        private int fuelVolume;

        public FuelTank(TypeTank typeTank, int fuelVolume) {
            this.typeTank = typeTank;
            this.fuelVolume = fuelVolume;
        }

        @Override
        public String toString() {
            return "FuelTank{" +
                    "typeTank=" + typeTank +
                    ", fuelVolume=" + fuelVolume +
                    '}';
        }
    }
}
