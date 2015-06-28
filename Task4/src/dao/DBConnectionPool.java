package dao;

import manager.ConfigurationManager;
import org.apache.commons.dbcp.cpdsadapter.DriverAdapterCPDS;
import org.apache.commons.dbcp.datasources.SharedPoolDataSource;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static logger.RailwaySystemLogger.log;

/**
 * Class that implements a pool of database connections
 *
 * http://j-hosting.ru/show.html?alias=connectdb
 */
public class DBConnectionPool {

    /**
     *  Maximum number of active connections
     * -1 - unlimited number of connections
     */
    private static final int MAX_ACTIVE = 200;

    /**
     * The maximum number of milliseconds that the pool will wait (when there are no free connections)
     * before throw an exception.
     * -1 - waiting will be indefinitely
     */
    private static final int MAX_WAIT = 100;

    /**
     * DB connection
     */
    private Connection conn = null;

    /**
     * Data source
     */
    private static DataSource ds = null;

    /**
     * Constructor, defines variables for the DB connection
     */
    public DBConnectionPool() {
        if (ds == null) {
            try
            {
                //Адаптер для JDBC-драйвера. Хранит параметры подключения к БД
                DriverAdapterCPDS pcds = new DriverAdapterCPDS();
                pcds.setDriver(ConfigurationManager.DATABASE_DRIVER_NAME);
                pcds.setUrl(ConfigurationManager.DATABASE_URL);
                pcds.setUser(ConfigurationManager.DATABASE_USER);
                pcds.setPassword(ConfigurationManager.DATABASE_PASSWORD);

                //Реализация интерфейса DataSource для разделяемого пула соеднинений
                SharedPoolDataSource tds = new SharedPoolDataSource();
                tds.setConnectionPoolDataSource(pcds);

                tds.setMaxActive(MAX_ACTIVE);

                tds.setMaxWait(MAX_WAIT);

                ds = tds;
            }
            catch (ClassNotFoundException e)
            {
                log.error(e.getMessage());
            }
        }
    }

    /**
     * Returns DB connection
     */
     public Connection openConnection() throws SQLException {
         if (conn == null) conn = ds.getConnection();
         return conn;
     }

    /**
     * Returns the number of active DB connections
     */
    public static int getActiveConnection() {
        return ((SharedPoolDataSource)ds).getNumActive();
    }

    /**
     * If connection is open, returns DB connection
     */
    public Connection getConnection() throws SQLException {
         return openConnection();
     }

    /**
     * Closes connection
     */
     public void close() {
         try
         {
             if (conn != null)
             {
                 conn.close();
                 conn = null;
             }
         }
         catch (SQLException e)
         {
             log.error(e.getMessage());
         }
     }
}

