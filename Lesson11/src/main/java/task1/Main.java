package task1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Instrument instrument = new Instrument();
        IInstrument iInstrument = instrument.createInstrument(IInstrument.Type.DRUM);
        IInstrument iInstrument1 = instrument.createInstrument(IInstrument.Type.GUITAR);
        IInstrument iInstrument2 = instrument.createInstrument(IInstrument.Type.PIPE);
        IInstrument[] instruments = new IInstrument[]{iInstrument, iInstrument1, iInstrument2};
        System.out.println(Arrays.toString(instruments));
        for (int i = 0; i < instruments.length; i++) {
            instruments[i].play();
        }
    }

}
