package edu.matc.controller;

import edu.matc.entity.Address;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(
        name = "updateStaffForm",
        urlPatterns = {"/update-staff-form"}
)

public class UpdateStaffForm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletContext();
        HttpSession session = req.getSession();

        int staffId = Integer.parseInt(req.getParameter("idStaff"));

        session.setAttribute("updateStaffId", staffId);

        StaffDao staffDao = new StaffDao();
        Staff staff = staffDao.getStaff(staffId);

        // for debugging -----------------------------
        String firstName =  staff.getFirstName();
        String lastName = staff.getLastName();
        LocalDate birthDt = staff.getBirthDt();
        String phoneNr = staff.getPhoneNr();
        String email = staff.getEmail();
        String jobTitle = staff.getJobTitle();
        String payCd = staff.getPayCd();
        String street = staff.getAddress().getStreet();
        String city = staff.getAddress().getCity();
        String state = staff.getAddress().getState();
        String zipcode = staff.getAddress().getZipcode();
        //---------------------------------------------

        session.setAttribute("firstName", staff.getFirstName());
        session.setAttribute("lastName", staff.getLastName());

        StringBuilder birthDate = new StringBuilder(staff.getBirthDt().toString());
        birthDate.setCharAt(4,'/');
        birthDate.setCharAt(7,'/');

        session.setAttribute("birthDt", birthDate);

        session.setAttribute("phoneNr", staff.getPhoneNr());
        session.setAttribute("email", staff.getEmail());
        session.setAttribute("jobTitle", staff.getJobTitle());
        session.setAttribute("payCd", staff.getPayCd());
        session.setAttribute("street", staff.getAddress().getStreet());
        session.setAttribute("city", staff.getAddress().getCity());
        session.setAttribute("state", staff.getAddress().getState());
        session.setAttribute("zipcode", staff.getAddress().getZipcode());

        session.setAttribute("updatePersonType", "Staff");
        session.setAttribute("updateMsg", null);

        RequestDispatcher dispatcher = req.getRequestDispatcher("updatePersonForm.jsp");
        dispatcher.forward(req, resp);
    }
}