package edu.matc.controller;

import edu.matc.persistence.ClientDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "userLogin",
        urlPatterns = {"/user-login"}
)
public class UserLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //ServletContext context = getServletContext();
        //HttpSession session = req.getSession();

        ClientDao clientDao = new ClientDao();


        String userRole = req.getParameter("userRole");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String username = req.getParameter("loginBtn");


        if (req.getParameter("login").equals("Login")) {
            req.setAttribute("clients", clientDao.getClientByLastName(req.getParameter("searchTerm")));
        } else {
            req.setAttribute("clients", clientDao.getAllClients());
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("searchClientResults.jsp");
        dispatcher.forward(req, resp);
    }
}
