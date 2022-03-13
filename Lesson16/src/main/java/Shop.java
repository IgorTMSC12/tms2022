import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Shop {
    private ArrayList<Product> listProducts = new ArrayList<>();

    public void addProduct(Product product) {
        boolean checkProduct = true;
        Iterator<Product> iterator = listProducts.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == product.getId()) {
                checkProduct = false;
            }
        }
        if (checkProduct) {
            listProducts.add(product);
        }
    }

    public ArrayList<Product> getProducts() {
        return listProducts;
    }

    public void removeProduct(int id) {
        Iterator<Product> iterator = listProducts.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                iterator.remove();
            }
        }
    }

    public void redactProduct(Product product) {
        Iterator<Product> iterator = listProducts.iterator();
        while (iterator.hasNext()) {
            Product product1 = iterator.next();
            if (product1.getId() == product.getId()) {
                product1.setPrice(product.getPrice());
                product1.setName(product.getName());
            }
        }
    }

    public void sortPriceProduct() {
        Collections.sort(listProducts, sortPriceProduct);
    }

    Comparator<Product> sortPriceProduct = new Comparator<Product>() {

        @Override
        public int compare(Product o1, Product o2) {
            return o1.getPrice() - o2.getPrice();
        }
    };

    Comparator<Product> sortIdProduct = new Comparator<Product>() {

        @Override
        public int compare(Product o1, Product o2) {
            return o1.getId() - o2.getId();
        }
    };

    public void sortIdProduct() {
        Collections.sort(listProducts, sortIdProduct);
    }
}
