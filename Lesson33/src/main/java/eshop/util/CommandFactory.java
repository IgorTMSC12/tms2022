package eshop.util;

import eshop.CommandsEnum;
import eshop.commands.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private static final Map<String, BaseCommand> COMMAND_LIST = new HashMap<>();

    static {
        COMMAND_LIST.put(CommandsEnum.HOME_PAGE_COMMAND.getCommand(), new HomePageCommandImpl());
        COMMAND_LIST.put(CommandsEnum.SIGN_IN_COMMAND.getCommand(), new SignInCommandImpl());
        COMMAND_LIST.put(CommandsEnum.CATEGORY_PAGE_COMMAND.getCommand(), new CategoryRedirectCommandImpl());
        COMMAND_LIST.put(CommandsEnum.ADD_PRODUCT_TO_CART.getCommand(), new AddProductToCartCommand());
        COMMAND_LIST.put(CommandsEnum.REDIRECT_SHOPPING_CART_COMMAND.getCommand(), new RedirectToShoppingCart());
        COMMAND_LIST.put(CommandsEnum.REDIRECT_PRODUCT_COMMAND.getCommand(), new RedirectProductPageCommand());
        COMMAND_LIST.put(CommandsEnum.DELETE_PRODUCT_TO_CART.getCommand(), new DeleteProductToCartCommand());
        COMMAND_LIST.put(CommandsEnum.REGISTER_PAGE_COMMAND.getCommand(), new RegisterPageCommand());
        COMMAND_LIST.put(CommandsEnum.REGISTER_USER_COMMAND.getCommand(), new RegisterCommand());
        COMMAND_LIST.put(CommandsEnum.CREATE_ORDER_COMMAND.getCommand(), new CreateOrderCommand());
        COMMAND_LIST.put(CommandsEnum.USER_CABINET_PAGE.getCommand(), new UserCabinetPageCommand());
    }

    public static BaseCommand defineCommand(HttpServletRequest request) {
        String commandKey = request.getParameter("command");
        if (commandKey == null || commandKey.isEmpty()) {
            commandKey = CommandsEnum.SIGN_IN_COMMAND.getCommand();
        }
        return COMMAND_LIST.get(commandKey);
    }
}
