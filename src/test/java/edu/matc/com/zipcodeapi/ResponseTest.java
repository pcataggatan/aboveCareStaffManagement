package edu.matc.com.zipcodeapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static org.junit.Assert.*;

public class ResponseTest {
    @Test
    public void getZipCodes() throws Exception {

        Client client = ClientBuilder.newClient();

        String apiKey = "AeRPGqRpbJTueB5iWmN0i6Qgd904ZeXPL3uFhKIyAdQG8VAdlpo7G4KTVXQQtPBi";
        String apiZipcode = "53718";
        String apiFormat = "json";
        int apiRadius = 10;
        String units = "mile";

        WebTarget target = client.target("http://www.zipcodeapi.com/rest/"
                + apiKey + "/radius." + apiFormat + "/"
                + apiZipcode + "/" + apiRadius + "/" + units);

        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();

        Response zipcodes = mapper.readValue(response, Response.class);

        List<ZipCodesItem> zipCodeItems = zipcodes.getZipCodes();

        assertTrue("No zipcode items returned", zipCodeItems.size() > 0);

    }

}