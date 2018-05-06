import mena.db.HibernateUtil;
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

    public static void main(String[] args) {
        //insert  --------------------------------------------------------
        HBLine lecturer1 = new HBLine();
        lecturer1.setTitle("Ahmed");
        lecturer1.setDescription("Ibrahim");
        lecturer1.setText("Developer");
        lecturer1.setDate(new Timestamp(System.currentTimeMillis()));
        HibernateUtil.hibernateTrx(lecturer1, "insert",0);
        System.out.println("The lecturer " + lecturer1 + " is successfully added to your database");
        lecturer1 = null;
        //update  --------------------------------------------------------*
        lecturer1 = new HBLine();
        lecturer1.setTitle("Ibrahim");
        lecturer1.setDescription("Mohamed");
        lecturer1.setText("Developer");
        lecturer1.setDate(new Timestamp(System.currentTimeMillis()));
        lecturer1.setId(5);
        HibernateUtil.hibernateTrx(lecturer1, "update",lecturer1.getId());
        System.out.println("The lecturer " + lecturer1 + " is successfully updated to your database");
        lecturer1 = null;
        //delete  --------------------------------------------------------
        HibernateUtil.hibernateTrx(new HBLine(), "delete",5);
        //select all  --------------------------------------------------------
        List<HBLine>  lines = HibernateUtil.getAllByHQL("from papers order by title,startdate");
        if(lines != null)
        for (HBLine lecturer : lines)
            System.out.println("The lecturer " + lecturer + " is successfully retrieved from your database");
        //select one  --------------------------------------------------------
        lecturer1 = HibernateUtil.getOneByID(new HBLine(),1);
        System.out.println("The lecturer " + lecturer1 + " is successfully retrieved from your database");
        lecturer1 = null;
    }
}