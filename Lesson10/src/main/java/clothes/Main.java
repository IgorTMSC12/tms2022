package clothes;

import clothes.jacket.GucciJacket;
import clothes.shoes.Crocs;
import clothes.trousers.AdidasTrousers;

public class Main {
    public static void main(String[] args) {
        GucciJacket gucciJacket = new GucciJacket();
        Crocs crocs = new Crocs();
        AdidasTrousers adidasTrousers = new AdidasTrousers();
        Person person = new Person("Igor", gucciJacket, crocs, adidasTrousers);
        person.getDressed(); // одеться
        System.out.println();
        person.undress(); // раздеться
    }
}
