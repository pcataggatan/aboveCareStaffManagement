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
        name = "addStaffForm",
        urlPatterns = {"/add-staff-form"}
)

public class AddNewStaffForm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletContext();
        HttpSession session = req.getSession();


        session.setAttribute("firstName", null);
        session.setAttribute("lastName", null);
        session.setAttribute("birthDt", null);
        session.setAttribute("phoneNr", null);
        session.setAttribute("email", null);
        session.setAttribute("jobTitle", null);
        session.setAttribute("payCd", null);
        session.setAttribute("street", null);
        session.setAttribute("city", null);
        session.setAttribute("state", null);
        session.setAttribute("zipcode", null);


        session.setAttribute("addPersonType", "Staff");
        session.setAttribute("addMsg", " ");
        session.setAttribute("addedAlready", "No");

        session.setAttribute("searchType", "viewAll");
        session.setAttribute("searchFor", "Staff");

        RequestDispatcher dispatcher = req.getRequestDispatcher("addPersonForm.jsp");
        dispatcher.forward(req, resp);
    }
}