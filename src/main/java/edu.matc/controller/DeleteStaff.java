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
        name = "deleteStaff",
        urlPatterns = {"/delete-staff"}
)

public class DeleteStaff extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletContext();
        HttpSession session = req.getSession();

        int staffId = Integer.parseInt(req.getParameter("idStaff"));

        StaffDao staffDao = new StaffDao();

        Staff staff = staffDao.getStaff(staffId);

        Set<Client> clients = staff.getClients();

        for (Client client : clients) {
            ClientDao updtClientDao = new ClientDao();
            Client updtClient = updtClientDao.getClient(client.getClientId());
            Staff nullStaff = null;
            updtClient.setStaff(nullStaff);
            String updtMsg = updtClientDao.updateClient(updtClient);
        }

        String deletedStaff = staff.getFirstName() + " " + staff.getLastName();

        session.setAttribute("deletedStaff", deletedStaff);
        session.setAttribute("deletePersonType", "Staff");

        String deleteMsg = staffDao.deleteStaff(staffId);

        if (deleteMsg.equals("Success")) {
            session.setAttribute("deleteMsg", "Staff Successfully Deleted");
        } else {
            session.setAttribute("deleteMsg", "Error Deleting Staff");
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("deletePerson.jsp");
        dispatcher.forward(req, resp);
    }
}

