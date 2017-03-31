package db;

import com.mongodb.DB;
import com.mongodb.DBCollection;

/**
 * Manage database
 *
 * @author Clesio
 * @since 17/04/2016
 * */
public class MongoClienteAccessor {

    private static DB db;

    public static DB getDb(){
        return db;
    }

    public static void setDB(DB db) {
        MongoClienteAccessor.db = db;
    }

    public static DBCollection getCollection(String name) {
        return db.getCollection(name);
    }

}
