import mena.model.HibernateUtil;
import mena.model.HBLine;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Ibrahim.mmh on 5/5/2018.
 */
public class HBLineTest {
    //---------------------------------hibernateTrx------------------------------
    public static void hibernateTrx(HBLine line, String type) // trx insert - update - delete
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
                line = (HBLine)session.get(HBLine.class, line.getId());
                if(line != null)
                    session.update(line);
            }
            if(type.equals("delete"))
            {
                line = (HBLine)session.get(HBLine.class, line.getId());
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
    public static HBLine getOneByID (int id)  // select one record
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        HBLine lecturer = null;
        try
        {
            tx = session.beginTransaction();
            lecturer = (HBLine) session.get(HBLine.class, id);
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
    public static List<HBLine> getAllByHQL(String HQL)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<HBLine>  lines = null;
        try
        {
            tx = session.beginTransaction();
            lines = (List<HBLine>) session.createQuery(HQL).list();
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
        HBLine lecturer1 = new HBLine();
        lecturer1.setTitle("Ahmed");
        lecturer1.setDescription("Ibrahim");
        lecturer1.setText("Developer");
        lecturer1.setDate(new Timestamp(System.currentTimeMillis()));
        hibernateTrx(lecturer1, "insert");
        System.out.println("The lecturer " + lecturer1 + " is successfully added to your database");
        lecturer1 = null;
        //update  --------------------------------------------------------*
        lecturer1 = new HBLine();
        lecturer1.setTitle("Ibrahim");
        lecturer1.setDescription("Mohamed");
        lecturer1.setText("Developer");
        lecturer1.setDate(new Timestamp(System.currentTimeMillis()));
        lecturer1.setId(5);
        hibernateTrx(lecturer1, "update");
        System.out.println("The lecturer " + lecturer1 + " is successfully updated to your database");
        lecturer1 = null;
        //delete  --------------------------------------------------------
        lecturer1 = new HBLine();
        lecturer1.setId(5);
        hibernateTrx(lecturer1, "delete");
        System.out.println("The lecturer " + lecturer1 + " is successfully deleted from your database");
        lecturer1 = null;
        //select all  --------------------------------------------------------
        List<HBLine>  lines = getAllByHQL("from papers order by title,startdate");
        if(lines != null)
        for (HBLine lecturer : lines)
            System.out.println("The lecturer " + lecturer + " is successfully retrieved from your database");
        //select one  --------------------------------------------------------
        lecturer1 = getOneByID(1);
        System.out.println("The lecturer " + lecturer1 + " is successfully retrieved from your database");
        lecturer1 = null;
    }
}