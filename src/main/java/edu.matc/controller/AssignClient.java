package edu.matc.controller;

import edu.matc.entity.Client;
import edu.matc.entity.Staff;
import edu.matc.persistence.ClientDao;
import edu.matc.persistence.StaffDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;

@WebServlet(
        name = "assignClient",
        urlPatterns = {"/assign-client"}
)

public class AssignClient extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletContext();
        HttpSession session = req.getSession();

        int staffId = (Integer) session.getAttribute("assignToStaffId");
        int clientId = Integer.parseInt(req.getParameter("assignClientId"));

        StaffDao staffDao = new StaffDao();
        Staff staff = staffDao.getStaff(staffId);

        ClientDao clientDao = new ClientDao();
        Client client = clientDao.getClient(clientId);

        Set<Client> clients = staff.getClients();
        clients.add(client);

        staff.setClients(clients);

        client.setStaff(staff);

        String assignClientName = client.getFirstName() + " " + client.getLastName();
        String assignStaffName = staff.getFirstName() + " " + staff.getLastName();

        String assignMsg = staffDao.updateStaff(staff);

        if (assignMsg.equals("Success")) {
            session.setAttribute("assignClientMsg",
                    assignClientName + " is successfully assigned to " + assignStaffName);
        } else {
            session.setAttribute("assignClientMsg",
                    "Error assigning " + assignClientName + " to " + assignStaffName);
        }

        session.setAttribute("searchType", "viewAll");
        session.setAttribute("searchFor", "Staff");

        resp.sendRedirect("assignClientForm.jsp");
    }
}
