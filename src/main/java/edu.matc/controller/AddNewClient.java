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

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate birthDt = LocalDate.parse(req.getParameter("birthDt"), formatter);

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
            session.setAttribute("addMsg", "Error Adding New Client");
        } else {
            session.setAttribute("addMsg", "New Client Successfully Added");
        }

        session.setAttribute("searchType", "viewAll");
        session.setAttribute("searchFor", "Client");
        resp.sendRedirect("personAdded.jsp");

    }
}
