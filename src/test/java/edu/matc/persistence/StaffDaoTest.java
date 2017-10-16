package edu.matc.persistence;

import edu.matc.entity.Address;
import edu.matc.entity.Staff;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class StaffDaoTest {

    private StaffDao staffDao;
    private Staff staff;
    private AddressDao addressDao;
    private Address address;

    @Before
    public void setUp() throws Exception {
        staffDao = new StaffDao();
        staff = new Staff();
        addressDao = new AddressDao();
        address = new Address();
    }


    @Test
    public void getAllStaffs() throws Exception {
        List<Staff> staffs = staffDao.getAllStaffs();
        assertTrue(staffs.size() > 0);
    }


    @Test
    public void getStaff() throws Exception {
        int id = 1;
        staff = staffDao.getStaff(id);

        //specific field value compare
        assertTrue("Not the staff with clientId " + id,
                staff.getFirstName().equals("John")
                        && staff.getLastName().equals("Smith"));
    }

    @Test
    public void addStaff() throws Exception {

        // get address using entered values
        // if not exist create new address object and SAVE IT!!!
        // use this for testing new address
        address = new Address("123 Staff Ave","Madison","WI","53701");
        int addAddress = addressDao.addAddress(address);

        // use this to test address that exists
        // get addr_id, ex. id = 1
        //int addAddress= 6;
        //address = addressDao.getAddress(addAddress);


        staff = new Staff("Almarie", "Quilang", LocalDate.now(), "(608) 909-9003"
                ,"abc3@xyz.com", "S02", "CNA", address);

        //Staff client2 = new Staff("Joe", "Smith", LocalDate.now(), "(608) 909-9003"
        //       ,"abc3@xyz.com", "C01", address);


        Set<Staff> staffsSet = new HashSet<>();
        staffsSet.add(staff);
        //for multi staff add populate the list
        //clientsSet.add(client2);

        // dont use this, suse object compare
        //int prevSize = staffDao.getAllStaffs().size();

        // this is done above if address doesn't exist
        //int addAddress = addressDao.addAddress(address);

        int addStaffId = staffDao.addStaff(staff);

        //for multiple clients
        //int newStaffid2 = staffDao.addStaff(client2);

        //shd be 1 if only entering one staff
        //int addedStaffs = 2;

        //assertEquals("New staff not added " + staff,
        //        prevSize, staffDao.getAllStaffs().size() - addedStaffs);

        Staff addedStaff = staffDao.getStaff(addStaffId);

        Address addedAddress = addressDao.getAddress(addAddress);
        assertTrue("New staff not added ",
                staff.equals(addedStaff) && address.equals(addedAddress));

    }

    @Test
    public void deleteStaff() throws Exception {
        int id = 1;
        staff = staffDao.getStaff(id);
        staffDao.deleteStaff(id);
        List<Staff> clients = staffDao.getAllStaffs();
        assertFalse("Staff not deleted", clients.contains(staff));
    }

    @Test
    public void updateStaff() throws Exception {
        // address shd be existing
        // get address and set attributes using entered values
        int updtAddrId = 3;
        address = addressDao.getAddress(updtAddrId);

        String newStreet = "4321 New Street Addr";
        String newZipcode = "53709";

        address.setStreet(newStreet);
        address.setZipcode(newZipcode);

        String updtMsg = addressDao.updateAddress(address);


        if (updtMsg.equals("Success")) {
            int updtStaffId = 4;
            staff = staffDao.getStaff(updtStaffId);
            String newLastName = "Updated";
            staff.setLastName(newLastName);

            staffDao.updateStaff(staff);

            Staff updatedStaff = staffDao.getStaff(updtStaffId);
            Address updatedAddress = addressDao.getAddress(updtAddrId);
            assertTrue("Staff's lastname not updated to " + newLastName,
                    staff.equals(updatedStaff) && address.equals(updatedAddress));
        } else {
            assertTrue("Staff update error, address not updated", true);
        }




    }

}