package edu.matc.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.com.zipcodeapi.Response;
import edu.matc.com.zipcodeapi.ZipCodesItem;
import edu.matc.entity.Staff;
import edu.matc.persistence.ClientDao;
import edu.matc.persistence.StaffDao;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@WebServlet(
        name = "clientZipCode",
        urlPatterns = {"/client-zipcode"}
)

public class ClientZipCode extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletContext();
        HttpSession session = req.getSession();

        String apiZipcode = req.getParameter("targetZipCode");
        String apiRadius = req.getParameter("targetRadius");;
        String apiKey = "7BUFiqTcqrWSjNIS1jKCOlkK31QPyEVn50rQZbzeFJxt749jKyz87K03U55ysqLx";
        String apiFormat = "json";
        String apiUnit = "mile";

        Client client = ClientBuilder.newClient();

        WebTarget target = client.target("http://www.zipcodeapi.com/rest/"
                + apiKey + "/radius." + apiFormat + "/"
                + apiZipcode + "/" + apiRadius + "/" + apiUnit);

        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();

        Response zipcodes = mapper.readValue(response, Response.class);
        List<ZipCodesItem> zipCodeList = zipcodes.getZipCodes();

        StaffDao staffDao = new StaffDao();
        List<Staff> staffList = staffDao.getAllStaffs();

        List<Staff> possibleStaff = new ArrayList<Staff>();

        for (Staff staff : staffList) {
            if (staff.getAddress().getZipcode().equals(apiZipcode)) {
                possibleStaff.add(staff);
            } else {
                for (ZipCodesItem zipcode : zipCodeList) {
                    if (staff.getAddress().getZipcode().equals(zipcode.getZipCode())) {
                        possibleStaff.add(staff);
                        break;
                    }
                }
            }
        }

        session.setAttribute("possibleStaff", possibleStaff);
        session.setAttribute("targetZipCode", apiZipcode);
        session.setAttribute("targetRadius", apiRadius);

        RequestDispatcher dispatcher = req.getRequestDispatcher("possibleStaff.jsp");
        dispatcher.forward(req, resp);
    }
}
