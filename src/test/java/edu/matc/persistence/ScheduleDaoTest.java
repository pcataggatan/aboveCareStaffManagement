package edu.matc.persistence;

import edu.matc.entity.Address;
import edu.matc.entity.Client;
import edu.matc.entity.Schedule;
import edu.matc.entity.Staff;
import org.junit.Before;
import org.junit.Test;
import sun.tools.jar.CommandLine;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class ScheduleDaoTest {

    private ClientDao clientDao;
    private Client client;
    private StaffDao staffDao;
    private Staff staff;
    private ScheduleDao scheduleDao;
    private Schedule schedule;

    @Before
    public void setUp() throws Exception {
        clientDao = new ClientDao();
        client = new Client();
        staffDao = new StaffDao();
        staff = new Staff();
        scheduleDao = new ScheduleDao();
        schedule = new Schedule();
    }


    @Test
    public void getAllSchedules() throws Exception {
        List<Schedule> schedules = scheduleDao.getAllSchedules();
        assertTrue(schedules.size() > 0);
    }


    @Test
    public void getSchedule() throws Exception {
        int id = 1;
        schedule = scheduleDao.getSchedule(id);

        //specific field value compare
        assertTrue("Not the schedule with schedId " + id,
                schedule.getTimeDays().equals("6-8a M W F"));
    }

    @Test
    public void addSchedule() throws Exception {

        int clientId = 3;
        client = clientDao.getClient(clientId);

        int staffId = 2;
        staff = staffDao.getStaff(staffId);

        schedule = new Schedule("11-2p T-Th-Su", client, staff);

        int addSchedId = scheduleDao.addSchedule(schedule);

        Schedule addedSchedule = scheduleDao.getSchedule(addSchedId);
        assertTrue("New schedule not added ", schedule.equals(addedSchedule));

    }

    @Test
    public void deleteClient() throws Exception {
        int id = 1;
        client = clientDao.getClient(id);
        clientDao.deleteClient(id);
        List<Client> clients = clientDao.getAllClients();
        assertFalse("Client not deleted", clients.contains(client));
    }

    @Test
    public void updateClient() throws Exception {
        // address shd be existing
        // get address and set attributes using entered values
        int updtSchedId = 1;
        schedule = scheduleDao.getSchedule(updtSchedId);

        String newTimeDays = "10-12a M-W-F-Sa";
        schedule.setTimeDays(newTimeDays);

        String updtMsg = scheduleDao.updateSchedule(schedule);

        if (updtMsg.equals("Success")) {
            Schedule updatedClient = scheduleDao.getSchedule(updtSchedId);
            assertTrue("Schedule time-days not updated to " + newTimeDays,
                    schedule.equals(updatedClient));
        } else {
            assertTrue("Client schedule upodate error", true);
        }
    }

}