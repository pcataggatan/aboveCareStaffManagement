package edu.matc.persistence;


import edu.matc.entity.Staff;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class StaffDao {

    private final Logger log = Logger.getLogger(this.getClass());



    /** Return a list of all staffs
     *
     * @return All staff
     */
    public List<Staff> getAllStaffs() {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        //List<Staff> staffs = session.createCriteria(Staff.class).list();
        List<Staff> staffs = session.createCriteria(Staff.class)
                .addOrder(Order.asc("staffId"))
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();
        session.close();
        return staffs;
    }



    /** Return a list of staffs based on search term
     *@param searchTerm search string
     *
     * @return Staffs that contain the search term string
     */
    public List<Staff> getStaffByLastName(String searchTerm) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        //Criteria cr = session.createCriteria(Staff.class);
        //cr.add(Restrictions.like("lastName", "%" + searchTerm + "%"));
        //List<Staff> staffs = cr.list();

        List<Staff> staffs = session.createCriteria(Staff.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .add(Restrictions.like("lastName", "%" + searchTerm + "%"))
                .addOrder(Order.asc("staffId"))
                .list();

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
                log.error("Error retrieving staff id: " + id, he);
            }
        } finally {
            session.close();
        }

        return staff;
    }


    /**
     * add a staff
     *
     * @param staff staff object
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
     * delete a staff by id
     * @param id the staff's id
     */
    public String deleteStaff(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Staff staff = null;
        String deleteMsg = "Success";

        try {
            tx = session.beginTransaction();
            staff = (Staff) session.get(Staff.class, id);
            session.delete(staff);
            tx.commit();
        } catch (HibernateException he) {
            if (tx!=null) {
                tx.rollback();
                deleteMsg = "Failure";
                log.error("Error deleting a staff id: " + id, he);
            }
        } finally {
            session.close();
        }

        return deleteMsg;
    }


    /**
     * Update the staff
     * @param staff staff object
     */

    public String updateStaff(Staff staff) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        String updateMsg = "Success";

        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(staff);
            tx.commit();
        } catch (HibernateException he) {
            if (tx!=null) {
                tx.rollback();
                updateMsg = "Failure";
                log.error("Error updating a staff id: " + staff.getStaffId(), he);
            }
        } finally {
            session.close();
        }

        return updateMsg;
    }

}
