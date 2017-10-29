package edu.matc.controller;


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
import java.util.List;


@WebServlet(
        name = "searchClient",
        urlPatterns = {"/search-client"}
)

public class SearchClient extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletContext();
        HttpSession session = req.getSession();

        ClientDao clientDao = new ClientDao();

        if (req.getParameter("searchType").equals("byLastname")) {
            session.setAttribute("clientList", clientDao.getClientByLastName(req.getParameter("searchTerm")));
        } else {
            session.setAttribute("clientList", clientDao.getAllClients());
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("searchResult.jsp");
        dispatcher.forward(req, resp);
    }
}
