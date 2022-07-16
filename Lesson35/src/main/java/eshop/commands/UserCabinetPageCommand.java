package eshop.commands;

import eshop.PagesPathEnum;
import eshop.entities.Image;
import eshop.entities.Order;
import eshop.entities.Product;
import eshop.entities.User;
import eshop.exceptions.CommandException;
import eshop.repositories.impl.ImageRepositoryImpl;
import eshop.repositories.impl.OrderRepositoryImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class UserCabinetPageCommand implements BaseCommand {
    private OrderRepositoryImpl orderRepository = new OrderRepositoryImpl();
    private ImageRepositoryImpl imageRepository = new ImageRepositoryImpl();

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        request.setAttribute("user", user);
        ArrayList<Order> orders = (ArrayList<Order>) orderRepository.getOrdersByIdUser(user.getId());
        request.setAttribute("orders", orders);
        List<Image> images = new ArrayList<>();
        for (Order order : orders) {
            for (Product product : order.getProducts()) {
                Image image = imageRepository.getImageByIdProduct(product.getId());
                if (images.size() == 0) {
                    images.add(image);
                }
                int count = 0;
                for (int i = 0; i < images.size(); i++) {
                    if (!(images.get(i).getIdProduct() == image.getIdProduct())) {
                        count++;
                    }
                    if (count == images.size()) {
                        images.add(image);
                    }
                }
            }
        }
        request.setAttribute("images", images);
        return PagesPathEnum.USER_CABINET_PAGE.getPath();
    }
}
