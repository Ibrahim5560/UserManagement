package mena.service;

import mena.model.HibernateUtil;
import mena.model.HBLine;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Ibrahim.mmh on 5/3/2018.
 */
public class HBLineService {
    public void hibernateLine (HBLine line,String dml)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        if(dml.equals("insert")) session.save(line);
        if(dml.equals("update")) session.update(line);
        if(dml.equals("delete")) session.delete(line);
        if(dml.equals("select")) session.load(HBLine.class, line);
        tx.commit();
        session.close();
    }
    public HBLine hibernateLine (HBLine line)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction tx = session.beginTransaction();
        return (HBLine) session.load(HBLine.class, line);
//        tx.commit();
//        session.close();
    }
    //---------------------------------getAllPapers--------------------------------------------------------------------------
    public static List<HBLine> getAllPapers()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<HBLine>  lines = (List<HBLine>) session.createQuery("from papers order by title,startdate").list();
        session.close();
        return lines;
    }
    public HBLine getPaper(int id)
    {
        HBLine line=new HBLine();
        line.setId(id);
        line = hibernateLine(line);
        return line;
    }
    //----------------------------------------------------------------------------
    public int addPaper(HBLine paper1)
    {
        HBLine paper = null;
        boolean paperExists = false;
        try {
            paper = getPaper(paper1.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(paper != null)
            paperExists = true;
        if(!paperExists)
        {
            try {
                hibernateLine(paper1,"insert");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 1;
        }
        return 0;
    }
    public int updatePaper(HBLine paper1)
    {
        HBLine paper = null;
        try {
            paper = getPaper(paper1.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(paper != null)
        {
            try {
                hibernateLine(paper1,"update");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 1;
        }
        return 0;
    }
    public int deletePaper(int id){
        HBLine paper1=null;
        try {
            paper1.setId(id);
            hibernateLine(paper1,"update");
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
