package edu.matc.controller;

import edu.matc.entity.Code;
import edu.matc.persistence.GenericDao;
import org.hibernate.criterion.MatchMode;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * This is the AddNewStaffForm servlet. It initializes the data elements for the Staff and forward
 * to the addPersonForm.jsp page.
 *
 *@author Pablo Cataggatan
 */
@WebServlet(
        name = "userHomePage",
        urlPatterns = {"/user-home-page"}
)
public class UserHomePage extends HttpServlet {

    /**
     *  Handles HTTP GET requests.
     *
     *@param  req             the HttpRequest
     *@param  resp            the HttpResponse
     *@exception  ServletException  if there is a general servlet exception
     *@exception  IOException       if there is a general I/O exception
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        session.setAttribute("userRole", getUserRole(req));

        session.setAttribute("staffRateCodeValueMap", loadStaffRateCodeValue());
        session.setAttribute("clientRateCodeValueMap", loadClientRateCodeValue());

        session.setAttribute("loggedIn", "Yes");

        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req, resp);

    }

    public String getUserRole(HttpServletRequest req) {

        String userRole ="";

        if (req.isUserInRole("administrator")) { userRole = "Admin"; }
        if (req.isUserInRole("biz_owner")) { userRole = "Owner"; }
        if (req.isUserInRole("ofc_staff")) { userRole = "OfficeStaff"; }

        return userRole;
    }

    public Map<String, String> loadStaffRateCodeValue() {

        GenericDao codeDao = new GenericDao(Code.class);
        Map<String, String> staffRateCodeValueMap = new TreeMap<>();

        List<Code> staffRateCodes = codeDao.findByProperty("descTx", "Staff rate", MatchMode.START);

        for (Code code : staffRateCodes) {
            staffRateCodeValueMap.put(code.getCodeCode(), code.getCodeValue());
        }

        return staffRateCodeValueMap;
    }

    public Map<String, String> loadClientRateCodeValue() {

        GenericDao codeDao = new GenericDao(Code.class);
        Map<String, String> clientRateCodeValueMap = new TreeMap<>();

        List<Code> clientRateCodes = codeDao.findByProperty("descTx", "Client rate", MatchMode.START);

        for (Code code : clientRateCodes) {
            clientRateCodeValueMap.put(code.getCodeCode(), code.getCodeValue());
        }

        return clientRateCodeValueMap;
    }

}
