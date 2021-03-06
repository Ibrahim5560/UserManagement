package mena.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Ibrahim.mmh on 5/2/2018.
 */
@XmlRootElement(name = "line")
public class Line implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private Timestamp date;
    private String title;
    private String description;
    private String text;

    public Line(){}

    public Line(String title,String description,String text){
        this.date=new Timestamp(System.currentTimeMillis());
        this.title=title;
        this.description=description;
        this.text=text;
    }
    public Line(int id,String title,String description,String text){
        this.id=id;
        this.date=new Timestamp(System.currentTimeMillis());
        this.title=title;
        this.description=description;
        this.text=text;
    }
    public Line(int id,Timestamp date,String title,String description,String text){
        this.id=id;
        this.date=date;
        this.title=title;
        this.description=description;
        this.text=text;
    }

    public int getId() {
        return id;
    }
    @XmlElement
    public void setId(int id) {
        this.id = id;
    }
    public Timestamp getDate() {
        return date;
    }
    @XmlElement
    public void setDate(Timestamp date) {
        this.date = date;
    }
    public String getTitle() {
        return title;
    }
    @XmlElement
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    @XmlElement
    public void setDescription(String description) {
        this.description = description;
    }
    public String getText() {
        return text;
    }
    @XmlElement
    public void setText(String text) {
        this.text = text;
    }
    //--------------------------------------------------------------------
    @Override
    public boolean equals(Object object){
        if(object == null){
            return false;
        }else if(!(object instanceof Line)){
            return false;
        }else {
            Line line = (Line)object;
            if(id == line.getId()
                    && title.equals(line.getTitle())
                    && date.equals(line.getDate())
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