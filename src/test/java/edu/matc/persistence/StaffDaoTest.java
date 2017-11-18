package edu.matc.persistence;

import edu.matc.entity.Address;
import edu.matc.entity.Client;
import edu.matc.entity.Staff;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class StaffDaoTest {

    private final Logger log = Logger.getLogger(this.getClass());


    private StaffDao staffDao;
    private Staff staff;
    private Address address;
    private ClientDao clientDao;
    private Client client;
    private Client client2;

    @Before
    public void setUp() throws Exception {
        staffDao = new StaffDao();
        staff = new Staff();
        address = new Address();
        client = new Client();
        client2 = new Client();
    }
    @Test
    public void getAllStaffs() throws Exception {
        List<Staff> staffs = staffDao.getAllStaffs();
        assertTrue(staffs.size() > 0);
    }


    @Test
    public void getStaffByLastname() throws Exception {
        String searchTerm = "Cataggatan";
        List<Staff> staffs = staffDao.getStaffByLastName(searchTerm);
        assertEquals("Wrong number of rows returned",2, staffs.size());
    }


    @Test
    public void getStaff() throws Exception {
        int id = 20001;
        staff = staffDao.getStaff(id);
        //specific field value compare
        assertTrue("Not the staff with staffId " + id,
                staff.getFirstName().equals("Pablo")
                        && staff.getLastName().equals("Cataggatan"));
    }

    @Test
    public void addStaff() throws Exception {

        address = new Address("2001 Hibernate St","Madison","WI","53718");

        staff = new Staff("Josh", "Cataggatan", LocalDate.now(), "(608) 909-9003"
                ,"abc3@xyz.com", "S01", "Care Giver");

        staff.setAddress(address);

        int addStaffid = staffDao.addStaff(staff);

        Staff addedStaff = staffDao.getStaff(addStaffid);

        Address addedAddress = addedStaff.getAddress();
        String addStreet = addedAddress.getStreet();

        assertTrue("New staff not added ",
                staff.equals(addedStaff) && addStreet.equals("2001 Hibernate St"));
    }

    @Test
    public void deleteStaff() throws Exception {
        int id = 20000;
        staff = staffDao.getStaff(id);

        Set<Client> clients = staff.getClients();

        for (Client client : clients) {
            ClientDao updtClientDao = new ClientDao();
            Client updtClient = updtClientDao.getClient(client.getClientId());
            Staff staff = null;
            updtClient.setStaff(staff);
            String updtMsg = updtClientDao.updateClient(updtClient);
        }

        String deleteMsg = staffDao.deleteStaff(id);

        List<Staff> staffs = staffDao.getAllStaffs();
        assertFalse("Staff not deleted", staffs.contains(staff));
    }

    @Test
    public void updateStaff() throws Exception {


        int updtStaffId = 20004;

        staff = staffDao.getStaff(updtStaffId);
        staff.setLastName("TestUpdated");
        staff.getAddress().setStreet("4321 Updated Street");

        Set<Client> clients = new HashSet<Client>();

        Client client1 = new ClientDao().getClient(30004);
        clients.add(client1);

        //Client client2 = new ClientDao().getClient(30005);
        //clients.add(client2);


        staff.setClients(clients);

        client1.setStaff(staff);
        //client2.setStaff(staff);

        String updtMsg = staffDao.updateStaff(staff);

        Staff updatedStaff = staffDao.getStaff(updtStaffId);

        assertTrue("Staff is not successfully updated",
                staff.equals(updatedStaff));

    }

}