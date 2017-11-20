package edu.matc.controller;

import edu.matc.entity.Address;
import edu.matc.entity.Client;
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
        name = "addNewClient",
        urlPatterns = {"/add-new-client"}
)
public class AddNewClient extends HttpServlet {

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

        Client client = getClientDataEntries(req);
        String addedClient = client.getFirstName() + " " + client.getLastName();

        GenericDao clientDao = new GenericDao(Client.class);

        if (clientDao.create(client) == 0) {
            session.setAttribute("addMsg", "Error adding new Client " + addedClient);
        } else {
            session.setAttribute("addMsg", "New Client " + addedClient + " is successfully added");
        }

        saveClientDataEntries(session, client);

        session.setAttribute("addedClient", addedClient);
        session.setAttribute("personType", "Client");
        session.setAttribute("searchType", "viewAll");
        session.setAttribute("addedAlready", "Yes");

        resp.sendRedirect("addPersonForm.jsp");
    }



    public Client getClientDataEntries(HttpServletRequest req) {

        Client client = new Client();

        client.setFirstName(req.getParameter("firstName"));
        client.setLastName(req.getParameter("lastName"));
        client.setPhoneNr(req.getParameter("phoneNr"));
        client.setEmail(req.getParameter("email"));
        client.setBillCd(req.getParameter("billCd"));

        StringBuilder birthDate = new StringBuilder(req.getParameter("birthDt"));
        birthDate.setCharAt(4,'/');
        birthDate.setCharAt(7,'/');
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate birthDt = LocalDate.parse(birthDate, formatter);
        client.setBirthDt(birthDt);

        Address  address = new Address();

        address.setStreet(req.getParameter("street"));
        address.setCity(req.getParameter("city"));
        address.setState(req.getParameter("state"));
        address.setZipcode(req.getParameter("zipcode"));

        client.setAddress(address);

        return client;
    }


    public void saveClientDataEntries(HttpSession session, Client client) {

        session.setAttribute("firstName", client.getFirstName());
        session.setAttribute("lastName", client.getLastName());

        StringBuilder dateOfBirth = new StringBuilder(client.getBirthDt().toString());
        dateOfBirth.setCharAt(4,'/');
        dateOfBirth.setCharAt(7,'/');
        session.setAttribute("birthDt", dateOfBirth);

        session.setAttribute("phoneNr", client.getPhoneNr());
        session.setAttribute("email", client.getEmail());
        session.setAttribute("billCd", client.getBillCd());
        session.setAttribute("street", client.getAddress().getStreet());
        session.setAttribute("city", client.getAddress().getCity());
        session.setAttribute("state", client.getAddress().getState());
        session.setAttribute("zipcode", client.getAddress().getZipcode());
    }
}
