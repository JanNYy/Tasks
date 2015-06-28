package dao.user;

import model.User;

import java.util.List;

/**
 * Created by Anna Oliinyk
 *
 * @author Anna Oliinyk
 */
public interface UserDAO {

    boolean isUserExist(String login);

    boolean addUser(User user);

    User getUserLoginPassword(String login, String password);

    List<User> getAllUsers();

}
