package eshop.servlet;

import eshop.PagesPathEnum;
import eshop.commands.BaseCommand;
import eshop.exceptions.CommandException;
import eshop.util.CommandFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/eshop")
public class ApplicationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BaseCommand requestCommand = CommandFactory.defineCommand(request);
        String path;
        try {
            path = requestCommand.execute(request);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
            requestDispatcher.forward(request, response);
        } catch (CommandException exception) {
            request.getRequestDispatcher(PagesPathEnum.SIGN_IN_PAGE.getPath()).forward(request, response);
        }
    }
}
