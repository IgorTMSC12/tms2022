package spaceport;

public class Spaceport {

    public void start(IStart iStart) {
        //iStart.launchSystemCheck();
        if (iStart.launchSystemCheck()) {
            iStart.engineStart();
            for (int i = 10; i >= 0; i--) {
                System.out.println(i);
            }
            iStart.start();
        } else {
            System.out.println("Предстартовая проверка провалена");
        }
    }
}
