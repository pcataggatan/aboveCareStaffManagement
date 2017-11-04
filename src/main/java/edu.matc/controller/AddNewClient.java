package edu.matc.controller;

import edu.matc.entity.Address;
import edu.matc.entity.Client;
import edu.matc.persistence.ClientDao;

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
        name = "addNewClient",
        urlPatterns = {"/add-new-client"}
)

public class AddNewClient extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletContext();
        HttpSession session = req.getSession();

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

        ClientDao clientDao = new ClientDao();

        int addClientId = clientDao.addClient(client);

        String addedClient = client.getFirstName() + " " + client.getLastName();

        session.setAttribute("addedClient", addedClient);

        if (addClientId == 0) {
            session.setAttribute("addMsg", "Error adding new Client " + addedClient);
        } else {
            session.setAttribute("addMsg", "New Client " + addedClient + " is successfully added");
        }


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


        session.setAttribute("addPersonType", "Client");
        session.setAttribute("searchType", "viewAll");
        session.setAttribute("searchFor", "Client");
        session.setAttribute("addedAlready", "Yes");

        //resp.sendRedirect("personAdded.jsp");
        resp.sendRedirect("addPersonForm.jsp");

    }
}
