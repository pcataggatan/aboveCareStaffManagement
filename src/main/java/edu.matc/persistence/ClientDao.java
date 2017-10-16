package edu.matc.persistence;

import edu.matc.entity.Address;
import edu.matc.entity.Client;
import edu.matc.entity.ClientDetailBean;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class ClientDao {

    private final Logger log = Logger.getLogger(this.getClass());



    /** Return a list of all clients
     *
     * @return All clients
     */
    public List<Client> getAllClients() {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        List<Client> clients = session.createCriteria(Client.class).list();
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
        Criteria cr = session.createCriteria(Client.class);
        cr.add(Restrictions.like("lastName", "%" + searchTerm + "%"));
        List<Client> clients = cr.list();
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

    /**
     * Get client and address detail
     * @param id client's id
     */

    public List<?> getClientDetail(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        List<?> result = null;

        try {
            tx = session.beginTransaction();
            String sql =  "select c.first_name, c.last_name, c. birth_dt, c.phone_nr, c.email, c.bill_cd," +
                    " a.street, a.city, a.state, a.zipcode" +
                    " from client c, address a " +
                    " where c.client_id = " + id +
                    " and c.addr_id = a.addr_id";
            //String sql =  "select c.client_id, c.first_name, c.last_name, c. birth_dt, c.phone_nr, c.email, c.bill_cd" +
            //        " from client c where c.client_id = 30001";
            //String sql =  "select c.*" +
            //        " from client as c, address as a" +
            //       " where c.client_id = " + id +
            //        " and c.addr_id = a.addr_id";

            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity("client", Client.class);
            query.addJoin("address", "client.address");
            //query.setParameter("clientId", id);
            result = query.list();
            // it this possible??? query.setResultTransformer(Transformers.aliasToBean(ClientDetail.class))
            // define result of type ist<ClientDetail>
            tx.commit();

        } catch (HibernateException he) {
            if (tx!=null) {
                tx.rollback();
                log.error("Error retrieving client/address, for client id: " + id, he);
            }
        } finally {
            session.close();
        }

        return result;

    }
}
