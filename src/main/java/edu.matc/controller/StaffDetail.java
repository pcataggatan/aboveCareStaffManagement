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
import java.util.List;


@WebServlet(
        name = "staffDetail",
        urlPatterns = {"/staff-detail"}
)

public class StaffDetail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletContext();
        HttpSession session = req.getSession();

        int staffId = Integer.parseInt(req.getParameter("idStaff"));

        StaffDao staffDao = new StaffDao();

        Staff staff = staffDao.getStaff(staffId);


        List<Code> staffRateCodes = (List<Code>) session.getAttribute("staffRateCodes");

        for (Code rateCode : staffRateCodes) {
            if (staff.getPayCd().equals(rateCode.getCodeCode())) {
                staff.setHourlyRate(rateCode.getCodeValue());
                break;
            }
        }


        //session.setAttribute("staffDetail", staffDao.getStaff(staffId));
        session.setAttribute("staffDetail", staff);
        session.setAttribute("personDetail","Staff");

        session.setAttribute("searchType", "viewAll");
        session.setAttribute("searchFor", "Staff");

        RequestDispatcher dispatcher = req.getRequestDispatcher("personDetail.jsp");
        dispatcher.forward(req, resp);
    }
}
