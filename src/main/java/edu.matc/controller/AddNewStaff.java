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
        name = "addNewStaff",
        urlPatterns = {"/add-new-staff"}
)

public class AddNewStaff extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletContext();
        HttpSession session = req.getSession();


        Staff staff = getStaffDataEntries(req);
        String addedStaff = staff.getFirstName() + " " + staff.getLastName();

        StaffDao staffDao = new StaffDao();
        int addStaffId = staffDao.addStaff(staff);

        if (addStaffId == 0) {
            session.setAttribute("addMsg", "Error adding new Staff " + addedStaff);
        } else {
            session.setAttribute("addMsg", "New Staff " + addedStaff + " is successfully added");
        }

        saveStaffDataEntries(session, staff);

        session.setAttribute("personType", "Staff");
        session.setAttribute("searchType", "viewAll");
        session.setAttribute("addedAlready", "Yes");

        resp.sendRedirect("addPersonForm.jsp");

    }


    public Staff getStaffDataEntries(HttpServletRequest req) {

        Staff staff = new Staff();

        staff.setFirstName(req.getParameter("firstName"));
        staff.setLastName(req.getParameter("lastName"));
        staff.setPhoneNr(req.getParameter("phoneNr"));
        staff.setEmail(req.getParameter("email"));
        staff.setJobTitle(req.getParameter("jobTitle"));
        staff.setPayCd(req.getParameter("payCd"));

        StringBuilder birthDate = new StringBuilder(req.getParameter("birthDt"));
        birthDate.setCharAt(4,'/');
        birthDate.setCharAt(7,'/');

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate birthDt = LocalDate.parse(birthDate, formatter);
        staff.setBirthDt(birthDt);

        Address  address = new Address();

        address.setStreet(req.getParameter("street"));
        address.setCity(req.getParameter("city"));
        address.setState(req.getParameter("state"));
        address.setZipcode(req.getParameter("zipcode"));

        staff.setAddress(address);

        return staff;
    }


    public void saveStaffDataEntries(HttpSession session, Staff staff) {

        session.setAttribute("firstName", staff.getFirstName());
        session.setAttribute("lastName", staff.getLastName());

        StringBuilder dateOfBirth = new StringBuilder(staff.getBirthDt().toString());
        dateOfBirth.setCharAt(4,'/');
        dateOfBirth.setCharAt(7,'/');
        session.setAttribute("birthDt", dateOfBirth);

        session.setAttribute("phoneNr", staff.getPhoneNr());
        session.setAttribute("email", staff.getEmail());
        session.setAttribute("jobTitle", staff.getJobTitle());
        session.setAttribute("payCd", staff.getPayCd());
        session.setAttribute("street", staff.getAddress().getStreet());
        session.setAttribute("city", staff.getAddress().getCity());
        session.setAttribute("state", staff.getAddress().getState());
        session.setAttribute("zipcode", staff.getAddress().getZipcode());
    }

}


