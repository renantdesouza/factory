package db;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import utils.PropertyReader;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Connect to database
 *
 * @author clesio
 * @since 17/04/2016.
 */
public class DBListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String host = getProp("host");
        Integer port = Integer.parseInt(getProp("port"));
        String dbName = getProp("db.name");
        MongoClienteAccessor.setDB(new MongoClient(new ServerAddress(host, port)).getDB(dbName));
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }

    private String getProp(String name) {
        return (String) PropertyReader.getProperty("db.properties", name);
    }

}
