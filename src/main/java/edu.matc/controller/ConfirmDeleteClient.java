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
        name = "confirmDeleteClient",
        urlPatterns = {"/confirm-delete-client"}
)

public class ConfirmDeleteClient extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletContext();
        HttpSession session = req.getSession();

        int clientId = Integer.parseInt(req.getParameter("idClient"));
        session.setAttribute("deleteClientId", clientId);

        ClientDao clientDao = new ClientDao();

        Client client = clientDao.getClient(clientId);

        String deletedClient = client.getFirstName() + " " + client.getLastName();

        session.setAttribute("deletedClient", deletedClient);
        session.setAttribute("personType", "Client");
        session.setAttribute("deleteMsg", null);

        RequestDispatcher dispatcher = req.getRequestDispatcher("confirmDeletePerson.jsp");
        dispatcher.forward(req, resp);
    }
}
