package command;

import dao.MainDAO;
import dao.user.UserDAO;
import manager.ConfigurationManager;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static logger.RailwaySystemLogger.log;

/**
 * Created by Anna Oliinyk
 *
 * @author Anna Oliinyk
 */
public class AcceptRegistrationCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String pass = request.getParameter("password");
        String confirmPass = request.getParameter("confirm_pass");

        if ( (login == null) || (login.equals("")) ||
                (pass == null) || (pass.equals("")) ||
                (confirmPass == null) || (confirmPass.equals("")) )
        {
            request.setAttribute("error_reg_empty_message", "error");
            return ConfigurationManager.REGISTRATION_PAGE_PATH;
        }

        MainDAO dao = MainDAO.getMainDAO(ConfigurationManager.CONNECTION);
        UserDAO userDAO = dao.getUserDAO();

        if (userDAO.isUserExist(login))
        {
            request.setAttribute("error_reg_exist_message", "error_reg_exist_message");
            return ConfigurationManager.REGISTRATION_PAGE_PATH;
        }
        else
        {
            if (pass.equals(confirmPass))
            {
                log.info("User " + login + " has been registered");

                User user = new User();

                user.setLogin(login);
                user.setPassword(pass);

                userDAO = dao.getUserDAO();
                if (userDAO.addUser(user))
                {
                    request.setAttribute("reg_ok_message", "reg");
                    return ConfigurationManager.LOGIN_PAGE_PATH;
                }
                else
                    return ConfigurationManager.ERROR_PAGE_PATH;
            }
            else
            {
                request.setAttribute("error_reg_pass_message", "error");
                return ConfigurationManager.REGISTRATION_PAGE_PATH;
            }
        }

    }

}
