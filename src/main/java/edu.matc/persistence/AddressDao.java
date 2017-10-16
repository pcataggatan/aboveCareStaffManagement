package edu.matc.persistence;

import edu.matc.entity.Address;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AddressDao {

    private final Logger log = Logger.getLogger(this.getClass());



    /** Return a list of all addresses
     *
     * @return All addresses
     */
    public List<Address> getAllAddresses() {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        List<Address> addresses = session.createCriteria(Address.class).list();
        session.close();
        return addresses;
    }


    /**
     * retrieve a address given their id
     *
     * @param id the address' id
     * @return address
     */
    public Address getAddress(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Address address = null;
        try {
            tx = session.beginTransaction();
            address = (Address) session.get(Address.class, id);
            tx.commit();
        } catch (HibernateException he) {
            if (tx!=null) {
                tx.rollback();
                log.error("Error retrieving address id: " + id, he);
            }
        } finally {
            session.close();
        }

        return address;
    }



    /**
     * add a address
     *
     * @param address address object
     * @return the id of the inserted record
     */
    public int addAddress(Address address) {
        int id = 0;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            id = (Integer) session.save(address);
            tx.commit();
        } catch (HibernateException he) {
            if (tx!=null) {
                tx.rollback();
                log.error("Error adding a new address", he);
            }
        } finally {
            session.close();
        }

        return id;
    }


    /**
     * delete a address by id
     * @param id the address' id
     */
    public String deleteAddress(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        //Address address;
        String deleteMsg = "Success";

        try {
            tx = session.beginTransaction();
            Address address = (Address) session.get(Address.class, id);
            session.delete(address);
            tx.commit();
        } catch (HibernateException he) {
            if (tx!=null) {
                tx.rollback();
                deleteMsg = "Failure";
                log.error("Error deleting a address id: " + id, he);
            }
        } finally {
            session.close();
        }

        return deleteMsg;
    }


    /**
     * Update the address
     * @param address address object
     */

    public String updateAddress(Address address) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        String updateMsg = "Success";

        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(address);
            tx.commit();
        } catch (HibernateException he) {
            if (tx!=null) {
                tx.rollback();
                updateMsg = "Failure";
                log.error("Error updating a address id: " + address.getAddrId(), he);
            }
        } finally {
            session.close();
        }

        return updateMsg;
    }

}
