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

/**
 * This is the AddNewStaffForm servlet. It initializes the data elements for the Staff and forward
 * to the addPersonForm.jsp page.
 *
 *@author Pablo Cataggatan
 */

@WebServlet(
        name = "addPersonForm",
        urlPatterns = {"/add-person-form"}
)
public class AddPersonForm extends HttpServlet {

    /**
     *  Handles HTTP GET requests.
     *
     *@param  req             the HttpRequest
     *@param  resp            the HttpResponse
     *@exception  ServletException  if there is a general servlet exception
     *@exception  IOException       if there is a general I/O exception
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletContext();
        HttpSession session = req.getSession();

        initializeCommonPersonData(session);

        String personType = req.getParameter("personType");

        if (personType.equals("Staff")) {
            session.setAttribute("jobTitle", null);
            session.setAttribute("payCd", null);
            session.setAttribute("personType", "Staff");
            //session.setAttribute("searchFor", "Staff");
        } else {
            session.setAttribute("billCd", null);
            session.setAttribute("personType", "Client");
            //session.setAttribute("searchFor", "Client");
        }

        //session.setAttribute("addPersonType", "Staff");
        session.setAttribute("addMsg", " ");
        session.setAttribute("addedAlready", "No");
        session.setAttribute("searchType", "viewAll");
        //session.setAttribute("searchFor", "Staff");

        RequestDispatcher dispatcher = req.getRequestDispatcher("addPersonForm.jsp");
        dispatcher.forward(req, resp);
    }


    public void initializeCommonPersonData(HttpSession session) {

        session.setAttribute("firstName", null);
        session.setAttribute("lastName", null);
        session.setAttribute("birthDt", null);
        session.setAttribute("phoneNr", null);
        session.setAttribute("email", null);
        session.setAttribute("street", null);
        session.setAttribute("city", null);
        session.setAttribute("state", null);
        session.setAttribute("zipcode", null);
    }
}