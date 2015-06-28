package dao.user;

import dao.AbstractModelDAO;
import dao.DBConnector;
import manager.QueriesManager;
import model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static logger.RailwaySystemLogger.log;

/**
 * Created by Anna Oliinyk
 *
 * @author Anna Oliinyk
 */
public class MySQLUserDAO extends AbstractModelDAO implements UserDAO {

    List<User> users;
    User user;

    /**
     * Finds user in DB
     * Returns <tt>true</tt> if the user exists
     * @param login is login of user
     * @return <tt>true</tt> if the user exists
     */
    @Override
    public boolean isUserExist(String login) {

        try
        {
            Connection cn = DBConnector.getConnection();
            if (cn != null)
            {
                statement = cn.prepareStatement(QueriesManager.GET_USER_LOGIN);
                statement.setString(1, login);
                resultSet = statement.executeQuery();
                return (resultSet.next());
            }
            else
            {
                log.error(" Connection failed ");
                return false;
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
     * Adds user to DB
     * Returns <tt>true</tt> if the transaction is successful
     * @param user is new user
     * @return <tt>true</tt> if the transaction is successful
     */
    @Override
    public boolean addUser(User user) {
        try
        {
            Connection cn = DBConnector.getConnection();
            if (cn != null)
            {
                statement = cn.prepareStatement(QueriesManager.INSERT_USER);
                statement.setString(1, user.getLogin());
                statement.setString(2, user.getPassword());
                statement.setInt(3, 1);
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
     * Returns user in DB based on login and password
     * @param login is user login
     * @param password is user password
     * @return user in DB based on login and password
     */
    @Override
    public User getUserLoginPassword(String login, String password) {

        try
        {
            Connection cn = DBConnector.getConnection();
            if (cn != null)
            {
                statement = cn.prepareStatement(QueriesManager.GET_USER_LOGIN_PASSWORD);
                statement.setString(1, login);
                statement.setString(2, password);
                resultSet = statement.executeQuery();
                if (resultSet.next())
                {
                    user = createUser(resultSet);
                    return user;
                }
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
        return null;
    }

    /**
     * Returns list of all users from DB
     * @return list of all users from DB
     */
    @Override
    public List<User> getAllUsers() {

        users = new ArrayList<User>();

        try {
            Connection cn = DBConnector.getConnection();
            if (cn != null)
            {
                statement = cn.prepareStatement(QueriesManager.GET_ALL_USERS);
                try
                {
                    resultSet = statement.executeQuery();

                    while (resultSet.next())
                    {
                        user = createUser(resultSet);
                        users.add(user);
                    }
                    return users;
                }
                catch (SQLException e)
                {
                    log.error(e.getMessage());
                }
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
        return null;
    }

    /**
     * Creates user from result set
     *
     * @param rs to create user
     * @return Created user
     */
    private User createUser(ResultSet rs) {
        User user = new User();
        try
        {
            user.setUserID(rs.getInt("id_user"));
            user.setLogin(rs.getString("login"));
            user.setPassword(rs.getString("password"));
            user.setRole(rs.getInt("role"));
            return user;
        }
        catch (SQLException e)
        {
            log.error(e.getMessage());
        }
        return null;
    }

}
