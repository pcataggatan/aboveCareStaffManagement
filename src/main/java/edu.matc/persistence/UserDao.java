package edu.matc.persistence;

import edu.matc.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDao {

    private final Logger log = Logger.getLogger(this.getClass());


    /**
     * check if username exists
     *
     * @param username username entered during login
     * @return true if username is found
     */
    public String validateUser(String username, String password) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        User user = null;
        String invalidMsg = "";

        try {
            tx = session.beginTransaction();
            user = (User) session.get(User.class, username);
            if (user == null) {
                invalidMsg = "Invalid username";
            } else {
                if (!user.getPassword().equals(password)) {
                    invalidMsg = "Invalid password";
                }
            }

            tx.commit();
        } catch (HibernateException he) {
            if (tx!=null) {
                tx.rollback();
                log.error("Error retrieving user, username: " + username, he);
            }
        } finally {
            session.close();
        }

       return invalidMsg;

    }


    /**
     * check if password exists
     *
     * @param password password entered during login
     * @return true if password is found
     */
    public boolean isValidPassword(String password) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        User user = null;
        try {
            tx = session.beginTransaction();
            user = (User) session.get(User.class, password);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) {
                tx.rollback();
                log.error("Error retrieving user, password: " + password, he);
            }
        } finally {
            session.close();
        }

        return user == null;
    }
}

