package edu.matc.persistence;

import edu.matc.entity.Address;
import edu.matc.entity.Staff;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class StaffDaoTest {

    private final Logger log = Logger.getLogger(this.getClass());

    private StaffDao staffDao;
    private Staff staff;
    //private AddressDao addressDao;
    private Address address;

    @Before
    public void setUp() throws Exception {
        staffDao = new StaffDao();
        staff = new Staff();
       // addressDao = new AddressDao();
        address = new Address();
    }


    @Test
    public void getAllStaffs() throws Exception {
        List<Staff> staffs = staffDao.getAllStaffs();
        assertTrue(staffs.size() > 0);
    }


    @Test
    public void getStaff() throws Exception {
        int id = 20001;
        staff = staffDao.getStaff(id);

        //specific field value compare
        assertTrue("Not the staff with staffId " + id,
                staff.getFirstName().equals("Corazon")
                        && staff.getLastName().equals("Acosta"));
    }

    @Test
    public void addStaff() throws Exception {

        address = new Address("2001 Hibernate St","Madison","WI","53718");

        staff = new Staff("Jared", "Cataggatan", LocalDate.now(), "(608) 909-9003"
                ,"abc3@xyz.com", "S01", "Care Giver", address);

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

        String deleteMsg = staffDao.deleteStaff(id);

        List<Staff> staffs = staffDao.getAllStaffs();
        assertFalse("Staff not deleted", staffs.contains(staff));
    }

    @Test
    public void updateStaff() throws Exception {

        int updtStaffId = 20002;
        String newLastName = "Update";

        staff = staffDao.getStaff(updtStaffId);
        staff.setLastName(newLastName);
        staff.getAddress().setStreet("4321 New Street Addr");

        String updtMsg = staffDao.updateStaff(staff);

        Staff updatedStaff = staffDao.getStaff(updtStaffId);

        assertTrue("Staff's lastname not updated to " + newLastName,
                staff.equals(updatedStaff));
    }

}