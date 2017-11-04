package edu.matc.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(
        name = "clientZipCodeForm",
        urlPatterns = {"/client-zipcode-form"}
)

public class ClientZipCodeForm extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletContext();
        HttpSession session = req.getSession();

        RequestDispatcher dispatcher = req.getRequestDispatcher("clientZipCodeForm.jsp");
        dispatcher.forward(req, resp);
    }
}
