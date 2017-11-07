package edu.matc.persistence;

import edu.matc.entity.Client;
import edu.matc.entity.Staff;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class ClientDao {

    private final Logger log = Logger.getLogger(this.getClass());



    /** Return a list of all clients
     *
     * @return All clients
     */
    public List<Client> getAllClients() {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        //List<Client> clients = session.createCriteria(Client.class).list();
        List<Client> clients = session.createCriteria(Client.class)
                .addOrder(Order.asc("clientId"))
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();
        session.close();
        return clients;
    }



    /** Return a list of clients based on search term
     *@param searchTerm search string
     *
     * @return Clients that contain the search term string
     */
    public List<Client> getClientByLastName(String searchTerm) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        //Criteria cr = session.createCriteria(Client.class);
        //cr.add(Restrictions.like("lastName", "%" + searchTerm + "%"));
        //List<Client> clients = cr.list();

        List<Client> clients = session.createCriteria(Client.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .add(Restrictions.like("lastName", "%" + searchTerm + "%"))
                .addOrder(Order.asc("clientId"))
                .list();
        session.close();
        return clients;

    }

    /**
     * retrieve a client given their id
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
                log.error("Error retrieving client id: " + id, he);
            }
        } finally {
            session.close();
        }

        return client;
    }


    /**
     * add a client
     *
     * @param client client object
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
                log.error("Error adding a new client", he);
            }
        } finally {
            session.close();
        }

        return id;
    }


    /**
     * delete a client by id
     * @param id the client's id
     */
    public String deleteClient(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Client client = null;
        String deleteMsg = "Success";

        try {
            tx = session.beginTransaction();
            client = (Client) session.get(Client.class, id);

            session.delete(client);
            tx.commit();
        } catch (HibernateException he) {
            if (tx!=null) {
                tx.rollback();
                deleteMsg = "Failure";
                log.error("Error deleting a client id: " + id, he);
            }
        } finally {
            session.close();
        }

        return deleteMsg;
    }


    /**
     * Update the client
     * @param client client object
     */

    public String updateClient(Client client) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        String updateMsg = "Success";

        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(client);
            tx.commit();
        } catch (HibernateException he) {
            if (tx!=null) {
                tx.rollback();
                updateMsg = "Failure";
                log.error("Error updating a client id: " + client.getClientId(), he);
            }
        } finally {
            session.close();
        }

        return updateMsg;
    }


}
