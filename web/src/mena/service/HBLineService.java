package mena.service;

import mena.db.HibernateUtil;
import mena.model.HBLine;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Ibrahim.mmh on 5/3/2018.
 */
public class HBLineService {

    public static List<HBLine> getAllPapers()
    {
        return  HibernateUtil.getAllByHQL("from papers order by title,startdate");
    }
    public HBLine getPaper(int id)
    {
        return  HibernateUtil.getOneByID(new HBLine(), id );
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
                HibernateUtil.hibernateTrx(paper1, "insert", 0);
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
                HibernateUtil.hibernateTrx(paper1, "update", paper1.getId());
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
            HibernateUtil.hibernateTrx(paper1, "delete", id);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
