package edu.matc.controller;

import edu.matc.entity.Client;
import edu.matc.entity.Staff;
import edu.matc.persistence.GenericDao;

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
 * This is the PersonDetail servlet. It retrieves either the Client id or Staff id from the request parameter and calls
 * the generic dao's get() method to get the specific row from the Client or Staff table. It then forwards the
 * request/response to the personDetail.jsp page.
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


    /**
     * Gets the information details for the Staff from the staff table and code table.
     * @param session the HttpSession
     * @param personId The Staff's id
     * @return A Staff object
     */
    public Staff getStaffDetail(HttpSession session, int personId) {

        GenericDao staffDao = new GenericDao(Staff.class);
        Staff staff = (Staff) staffDao.get(personId);

        Map<String, String> staffRateCodeValueMap =
                (Map<String, String>) session.getAttribute("staffRateCodeValueMap");

        staff.setHourlyRate(staffRateCodeValueMap.get(staff.getPayCd()));

        return staff;
    }


    /**
     * Gets the information details for the Client from the client table and code table.
     * @param session the HttpSession
     * @param personId The Client's id
     * @return A Client object
     */
    public Client getClientDetail(HttpSession session, int personId) {

        GenericDao clientDao = new GenericDao(Client.class);
        Client client = (Client) clientDao.get(personId);

        Map<String, String> clientRateCodeValueMap =
                (Map<String, String>) session.getAttribute("clientRateCodeValueMap");

        client.setHourlyRate(clientRateCodeValueMap.get(client.getBillCd()));

        return client;
    }
}
