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
        name = "addNewClient",
        urlPatterns = {"/add-new-client"}
)

public class AddNewClient extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletContext();
        HttpSession session = req.getSession();

        String firstName = req.getParameter("firstName");
        // validate all rquired fields //

        //do processing here //

        //session.setAttribute("addPersonType","Client");

        //don't forward... redirect
        //RequestDispatcher dispatcher = req.getRequestDispatcher("addNewPerson.jsp");
        //dispatcher.forward(req, resp);

        resp.sendRedirect("url here");

    }
}
