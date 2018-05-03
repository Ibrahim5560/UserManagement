package mena.service;

import mena.db.MySQLSingleton;
import mena.model.Line;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ibrahim.mmh on 5/2/2018.
 */
public class LineService {
    MySQLSingleton instance = MySQLSingleton.getInstance();
    Connection conn = instance.getConnection();
    public List<Line> getAllPapers()
    {
        List<Line> paperList = new ArrayList<Line>();
        try {
            paperList = instance.getAllNews("select * from papers order by title,startdate",conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paperList;
    }
    //----------------------------------------------------------------------------
    public Line getPaper(int id)
    {
        Line paper = null;
        try {
            paper = instance.selectQuery("select * from papers where id=" + id, conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paper;
    }
    public int addPaper(Line paper1)
    {
        Line paper = null;
        boolean paperExists = false;
        StringBuffer sb = new StringBuffer();
        try {
            paper = instance.selectQuery("select * from papers where id=" + paper1.getId(), conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(paper != null)
            paperExists = true;
        if(!paperExists)
        {
            sb.append("insert into papers values (");
            sb.append(paper1.getId()+",now(),'");
            sb.append(paper1.getTitle()+"','");
            sb.append(paper1.getDescription()+"','");
            sb.append(paper1.getText() + "')");
//            System.out.println(sb.toString());
            try {
                instance.createQuery(sb.toString(), conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 1;
        }
        return 0;
    }
    public int updatePaper(Line paper1)
    {
        Line paper = null;
        StringBuffer sb = new StringBuffer();
        try {
            paper = instance.selectQuery("select * from papers where id=" + paper1.getId(), conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(paper != null)
        {
            sb.append("update papers set startdate=now() , title='");
            sb.append(paper1.getTitle()+"' , description='");
            sb.append(paper1.getDescription()+"' , text='");
            sb.append(paper1.getText()+"' where id=");
            sb.append(paper1.getId());
//            System.out.println(sb.toString());
            try {
                instance.createQuery(sb.toString(), conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 1;
        }
        return 0;
    }

    public int deletePaper(int id){
        boolean flag=false;
        try {
            flag = instance.isDeletedQuery("delete from papers where id=" + id, conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(flag)
            return 1;
        return 0;
    }
    //----------------------------------------------------------------------------
}