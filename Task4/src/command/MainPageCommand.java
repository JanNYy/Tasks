package command;

import manager.ConfigurationManager;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Anna Oliinyk
 *
 * @author Anna Oliinyk
 */
public class MainPageCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user.getRole() == User.Role.ADMIN)
            return ConfigurationManager.ADMIN_MAIN_PAGE_PATH;
        else
            return ConfigurationManager.CLIENT_MAIN_PAGE_PATH;
    }

}
