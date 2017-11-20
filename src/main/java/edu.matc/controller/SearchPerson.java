package edu.matc.controller;

import edu.matc.entity.Client;
import edu.matc.entity.Staff;
import edu.matc.persistence.GenericDao;
import org.hibernate.criterion.MatchMode;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * This is the AddNewStaffForm servlet. It initializes the data elements for the Staff and forward
 * to the addPersonForm.jsp page.
 *
 *@author Pablo Cataggatan
 */
@WebServlet(
        name = "searchPerson",
        urlPatterns = {"/search-person"}
)
public class SearchPerson extends HttpServlet {

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

        GenericDao staffDao = new GenericDao(Staff.class);
        List<Staff> staffList = null;
        String searchTerm = req.getParameter("searchTerm");

        if (req.getParameter("searchType").equals("byLastname")) {
            staffList = staffDao.findByProperty("lastName", searchTerm, MatchMode.ANYWHERE);
        } else {
            staffList = staffDao.getAll();
        }

        return staffList;
    }


    public List<Client> searchClient(HttpServletRequest req) {

        GenericDao clientDao = new GenericDao(Client.class);
        List<Client> clientList = null;
        String searchTerm = req.getParameter("searchTerm");

        if (req.getParameter("searchType").equals("byLastname")) {
            clientList = clientDao.findByProperty("lastName", searchTerm, MatchMode.ANYWHERE);
        } else {
            clientList = clientDao.getAll();
        }

        return clientList;
    }

}


