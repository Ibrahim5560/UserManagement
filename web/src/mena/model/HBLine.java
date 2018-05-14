package mena.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Ibrahim.mmh on 5/3/2018.
 */
public class HBLine implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private Timestamp startdate;
    private String title;
    private String description;
    private String text;

    public HBLine(){}

    public HBLine(String title,String description,String text){
        this.startdate = new Timestamp(System.currentTimeMillis());
        this.title=title;
        this.description=description;
        this.text=text;
    }
    public HBLine(int id,String title,String description,String text){
        this.id=id;
        this.startdate = new Timestamp(System.currentTimeMillis());
        this.title=title;
        this.description=description;
        this.text=text;
    }
    public HBLine(int id,Timestamp startdate,String title,String description,String text){
        this.id=id;
        this.startdate = startdate;
        this.title=title;
        this.description=description;
        this.text=text;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Timestamp getStartdate() {
        return startdate;
    }
    public void setStartdate(Timestamp startdate) {
        this.startdate = startdate;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    //--------------------------------------------------------------------
    @Override
    public boolean equals(Object object){
        if(object == null){
            return false;
        }else if(!(object instanceof HBLine)){
            return false;
        }else {
            HBLine line = (HBLine)object;
            if(id == line.getId()
                    && title.equals(line.getTitle())
                    && startdate.equals(line.getStartdate())
                    && description.equals(line.getDescription())
                    && text.equals(line.getText())
                    ){
                return true;
            }
        }
        return false;
    }
    //------------------------------------------------------------------------
}