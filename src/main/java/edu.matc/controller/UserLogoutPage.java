package edu.matc.controller;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(
        name = "userLogoutPage",
        urlPatterns = {"/user-logout-page"}
)
public class UserLogoutPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletContext();
        HttpSession session = req.getSession();
        session.setAttribute("userRole", "None");
        req.getSession().invalidate();
        resp.sendRedirect("userLogout.jsp");
    }

}
