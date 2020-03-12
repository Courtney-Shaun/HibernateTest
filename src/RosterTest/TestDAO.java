package RosterTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.TransactionScoped;
import java.util.*;

public class TestDAO {

    SessionFactory factory = null;
    Session session = null;

    private static TestDAO single_instance = null;

    private TestDAO() {
        factory = HibernateUtil.getSessionFactory();
    }


    public static TestDAO getInstance() {
        if (single_instance == null) {
            single_instance = new TestDAO();
        }

        return single_instance;
    }

    public List<Players> getPlayers() {

        try {
            session = factory.openSession();
            session.getTransaction().begin();
            String sql = "from RosterTest.Players";
            List<Players> ps = (List<Players>)session.createQuery(sql).getResultList();
            session.getTransaction().commit();
            return ps;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public Players getPlayer(int id) {

        try {
            session = factory.openSession();
            session.getTransaction().begin();
            String sql = "from RosterTest.Players where id=" + Integer.toString(id);
            Players p = (Players)session.createQuery(sql).getSingleResult();
            session.getTransaction().commit();
            return p;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }


}




