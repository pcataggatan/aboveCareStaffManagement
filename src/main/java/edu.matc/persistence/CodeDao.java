package edu.matc.persistence;


import edu.matc.entity.Client;
import edu.matc.entity.Code;
import edu.matc.entity.Staff;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class CodeDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of clients based on search term
     *@param searchTerm search string
     *
     * @return Codes that contain the search term string
     */
    public List<Code> getCodeByDescription(String searchTerm) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Code.class);
        cr.add(Restrictions.like("descTx", "%" + searchTerm + "%"));
        List<Code> codes = cr.list();
        return codes;

    }
}