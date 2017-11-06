package edu.matc.controller;

import edu.matc.entity.Client;
import edu.matc.entity.Code;
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
import java.util.List;


@WebServlet(
        name = "clientDetail",
        urlPatterns = {"/client-detail"}
)

public class ClientDetail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletContext();
        HttpSession session = req.getSession();

        int clientId = Integer.parseInt(req.getParameter("idClient"));

        ClientDao clientDao = new ClientDao();

        Client client = clientDao.getClient(clientId);


        List<Code> clientRateCodes = (List<Code>) session.getAttribute("clientRateCodes");

        for (Code rateCode : clientRateCodes) {
            if (client.getBillCd().equals(rateCode.getCodeCode())) {
                client.setHourlyRate(rateCode.getCodeValue());
                break;
            }
        }


        //session.setAttribute("clientDetail", clientDao.getClient(clientId));
        session.setAttribute("clientDetail", client);
        session.setAttribute("personDetail","Client");

        session.setAttribute("searchType", "viewAll");
        session.setAttribute("searchFor", "Client");

        RequestDispatcher dispatcher = req.getRequestDispatcher("personDetail.jsp");
        dispatcher.forward(req, resp);
    }
}
