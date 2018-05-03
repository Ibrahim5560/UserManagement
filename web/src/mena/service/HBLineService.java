package mena.service;

import mena.db.HibernateUtil;
import mena.model.HBLine;
import mena.model.Line;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Ibrahim.mmh on 5/3/2018.
 */
public class HBLineService {
    public void hibernateLine (HBLine line,String dml)
    {
        Session session =
                HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        if(dml.equals("insert")) session.save(line);
        if(dml.equals("update")) session.update(line);
        if(dml.equals("delete")) session.delete(line);
        if(dml.equals("select")) session.load(Line.class, line.getId());
        tx.commit();
    }

    //---------------------------------getAllPapers--------------------------------------------------------------------------
    public static List<HBLine> getAllPapers()
    {
        Session session =
                HibernateUtil.getSessionFactory().getCurrentSession();
        List<HBLine>  lines = (List<HBLine>) session.createSQLQuery("from papers order by title,startdate").list();
        return lines;
    }
    public static HBLine getPaper(int id)
    {
        HBLine line=null;
        Session session =
                HibernateUtil.getSessionFactory().getCurrentSession();
        line = (HBLine) session.load(HBLine.class, id);
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
