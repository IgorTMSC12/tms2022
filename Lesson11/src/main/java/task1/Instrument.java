package task1;

public class Instrument {

    public IInstrument createInstrument(IInstrument.Type type) {
        IInstrument one = null;
        switch (type) {
            case GUITAR:
                one = new Guitar(5);
                break;
            case DRUM:
                one = new Drum(20);
                break;
            case PIPE:
                one = new Pipe(8);
        }
        return one;
    }
}
