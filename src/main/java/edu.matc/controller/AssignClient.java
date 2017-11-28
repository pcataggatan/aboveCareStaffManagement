package edu.matc.controller;

import edu.matc.entity.Client;
import edu.matc.entity.Staff;
import edu.matc.persistence.GenericDao;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;

/**
 * This is the AssignClient servlet. It uses the Staff Id and Client Id from the session variables and calls the
 * generic dao's get() method to retrieve specific rows from the Staff and Client tables. It also calls the generic
 * dao's update() method to update Staff table when associating the client with the staff. It then forwards the request
 * to the assignClientForm.jsp page indicating success or failure from the Staff table update operation.
 *
 *@author Pablo Cataggatan
 */
@WebServlet(
        name = "assignClient",
        urlPatterns = {"/assign-client"}
)
public class AssignClient extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

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

        GenericDao staffDao = new GenericDao(Staff.class);
        Staff staff = (Staff) staffDao.get((Integer) session.getAttribute("assignToStaffId"));

        GenericDao clientDao = new GenericDao(Client.class);
        Client client = (Client) clientDao.get(Integer.parseInt(req.getParameter("assignClientId")));

        Set<Client> clients = staff.getClients();
        clients.add(client);

        staff.setClients(clients);
        client.setStaff(staff);

        String assignClientName = client.getFirstName() + " " + client.getLastName();
        String assignStaffName = staff.getFirstName() + " " + staff.getLastName();

        if (staffDao.update(staff).equals("Success")) {
            session.setAttribute("assignClientMsg",
                    assignClientName + " is successfully assigned to " + assignStaffName);
        } else {
            session.setAttribute("assignClientMsg",
                    "Error assigning " + assignClientName + " to " + assignStaffName);
            log.error("There's an error updating the staff table when assigning Client to Staff");
        }

        session.setAttribute("searchType", "viewAll");
        session.setAttribute("personType", "Staff");

        RequestDispatcher dispatcher = req.getRequestDispatcher("assignClientForm.jsp");
        dispatcher.forward(req, resp);
    }
}
