package edu.matc.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * This is the SearchPersonForm servlet. It retrieves the person type from the request parameter and saves it to a
 * session variable needed to distinguish the data being displayed on the search result page. It forwards the request/
 * response to the searchPersonForm.jsp page.
 *
 *@author Pablo Cataggatan
 */
@WebServlet(
        name = "searchPersonForm",
        urlPatterns = {"/search-person-form"}
)
public class SearchPersonForm extends HttpServlet {

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

        HttpSession session = req.getSession();
        session.setAttribute("personType", req.getParameter("personType"));

        RequestDispatcher dispatcher = req.getRequestDispatcher("searchPersonForm.jsp");
        dispatcher.forward(req, resp);
    }
}

