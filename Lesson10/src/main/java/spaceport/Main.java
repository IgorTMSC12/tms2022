package spaceport;

public class Main {
    public static void main(String[] args) {
        Shatl shatl = new Shatl();
        Spaceport spaceport = new Spaceport();
        spaceport.start(shatl);

        System.out.println();

        SpaceX spaceX = new SpaceX();
        Spaceport spaceport1 = new Spaceport();
        spaceport1.start(spaceX);
    }
}
