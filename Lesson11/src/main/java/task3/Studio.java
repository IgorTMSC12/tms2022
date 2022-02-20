package task3;

public class Studio {

    public void dressMen(Clothes[] clothes) {
        for (int i = 0; i < clothes.length; i++) {
            if (clothes[i] instanceof TShirt) {
                ((TShirt) clothes[i]).dressMan();
            } else if (clothes[i] instanceof Trousers) {
                ((Trousers) clothes[i]).dressMan();
            } else if (clothes[i] instanceof Tie) {
                ((Tie) clothes[i]).dressMan();
            }
        }
    }

    public void dressWomen(Clothes[] clothes) {
        for (int i = 0; i < clothes.length; i++) {
            if (clothes[i] instanceof TShirt) {
                ((TShirt) clothes[i]).dressWomen();
            } else if (clothes[i] instanceof Trousers) {
                ((Trousers) clothes[i]).dressWomen();
            } else if (clothes[i] instanceof Skirt) {
                ((Skirt) clothes[i]).dressWomen();
            }
        }
    }
}
