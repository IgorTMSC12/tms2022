package clothes;

import clothes.jacket.IJacket;
import clothes.shoes.IShoes;
import clothes.trousers.ITrousers;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Person {
    private String name;
    private IJacket iJacket;
    private IShoes iShoes;
    private ITrousers iTrousers;

    public void getDressed() {
        iJacket.putOn();
        iShoes.putOn();
        iTrousers.putOn();
    }

    public void undress() {
        iJacket.takeOff();
        iShoes.takeOff();
        iTrousers.takeOff();
    }
}
