package edu.matc.controller;

import edu.matc.entity.Client;
import edu.matc.entity.Staff;
import edu.matc.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
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
        name = "confirmDeletePerson",
        urlPatterns = {"/confirm-delete-person"}
)
public class ConfirmDeletePerson extends HttpServlet {

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

        HttpSession session = req.getSession();

        int personId = Integer.parseInt(req.getParameter("idPerson"));
        String personType = (String) session.getAttribute("personType");

        if (personType.equals("Staff")) {
            GenericDao staffDao = new GenericDao(Staff.class);
            Staff staff = (Staff) staffDao.get(personId);
            session.setAttribute("clientsForDeletedStaff", staff.getClients());
            session.setAttribute("deletedStaff", staff.getFirstName() + " " + staff.getLastName());
            session.setAttribute("deleteStaffId", personId);
        } else {
            GenericDao clientDao = new GenericDao(Client.class);
            Client client = (Client) clientDao.get(personId);
            session.setAttribute("deletedClient", client.getFirstName() + " " + client.getLastName());
            session.setAttribute("deleteClientId", personId);
        }

        session.setAttribute("deleteMsg", "");
        RequestDispatcher dispatcher = req.getRequestDispatcher("confirmDeletePerson.jsp");
        dispatcher.forward(req, resp);
    }
}