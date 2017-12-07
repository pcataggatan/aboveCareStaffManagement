package edu.matc.controller;

import edu.matc.entity.Address;
import edu.matc.entity.Staff;
import edu.matc.persistence.GenericDao;
import org.apache.log4j.Logger;

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
 * This is the AddNewStaff servlet. It retrieves the data from the request parameters and calls the generic dao's
 * create() method to add a new row to the Staff table. It then redirects the response to the AddPersonForm.jsp page
 * indicating success or failure from the Staff table insert operation.
 *
 *@author Pablo Cataggatan
 */
@WebServlet(
        name = "addNewStaff",
        urlPatterns = {"/add-new-staff"}
)
public class AddNewStaff extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     *  Handles HTTP GET requests.
     *
     *@param  req             the HttpRequest
     *@param  resp            the HttpResponse
     *@exception  ServletException  if there is a general servlet exception
     *@exception  IOException       if there is a general I/O exception
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        Staff staff = getStaffDataEntries(req);
        String addedStaff = staff.getFirstName() + " " + staff.getLastName();

        GenericDao staffDao = new GenericDao(Staff.class);

        if (staffDao.create(staff) == 0) {
            session.setAttribute("addMsg", "Error adding new Staff " + addedStaff);
            log.error("There's an error when adding new Staff to the staff table");
        } else {
            session.setAttribute("addMsg", "New Staff " + addedStaff + " is successfully added");
        }

        saveStaffDataEntries(session, staff);

        session.setAttribute("personType", "Staff");
        session.setAttribute("searchType", "viewAll");
        session.setAttribute("addedAlready", "Yes");

        resp.sendRedirect("addPersonForm.jsp");
    }


    /**
     * Gets the values of the request parameters and populates the Staff object's attributes.
     * @param req the HttpRequest
     * @return A Staff object
     */
    public Staff getStaffDataEntries(HttpServletRequest req) {

        Staff staff = new Staff();

        staff.setFirstName(req.getParameter("firstName"));
        staff.setLastName(req.getParameter("lastName"));
        staff.setPhoneNr(req.getParameter("phoneNr"));
        staff.setEmail(req.getParameter("email"));
        staff.setJobTitle(req.getParameter("jobTitle"));
        staff.setPayCd(req.getParameter("payCd"));
        staff.setSchedule(req.getParameter("schedule"));

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

    /**
     * Saves the values of Staff's attributes to session variables needed for displaying data on the form.
     * @param session The HttpSession
     * @param staff The Client object
     */
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
        session.setAttribute("schedule", staff.getSchedule());

        session.setAttribute("street", staff.getAddress().getStreet());
        session.setAttribute("city", staff.getAddress().getCity());
        session.setAttribute("state", staff.getAddress().getState());
        session.setAttribute("zipcode", staff.getAddress().getZipcode());
    }

}


