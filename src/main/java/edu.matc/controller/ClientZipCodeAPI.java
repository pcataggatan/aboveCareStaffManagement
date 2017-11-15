package edu.matc.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.com.zipcodeapi.Response;
import edu.matc.com.zipcodeapi.ZipCodesItem;
import edu.matc.entity.Staff;
import edu.matc.persistence.StaffDao;
import org.apache.log4j.Logger;

import javax.ws.rs.NotFoundException;
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
import java.util.*;


@WebServlet(
        name = "clientZipCode",
        urlPatterns = {"/client-zipcode"}
)
public class ClientZipCodeAPI extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletContext();
        HttpSession session = req.getSession();

        String apiZipcode = req.getParameter("targetZipCode");
        String apiRadius = req.getParameter("targetRadius");

        String apiKey = "AeRPGqRpbJTueB5iWmN0i6Qgd904ZeXPL3uFhKIyAdQG8VAdlpo7G4KTVXQQtPBi";
        String apiFormat = "json";
        String apiUnit = "mile";


        //Client client = ClientBuilder.newClient();
        //String response = "";

        Map<String, Double> zipDistanceMap = new TreeMap<>();

        try {
            Client client = ClientBuilder.newClient();

            WebTarget target = client.target("http://www.zipcodeapi.com/rest/"
                    + apiKey + "/radius." + apiFormat + "/"
                    + apiZipcode + "/" + apiRadius + "/" + apiUnit);

            String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

            ObjectMapper mapper = new ObjectMapper();

            Response zipcodes = mapper.readValue(response, Response.class);

            for (ZipCodesItem zipCodeItem : zipcodes.getZipCodes()) {
                zipDistanceMap.put(zipCodeItem.getZipCode(), zipCodeItem.getDistance());
            }

        } catch (NotFoundException nfe) {
            log.error("Zip code " + apiZipcode + " does not exist");
            session.setAttribute("errorMsg", "Zipcode does not exist, enter a valid zipcode");
            RequestDispatcher dispatcher = req.getRequestDispatcher("clientZipCodeForm.jsp");
            dispatcher.forward(req, resp);
            return;

        } catch (Exception e) {
            log.error("Bad or invalid Zipcode " + apiZipcode);
            session.setAttribute("errorMsg", "Bad or invalid Zipcode, enter a valid zipcode");
            RequestDispatcher dispatcher = req.getRequestDispatcher("clientZipCodeForm.jsp");
            dispatcher.forward(req, resp);
            return;
        }


        StaffDao staffDao = new StaffDao();
        List<Staff> staffList = staffDao.getAllStaffs();

        List<Staff> possibleStaff = new ArrayList<Staff>();

        Map<String, String> staffRateCodeValueMap =
                (Map<String, String>) session.getAttribute("staffRateCodeValueMap");

        for (Staff staff : staffList) {
            String zip = staff.getAddress().getZipcode();
            String rateCode = staff.getPayCd();

            if (zipDistanceMap.containsKey(zip)) {
                staff.setDistance(zipDistanceMap.get(zip));
                staff.setHourlyRate(staffRateCodeValueMap.get(rateCode));
                possibleStaff.add(staff);
            }
        }

        session.setAttribute("possibleStaff", possibleStaff);
        session.setAttribute("targetZipCode", apiZipcode);
        session.setAttribute("targetRadius", apiRadius);


        session.setAttribute("searchType", "viewAll");
        session.setAttribute("personType", "Client");

        RequestDispatcher dispatcher = req.getRequestDispatcher("possibleStaff.jsp");
        dispatcher.forward(req, resp);
    }
}