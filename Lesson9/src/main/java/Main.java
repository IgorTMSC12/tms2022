public class Main {
    public static void main(String[] args) {
        PassengerCar passengerCar = new PassengerCar(155, 220, 1800, "BMW",
                4, 36, "Седан", 4);
        passengerCar.info();
        passengerCar.driveKilometers(360);

        System.out.println("--------------------");

        CargoTransport cargoTransport = new CargoTransport(250, 160, 3400, "KAMAZ",
                6, 62, 8);
        cargoTransport.info();
        cargoTransport.cargoLoading(7);

        System.out.println("--------------------");

        CivilTransport civilTransport = new CivilTransport(2000, 800, 41, "Boing",
                30, 400, 100, false);
        civilTransport.info();
        civilTransport.passengerInput(80);

        System.out.println("--------------------");

        MilitaryTransport militaryTransport = new MilitaryTransport(600, 500, 6000,
                "СУ-57", 15, 300, true, 25);
        militaryTransport.info();
        militaryTransport.shot();
        militaryTransport.ejection();
    }
}
