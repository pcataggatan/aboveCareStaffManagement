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
        name = "updateClientForm",
        urlPatterns = {"/update-client-form"}
)

public class UpdateClientForm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletContext();
        HttpSession session = req.getSession();

        int clientId = Integer.parseInt(req.getParameter("idClient"));

        session.setAttribute("updateClientId", clientId);

        ClientDao clientDao = new ClientDao();
        Client client = clientDao.getClient(clientId);

        // for debugging -----------------------------
        String firstName =  client.getFirstName();
        String lastName = client.getLastName();
        LocalDate birthDt = client.getBirthDt();
        String phoneNr = client.getPhoneNr();
        String email = client.getEmail();
        String payCd = client.getBillCd();
        String street = client.getAddress().getStreet();
        String city = client.getAddress().getCity();
        String state = client.getAddress().getState();
        String zipcode = client.getAddress().getZipcode();
        //---------------------------------------------

        session.setAttribute("firstName", client.getFirstName());
        session.setAttribute("lastName", client.getLastName());

        StringBuilder birthDate = new StringBuilder(client.getBirthDt().toString());
        birthDate.setCharAt(4,'/');
        birthDate.setCharAt(7,'/');

        session.setAttribute("birthDt", birthDate);

        session.setAttribute("phoneNr", client.getPhoneNr());
        session.setAttribute("email", client.getEmail());
        session.setAttribute("billCd", client.getBillCd());
        session.setAttribute("street", client.getAddress().getStreet());
        session.setAttribute("city", client.getAddress().getCity());
        session.setAttribute("state", client.getAddress().getState());
        session.setAttribute("zipcode", client.getAddress().getZipcode());

        session.setAttribute("updatePersonType", "Client");
        session.setAttribute("updateMsg", null);

        RequestDispatcher dispatcher = req.getRequestDispatcher("updatePersonForm.jsp");
        dispatcher.forward(req, resp);
    }
}