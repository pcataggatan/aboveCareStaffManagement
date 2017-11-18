package edu.matc.controller;

import edu.matc.entity.Client;
import edu.matc.persistence.ClientDao;
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
        name = "updateClient",
        urlPatterns = {"/update-client"}
)
public class UpdateClient extends HttpServlet {

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

        int clientId = Integer.parseInt(req.getParameter("idClient"));

        Client client = updateClientData(req, clientId);
        String updatedClient = client.getFirstName() + " " + client.getLastName();

        ClientDao clientDao = new ClientDao();

        if (clientDao.updateClient(client).equals("Success")) {
            session.setAttribute("updateMsg", "Client " + updatedClient + " is successfully updated");
        } else {
            session.setAttribute("updateMsg", "Error updating client " + updatedClient);
        }

        saveClientUpdatedData(session, client);

        session.setAttribute("personType", "Client");
        session.setAttribute("searchType", "viewAll");
        session.setAttribute("updatedAlready", "Yes");

        resp.sendRedirect("updatePersonForm.jsp");
    }


    public Client updateClientData(HttpServletRequest req, int clientId) {

        ClientDao clientDao = new ClientDao();
        Client client = clientDao.getClient(clientId);

        client.setFirstName(req.getParameter("firstName"));
        client.setLastName(req.getParameter("lastName"));

        StringBuilder birthDate = new StringBuilder(req.getParameter("birthDt"));
        birthDate.setCharAt(4,'/');
        birthDate.setCharAt(7,'/');
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate birthDt = LocalDate.parse(birthDate, formatter);
        client.setBirthDt(birthDt);

        client.setPhoneNr(req.getParameter("phoneNr"));
        client.setEmail(req.getParameter("email"));
        client.setBillCd(req.getParameter("billCd"));

        client.getAddress().setStreet(req.getParameter("street"));
        client.getAddress().setCity(req.getParameter("city"));
        client.getAddress().setState(req.getParameter("state"));
        client.getAddress().setZipcode(req.getParameter("zipcode"));

        return client;
    }

    public void saveClientUpdatedData(HttpSession session, Client client) {

        session.setAttribute("updtFirstName", client.getFirstName());
        session.setAttribute("updtLastName", client.getLastName());

        StringBuilder dateOfBirth = new StringBuilder(client.getBirthDt().toString());
        dateOfBirth.setCharAt(4,'/');
        dateOfBirth.setCharAt(7,'/');
        session.setAttribute("updtBirthDt", dateOfBirth);

        session.setAttribute("updtPhoneNr", client.getPhoneNr());
        session.setAttribute("updtEmail", client.getEmail());
        session.setAttribute("updtBillCd", client.getBillCd());

        session.setAttribute("updtStreet", client.getAddress().getStreet());
        session.setAttribute("updtCity", client.getAddress().getCity());
        session.setAttribute("updtState", client.getAddress().getState());
        session.setAttribute("updtZipcode", client.getAddress().getZipcode());

    }
}

