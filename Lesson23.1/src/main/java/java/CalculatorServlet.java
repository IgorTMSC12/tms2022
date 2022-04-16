package java;

import model.Calculator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/calculator.html");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Calculator calculator = new Calculator();
        int number1 = Integer.parseInt(req.getParameter("Number1"));
        int number2 = Integer.parseInt(req.getParameter("Number2"));
        String button = req.getParameter("button");
        int result = 0;
        if (button.equals("difference (-)")) {
            result = calculator.difference(number1, number2);
        } else if (button.equals("sum (+)")) {
            result = calculator.sum(number1, number2);
        } else if (button.equals("division (/)")) {
            result = calculator.division(number1, number2);
        } else if (button.equals("multiplication (*)")) {
            result = calculator.multiplication(number1, number2);
        }

        PrintWriter printWriter = resp.getWriter();
        printWriter.println("Result: " + result);
    }
}
