package edu.matc.persistence;

import edu.matc.entity.Staff;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class StaffDao {
    
    private final Logger log = Logger.getLogger(this.getClass());


    /** Return a list of all staffs
     *
     * @return All staffs
     */
    public List<Staff> getAllStaffs() {
        List<Staff> staffs = new ArrayList<Staff>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        staffs = session.createCriteria(Staff.class).list();
        session.close();
        return staffs;
    }

    /** Return a list of staffs based on search term
     * @param searchTerm search string
     * @return Staffs that contain the search term string
     */
    public List<Staff> getStaffByLastName(String searchTerm) {
        List<Staff> staffs = new ArrayList<Staff>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Staff.class);
        cr.add(Restrictions.like("lastName", "%" + searchTerm + "%"));
        staffs = cr.list();
        session.close();
        return staffs;

    }



    /**
     * retrieve a staff given their id
     *
     * @param id the staff's id
     * @return staff
     */
    public Staff getStaff(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Staff staff = null;
        try {
            tx = session.beginTransaction();
            staff = (Staff) session.get(Staff.class, id);
            tx.commit();
        } catch (HibernateException he) {
            if (tx!=null) {
                tx.rollback();
                log.error("Error retrieving a staff, id: " + id, he);
            }
        } finally {
            session.close();
        }

        return staff;
    }


    /**
     * add a staff
     *
     * @param staff
     * @return the id of the inserted record
     */
    public int addStaff(Staff staff) {
        int id = 0;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            id = (Integer) session.save(staff);
            tx.commit();
        } catch (HibernateException he) {
            if (tx!=null) {
                tx.rollback();
                log.error("Error adding a new staff", he);
            }
        } finally {
            session.close();
        }

        return id;
    }


    /**
     * delete a satff by id
     * @param id the staff's id
     */
    public void deleteStaff(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Staff staff = null;
        try {
            tx = session.beginTransaction();
            staff = (Staff) session.get(Staff.class, id);
            session.delete(staff);
            tx.commit();
        } catch (HibernateException he) {
            if (tx!=null) {
                tx.rollback();
                log.error("Error deleting a staff, id: " + id, he);
            }
        } finally {
            session.close();
        }
    }


    /**
     * Update the staff
     * @param staff
     */

    public void updateStaff(Staff staff) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(staff);
            tx.commit();
        } catch (HibernateException he) {
            if (tx!=null) {
                tx.rollback();
                log.error("Error updating a staff, id: " + staff.getStaffId(), he);
            }
        } finally {
            session.close();
        }
    }
    
}
