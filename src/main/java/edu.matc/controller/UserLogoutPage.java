package edu.matc.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * This is the UserLogoutPage servlet. It invalidates the current session and redirects the response to to the
 * userLogout.jsp page.
 *
 *@author Pablo Cataggatan
 */
@WebServlet(
        name = "userLogoutPage",
        urlPatterns = {"/user-logout-page"}
)
public class UserLogoutPage extends HttpServlet {

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

        req.getSession().invalidate();
        resp.sendRedirect("userLogout.jsp");
    }
}
