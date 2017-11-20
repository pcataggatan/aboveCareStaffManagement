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
import java.util.Set;


@WebServlet(
        name = "deleteStaff",
        urlPatterns = {"/delete-staff"}
)

public class DeleteStaff extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        int staffId = (Integer) session.getAttribute("deleteStaffId");

        GenericDao staffDao = new GenericDao(Staff.class);
        Staff staff = (Staff) staffDao.get(staffId);

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

        //disassociate all clients assigned to this staff
        for (Client client : clients) {
            GenericDao updtClientDao = new GenericDao(Client.class);
            Client updtClient = (Client) updtClientDao.get(client.getClientId());
            updtClient.setStaff(null);
            String updtMsg = updtClientDao.update(updtClient);
        }

        String deleteStaffName = staff.getFirstName() + " " + staff.getLastName();

        GenericDao staffDao = new GenericDao(Staff.class);
        String deleteMsg = staffDao.delete(staffId);

        if (deleteMsg.equals("Success")) {
            session.setAttribute("deleteMsg", "Staff " + deleteStaffName + " is successfully deleted");
        } else {
            session.setAttribute("deleteMsg", "Error deleting Staff " + deleteStaffName);
        }

    }
}

