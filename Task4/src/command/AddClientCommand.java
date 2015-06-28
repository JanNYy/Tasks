package command;

import dao.MainDAO;
import dao.client.ClientDAO;
import manager.ConfigurationManager;
import model.Client;
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
public class AddClientCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String surname = request.getParameter("surname");
        String name = request.getParameter("name");
        String patronymic = request.getParameter("patronymic");
        String telephone = request.getParameter("telephone");

        if ( (surname == null) || (surname.equals("")) ||
                (name == null) || (name.equals("")) ||
                (patronymic == null) || (patronymic.equals("")) ||
                (telephone == null) || (telephone.equals("")) )
        {
            request.setAttribute("error_empty_message", "error");
            return ConfigurationManager.CLIENT_NEW_PAGE_PATH;
        }

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        int userID = user.getUserID();

        Client client = new Client();
        client.setSurname(surname);
        client.setName(name);
        client.setPatronymic(patronymic);
        client.setTelephone(telephone);
        client.setUserID(userID);

        MainDAO dao = MainDAO.getMainDAO(ConfigurationManager.CONNECTION);
        ClientDAO clientDAO = dao.getClientDAO();
        if (clientDAO.addClient(client))
        {
            session.setAttribute("client", client);
            return ConfigurationManager.CLIENT_MAIN_PAGE_PATH;
        }
        else
            return ConfigurationManager.ERROR_PAGE_PATH;
    }

}
