package mena.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Ibrahim.mmh on 5/2/2018.
 */
public class Entity implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private Date date;
    private String title;
    private String description;
    private String text;

    public Entity(){}
    public Entity(int id,String title,String description,String text){
        this.id=id;
        this.date=new Date();
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
        }else if(!(object instanceof Entity)){
            return false;
        }else {
            Entity entity = (Entity)object;
            if(id == entity.getId()
                    && title.equals(entity.getTitle())
                    && date.equals(entity.getDate())
                    && description.equals(entity.getDescription())
                    && text.equals(entity.getText())
                    ){
                return true;
            }
        }
        return false;
    }
    //------------------------------------------------------------------------

}
