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
import java.util.Set;

/**
 * This is the AddNewStaffForm servlet. It initializes the data elements for the Staff and forward
 * to the addPersonForm.jsp page.
 *
 *@author Pablo Cataggatan
 */
@WebServlet(
        name = "assignClient",
        urlPatterns = {"/assign-client"}
)
public class AssignClient extends HttpServlet {

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

        StaffDao staffDao = new StaffDao();
        Staff staff = staffDao.getStaff((Integer) session.getAttribute("assignToStaffId"));

        ClientDao clientDao = new ClientDao();
        Client client = clientDao.getClient(Integer.parseInt(req.getParameter("assignClientId")));

        Set<Client> clients = staff.getClients();
        clients.add(client);

        staff.setClients(clients);
        client.setStaff(staff);

        String assignClientName = client.getFirstName() + " " + client.getLastName();
        String assignStaffName = staff.getFirstName() + " " + staff.getLastName();

        if (staffDao.updateStaff(staff).equals("Success")) {
            session.setAttribute("assignClientMsg",
                    assignClientName + " is successfully assigned to " + assignStaffName);
        } else {
            session.setAttribute("assignClientMsg",
                    "Error assigning " + assignClientName + " to " + assignStaffName);
        }

        session.setAttribute("searchType", "viewAll");
        session.setAttribute("personType", "Staff");

        //resp.sendRedirect("assignClientForm.jsp");
        //can we forawrd?
        RequestDispatcher dispatcher = req.getRequestDispatcher("assignClientForm.jsp");
        dispatcher.forward(req, resp);
    }
}
