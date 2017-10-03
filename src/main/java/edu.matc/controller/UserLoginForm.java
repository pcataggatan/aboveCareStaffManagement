package edu.matc.controller;

import edu.matc.persistence.ClientDao;

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
        name = "userLoginFormForm",
        urlPatterns = {"/user-login-form"}
)

public class UserLoginForm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletContext();
        HttpSession session = req.getSession();
        session.setAttribute("userRole",null);
        session.setAttribute("invalidLoginMsg", null);

        RequestDispatcher dispatcher = req.getRequestDispatcher("userLoginForm.jsp");
        dispatcher.forward(req, resp);
    }
}
