package edu.matc.controller;

import edu.matc.entity.Address;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@WebServlet(
        name = "updateStaff",
        urlPatterns = {"/update-staff"}
)

public class UpdateStaff extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletContext();
        HttpSession session = req.getSession();

        int staffId = Integer.parseInt(req.getParameter("idStaff"));

        StaffDao staffDao = new StaffDao();

        Staff staff = staffDao.getStaff(staffId);

        // for debugging ----------------------------------------
        String xfirstName = req.getParameter("firstName");
        String xlastName = req.getParameter("lastName");
        String xbirthDt = req.getParameter("birthDt");
        String xphoneNr = req.getParameter("phoneNr");
        String xemail = req.getParameter("email");
        String xjobTitle = req.getParameter("jobTitle");
        String xpayCd = req.getParameter("payCd");
        String xstreet = req.getParameter("street");
        String xcity = req.getParameter("city");
        String xstate = req.getParameter("state");
        String xzipcode = req.getParameter("zipcode");
        // ------------------------------------------------------

        staff.setFirstName(req.getParameter("firstName"));
        staff.setLastName(req.getParameter("lastName"));

        StringBuilder birthDate = new StringBuilder(req.getParameter("birthDt"));
        birthDate.setCharAt(4,'/');
        birthDate.setCharAt(7,'/');

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate birthDt = LocalDate.parse(birthDate, formatter);

        staff.setBirthDt(birthDt);

        staff.setPhoneNr(req.getParameter("phoneNr"));
        staff.setEmail(req.getParameter("email"));
        staff.setJobTitle(req.getParameter("jobTitle"));
        staff.setPayCd(req.getParameter("payCd"));

        staff.getAddress().setStreet(req.getParameter("street"));
        staff.getAddress().setCity(req.getParameter("city"));
        staff.getAddress().setState(req.getParameter("state"));
        staff.getAddress().setZipcode(req.getParameter("zipcode"));

        String updatedStaff = staff.getFirstName() + " " + staff.getLastName();

        String updtMsg = staffDao.updateStaff(staff);

        if (updtMsg.equals("Success")) {
            session.setAttribute("updateMsg", "Staff Successfully Updated");
        } else {
            session.setAttribute("updateMsg", "Error Updating Staff");
        }

        session.setAttribute("updatedStaff", updatedStaff);
        session.setAttribute("updatePersonType", "Staff");
        session.setAttribute("searchType", "viewAll");
        session.setAttribute("searchFor", "Staff");

        resp.sendRedirect("personUpdated.jsp");

    }
}

