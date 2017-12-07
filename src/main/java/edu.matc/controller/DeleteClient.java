package edu.matc.controller;

import edu.matc.entity.Client;
import edu.matc.persistence.GenericDao;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * This is the DeleteClient servlet. It retrieves the Client id from the request parameter and calls the generic dao's
 * delete() method to delete the Client from the client table. It then forwards the request/response to the
 * deletePerson.jsp page.
 *
 *@author Pablo Cataggatan
 */
@WebServlet(
        name = "deleteClient",
        urlPatterns = {"/delete-client"}
)
public class DeleteClient extends HttpServlet {

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
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        int clientId = (Integer) session.getAttribute("deleteClientId");

        GenericDao clientDao = new GenericDao(Client.class);
        Client client = (Client) clientDao.get(clientId);

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


    /**
     * Disassociates the Client from the Staff and then deletes the Client from the client table.
     * @param session the HttpSession
     * @param client A Client object
     * @param clientId The Client's id
     */
    public void deleteClient(HttpSession session, Client client, int clientId) {

        GenericDao clientDao = new GenericDao(Client.class);

        //disassociate any staff assigned to this client
        if (client.getStaff() != null) {
            client.setStaff(null);
            String updtMsg = clientDao.update(client);
        }

        String deleteClientName = client.getFirstName() + " " + client.getLastName();
        String deleteMsg = clientDao.delete(clientId);

        if (deleteMsg.equals("Success")) {
            session.setAttribute("deleteMsg", "Client " + deleteClientName + " is successfully deleted");
        } else {
            session.setAttribute("deleteMsg", "Error deleting Client " + deleteClientName);
            log.error("There's an error when deleting a Client from the client table");
        }
    }
}

