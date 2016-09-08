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

    private static final String HOST = "host";
    private static final String PORT = "port";
    private static final String NAME = "db.name";
    private static final String PROPERTIES = "db.properties";

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String host = getProp(HOST);
        Integer port = Integer.parseInt(getProp(PORT));
        String dbName = getProp(NAME);
        MongoClienteAccessor.setDB(new MongoClient(new ServerAddress(host, port)).getDB(dbName));
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }

    private String getProp(String name) {
        return (String) PropertyReader.getProperty(PROPERTIES, name);
    }

}