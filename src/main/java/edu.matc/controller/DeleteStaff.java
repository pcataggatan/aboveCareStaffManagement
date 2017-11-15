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

        int staffId = (Integer) session.getAttribute("deleteStaffId");

        StaffDao staffDao = new StaffDao();

        Staff staff = staffDao.getStaff(staffId);

        if (staff == null) {
            session.setAttribute("deleteMsg", "Staff does not exist anymore");
        } else {
            deleteStaff(session, staff, staffId);
        }

        session.setAttribute("searchType", "viewAll");
        session.setAttribute("personType", "Staff");

        RequestDispatcher dispatcher = req.getRequestDispatcher("deletePerson.jsp");
        dispatcher.forward(req, resp);
    }


    public void deleteStaff(HttpSession session, Staff staff, int staffId) {

        Set<Client> clients = staff.getClients();

        for (Client client : clients) {
            ClientDao updtClientDao = new ClientDao();
            Client updtClient = updtClientDao.getClient(client.getClientId());
            Staff nullStaff = null;
            updtClient.setStaff(nullStaff);
            String updtMsg = updtClientDao.updateClient(updtClient);
        }

        String deleteStaffName = staff.getFirstName() + " " + staff.getLastName();

        StaffDao staffDao = new StaffDao();

        String deleteMsg = staffDao.deleteStaff(staffId);

        if (deleteMsg.equals("Success")) {
            session.setAttribute("deleteMsg", "Staff " + deleteStaffName + " is successfully deleted");
        } else {
            session.setAttribute("deleteMsg", "Error deleting Staff " + deleteStaffName);
        }

    }
}

