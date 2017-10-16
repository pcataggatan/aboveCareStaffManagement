package edu.matc.persistence;


import edu.matc.entity.Schedule;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.ArrayList;
import java.util.List;

public class ScheduleDao {

    private final Logger log = Logger.getLogger(this.getClass());



    /** Return a list of all schedule
     *
     * @return All schedule
     */
    public List<Schedule> getAllSchedules() {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        List<Schedule> schedules = session.createCriteria(Schedule.class).list();
        session.close();
        return schedules;
    }


    /**
     * retrieve a schedule given their id
     *
     * @param id the schedule's id
     * @return schedule
     */
    public Schedule getSchedule(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Schedule schedule = null;
        try {
            tx = session.beginTransaction();
            schedule = (Schedule) session.get(Schedule.class, id);
            tx.commit();
        } catch (HibernateException he) {
            if (tx!=null) {
                tx.rollback();
                log.error("Error retrieving schedule id: " + id, he);
            }
        } finally {
            session.close();
        }

        return schedule;
    }



    /**
     * add a shcedule
     *
     * @param schedule schedule object
     * @return the id of the inserted record
     */
    public int addSchedule(Schedule schedule) {
        int id = 0;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            id = (Integer) session.save(schedule);
            tx.commit();
        } catch (HibernateException he) {
            if (tx!=null) {
                tx.rollback();
                log.error("Error adding a new schedule", he);
            }
        } finally {
            session.close();
        }

        return id;
    }


    /**
     * delete a schedule by id
     * @param id the schedule' id
     */
    public String deleteScheduler(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        //Schedule schedule;
        String deleteMsg = "Success";

        try {
            tx = session.beginTransaction();
            Schedule schedule = (Schedule) session.get(Schedule.class, id);
            session.delete(schedule);
            tx.commit();
        } catch (HibernateException he) {
            if (tx!=null) {
                tx.rollback();
                deleteMsg = "Failure";
                log.error("Error deleting a schedule id: " + id, he);
            }
        } finally {
            session.close();
        }

        return deleteMsg;
    }


    /**
     * Update the schedule
     * @param schedule schedule object
     */

    public String updateSchedule(Schedule schedule) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        String updateMsg = "Success";

        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(schedule);
            tx.commit();
        } catch (HibernateException he) {
            if (tx!=null) {
                tx.rollback();
                updateMsg = "Failure";
                log.error("Error updating a schedule id: " + schedule.getSchedId(), he);
            }
        } finally {
            session.close();
        }

        return updateMsg;
    }

}
