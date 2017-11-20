package edu.matc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.com.zipcodeapi.Response;
import edu.matc.com.zipcodeapi.ZipCodesItem;
import edu.matc.entity.Staff;
import edu.matc.persistence.GenericDao;
import org.apache.log4j.Logger;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

/**
 * This is the AddNewStaffForm servlet. It initializes the data elements for the Staff and forward
 * to the addPersonForm.jsp page.
 *
 *@author Pablo Cataggatan
 */
@WebServlet(
        name = "clientZipCode",
        urlPatterns = {"/client-zipcode"}
)
public class ClientZipCodeAPI extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());
    private String errorMsg;

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

        String apiZipcode = req.getParameter("targetZipCode");
        String apiRadius = req.getParameter("targetRadius");

        session.setAttribute("apiZipCode", apiZipcode);
        session.setAttribute("apiRadius", apiRadius);

        String apiKey = "AeRPGqRpbJTueB5iWmN0i6Qgd904ZeXPL3uFhKIyAdQG8VAdlpo7G4KTVXQQtPBi";
        String uri = "http://www.zipcodeapi.com/rest/" + apiKey + "/radius.json/" + apiZipcode + "/"
                + apiRadius + "/mile";

        Map<String, Double> zipDistanceMap = callZipCodeAPI(session, uri, apiZipcode);

        if (errorMsg == null || errorMsg.equals("")) {
            session.setAttribute("possibleStaff", getPossibleStaff(session, zipDistanceMap));
            session.setAttribute("searchType", "viewAll");
            session.setAttribute("personType", "Client");
            RequestDispatcher dispatcher = req.getRequestDispatcher("possibleStaff.jsp");
            dispatcher.forward(req, resp);
        } else {
            session.setAttribute("errorMsg", errorMsg);
            RequestDispatcher dispatcher = req.getRequestDispatcher("clientZipCodeForm.jsp");
            dispatcher.forward(req, resp);
        }
    }


    public Map<String, Double> callZipCodeAPI(HttpSession session, String uri, String apiZipcode) throws IOException {

        Map<String, Double> zipDistanceMap = new TreeMap<>();

        errorMsg = "";

        try {
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(uri);
            String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
            ObjectMapper mapper = new ObjectMapper();

            Response zipCodes = mapper.readValue(response, Response.class);

            zipDistanceMap = getZipCodesAndDistances(zipCodes);

        } catch (NotFoundException nfe) {
            log.error("Zip code " + apiZipcode + " does not exist");
            errorMsg = "Zipcode does not exist, enter a valid zipcode";

        } catch (Exception e) {
            log.error("Bad or invalid Zipcode " + apiZipcode);
            errorMsg = "Bad or invalid Zipcode, enter a valid zipcode";
        }

        return zipDistanceMap;
    }


    public Map<String, Double> getZipCodesAndDistances(Response zipCodes) {

        Map<String, Double> zipCodesAndDistances = new TreeMap<>();

        for (ZipCodesItem zipCodeItem : zipCodes.getZipCodes()) {
            zipCodesAndDistances.put(zipCodeItem.getZipCode(), zipCodeItem.getDistance());
        }

        return zipCodesAndDistances;
    }


    public List<Staff> getPossibleStaff(HttpSession session, Map<String, Double> zipDistanceMap) {

        Map<String, String> staffRateCodeValueMap =
                (Map<String, String>) session.getAttribute("staffRateCodeValueMap");

        List<Staff> possibleStaff = new ArrayList<Staff>();

        GenericDao staffDao = new GenericDao(Staff.class);

        for (Staff staff : (List<Staff>)staffDao.getAll()) {

            String zip = staff.getAddress().getZipcode();
            String rateCode = staff.getPayCd();

            if (zipDistanceMap.containsKey(zip)) {
                staff.setDistance(zipDistanceMap.get(zip));
                staff.setHourlyRate(staffRateCodeValueMap.get(rateCode));
                possibleStaff.add(staff);
            }
        }

        return possibleStaff;
    }
}