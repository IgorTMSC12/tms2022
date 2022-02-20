package task1;

public class Guitar implements IInstrument {
    private int numberStrings;

    public Guitar(int numberStrings) {
        this.numberStrings = numberStrings;
    }

    @Override
    public void play() {
        System.out.println("Играет гитара");
    }

    @Override
    public String toString() {
        return "Guitar{" +
                "numberStrings=" + numberStrings +
                '}';
    }
}
