package eshop.commands;

import eshop.PagesPathEnum;
import eshop.exceptions.CommandException;

import javax.servlet.http.HttpServletRequest;

public class RegisterPageCommand implements BaseCommand {

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        return PagesPathEnum.REGISTER_PAGE.getPath();
    }
}
