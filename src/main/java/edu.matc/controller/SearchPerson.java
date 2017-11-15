package edu.matc.controller;


import edu.matc.entity.Client;
import edu.matc.entity.Code;
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
        name = "searchPerson",
        urlPatterns = {"/search-person"}
)
public class SearchPerson extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletContext();
        HttpSession session = req.getSession();

        String personType = (String) session.getAttribute("personType");

        if (personType.equals("Staff")) {
            session.setAttribute("staffList", searchStaff(req));
        } else {
            session.setAttribute("clientList", searchClient(req));
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("searchPersonResult.jsp");
        dispatcher.forward(req, resp);
    }



    public List<Staff> searchStaff(HttpServletRequest req) {

        StaffDao staffDao = new StaffDao();
        List<Staff> staffList = null;

        if (req.getParameter("searchType").equals("byLastname")) {
            staffList = staffDao.getStaffByLastName(req.getParameter("searchTerm"));
        } else {
            staffList = staffDao.getAllStaffs();
        }

        return staffList;
    }



    public List<Client> searchClient(HttpServletRequest req) {

        ClientDao clientDao = new ClientDao();
        List<Client> clientList = null;

        if (req.getParameter("searchType").equals("byLastname")) {
            clientList = clientDao.getClientByLastName(req.getParameter("searchTerm"));
        } else {
            clientList = clientDao.getAllClients();
        }

        return clientList;
    }

}


