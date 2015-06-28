package dao.client;

import dao.AbstractModelDAO;
import dao.DBConnector;
import manager.QueriesManager;
import model.Client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static logger.RailwaySystemLogger.log;

/**
 * Created by Anna Oliinyk
 *
 * @author Anna Oliinyk
 */
public class MySQLClientDAO extends AbstractModelDAO implements ClientDAO {

    protected Client client;

    /**
     * Returns the client from DB based on the user ID
     * @param id is user ID
     * @return the client from DB based on the user ID
     */
    @Override
    public Client getUserClient(int id) {

        try
        {
            Connection cn = DBConnector.getConnection();
            if (cn != null)
            {
                statement = cn.prepareStatement(QueriesManager.GET_USER_CLIENT);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    client = createClient(resultSet);
                    return client;
                }
            }
            else
            {
                log.error(" Connection failed ");
            }

        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        finally
        {
            closeStatements();
            DBConnector.destroyConnection();
        }
        return null;
    }

    /**
     * Adds client to DB
     * Returns <tt>true</tt> if the transaction is successful
     * @param client is new client
     * @return <tt>true</tt> if the transaction is successful
     */
    @Override
    public boolean addClient(Client client) {

        try
        {
            Connection cn = DBConnector.getConnection();
            if (cn != null)
            {
                statement = cn.prepareStatement(QueriesManager.INSERT_CLIENT);
                statement.setString(1, client.getSurname());
                statement.setString(2, client.getName());
                statement.setString(3, client.getPatronymic());
                statement.setString(4, client.getTelephone());
                statement.setInt(5, client.getUserID());
                statement.executeUpdate();
                return true;
            }
            else
            {
                log.error(" Connection failed ");
            }
        }
        catch (SQLException e)
        {
            log.error(e.getMessage());
        }
        finally
        {
            closeStatements();
            DBConnector.destroyConnection();
        }
        return false;

    }

    /**
     * Creates client from result set
     *
     * @param rs to create client
     * @return Created client
     */
    private Client createClient(ResultSet rs) {
        Client client = new Client();
        try
        {
            client.setClientID(rs.getInt("id_client"));
            client.setSurname(rs.getString("surname"));
            client.setName(rs.getString("name"));
            client.setPatronymic(rs.getString("patronymic"));
            client.setTelephone(rs.getString("telephone"));
            client.setUserID(rs.getInt("id_user_FK"));
            return client;
        }
        catch (SQLException e)
        {
            log.error(e.getMessage());
        }
        return null;
    }

}
