package dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import db.MongoClienteAccessor;
import model.Model;

import java.beans.Transient;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Generic DATA ACCESS OBJETC
 *
 * @author renantdesouza.
 * @since 15/08/2016.
 */
public class DAO<T extends Model> {

    private Class<T> klazz;
    private DBCollection collection = MongoClienteAccessor.getCollection(klazz.getSimpleName().toLowerCase());

    public DAO(Class<T> klazz) {
        this.klazz = klazz;
    }

    public void create(T entity) {
        collection.insert(getObject(entity));
    }

    public void update(T entity) {
        collection.update(query(entity), getObject(entity));
    }

    public void update(String field, T entity) {
        //TODO AJUSTAR AOS PADRÕES DE HANDLER.
        try {
            collection.update(query(field, klazz.getDeclaredField(field)), getObject(entity));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public List<T> findAll() {
        return find(null, null);
    }

    public T findById(String id) {
        return convert(collection.findOne(query(id)));
    }

    public List<T> find(String field, Object value) {
        List<T> entities = new ArrayList<>();
        DBCursor objs = field == null ? collection.find() : collection.find(new BasicDBObject(field, value));
        while(objs.hasNext()) {
            entities.add(convert(objs.next()));
        }
        return entities;
    }

    public void delete(T entity) {
        collection.remove(query(entity));
    }

    public void delete(String field, Object value) {
        collection.remove(query(field, value));
    }

    private BasicDBObject getObject(T entity) {
        BasicDBObject obj = new BasicDBObject();
        for(Field field : klazz.getDeclaredFields()) {
            if(!field.isAnnotationPresent(Transient.class)) {
                field.setAccessible(true);
                //TODO AJUSTAR AOS PADRÕES DE HANDLER.
                try {
                    obj.append(field.getName(), field.get(entity));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return obj;
    }

    private T convert(DBObject obj) {
        return new Gson().fromJson(obj.toString(), new TypeToken<T>() {}.getType());
    }

    private DBObject query(T entity){
        return query(entity.getId());
    }

    private DBObject query(String id){
        return query("_id", id);
    }

    private DBObject query(String field, Object value) {
        return new BasicDBObject(field, value);
    }
}
