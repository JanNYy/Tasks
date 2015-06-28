package command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import dao.MainDAO;
import dao.client.ClientDAO;
import manager.ConfigurationManager;
import model.Client;
import model.User;

/**
 * Created by Anna Oliinyk
 *
 * @author Anna Oliinyk
 */
public class NoCommand implements Command {

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if ( (!session.isNew()) && (user != null) )
        {
            if (user.getRole() == User.Role.ADMIN)
                return ConfigurationManager.ADMIN_MAIN_PAGE_PATH;
            else
            {
                Client client = (Client) session.getAttribute("client");
                if (client != null)
                    return ConfigurationManager.CLIENT_MAIN_PAGE_PATH;
                else
                    return ConfigurationManager.CLIENT_NEW_PAGE_PATH;
            }
        }

        return ConfigurationManager.LOGIN_PAGE_PATH;
    }

}
