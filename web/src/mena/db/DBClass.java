package mena.db;

import mena.model.Entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ibrahim.mmh on 5/2/2018.
 */
public class DBClass {
    private static Map<Integer,Entity> entities = new HashMap<>();
    public static Map<Integer,Entity> getEntities(){
        return entities;
    }
}
