package edu.matc.controller;

import edu.matc.entity.Client;
import edu.matc.persistence.ClientDao;
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
        name = "deleteClient",
        urlPatterns = {"/delete-client"}
)
public class DeleteClient extends HttpServlet {

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

        int clientId = (Integer) session.getAttribute("deleteClientId");

        ClientDao clientDao = new ClientDao();
        Client client = clientDao.getClient(clientId);

        if (client == null) {
            session.setAttribute("deleteMsg", "Client does not exist anymore");
        } else {
            deleteClient(session, client, clientId);
        }

        session.setAttribute("searchType", "viewAll");
        session.setAttribute("personType", "Client");

        RequestDispatcher dispatcher = req.getRequestDispatcher("deletePerson.jsp");
        dispatcher.forward(req, resp);
    }


    public void deleteClient(HttpSession session, Client client, int clientId) {

        ClientDao clientDao = new ClientDao();

        if (client.getStaff() != null) {
            client.setStaff(null);
            String updtMsg = clientDao.updateClient(client);
        }

        String deleteClientName = client.getFirstName() + " " + client.getLastName();
        String deleteMsg = clientDao.deleteClient(clientId);

        if (deleteMsg.equals("Success")) {
            session.setAttribute("deleteMsg", "Client " + deleteClientName + " is successfully deleted");
        } else {
            session.setAttribute("deleteMsg", "Error deleting Client " + deleteClientName);
        }
    }
}

