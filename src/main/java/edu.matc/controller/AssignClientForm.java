package edu.matc.controller;

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

@WebServlet(
        name = "assignClientForm",
        urlPatterns = {"/assign-client-form"}
)

public class AssignClientForm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletContext();
        HttpSession session = req.getSession();

        int staffId = Integer.parseInt(req.getParameter("idStaff"));
        session.setAttribute("assignToStaffId", staffId);

        StaffDao staffDao = new StaffDao();

        Staff staff = staffDao.getStaff(staffId);

        String assignClientToStaff = staff.getFirstName() + " " + staff.getLastName();

        session.setAttribute("assignToStaff", assignClientToStaff);
        session.setAttribute("assignClientMsg", " ");

        RequestDispatcher dispatcher = req.getRequestDispatcher("assignClientForm.jsp");
        dispatcher.forward(req, resp);
    }
}