package task1;

public class Pipe implements IInstrument {
    private int diametr;

    public Pipe(int diametr) {
        this.diametr = diametr;
    }

    @Override
    public void play() {
        System.out.println("Играет труба");
    }

    @Override
    public String toString() {
        return "Pipe{" +
                "diametr=" + diametr +
                '}';
    }
}
