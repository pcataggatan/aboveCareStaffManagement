package edu.matc.persistence;

import edu.matc.entity.Client;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class ClientDaoTest {

    private Client client;
    private ClientDao clientDao;

    @Before
    public void setUp() throws Exception {
        client = new Client();
        clientDao = new ClientDao();
    }


    @Test
    public void getAllClients() throws Exception {
        List<Client> clients = clientDao.getAllClients();
        assertTrue(clients.size() > 0);
    }


    @Test
    public void getClient() throws Exception {
        int id = 1;
        client = clientDao.getClient(id);
        assertTrue("Not the client with userid " + id, client.getFirstName().equals("John"));
    }

    @Test
    public void addClient() throws Exception {
        client = new Client(0, "Pablo", "Smith", LocalDate.now(), "123 Java Workd St"
                ,"", "Madison", "WI", "53704", "(608) 909-9003"
                ,"abc3@xyz.com", "C01", LocalDate.now(), LocalDate.now());
        int prevSize = clientDao.getAllClients().size();
        int newClientid = clientDao.addClient(client);
        assertEquals("New client not added " + client, prevSize, clientDao.getAllClients().size() - 1);
    }

    @Test
    public void deleteClient() throws Exception {
        int id = clientDao.getAllClients().size() - 1;
        client = clientDao.getClient(id);
        clientDao.deleteClient(id);
        List<Client> clients = clientDao.getAllClients();
        assertFalse("User not deleted", clients.contains(client));
    }

    @Test
    public void updateClient() throws Exception {
        client = clientDao.getClient(1);
        String newLastName = "Jones";
        client.setLastName(newLastName);
        clientDao.updateClient(client);
        assertTrue("Client's lastname not updated to " + newLastName,
                clientDao.getClient(1).getLastName().equals("Jones"));

    }

}