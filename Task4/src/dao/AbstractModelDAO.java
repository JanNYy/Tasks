package dao;

import manager.QueriesManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static logger.RailwaySystemLogger.log;

/**
 * Created by Anna Oliinyk
 *
 * @author Anna Oliinyk
 */
public abstract class AbstractModelDAO {

    protected ResultSet resultSet;
    protected PreparedStatement statement;

    protected void closeStatements()
    {
        if (resultSet != null)
        {
            try
            {
                resultSet.close();
            }
            catch (SQLException e)
            {
                log.error(e.getMessage());
            }
        }
        if (statement != null)
        {
            try
            {
                statement.close();
            }
            catch (SQLException e)
            {
                log.error(e.getMessage());
            }
        }
     }

}
