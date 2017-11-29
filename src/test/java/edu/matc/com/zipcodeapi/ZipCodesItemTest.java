package edu.matc.com.zipcodeapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import static org.junit.Assert.*;

public class ZipCodesItemTest {

    private Response zipcodes;

    @Before
    public void setUp() throws Exception {

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

        zipcodes = mapper.readValue(response, Response.class);

    }

    @Test
    public void getDistance() throws Exception {

        ZipCodesItem zipcode = zipcodes.getZipCodes().get(0);
        assertTrue("Not the correct distance", zipcode.getDistance() == 6.696);
    }

    @Test
    public void getCity() throws Exception {

        ZipCodesItem zipcode = zipcodes.getZipCodes().get(0);
        assertEquals("Mc Farland", zipcode.getCity());
    }

    @Test
    public void getState() throws Exception {

        ZipCodesItem zipcode = zipcodes.getZipCodes().get(0);
        assertEquals("WI", zipcode.getState());
    }

    @Test
    public void getZipCode() throws Exception {

        ZipCodesItem zipcode = zipcodes.getZipCodes().get(0);
        assertEquals("53558", zipcode.getZipCode());
    }

}