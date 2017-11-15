package edu.matc.controller;

import edu.matc.entity.Client;
import edu.matc.entity.Staff;
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
        name = "confirmDeleteStaff",
        urlPatterns = {"/confirm-delete-staff"}
)

public class ConfirmDeleteStaff extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletContext();
        HttpSession session = req.getSession();

        int staffId = Integer.parseInt(req.getParameter("idStaff"));
        session.setAttribute("deleteStaffId", staffId);

        StaffDao staffDao = new StaffDao();

        Staff staff = staffDao.getStaff(staffId);

        Set<Client> clients = staff.getClients();
        session.setAttribute("clientsForDeletedStaff", clients);

        String deletedStaff = staff.getFirstName() + " " + staff.getLastName();

        session.setAttribute("deletedStaff", deletedStaff);
        session.setAttribute("personType", "Staff");
        session.setAttribute("deleteMsg", null);

        RequestDispatcher dispatcher = req.getRequestDispatcher("confirmDeletePerson.jsp");
        dispatcher.forward(req, resp);
    }
}