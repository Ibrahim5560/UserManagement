package mena.service;

import mena.model.Paper;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 * Created by Ibrahim.mmh on 5/2/2018.
 */
public class PaperService {
    public List<Paper> getAllPapers()
    {
        List<Paper> paperList = null;
        FileInputStream fis ;
        ObjectInputStream ois;
        try
        {
            File file = new File("F:"+ File.separator +"Papers.dat");
            if (!file.exists())
            {
                Paper paper = new Paper(1,"Ibrahim", "Senior Java Developer","Software Development");
                Paper paper2 = new Paper(2,"Ahmed", "Java Team Lead","Software Development");
                paperList = new ArrayList<Paper>();
                paperList.add(paper);
                paperList.add(paper2);
                savePaperList(paperList);
            }
            else
            {
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);
                paperList = (List<Paper>) ois.readObject();
                ois.close();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        sortPapers(paperList);
        return paperList;
    }
    //----------------------------------------------------------------------------
    public Paper getPaper(int id)
    {
        List<Paper> papers = getAllPapers();
        for(Paper paper: papers)
            if(paper.getId() == id)
                return paper;
        return null;
    }
    public int addPaper(Paper paper1)
    {
        List<Paper> paperList = getAllPapers();
        boolean paperExists = false;
        for(Paper paper: paperList)
        {
            if(paper.getId() == paper1.getId())
            {
                paperExists = true;
                break;
            }
        }
        if(!paperExists)
        {
            paperList.add(paper1);
            savePaperList(paperList);
            return 1;
        }
        return 0;
    }
    public int updatePaper(Paper paper1)
    {
        List<Paper> paperList = getAllPapers();
        for(Paper paper: paperList)
        {
            if(paper.getId() == paper1.getId())
            {
                int index = paperList.indexOf(paper);
                paperList.set(index, paper1);
                savePaperList(paperList);
                return 1;
            }
        }
        return 0;
    }

    public int deletePaper(int id){
        List<Paper> paperList = getAllPapers();
        for(Paper paper: paperList){
            if(paper.getId() == id){
                int index = paperList.indexOf(paper);
                paperList.remove(index);
                savePaperList(paperList);
                return 1;
            }
        }
        return 0;
    }
    //----------------------------------------------------------------------------
    private void savePaperList(List<Paper> paperList){
        try
        {
            File file = new File("F:"+ File.separator +"Papers.dat");
            FileOutputStream fos;
            fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(paperList);
            oos.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //sort the Papers by Title or Date
    private void sortPapers(List<Paper> paperList){
        //-----------------------------------------------------------------------
        Collections.sort(paperList, new Comparator<Paper>() {
            @Override
            public int compare(Paper p1, Paper p2) {
                if (!p1.getTitle().equals(p2.getTitle()))
                    return p1.getTitle().compareTo(p2.getTitle()); // ascending order
                else if (!p1.getDate().equals(p2.getDate()))
                    return p1.getDate().compareTo(p2.getDate()); // ascending order
                else
                    return 1;
            }
        });
        //-----------------------------------------------------------------------
    }
}