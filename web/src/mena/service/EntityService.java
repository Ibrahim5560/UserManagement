package mena.service;

import mena.db.DBClass;
import mena.model.Entity;

import java.io.*;
import java.util.*;

/**
 * Created by Ibrahim.mmh on 5/2/2018.
 */
public class EntityService {

    private Map<Integer,Entity> entities = DBClass.getEntities();
    public EntityService(){
        entities.put(1, new Entity(1,"Ibrahim", "Senior Java Developer","Software Development"));
        entities.put(2, new Entity(2,"Ahmed", "Java Team Lead","Software Development"));
    }
    public List<Entity> getAllEntities()
    {
        List<Entity> entityList = new ArrayList<Entity>(entities.values());
        sortEntities(entityList);
        return entityList;
    }
    //----------------------------------------------------------------------------
    public Entity getEntity(int id)
    {
        return entities.get(id);
    }
    public Entity addEntity(Entity pEntity)
    {
        pEntity.setId(entities.size() + 1);
        entities.put(pEntity.getId(),pEntity);
        return pEntity;
    }
    public Entity updateEntity(Entity pEntity)
    {
        if (pEntity.getId()==0)
            return null;
        entities.put(pEntity.getId(),pEntity);
        return pEntity;
    }

    public Entity deleteEntity(int id){
        return entities.remove(id);
    }
    //----------------------------------------------------------------------------
    //sort the Entities by Title or Date
    private void sortEntities(List<Entity> entityList){
        //-----------------------------------------------------------------------
        Collections.sort(entityList, new Comparator<Entity>() {
            @Override
            public int compare(Entity p1, Entity p2) {
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
