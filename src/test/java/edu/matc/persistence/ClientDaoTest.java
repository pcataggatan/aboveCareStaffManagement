package edu.matc.persistence;

import edu.matc.entity.Client;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class ClientDaoTest {

    private ClientDao clientDao;
    private Client client;


    @Before
    public void setUp() throws Exception {
        clientDao = new ClientDao();
        client = new Client();
    }


    @Test
    public void getAllClients() throws Exception {
        List<Client> clients = clientDao.getAllClients();
        assertTrue(clients.size() > 0);
    }


    @Test
    public void getClient() throws Exception {
        int id = 50001;
        client = clientDao.getClient(id);
        assertTrue("Not the client with userid " + id,
                client.getFirstName().equals("John"));
    }

    @Test
    public void addClient() throws Exception {
        client = new Client("Pablo", "Smith", LocalDate.now(), "123 Java Workd St"
                ,null, "Madison", "WI", "53704", "(608) 909-9003"
                ,"abc3@xyz.com", "C01","1-3p T/Th",null,null);

        int prevSize = clientDao.getAllClients().size();
        int newClientid = clientDao.addClient(client);
        Client newClient = clientDao.getClient(newClientid);
        assertTrue("New client not added " + client, client.equals(newClient));
    }

    @Test
    public void deleteClient() throws Exception {
        int id = 50000;
        client = clientDao.getClient(id);
        clientDao.deleteClient(id);
        List<Client> clients = clientDao.getAllClients();
        assertFalse("Client not deleted", clients.contains(client));
    }

    @Test
    public void updateClient() throws Exception {
        int id = 50001;
        client = clientDao.getClient(id);
        String newLastName = "Jones";
        client.setLastName(newLastName);
        clientDao.updateClient(client);
        Client updatedClient = clientDao.getClient(id);
        assertTrue("Client's lastname not updated to " + newLastName,
                client.equals(updatedClient));

    }

}