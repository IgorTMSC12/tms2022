package eshop;

public enum PagesPathEnum {

    HOME_PAGE("home.jsp"),
    SIGN_IN_PAGE("signIn.jsp"),
    CATEGORY_PAGE("category.jsp"),
    PRODUCT_PAGE("product.jsp"),
    CART_PAGE("cart.jsp"),
    REGISTER_PAGE("register.jsp"),
    USER_CABINET_PAGE("cabinet.jsp"),
    SEARCH_PAGE("search.jsp");

    private String path;

    PagesPathEnum(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
