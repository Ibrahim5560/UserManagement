import mena.db.HibernateUtil;

import java.util.List;

/**
 * Created by Ibrahim.mmh on 5/4/2018.
 */
public class HibernateTest {

    public static void main(String[] args) {
        //insert  --------------------------------------------------------
        Lecturer lecturer1 = new Lecturer();
        lecturer1.setFirstName("Ahmed");
        lecturer1.setLastName("Ibrahim");
        HibernateUtil.hibernateTrx(lecturer1, "insert", 0);
        System.out.println("The lecturer " + lecturer1 + " is successfully added to your database");
        lecturer1 = null;
        //update  --------------------------------------------------------
        lecturer1 = new Lecturer();
        lecturer1.setFirstName("Nada");
        lecturer1.setLastName("Ibrahim");
        lecturer1.setId(4);
        HibernateUtil.hibernateTrx(lecturer1, "update", 4);
        System.out.println("The lecturer " + lecturer1 + " is successfully updated to your database");
        lecturer1 = null;
        //delete  --------------------------------------------------------
        HibernateUtil.<Lecturer>hibernateTrx(new Lecturer(), "delete", 20);
        System.out.println("The lecturer " + lecturer1 + " is successfully deleted from your database");
        lecturer1 = null;
        //select all  --------------------------------------------------------
        List<Lecturer>  lines = HibernateUtil.<Lecturer>getAllByHQL("from Lecturer order by fname,lname");
        for (Lecturer lecturer : lines)
            System.out.println("The lecturer " + lecturer + " is successfully retrieved from your database");
        //select one  --------------------------------------------------------
        lecturer1 = HibernateUtil.<Lecturer>getOneByID(new Lecturer(), 1);
        System.out.println("The lecturer " + lecturer1 + " is successfully retrieved from your database");
        lecturer1 = null;
    }
}