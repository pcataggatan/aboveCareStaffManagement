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
        name = "searchPersonForm",
        urlPatterns = {"/search-person-form"}
)

public class SearchPersonForm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletContext();
        HttpSession session = req.getSession();

        String personType = req.getParameter("personType");

        session.setAttribute("personType", personType);

        /*--
        if (personType.equals("Staff")) {
            session.setAttribute("personType", "Staff");
        } else {
            session.setAttribute("personType", "Client");
        }
        --*/

        RequestDispatcher dispatcher = req.getRequestDispatcher("searchPersonForm.jsp");
        dispatcher.forward(req, resp);
    }
}

