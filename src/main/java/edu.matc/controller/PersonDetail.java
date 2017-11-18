package edu.matc.controller;

import edu.matc.entity.Client;
import edu.matc.entity.Staff;
import edu.matc.persistence.ClientDao;
import edu.matc.persistence.StaffDao;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * This is the AddNewStaffForm servlet. It initializes the data elements for the Staff and forward
 * to the addPersonForm.jsp page.
 *
 *@author Pablo Cataggatan
 */
@WebServlet(
        name = "personDetail",
        urlPatterns = {"/person-detail"}
)
public class PersonDetail extends HttpServlet {

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

        int personId = Integer.parseInt(req.getParameter("idPerson"));
        String personType = req.getParameter("personType");

        if (personType.equals("Staff")) {
            session.setAttribute("staffDetail", getStaffDetail(session, personId));
        } else {
            session.setAttribute("clientDetail", getClientDetail(session, personId));
        }

        session.setAttribute("personType", personType);
        session.setAttribute("searchType", "viewAll");

        RequestDispatcher dispatcher = req.getRequestDispatcher("personDetail.jsp");
        dispatcher.forward(req, resp);
    }


    public Staff getStaffDetail(HttpSession session, int personId) {

        StaffDao staffDao = new StaffDao();
        Staff staff = staffDao.getStaff(personId);

        Map<String, String> staffRateCodeValueMap =
                (Map<String, String>) session.getAttribute("staffRateCodeValueMap");

        staff.setHourlyRate(staffRateCodeValueMap.get(staff.getPayCd()));

        return staff;
    }


    public Client getClientDetail(HttpSession session, int personId) {

        ClientDao clientDao = new ClientDao();
        Client client = clientDao.getClient(personId);

        Map<String, String> clientRateCodeValueMap =
                (Map<String, String>) session.getAttribute("clientRateCodeValueMap");

        client.setHourlyRate(clientRateCodeValueMap.get(client.getBillCd()));

        return client;
    }
}
