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
import java.util.*;

/**
 * This is the AssignClientForm servlet. It calls the generic dao's get() method to retrieve a specific row from the
 * Staff table and initializes a map that contains the client ids as keys and client names as values needed for the
 * dropdown list. It then forwards the request and response to the assignClientForm.jsp page.
 *
 *@author Pablo Cataggatan
 */
@WebServlet(
        name = "assignClientForm",
        urlPatterns = {"/assign-client-form"}
)
public class AssignClientForm extends HttpServlet {

    /**
     *  Handles HTTP GET requests.
     *
     *@param  req             the HttpRequest
     *@param  resp            the HttpResponse
     *@exception  ServletException  if there is a general servlet exception
     *@exception  IOException       if there is a general I/O exception
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        int staffId = Integer.parseInt(req.getParameter("idStaff"));

        GenericDao staffDao = new GenericDao(Staff.class);
        Staff staff = (Staff) staffDao.get(staffId);
        session.setAttribute("assignToStaff", staff.getFirstName() + " " + staff.getLastName());

        session.setAttribute("clientList", getClientsForStaff());

        session.setAttribute("assignClientMsg", null);
        session.setAttribute("assignToStaffId", staffId);

        RequestDispatcher dispatcher = req.getRequestDispatcher("assignClientForm.jsp");
        dispatcher.forward(req, resp);
    }


    /**
     * Gets the list of all client ids and the corresponding client names. The key/value pairs are used for the
     * drop down list for the user to select from.
     * @return A map containing client ids as keys and and names as values
     */
    public Map<Integer, String> getClientsForStaff() {

        Map<Integer, String> clientList = new TreeMap<Integer, String>();

        GenericDao clientDao = new GenericDao(Client.class);

        for (Client client : (List<Client>) clientDao.getAll()) {
            clientList.put(client.getClientId(), client.getFirstName() + " " + client.getLastName());
        }

        return clientList;
    }
}