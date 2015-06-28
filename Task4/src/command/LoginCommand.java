package command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import dao.MainDAO;
import dao.client.ClientDAO;
import dao.user.UserDAO;
import manager.ConfigurationManager;
//import manager.MessageManager;
import model.Client;
import model.User;

import static logger.RailwaySystemLogger.log;

/**
 * Created by Anna Oliinyk
 *
 * @author Anna Oliinyk
 */
public class LoginCommand implements Command {

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        if ( (login == null) || (login.equals("")) ||
                (pass == null) || (pass.equals("")) )
        {
            request.setAttribute("error_empty_message", "error");
            return ConfigurationManager.LOGIN_PAGE_PATH;
        }

        MainDAO dao = MainDAO.getMainDAO(ConfigurationManager.CONNECTION);
        UserDAO userDAO = dao.getUserDAO();
        User user = userDAO.getUserLoginPassword(login, pass);

        if (user != null)
        {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);

            if (user.getRole() == User.Role.ADMIN)
            {
                return ConfigurationManager.ADMIN_MAIN_PAGE_PATH;
            }
            else
            {
                ClientDAO clientDAO = dao.getClientDAO();
                Client client = clientDAO.getUserClient(user.getUserID());
                if (client != null)
                {
                    session.setAttribute("client", client);
                    return ConfigurationManager.CLIENT_MAIN_PAGE_PATH;
                }
                else
                {
                    return ConfigurationManager.CLIENT_NEW_PAGE_PATH;
                }
            }
        }
        else
        {
            log.error("Login or pass are wrong " + login);
            request.setAttribute("error_message", "error");
            return ConfigurationManager.LOGIN_PAGE_PATH;
        }
    }

}
