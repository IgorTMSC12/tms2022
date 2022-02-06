package by.tms.car;

public class Car {
    private String model;
    private String color = "Чёрный цвет";
    private Engine engine;
    private boolean go;
    private FuelTank tank = new FuelTank();

    public Car(String model, String engine) {
        this.model = model;
        this.engine = new Engine(engine);
    }

    public void startCar() {
        if (tank.volumeTank > 0) {
            System.out.println("Запуск двигателя ");
            engine.start();
            tank.info();
        } else {
            System.out.println("Машина не завелась.");
            tank.info();
        }
    }

    public void offCar() {
        if (engine.startEngine) {
            System.out.println("Машина заглушена");
            engine.stop();
        } else {
            System.out.println("Машина не может быть заглушена, так как она не заведена");
        }
        if (go) {
            System.out.println("Машина проехала 25 км");
        }
    }

    public void goCar() {
        if (engine.startEngine) {
            System.out.println("Машина поехала ");
            go = true;
        } else {
            System.out.println("Машина не может поехать, двигатель не запущен");
        }

    }

    public class Engine {
        private String typeEngine;
        private boolean startEngine;

        public Engine(String typeEngine) {
            this.typeEngine = typeEngine;
        }

        public void info() {
            System.out.println("Двигатель: " + typeEngine);
        }

        public void start() {
            startEngine = true;
            System.out.println("START");
        }

        public void stop() {
            startEngine = false;
            System.out.println("STOP");
        }
    }

    public class FuelTank {
        private int volumeTank = 15;

        public void info() {
            if (volumeTank == 0) {
                System.out.println("Топлива нет, заправьте машину");
            } else {
                System.out.println("Осталось топлива: " + volumeTank);
            }
        }
    }

}

