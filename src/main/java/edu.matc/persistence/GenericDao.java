package edu.matc.persistence;


import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a Generic Dao.
 *
 * Created by Pablo Cataggatan on 11/20/17.
 * Modeled after: https://rodrigouchoa.wordpress.com/2014/09/26/generic-dao-example/
 *
 */
public class GenericDao<T> {

    private Class<T> type;
    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Instantiates a new Abstract dao.
     *
     * @param type the entity type, for example User, Trail, etc.
     */
    public GenericDao(Class<T> type) {
        this.type = type;
    }

    /**
     * Adds the object to the database.import org.hibernate.criterion.Order;
     *
     * @param object the entity to create
     * @return the id of the newly added record
     */
    public int create(T object) {

        Transaction transaction = null;
        Integer id = null;
        Session session = null;
        try {
            session = getSession();
            transaction = session.beginTransaction();
            id = (Integer) session.save(object);
            transaction.commit();
            log.debug("Created " + object.getClass().getName() + " with id of: " + id);
        } catch (HibernateException e) {
            if (transaction != null) {
                try {
                    log.error("Error saving  " + object, e);
                    transaction.rollback();
                } catch (HibernateException he2) {
                    log.error("Error rolling back save of " + object, e);
                }
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return id;
    }

    /**
     * Gets the entity with the id passed in.
     *
     * @param id the id of the entity to be read and returned
     * @return the entity
     */
    @SuppressWarnings("unchecked")
    public T get(int id) {

        Session session = getSession();
        T t = null;
        try {
            t = (T) session.get(type, id);
        } catch (HibernateException e) {
            log.error("Error getting " + type + " with id " + id, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return t;
    }

    /**
     * Gets all entities of the given type.
     *
     * @return all the entities
     */
    @SuppressWarnings("unchecked")
    public List<T> getAll() {

        Session session = getSession();
        ArrayList<T> list = null;
        try {
            list = (ArrayList<T>)getSession().createCriteria(type)
                    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                    .list();
        } catch (HibernateException e) {
            log.error("Error getting list of " + type, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return list;

    }

    /**
     * Update the entity
     *
     * @param object the entity to be updated
     */
    public String update(T object) {
        Session session = getSession();
        Transaction transaction = null;
        String updateMsg = "Success";

        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(object);
            transaction.commit();
            log.debug("Updated " + object.getClass().getName() + ": " + object);
        } catch (HibernateException e) {
            if (transaction != null) {
                updateMsg = "Failure";
                try {
                    log.error("Error updating  " + object, e);
                    transaction.rollback();
                } catch (HibernateException he2) {
                    log.error("Error rolling back update of " +object, e);
                }
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return updateMsg;
    }

    /**
     * Delete the entity.
     *
     * @param id the id of the entity to be deleted
     */
    public String delete(int id) {
        Session session = getSession();
        Transaction transaction = null;
        T t = null;
        String deleteMsg = "Success";

        try {
            transaction = session.beginTransaction();
            t = (T) session.get(type, id);
            session.delete(t);
            transaction.commit();
            log.debug("Deleted " + type + " with id " + id);
        } catch (HibernateException e) {
            if (transaction != null) {
                deleteMsg = "Failure";
                try {
                    log.error("Error deleting  " + type + " with id " + id, e);
                    transaction.rollback();
                } catch (HibernateException he2) {
                    log.error("Error rolling back delete of " + type + " with id " + id, e);
                }
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return deleteMsg;
    }


    /**
     * Finds entities by a String property specifying a MatchMode. This search
     * is case insensitive.
     *
     * @param propertyName the property name.
     * @param value        the value to check against.
     * @param matchMode    the match mode: EXACT, START, END, ANYWHERE.
     * @return list of entities matching the criteria
     */
    @SuppressWarnings("unchecked")
    public List<T> findByProperty(String propertyName, String value, MatchMode matchMode){
        if (matchMode != null){
            return getSession().createCriteria(type)
                    .add(Restrictions.ilike(propertyName, value, matchMode))
                    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                    .list();
        }else{
            return getSession().createCriteria(type)
                    .add(Restrictions.ilike(propertyName, value, MatchMode.EXACT))
                    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                    .list();
        }
    }


    /**
     * Returnes an open session from the SessionFactory
     * @return session
     */
    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();

    }
}