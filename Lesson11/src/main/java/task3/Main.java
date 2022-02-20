package task3;

import static task3.ClothingSizeType.*;

public class Main {
    public static void main(String[] args) {
        TShirt tShirt = new TShirt(XS, 40, "Red");
        Trousers trousers = new Trousers(L, 32, "Black");
        Skirt skirt = new Skirt(XS, 18, "Grey");
        Tie tie = new Tie(M, 27, "Black");
        Clothes[] clothes = new Clothes[]{tShirt, trousers, skirt, tie};
        Studio studio = new Studio();
        studio.dressMen(clothes);
        System.out.println();
        studio.dressWomen(clothes);

    }
}
