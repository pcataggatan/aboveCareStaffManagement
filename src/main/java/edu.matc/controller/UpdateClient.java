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
        name = "updateClient",
        urlPatterns = {"/update-client"}
)

public class UpdateClient extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletContext();
        HttpSession session = req.getSession();

        int clientId = Integer.parseInt(req.getParameter("idClient"));

        ClientDao clientDao = new ClientDao();

        Client client = clientDao.getClient(clientId);

        // for debugging ----------------------------------------
        String xfirstName = req.getParameter("firstName");
        String xlastName = req.getParameter("lastName");
        String xbirthDt = req.getParameter("birthDt");
        String xphoneNr = req.getParameter("phoneNr");
        String xemail = req.getParameter("email");
        String xpayCd = req.getParameter("billCd");
        String xstreet = req.getParameter("street");
        String xcity = req.getParameter("city");
        String xstate = req.getParameter("state");
        String xzipcode = req.getParameter("zipcode");
        // ------------------------------------------------------

        client.setFirstName(req.getParameter("firstName"));
        client.setLastName(req.getParameter("lastName"));
        client.setPhoneNr(req.getParameter("phoneNr"));
        client.setEmail(req.getParameter("email"));
        client.setBillCd(req.getParameter("billCd"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthDt = LocalDate.parse(req.getParameter("birthDt"), formatter);

        client.setBirthDt(birthDt);

        client.getAddress().setStreet(req.getParameter("street"));
        client.getAddress().setCity(req.getParameter("city"));
        client.getAddress().setState(req.getParameter("state"));
        client.getAddress().setZipcode(req.getParameter("zipcode"));

        String updatedClient = client.getFirstName() + " " + client.getLastName();

        String updtMsg = clientDao.updateClient(client);

        if (updtMsg.equals("Success")) {
            session.setAttribute("updateMsg", "Client Successfully Updated");
        } else {
            session.setAttribute("updateMsg", "Error Updating Client");
        }

        session.setAttribute("updatedClient", updatedClient);
        session.setAttribute("updatePersonType", "Client");
        session.setAttribute("searchType", "viewAll");
        session.setAttribute("searchFor", "Client");

        resp.sendRedirect("personUpdated.jsp");

    }
}

