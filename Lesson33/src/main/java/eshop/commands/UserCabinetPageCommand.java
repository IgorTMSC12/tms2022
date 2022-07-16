package eshop.commands;

import eshop.PagesPathEnum;
import eshop.domain.Order;
import eshop.domain.StorageOrder;
import eshop.domain.User;
import eshop.exceptions.CommandException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class UserCabinetPageCommand implements BaseCommand {

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        request.setAttribute("user", user);
        ArrayList<Order> orders = (ArrayList<Order>) StorageOrder.getOrdersByIdUser(user.getIdUser());

        request.setAttribute("orders", orders);

        return PagesPathEnum.USER_CABINET_PAGE.getPath();
    }
}
