package mena.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
/**
 * Created by Ibrahim.mmh on 5/2/2018.
 */
@XmlRootElement(name = "paper")
public class Paper implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private Date date;
    private String title;
    private String description;
    private String text;

    public Paper(){}

    public Paper(int id,String title,String description,String text){
        this.id=id;
        this.date=new java.util.Date();
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
    public Date getDate() {
        return date;
    }
    @XmlElement
    public void setDate(Date date) {
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
        }else if(!(object instanceof Paper)){
            return false;
        }else {
            Paper paper = (Paper)object;
            if(id == paper.getId()
                    && title.equals(paper.getTitle())
                    && date.equals(paper.getDate())
                    && description.equals(paper.getDescription())
                    && text.equals(paper.getText())
                    ){
                return true;
            }
        }
        return false;
    }
    //------------------------------------------------------------------------
}