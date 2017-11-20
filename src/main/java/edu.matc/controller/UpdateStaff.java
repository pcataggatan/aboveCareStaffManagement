package edu.matc.controller;

import edu.matc.entity.Staff;
import edu.matc.persistence.GenericDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * This is the AddNewStaffForm servlet. It initializes the data elements for the Staff and forward
 * to the addPersonForm.jsp page.
 *
 *@author Pablo Cataggatan
 */
@WebServlet(
        name = "updateStaff",
        urlPatterns = {"/update-staff"}
)
public class UpdateStaff extends HttpServlet {

    /**
     *  Handles HTTP GET requests.
     *
     *@param  req             the HttpRequest
     *@param  resp            the HttpResponse
     *@exception  ServletException  if there is a general servlet exception
     *@exception  IOException       if there is a general I/O exception
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        int staffId = Integer.parseInt(req.getParameter("idStaff"));

        Staff staff = updateStaffData(req, staffId);
        String updatedStaff = staff.getFirstName() + " " + staff.getLastName();

        GenericDao staffDao = new GenericDao(Staff.class);

        if (staffDao.update(staff).equals("Success")) {
            session.setAttribute("updateMsg", "Staff " + updatedStaff + " is successfully updated");
        } else {
            session.setAttribute("updateMsg", "Error updating Staff " + updatedStaff);
        }

        saveStaffUpdatedData(session, staff);

        session.setAttribute("personType", "Staff");
        session.setAttribute("searchType", "viewAll");
        session.setAttribute("updatedAlready", "Yes");

        resp.sendRedirect("updatePersonForm.jsp");
    }


    public Staff updateStaffData(HttpServletRequest req, int staffId) {

        GenericDao staffDao = new GenericDao(Staff.class);
        Staff staff = (Staff) staffDao.get(staffId);

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
        staff.setSchedule(req.getParameter("schedule"));

        staff.getAddress().setStreet(req.getParameter("street"));
        staff.getAddress().setCity(req.getParameter("city"));
        staff.getAddress().setState(req.getParameter("state"));
        staff.getAddress().setZipcode(req.getParameter("zipcode"));

        return staff;
    }

    public void saveStaffUpdatedData(HttpSession session, Staff staff) {

        session.setAttribute("updtFirstName", staff.getFirstName());
        session.setAttribute("updtLastName", staff.getLastName());

        StringBuilder dateOfBirth = new StringBuilder(staff.getBirthDt().toString());
        dateOfBirth.setCharAt(4,'/');
        dateOfBirth.setCharAt(7,'/');
        session.setAttribute("updtBirthDt", dateOfBirth);

        session.setAttribute("updtPhoneNr", staff.getPhoneNr());
        session.setAttribute("updtEmail", staff.getEmail());
        session.setAttribute("updtJobTitle", staff.getJobTitle());
        session.setAttribute("updtPayCd", staff.getPayCd());
        session.setAttribute("updtSchedule", staff.getSchedule());

        session.setAttribute("updtStreet", staff.getAddress().getStreet());
        session.setAttribute("updtCity", staff.getAddress().getCity());
        session.setAttribute("updtState", staff.getAddress().getState());
        session.setAttribute("updtZipcode", staff.getAddress().getZipcode());
    }
}

