package edu.matc.controller;

import edu.matc.persistence.ClientDao;
import edu.matc.persistence.UserDao;

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

        UserDao userDao = new UserDao();


        String userRole = req.getParameter("userRole");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String loginBtn = req.getParameter("loginBtn");


        if (loginBtn.equals("Login")) {
            req.setAttribute("userRole",userRole);
            String invalidMsg = userDao.validateUser(username, password);

            if (invalidMsg.equals("")) {
                RequestDispatcher dispatcher = req.getRequestDispatcher("userMainPage.jsp");
                dispatcher.forward(req, resp);
            } else {
                req.setAttribute("invalidLoginMsg", invalidMsg);
                RequestDispatcher dispatcher = req.getRequestDispatcher("userLoginForm.jsp");
                dispatcher.forward(req, resp);
            }
        } else {
            // there's a proper way to link to homepage
            RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
