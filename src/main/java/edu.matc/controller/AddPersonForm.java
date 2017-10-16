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
        name = "addPersonForm",
        urlPatterns = {"/add-person-form"}
)

public class AddPersonForm extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletContext();
        HttpSession session = req.getSession();

        session.setAttribute("addPersonType", "Client");
        RequestDispatcher dispatcher = req.getRequestDispatcher("addPersonForm.jsp");
        dispatcher.forward(req, resp);
    }
}
