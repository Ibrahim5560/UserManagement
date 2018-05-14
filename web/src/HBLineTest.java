import mena.db.HibernateUtil;
import mena.model.HBLine;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Ibrahim.mmh on 5/5/2018.
 */
public class HBLineTest {

    public static void main(String[] args) {
        //insert  --------------------------------------------------------
        HBLine lecturer1 = new HBLine("Ahmed","Ibrahim","Developer");
        HibernateUtil.hibernateTrx(lecturer1, "insert",0);
        System.out.println("The lecturer " + lecturer1 + " is successfully added to your database");
        lecturer1 = null;
        //update  --------------------------------------------------------*
        lecturer1 = new HBLine(5,"Ibrahim","Mohamed","Developer");
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