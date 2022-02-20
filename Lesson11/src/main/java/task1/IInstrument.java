package task1;

public interface IInstrument {
    String KEY = "До мажор"; //не понял для чего это

    void play();

    enum Type {
        GUITAR,
        DRUM,
        PIPE
    }
}
