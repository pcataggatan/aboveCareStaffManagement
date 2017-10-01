package edu.matc.persistence;

import edu.matc.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private final Logger log = Logger.getLogger(this.getClass());


    /**
     * retrieve a user given their id
     *
     * @param username the user's username
     * @return user
     */
    public boolean isUsernameExist(String username) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        boolean userFound = false;
        User user = null;
        try {
            tx = session.beginTransaction();
            session.get(User.class)
            user = (User) session.get(User.class, username);
            tx.commit();
        } catch (HibernateException he) {
            if (tx!=null) {
                tx.rollback();
                log.error("Error retrieving user, id: " + username, he);
            }
        } finally {
            session.close();
        }

        return user;
    }


    /**
     * add a user
     *
     * @param user
     * @return the id of the inserted record
     */
    public int addUser(User user) {
        int id = 0;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            id = (Integer) session.save(user);
            tx.commit();
        } catch (HibernateException he) {
            if (tx!=null) {
                tx.rollback();
                log.error("Error adding a new user", he);
            }
        } finally {
            session.close();
        }

        return id;
    }


    /**
     * delete a user by id
     * @param id the user's id
     */
    public void deleteUser(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        User user = null;
        try {
            tx = session.beginTransaction();
            user = (User) session.get(User.class, id);
            session.delete(user);
            tx.commit();
        } catch (HibernateException he) {
            if (tx!=null) {
                tx.rollback();
                log.error("Error deleting a user, id: " + id, he);
            }
        } finally {
            session.close();
        }
    }


    /**
     * Update the user
     * @param user
     */

    public void updateUser(User user) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(user);
            tx.commit();
        } catch (HibernateException he) {
            if (tx!=null) {
                tx.rollback();
                log.error("Error updating a user, id: " + user.getUserId(), he);
            }
        } finally {
            session.close();
        }
    }

}
