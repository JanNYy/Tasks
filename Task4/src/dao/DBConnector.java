package dao;

import java.sql.Connection;
import java.sql.SQLException;

import static logger.RailwaySystemLogger.log;

/**
 * Created by Anna Oliinyk
 *
 * @author Anna Oliinyk
 */
public class DBConnector {

    public static final DBConnectionPool connectionPool = new DBConnectionPool();

    public static Connection getConnection() {
        try
        {
            return connectionPool.getConnection();
        }
        catch (SQLException e)
        {
            log.error(e.getMessage());
            return null;
        }
    }

    public static void destroyConnection() {
        connectionPool.close();
    }

}
