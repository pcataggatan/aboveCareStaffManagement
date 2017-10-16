package edu.matc.persistence;

import edu.matc.entity.Address;
import edu.matc.entity.Client;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import sun.tools.jar.CommandLine;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class ClientDaoTest {

    private final Logger log = Logger.getLogger(this.getClass());

    private ClientDao clientDao;
    private Client client;
    private AddressDao addressDao;
    private Address address;

    @Before
    public void setUp() throws Exception {
        clientDao = new ClientDao();
        client = new Client();
        addressDao = new AddressDao();
        address = new Address();
    }


    @Test
    public void getAllClients() throws Exception {
        List<Client> clients = clientDao.getAllClients();
        assertTrue(clients.size() > 0);
    }


    @Test
    public void getClient() throws Exception {
        int id = 30001;
        client = clientDao.getClient(id);

        //specific field value compare
        assertTrue("Not the client with clientId " + id,
                client.getFirstName().equals("John")
                        && client.getLastName().equals("Smith"));
    }

    @Test
    public void addClient() throws Exception {

        // get address using entered values
        // if not exist create new address object and SAVE IT!!!
        // use this for testing new address
        //address = new Address("123 Intellij Ave","Madison","WI","53702");
        //int addAddress = addressDao.addAddress(address);

        // use this to test address that exists
        // get addr_id, ex. id = 1
        int addAddress= 10002;
        address = addressDao.getAddress(addAddress);


        client = new Client("Drew", "Smith", LocalDate.now(), "(608) 909-9003"
                ,"abc3@xyz.com", "C01", address);

        //for multiple clients, create another client
        //Client client2 = new Client("Joe", "Smith", LocalDate.now(), "(608) 909-9003"
        //       ,"abc3@xyz.com", "C01", address);


        Set<Client> clientsSet = new HashSet<>();
        clientsSet.add(client);
        address.setClients(clientsSet);

        //!!! see NOTES on ADDing new addres or SAVEORUPDATE existng address
        //int addAddress = addressDao.addAddress(address);
        //String updtMsg = addressDao.updateAddress(address);


        int addClientid = clientDao.addClient(client);
        //for multiple clients
        //int newClientid2 = clientDao.addClient(client2);
        //shd be 1 if only entering one client

        Client addedClient = clientDao.getClient(addClientid);
        Address addedAddress = addressDao.getAddress(addAddress);
        assertTrue("New client not added ",
                client.equals(addedClient) && address.equals(addedAddress));

    }

    @Test
    public void deleteClient() throws Exception {
        int id = 30000;
        client = clientDao.getClient(id);
        clientDao.deleteClient(id);
        List<Client> clients = clientDao.getAllClients();
        assertFalse("Client not deleted", clients.contains(client));
    }

    @Test
    public void updateClient() throws Exception {
        // address shd be existing
        // get address and set attributes using entered values
        int updtAddrId = 10006;
        address = addressDao.getAddress(updtAddrId);

        String newStreet = "4321 New Street Addr";
        String newZipcode = "53709";

        address.setStreet(newStreet);
        address.setZipcode(newZipcode);

        String updtMsg = addressDao.updateAddress(address);


        if (updtMsg.equals("Success")) {
            int updtClientId = 30001;
            client = clientDao.getClient(updtClientId);
            String newLastName = "Updated";
            client.setLastName(newLastName);

            clientDao.updateClient(client);

            Client updatedClient = clientDao.getClient(updtClientId);
            Address updatedAddress = addressDao.getAddress(updtAddrId);
            assertTrue("Client's lastname not updated to " + newLastName,
                    client.equals(updatedClient) && address.equals(updatedAddress));
        } else {
            assertTrue("Client update error, address not updated", true);
        }

    }


    @Test
    public void getClientDetail() {
        int id = 30001;
        List result = clientDao.getClientDetail(id);
        for (Object o : result) {
            
            System.out.println(o);
        }
        assertTrue(result.size() > 0);
    }
}