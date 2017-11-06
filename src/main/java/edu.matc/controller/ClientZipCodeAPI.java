package edu.matc.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.com.zipcodeapi.Response;
import edu.matc.com.zipcodeapi.ZipCodesItem;
import edu.matc.entity.Code;
import edu.matc.entity.Staff;
import edu.matc.persistence.ClientDao;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


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
        session.setAttribute("apiZipCode", apiZipcode);
        String apiRadius = req.getParameter("targetRadius");;
        //String apiKey = "S5CeIxgBGs11DuK4Nq1jSfZ8lwCWlGrctmgx4G5y7v0CTMrPgXMKQQC5XGkC2ct3";
        String apiKey = "AeRPGqRpbJTueB5iWmN0i6Qgd904ZeXPL3uFhKIyAdQG8VAdlpo7G4KTVXQQtPBi";
        String apiFormat = "json";
        String apiUnit = "mile";

        Client client = ClientBuilder.newClient();
        String response = "";
        List<ZipCodesItem> zipCodeList = null;

        try {
            WebTarget target = client.target("http://www.zipcodeapi.com/rest/"
                    + apiKey + "/radius." + apiFormat + "/"
                    + apiZipcode + "/" + apiRadius + "/" + apiUnit);

            response = target.request(MediaType.APPLICATION_JSON).get(String.class);

            ObjectMapper mapper = new ObjectMapper();

            Response zipcodes = mapper.readValue(response, Response.class);
            zipCodeList = zipcodes.getZipCodes();


        } catch (NotFoundException nfe) {
            log.error("Zip code " + apiZipcode + " does not exist");
            session.setAttribute("errorMsg", "Zipcode does not exist, enter a valid zipcode");
            RequestDispatcher dispatcher = req.getRequestDispatcher("clientZipCodeForm.jsp");
            dispatcher.forward(req, resp);
            return;
        }


        StaffDao staffDao = new StaffDao();
        List<Staff> staffList = staffDao.getAllStaffs();

        List<Staff> possibleStaff = new ArrayList<Staff>();

        for (Staff staff : staffList) {
            for (ZipCodesItem zipcode : zipCodeList) {
                if (staff.getAddress().getZipcode().equals(zipcode.getZipCode())) {

                    staff.setDistance(zipcode.getDistance());

                    List<Code> staffRateCodes = (List<Code>) session.getAttribute("staffRateCodes");

                    for (Code rateCode : staffRateCodes) {
                        if (staff.getPayCd().equals(rateCode.getCode())) {
                            staff.setHourlyRate(rateCode.getValue());
                            break;
                        }
                    }

                    possibleStaff.add(staff);
                    break;
                }
            }
        }

        session.setAttribute("possibleStaff", possibleStaff);
        session.setAttribute("targetZipCode", apiZipcode);
        session.setAttribute("targetRadius", apiRadius);


        session.setAttribute("searchType", "viewAll");
        session.setAttribute("searchFor", "Staff");

        RequestDispatcher dispatcher = req.getRequestDispatcher("possibleStaff.jsp");
        dispatcher.forward(req, resp);
    }
}
