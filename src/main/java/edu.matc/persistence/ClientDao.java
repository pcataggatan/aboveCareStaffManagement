package edu.matc.persistence;

import edu.matc.entity.Client;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ClientDao {

    private final Logger log = Logger.getLogger(this.getClass());


    /** Return a list of all clients
     *
     * @return All clients
     */
    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<Client>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        clients = session.createCriteria(Client.class).list();
        return clients;
    }


    /**
     * retrieve a user given their id
     *
     * @param id the client's id
     * @return client
     */
    public Client getClient(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Client client = null;
        try {
            tx = session.beginTransaction();
            client = (Client) session.get(Client.class, id);
            tx.commit();
        } catch (HibernateException he) {
            if (tx!=null) {
                tx.rollback();
                log.error("Error retrieving client", he);
            }
        } finally {
            session.close();
        }

        return client;
    }


    /**
     * add a user
     *
     * @param client
     * @return the id of the inserted record
     */
    public int addClient(Client client) {
        int id = 0;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            id = (Integer) session.save(client);
            tx.commit();
        } catch (HibernateException he) {
            if (tx!=null) {
                tx.rollback();
                log.error("Error adding a client: ", he);
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
    public void deleteClient(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Client client = null;
        try {
            tx = session.beginTransaction();
            client = (Client) session.get(Client.class, id);
            session.delete(client);
            tx.commit();
        } catch (HibernateException he) {
            if (tx!=null) {
                tx.rollback();
                log.error("Error deleting a client, id: " + id, he);
            }
        } finally {
            session.close();
        }
    }


    /**
     * Update the user
     * @param client
     */

    public void updateClient(Client client) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(client);
            tx.commit();
        } catch (HibernateException he) {
            if (tx!=null) {
                tx.rollback();
                log.error("Error updating a client, id: " + client.getClientId(), he);
            }
        } finally {
            session.close();
        }
    }

}
