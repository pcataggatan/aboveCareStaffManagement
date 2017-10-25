package edu.matc.controller;

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
        name = "userHomePage",
        urlPatterns = {"/user-home-page"}
)
public class UserHomePage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletContext();
        HttpSession session = req.getSession();

        String userRole;

        if (req.isUserInRole("administrator")) {
            session.setAttribute("userRole", "Admin");
        } else if (req.isUserInRole("biz_owner")) {
            session.setAttribute("userRole", "Owner");
        } else if (req.isUserInRole("ofc_staff")) {
            session.setAttribute("userRole", "OfficeStaff");
        }

        session.setAttribute("loggedIn", "Yes");
        /*session.setAttribute("loggedOut", "No");*/

        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req, resp);

    }
}