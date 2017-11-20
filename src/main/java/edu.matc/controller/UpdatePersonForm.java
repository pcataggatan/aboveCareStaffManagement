package edu.matc.controller;

import edu.matc.entity.Client;
import edu.matc.entity.Staff;
import edu.matc.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * This is the AddNewStaffForm servlet. It initializes the data elements for the Staff and forward
 * to the addPersonForm.jsp page.
 *
 *@author Pablo Cataggatan
 */
@WebServlet(
        name = "updatePersonForm",
        urlPatterns = {"/update-person-form"}
)
public class UpdatePersonForm extends HttpServlet {

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

        int personId = Integer.parseInt(req.getParameter("idPerson"));
        String personType = (String) session.getAttribute("personType");

        if (personType.equals("Staff")) {
            prefillUpdateStaffForm(session, personId);
            session.setAttribute("updateStaffId", personId);
        } else {
            prefillUpdateClientForm(session, personId);
            session.setAttribute("updateClientId", personId);
        }

        session.setAttribute("updateMsg", null);
        session.setAttribute("updatedAlready", "No");

        RequestDispatcher dispatcher = req.getRequestDispatcher("updatePersonForm.jsp");
        dispatcher.forward(req, resp);
    }


    public void prefillUpdateStaffForm(HttpSession session, int personId) {

        GenericDao staffDao = new GenericDao(Staff.class);
        Staff staff = (Staff) staffDao.get(personId);

        session.setAttribute("updtFirstName", staff.getFirstName());
        session.setAttribute("updtLastName", staff.getLastName());

        StringBuilder birthDate = new StringBuilder(staff.getBirthDt().toString());
        birthDate.setCharAt(4, '/');
        birthDate.setCharAt(7, '/');
        session.setAttribute("updtBirthDt", birthDate);

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


    public void prefillUpdateClientForm(HttpSession session, int personId) {

        GenericDao clientDao = new GenericDao(Client.class);
        Client client = (Client) clientDao.get(personId);

        session.setAttribute("updtFirstName", client.getFirstName());
        session.setAttribute("updtLastName", client.getLastName());

        StringBuilder birthDate = new StringBuilder(client.getBirthDt().toString());
        birthDate.setCharAt(4,'/');
        birthDate.setCharAt(7,'/');
        session.setAttribute("updtBirthDt", birthDate);

        session.setAttribute("updtPhoneNr", client.getPhoneNr());
        session.setAttribute("updtEmail", client.getEmail());
        session.setAttribute("updtBillCd", client.getBillCd());

        session.setAttribute("updtStreet", client.getAddress().getStreet());
        session.setAttribute("updtCity", client.getAddress().getCity());
        session.setAttribute("updtState", client.getAddress().getState());
        session.setAttribute("updtZipcode", client.getAddress().getZipcode());
    }
}
