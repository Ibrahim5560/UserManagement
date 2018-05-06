package mena.db;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by Ibrahim.mmh on 5/3/2018.
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    //---------------------------------hibernateTrx------------------------------
    public static <E> void hibernateTrx(E line, String type, int id) // trx insert - update - delete
    {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try
        {
            tx = session.beginTransaction();
            if(type.equals("insert"))
                session.save(line);
            if(type.equals("update"))
            {
                line = (E) session.get(line.getClass(), id);
                if(line != null)
                    session.update(line);
            }
            if(type.equals("delete"))
            {
                line = (E) session.get(line.getClass(), id);
                if(line != null)
                    session.delete(line);
            }
            tx.commit();
        }
        catch (HibernateException e)
        {
            if (tx!=null)
                tx.rollback();
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
    }
    //---------------------------------getOneByID--------------------------------------
    public static <E> E getOneByID (E lecturer,int id)  // select one record
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try
        {
            tx = session.beginTransaction();
            lecturer = (E) session.get(lecturer.getClass(), id);
            tx.commit();
        }
        catch (HibernateException e)
        {
            if (tx!=null)
                tx.rollback();
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
        return lecturer;
    }
    //---------------------------------getAllByHQL--------------------------------------
    public static <E> List<E> getAllByHQL(String HQL)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<E>  lines = null;
        try
        {
            tx = session.beginTransaction();
            lines = (List<E>) session.createQuery(HQL).list();
            tx.commit();
        }
        catch (HibernateException e)
        {
            if (tx!=null)
                tx.rollback();
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
        return lines;
    }
    //----------------------------------------------------------------------------------------
}
