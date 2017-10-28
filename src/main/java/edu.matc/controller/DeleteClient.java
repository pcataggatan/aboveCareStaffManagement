package edu.matc.controller;

import edu.matc.entity.Client;
import edu.matc.entity.Staff;
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


@WebServlet(
        name = "deleteClient",
        urlPatterns = {"/delete-client"}
)

public class DeleteClient extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletContext();
        HttpSession session = req.getSession();

        int clientId = Integer.parseInt(req.getParameter("idClient"));

        ClientDao clientDao = new ClientDao();

        Client client = clientDao.getClient(clientId);

        if (client.getStaff() != null) {
            Staff staff = null;
            client.setStaff(staff);
            String updtMsg = clientDao.updateClient(client);
        }

        String deletedClient = client.getFirstName() + " " + client.getLastName();

        session.setAttribute("deletedClient", deletedClient);
        session.setAttribute("deletePersonType", "Client");

        String deleteMsg = clientDao.deleteClient(clientId);
        if (deleteMsg.equals("Success")) {
            session.setAttribute("deleteMsg", "Client Successfully Deleted");
        } else {
            session.setAttribute("deleteMsg", "Error Deleting Client");
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("deletePerson.jsp");
        dispatcher.forward(req, resp);
    }
}

