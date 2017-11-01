package edu.matc.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.com.zipcodeapi.Response;
import edu.matc.com.zipcodeapi.ZipCodesItem;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import static org.junit.Assert.assertEquals;

public class TestServiceClient {

    @Test
    public void testZipCodeApiJSON() throws Exception {
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

        ZipCodesItem zipcode = zipcodes.getZipCodes().get(0);
        //assertEquals("53558", zipcode.getZipCode());
        assertEquals("Mc Farland", zipcode.getCity());
    }
}
