import mena.db.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Ibrahim.mmh on 5/4/2018.
 */
public class HibernateTest {
    //---------------------------------hibernateTrx------------------------------
    public static void hibernateTrx(Lecturer line, String type) // trx insert - update - delete
    {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try
        {
            tx = session.beginTransaction();//
            if(type.equals("insert"))
                session.save(line);
            if(type.equals("update"))
            {
                line = (Lecturer)session.get(Lecturer.class, line.getId());
                if(line != null)
                    session.update(line);
            }
            if(type.equals("delete"))
            {
                line = (Lecturer)session.get(Lecturer.class, line.getId());
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
    public static Lecturer getOneByID (int id)  // select one record
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Lecturer lecturer = null;
        try
        {
            tx = session.beginTransaction();
            lecturer = (Lecturer) session.get(Lecturer.class, id);
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
    public static List<Lecturer> getAllByHQL(String HQL)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Lecturer>  lines = null;
        try
        {
            tx = session.beginTransaction();
            lines = (List<Lecturer>) session.createQuery(HQL).list();
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
    public static void main(String[] args) {
        //insert  --------------------------------------------------------
        Lecturer lecturer1 = new Lecturer();
        lecturer1.setFirstName("Ahmed");
        lecturer1.setLastName("Ibrahim");
        hibernateTrx(lecturer1, "insert");
        System.out.println("The lecturer " + lecturer1 + " is successfully added to your database");
        lecturer1 = null;
        //update  --------------------------------------------------------
        lecturer1 = new Lecturer();
        lecturer1.setFirstName("Nada");
        lecturer1.setLastName("Ibrahim");
        lecturer1.setId(4);
        hibernateTrx(lecturer1, "update");
        System.out.println("The lecturer " + lecturer1 + " is successfully updated to your database");
        lecturer1 = null;
        //delete  --------------------------------------------------------
        lecturer1 = new Lecturer();
        lecturer1.setId(20);
        hibernateTrx(lecturer1, "delete");
        System.out.println("The lecturer " + lecturer1 + " is successfully deleted from your database");
        lecturer1 = null;
        //select all  --------------------------------------------------------
        List<Lecturer>  lines = getAllByHQL("from Lecturer order by fname,lname");
        for (Lecturer lecturer : lines)
            System.out.println("The lecturer " + lecturer + " is successfully retrieved from your database");
        //select one  --------------------------------------------------------
        lecturer1 = getOneByID(1);
        System.out.println("The lecturer " + lecturer1 + " is successfully retrieved from your database");
        lecturer1 = null;
    }
}