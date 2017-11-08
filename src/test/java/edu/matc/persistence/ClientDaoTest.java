package edu.matc.persistence;

import edu.matc.entity.Address;
import edu.matc.entity.Client;
import edu.matc.entity.Staff;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class ClientDaoTest {

    private final Logger log = Logger.getLogger(this.getClass());

    private ClientDao clientDao;
    private Client client;
    private Address address;



    @Before
    public void setUp() throws Exception {
        clientDao = new ClientDao();
        client = new Client();
        address = new Address();
    }


    @Test
    public void getAllClients() throws Exception {
        List<Client> clients = clientDao.getAllClients();
        assertTrue(clients.size() > 0);
    }



    @Test
    public void getClientsByLastName() throws Exception {
        String searchTerm = "Smith";
        List<Client> clients = clientDao.getClientByLastName(searchTerm);
        assertEquals("Wrong number of rows returned",1, clients.size());

    }


    @Test
    public void getClient() throws Exception {
        //int id = 30001;
        int id = 30004;
        client = clientDao.getClient(id);
        assertTrue("Not the client with clientId " + id,
                client.getFirstName().equals("Barbara")
                        && client.getLastName().equals("Tucker"));
    }

    @Test
    public void addClient() throws Exception {

        address = new Address("102 Intellij Ave","Madison","WI","53702");

        client = new Client("Josh", "Cataggatan", LocalDate.now(), "(608) 909-9003"
                ,"abc3@xyz.com", "C01");

        client.setAddress(address);

        int addClientid = clientDao.addClient(client);

        Client addedClient = clientDao.getClient(addClientid);

        Address addedAddress = addedClient.getAddress();
        String addStreet = addedAddress.getStreet();

        assertTrue("New client not added ",
                client.equals(addedClient) && addStreet.equals("102 Intellij Ave"));
     }

    @Test
    public void deleteClient() throws Exception {
        int id = 30000;

        client = clientDao.getClient(id);

        if (client.getStaff() != null) {
            Staff staff = null;
            client.setStaff(staff);
            String updtMsg = clientDao.updateClient(client);
        }

        String deleteMsg = clientDao.deleteClient(id);

        List<Client> clients = clientDao.getAllClients();
        assertFalse("Client not deleted", clients.contains(client));
    }

    @Test
    public void updateClient() throws Exception {

        int updtClientId = 30002;
        String newLastName = "Updated";

        client = clientDao.getClient(updtClientId);
        client.setLastName(newLastName);
        client.getAddress().setStreet("4321 New Street Addr");

        String updtMsg = clientDao.updateClient(client);

        Client updatedClient = clientDao.getClient(updtClientId);

        assertTrue("Client's lastname not updated to " + newLastName,
                client.equals(updatedClient));
   }

}