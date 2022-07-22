package eshop;

public enum CommandsEnum {

    HOME_PAGE_COMMAND("start_page"),
    SIGN_IN_COMMAND("sign-in"),
    CATEGORY_PAGE_COMMAND("category-redirect"),
    REDIRECT_SHOPPING_CART_COMMAND("redirect-to-shopping-cart"),
    REDIRECT_PRODUCT_COMMAND("product-redirect"),
    ADD_PRODUCT_TO_CART("add-product-to-cart"),
    DELETE_PRODUCT_TO_CART("delete-product-to-cart"),
    REGISTER_PAGE_COMMAND("register"),
    REGISTER_USER_COMMAND("register-user"),
    CREATE_ORDER_COMMAND("create-order"),
    USER_CABINET_PAGE("user-cabinet-page"),
    SEARCH_PAGE("search-page");

    private final String command;

    CommandsEnum(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
