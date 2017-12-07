package edu.matc.persistence;

import edu.matc.entity.Address;
import edu.matc.entity.Client;
import edu.matc.entity.Code;
import edu.matc.entity.Staff;
import org.hibernate.criterion.MatchMode;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class GenericDaoTest {

    private Staff staff;
    private Client client;
    private Address address;
    private GenericDao codeDao;
    private GenericDao staffDao;
    private GenericDao clientDao;

    @Before
    public void setUp() throws Exception {
        staff = new Staff();
        client = new Client();
        address = new Address();
        staffDao = new GenericDao(Staff.class);
        clientDao = new GenericDao(Client.class);
        codeDao = new GenericDao(Code.class);
    }

    @Test
    public void createStaff() throws Exception {

        address = new Address("2001 Hibernate St","Madison","WI","53718");

        staff = new Staff("Leonora", "Valenzuala", LocalDate.now(), "(608)101-1012"
                ,"lvalenzuela12@@abovecare.com", "S12", "Care Giver");

        staff.setAddress(address);

        int addStaffid = staffDao.create(staff);

        Staff addedStaff = (Staff) staffDao.get(addStaffid);

        Address addedAddress = addedStaff.getAddress();
        String addStreet = addedAddress.getStreet();

        assertTrue("New staff not added ",
                staff.equals(addedStaff) && addStreet.equals("2001 Hibernate St"));
    }

    @Test
    public void getStaff() throws Exception {

        int id = 20001;
        staff = (Staff) staffDao.get(id);

        assertTrue("Not the staff with staffId " + id,
                staff.getFirstName().equals("Pablo")
                        && staff.getLastName().equals("Cataggatan"));
    }

    @Test
    public void getAllStaff() throws Exception {

        List<Staff> staffs = staffDao.getAll();
        assertTrue(staffs.size() > 0);
    }

    @Test
    public void updateStaff() throws Exception {

        int updtStaffId = 20004;

        staff = (Staff) staffDao.get(updtStaffId);
        staff.setLastName("Catherine");
        staff.getAddress().setStreet("12345 Wright St");

        Set<Client> clients = new HashSet<Client>();

        GenericDao clientDao = new GenericDao(Client.class);
        Client client = (Client) clientDao.get(30004);
        clients.add(client);

        staff.setClients(clients);

        client.setStaff(staff);

        String updtMsg = staffDao.update(staff);

        Staff updatedStaff = (Staff) staffDao.get(updtStaffId);

        assertTrue("Staff is not successfully updated",
                staff.equals(updatedStaff));
    }

    @Test
    public void deleteStaff() throws Exception {

        int id = 20000;
        staff = (Staff) staffDao.get(id);

        Set<Client> clients = staff.getClients();

        for (Client client : clients) {
            GenericDao updtClientDao = new GenericDao(Client.class);
            Client updtClient = (Client) updtClientDao.get(client.getClientId());
            Staff staff = null;
            updtClient.setStaff(staff);
            String updtMsg = updtClientDao.update(updtClient);
        }

        String deleteMsg = staffDao.delete(id);

        List<Staff> staffs = staffDao.getAll();
        assertFalse("Staff not deleted", staffs.contains(staff));
    }

    @Test
    public void findStaffByProperty() throws Exception {

        String searchTerm = "Cataggatan";
        List<Staff> staffs = staffDao.findByProperty("lastName", searchTerm, MatchMode.ANYWHERE);
        assertEquals("Wrong number of rows returned",1, staffs.size());

    }


    @Test
    public void createClient() throws Exception {

        address = new Address("1002 Intellij Ave","Madison","WI","53702");

        client = new Client("Kimberly", "Crowley", LocalDate.now(), "(608)909-9015"
                ,"xyz15@xyz.com", "C01");

        client.setAddress(address);

        int addClientid = clientDao.create(client);

        Client addedClient = (Client) clientDao.get(addClientid);

        Address addedAddress = addedClient.getAddress();
        String addStreet = addedAddress.getStreet();

        assertTrue("New client not added ",
                client.equals(addedClient) && addStreet.equals("1002 Intellij Ave"));
    }

    @Test
    public void getClient() throws Exception {

        int id = 30004;
        client = (Client) clientDao.get(id);
        assertTrue("Not the client with clientId " + id,
                client.getFirstName().equals("Barbara")
                        && client.getLastName().equals("Lewis"));
    }

    @Test
    public void getAllClient() throws Exception {

        List<Client> clients = clientDao.getAll();
        assertTrue("Clients are not retrieved", clients.size() > 0);
    }

    @Test
    public void updateClient() throws Exception {

        int updtClientId = 30002;
        String newLastName = "Johnson";

        client = (Client) clientDao.get(updtClientId);
        client.setLastName(newLastName);
        client.getAddress().setStreet("54321 Anderson Ln");

        String updtMsg = clientDao.update(client);

        Client updatedClient = (Client) clientDao.get(updtClientId);

        assertTrue("Client's lastname not updated to " + newLastName,
                client.equals(updatedClient));
    }

    @Test
    public void deleteClient() throws Exception {

        int id = 30000;

        client = (Client) clientDao.get(id);

        if (client.getStaff() != null) {
            Staff staff = null;
            client.setStaff(staff);
            String updtMsg = clientDao.update(client);
        }

        String deleteMsg = clientDao.delete(id);

        List<Client> clients = clientDao.getAll();
        assertFalse("Client not deleted", clients.contains(client));

    }

    @Test
    public void findClientByProperty() throws Exception {

        String searchTerm = "Smith";
        List<Client> clients = clientDao.findByProperty("lastName", searchTerm, MatchMode.ANYWHERE);
        assertEquals("Wrong number of rows returned",1, clients.size());

    }


    @Test
    public void getAllCode() throws Exception {

        List<Code> codes = codeDao.getAll();
        assertTrue("Codes are not retrieved", codes.size() > 0);
    }

}