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
        name = "updatePersonForm",
        urlPatterns = {"/update-person-form"}
)

public class UpdatePersonForm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletContext();
        HttpSession session = req.getSession();

        int personId = Integer.parseInt(req.getParameter("idPerson"));

        //String personType = req.getParameter("personType");
        String personType = (String) session.getAttribute("personType");


        if (personType.equals("Staff")) {
            prefillUpdateStaffForm(session, personId);
            //session.setAttribute("personType", "Staff");
            session.setAttribute("updateStaffId", personId);
        } else {
            prefillUpdateClientForm(session, personId);
            //session.setAttribute("personType", "Client");
            session.setAttribute("updateClientId", personId);

        }

        session.setAttribute("updateMsg", null);
        session.setAttribute("updatedAlready", "No");

        RequestDispatcher dispatcher = req.getRequestDispatcher("updatePersonForm.jsp");
        dispatcher.forward(req, resp);
    }


    public void prefillUpdateStaffForm(HttpSession session, int personId) {

        StaffDao staffDao = new StaffDao();
        Staff staff = staffDao.getStaff(personId);

        session.setAttribute("firstName", staff.getFirstName());
        session.setAttribute("lastName", staff.getLastName());

        StringBuilder birthDate = new StringBuilder(staff.getBirthDt().toString());
        birthDate.setCharAt(4, '/');
        birthDate.setCharAt(7, '/');

        session.setAttribute("birthDt", birthDate);

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


    public void prefillUpdateClientForm(HttpSession session, int personId) {

        ClientDao clientDao = new ClientDao();
        Client client = clientDao.getClient(personId);

        session.setAttribute("firstName", client.getFirstName());
        session.setAttribute("lastName", client.getLastName());

        StringBuilder birthDate = new StringBuilder(client.getBirthDt().toString());
        birthDate.setCharAt(4,'/');
        birthDate.setCharAt(7,'/');

        session.setAttribute("birthDt", birthDate);

        session.setAttribute("phoneNr", client.getPhoneNr());
        session.setAttribute("email", client.getEmail());
        session.setAttribute("billCd", client.getBillCd());
        session.setAttribute("street", client.getAddress().getStreet());
        session.setAttribute("city", client.getAddress().getCity());
        session.setAttribute("state", client.getAddress().getState());
        session.setAttribute("zipcode", client.getAddress().getZipcode());
    }
}
