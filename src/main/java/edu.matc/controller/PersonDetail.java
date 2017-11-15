package edu.matc.controller;

import edu.matc.entity.Client;
import edu.matc.entity.Code;
import edu.matc.entity.Staff;
import edu.matc.persistence.ClientDao;
import edu.matc.persistence.StaffDao;

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
import java.util.Map;


@WebServlet(
        name = "personDetail",
        urlPatterns = {"/person-detail"}
)

public class PersonDetail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletContext();
        HttpSession session = req.getSession();


        int personId = Integer.parseInt(req.getParameter("idPerson"));

        String personType = req.getParameter("personType");


        if (personType.equals("Staff")) {
            Staff staff = getStaffDetail(session, personId);
            session.setAttribute("staffDetail", staff);
            session.setAttribute("personType","Staff");
        } else {
            Client client = getClientDetail(session, personId);
            session.setAttribute("clientDetail", client);
            session.setAttribute("personType","Client");
        }


        //session.setAttribute("staffDetail", staffDao.getStaff(staffId));
        //session.setAttribute("staffDetail", staff);
        //session.setAttribute("personType","Staff");
        session.setAttribute("searchType", "viewAll");
        //session.setAttribute("searchFor", "Staff");

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
