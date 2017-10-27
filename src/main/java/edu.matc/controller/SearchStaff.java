package edu.matc.controller;


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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@WebServlet(
        name = "searchStaff",
        urlPatterns = {"/search-staff"}
)

public class SearchStaff extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletContext();
        HttpSession session = req.getSession();

        StaffDao staffDao = new StaffDao();

        if (req.getParameter("searchType").equals("byLastname")) {
            List<Staff> staffList = staffDao.getStaffByLastName(req.getParameter("searchTerm"));
            Set<Staff> staffSet = new HashSet<>();
            for (Staff staff : staffList) {
                staffSet.add(staff);
            }
            session.setAttribute("staffList", staffSet);
        } else {
            List<Staff> staffList = staffDao.getAllStaffs();
            Set<Staff> staffSet = new HashSet<>();
            for (Staff staff : staffList) {
                staffSet.add(staff);
            }
            session.setAttribute("staffList", staffSet);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("searchResult.jsp");
        dispatcher.forward(req, resp);
    }
}


