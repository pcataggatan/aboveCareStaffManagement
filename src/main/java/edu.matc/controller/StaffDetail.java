package edu.matc.controller;

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
        name = "staffDetail",
        urlPatterns = {"/staff-detail"}
)

public class StaffDetail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletContext();
        HttpSession session = req.getSession();

        StaffDao staffDao = new StaffDao();

        int staffId = Integer.parseInt(req.getParameter("idStaff"));

        session.setAttribute("staffDetail", staffDao.getStaff(staffId));
        session.setAttribute("personDetail","Staff");

        session.setAttribute("searchType", "viewAll");
        session.setAttribute("searchFor", "Staff");

        RequestDispatcher dispatcher = req.getRequestDispatcher("personDetail.jsp");
        dispatcher.forward(req, resp);
    }
}
