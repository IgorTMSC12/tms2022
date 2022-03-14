public class Main {
    public static void main(String[] args) {
        Product product = new Product(1, "Apple", 24);
        Product product2 = new Product(2, "Bread", 9);
        Product product3 = new Product(3, "Milk", 15);
        Shop shop = new Shop();
        shop.addProduct(product);
        shop.addProduct(product2);
        shop.addProduct(product3);
        System.out.println(shop.getProducts().toString());
        shop.sortPriceProduct();
        System.out.println(shop.getProducts().toString());
        shop.removeProduct(product2.getId());
        shop.sortIdProduct();
        System.out.println(shop.getProducts().toString());
        shop.redactProduct(new Product(1, "Eggs", 17));
        System.out.println(shop.getProducts().toString());
    }
}
