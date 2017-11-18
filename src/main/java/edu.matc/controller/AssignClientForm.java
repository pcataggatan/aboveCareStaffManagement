package edu.matc.controller;

import edu.matc.entity.Client;
import edu.matc.entity.Staff;
import edu.matc.persistence.ClientDao;
import edu.matc.persistence.StaffDao;
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
 * This is the AddNewStaffForm servlet. It initializes the data elements for the Staff and forward
 * to the addPersonForm.jsp page.
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        int staffId = Integer.parseInt(req.getParameter("idStaff"));

        StaffDao staffDao = new StaffDao();
        Staff staff = staffDao.getStaff(staffId);
        session.setAttribute("assignToStaff", staff.getFirstName() + " " + staff.getLastName());

        session.setAttribute("clientList", getClientsForStaff());

        session.setAttribute("assignClientMsg", null);
        session.setAttribute("assignToStaffId", staffId);

        RequestDispatcher dispatcher = req.getRequestDispatcher("assignClientForm.jsp");
        dispatcher.forward(req, resp);
    }


    public Map<Integer, String> getClientsForStaff() {

        Map<Integer, String> clientList = new TreeMap<Integer, String>();

        ClientDao clientDao = new ClientDao();

        for (Client client : clientDao.getAllClients()) {
            clientList.put(client.getClientId(), client.getFirstName() + " " + client.getLastName());
        }

        return clientList;
    }
}