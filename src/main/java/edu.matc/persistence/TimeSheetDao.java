package edu.matc.persistence;

import edu.matc.entity.TimeSheet;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TimeSheetDao {

    private final Logger log = Logger.getLogger(this.getClass());



    /** Return a list of all timeSheets
     *
     * @return All timeSheets
     */
    public List<TimeSheet> getAllTimeSheets() {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        List<TimeSheet> timeSheets = session.createCriteria(TimeSheet.class).list();
        session.close();
        return timeSheets;
    }


    /**
     * retrieve a timeSheet given their id
     *
     * @param id the timeSheet' id
     * @return timeSheet
     */
    public TimeSheet getTimeSheet(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        TimeSheet timeSheet = null;
        try {
            tx = session.beginTransaction();
            timeSheet = (TimeSheet) session.get(TimeSheet.class, id);
            tx.commit();
        } catch (HibernateException he) {
            if (tx!=null) {
                tx.rollback();
                log.error("Error retrieving timeSheet id: " + id, he);
            }
        } finally {
            session.close();
        }

        return timeSheet;
    }



    /**
     * add a timeSheet
     *
     * @param timeSheet timeSheet object
     * @return the id of the inserted record
     */
    public int addTimeSheet(TimeSheet timeSheet) {
        int id = 0;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            id = (Integer) session.save(timeSheet);
            tx.commit();
        } catch (HibernateException he) {
            if (tx!=null) {
                tx.rollback();
                log.error("Error adding a new timeSheet", he);
            }
        } finally {
            session.close();
        }

        return id;
    }


    /**
     * delete a timeSheet by id
     * @param id the timeSheet' id
     */
    public String deleteTimeSheet(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        //TimeSheet timeSheet;
        String deleteMsg = "Success";

        try {
            tx = session.beginTransaction();
            TimeSheet timeSheet = (TimeSheet) session.get(TimeSheet.class, id);
            session.delete(timeSheet);
            tx.commit();
        } catch (HibernateException he) {
            if (tx!=null) {
                tx.rollback();
                deleteMsg = "Failure";
                log.error("Error deleting a timeSheet id: " + id, he);
            }
        } finally {
            session.close();
        }

        return deleteMsg;
    }


    /**
     * Update the timeSheet
     * @param timeSheet timeSheet object
     */

    public String updateTimeSheet(TimeSheet timeSheet) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        String updateMsg = "Success";

        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(timeSheet);
            tx.commit();
        } catch (HibernateException he) {
            if (tx!=null) {
                tx.rollback();
                updateMsg = "Failure";
                log.error("Error updating a timeSheet id: " + timeSheet.getTimeId(), he);
            }
        } finally {
            session.close();
        }

        return updateMsg;
    }

}
