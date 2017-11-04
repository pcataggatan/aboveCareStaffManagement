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
        name = "searchClientForm",
        urlPatterns = {"/search-client-form"}
)

public class SearchClientForm extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletContext();
        HttpSession session = req.getSession();

        session.setAttribute("searchFor", "Client");

        RequestDispatcher dispatcher = req.getRequestDispatcher("searchForm.jsp");
        dispatcher.forward(req, resp);
    }
}
