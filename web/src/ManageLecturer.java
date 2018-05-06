/**
 * Created by Ibrahim.mmh on 5/4/2018.
 */
    import java.util.List;
    import java.util.Date;
    import java.util.Iterator;

    import org.hibernate.HibernateException;
    import org.hibernate.Session;
    import org.hibernate.Transaction;
    import org.hibernate.SessionFactory;
    import org.hibernate.cfg.Configuration;

    public class ManageLecturer {
        private static SessionFactory factory;
        public static void main(String[] args) {
            try{
                factory = new Configuration().configure().buildSessionFactory();
            }catch (Throwable ex) {
                System.err.println("Failed to create sessionFactory object." + ex);
                throw new ExceptionInInitializerError(ex);
            }
            ManageLecturer ME = new ManageLecturer();

      /* Add few employee records in database */
            Integer empID1 = ME.addEmployee("Zara", "Ali");
            Integer empID2 = ME.addEmployee("Daisy", "Das");
            Integer empID3 = ME.addEmployee("John", "Paul");

      /* List down all the employees */
            ME.listEmployees();

      /* Update employee's records */
            ME.updateEmployee(empID1);

      /* Delete an employee from the database */
            ME.deleteEmployee(empID2);

      /* List down new list of the employees */
            ME.listEmployees();
        }
        /* Method to CREATE an employee in the database */
        public Integer addEmployee(String fname, String lname){
            Session session = factory.openSession();
            Transaction tx = null;
            Integer employeeID = null;
            try{
                tx = session.beginTransaction();
                Lecturer employee = new Lecturer(fname, lname);
                employeeID = (Integer) session.save(employee);
                tx.commit();
            }catch (HibernateException e) {
                if (tx!=null) tx.rollback();
                e.printStackTrace();
            }finally {
                session.close();
            }
            return employeeID;
        }
        /* Method to  READ all the employees */
        public void listEmployees( ){
            Session session = factory.openSession();
            Transaction tx = null;
            try{
                tx = session.beginTransaction();
                List employees = session.createQuery("FROM Lecturer").list();
                for (Iterator iterator =
                     employees.iterator(); iterator.hasNext();){
                    Lecturer employee = (Lecturer) iterator.next();
                    System.out.print("First Name: " + employee.getFirstName());
                    System.out.print("  Last Name: " + employee.getLastName());
                }
                tx.commit();
            }catch (HibernateException e) {
                if (tx!=null) tx.rollback();
                e.printStackTrace();
            }finally {
                session.close();
            }
        }
        /* Method to UPDATE salary for an employee */
        public void updateEmployee(Integer EmployeeID){
            Session session = factory.openSession();
            Transaction tx = null;
            try{
                tx = session.beginTransaction();
                Lecturer employee =
                        (Lecturer)session.get(Lecturer.class, EmployeeID);
                session.update(employee);
                tx.commit();
            }catch (HibernateException e) {
                if (tx!=null) tx.rollback();
                e.printStackTrace();
            }finally {
                session.close();
            }
        }
        /* Method to DELETE an employee from the records */
        public void deleteEmployee(Integer EmployeeID){
            Session session = factory.openSession();
            Transaction tx = null;
            try{
                tx = session.beginTransaction();
                Lecturer employee =
                        (Lecturer)session.get(Lecturer.class, EmployeeID);
                session.delete(employee);
                tx.commit();
            }catch (HibernateException e) {
                if (tx!=null) tx.rollback();
                e.printStackTrace();
            }finally {
                session.close();
            }
        }
    }