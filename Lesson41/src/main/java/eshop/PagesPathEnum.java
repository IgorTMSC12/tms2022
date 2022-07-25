package eshop;

public enum PagesPathEnum {

    HOME_PAGE("home"),
    SIGN_IN_PAGE("signIn"),
    CATEGORY_PAGE("category"),
    PRODUCT_PAGE("product"),
    CART_PAGE("cart"),
    REGISTER_PAGE("register"),
    USER_CABINET_PAGE("cabinet"),
    SEARCH_PAGE("search");

    private String path;

    PagesPathEnum(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
