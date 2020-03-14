package RosterTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.type.StringRepresentableType;

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

    // Get an instance of the class
    public static TestDAO getInstance() {
        if (single_instance == null) {
            single_instance = new TestDAO();
        }

        return single_instance;
    }
    // Returns all the players in the database.
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
    // Used to get a single player from the database using the id column
    public Players getPlayer(int id) {

        try {
            session = factory.openSession();
            session.getTransaction().begin();
            String sql = "from RosterTest.Players where id=" + id;
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
    //  Used to get one player from the database by their number.
    public Players getNumber(int number) {

        try {
            session = factory.openSession();
            session.getTransaction().begin();
            String sql = "from RosterTest.Players where number=" + number;
            Players n = (Players)session.createQuery(sql).getSingleResult();
            session.getTransaction().commit();
            return n;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }



}




