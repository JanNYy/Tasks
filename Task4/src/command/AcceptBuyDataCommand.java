package command;

import dao.MainDAO;
import dao.client.ClientDAO;
import dao.ticket.TicketDAO;
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
public class AcceptBuyDataCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String dateTimeBegin = request.getParameter("datetime_begin");
        String dateTimeEnd = request.getParameter("datetime_end");
        int numberWagon = Integer.parseInt(request.getParameter("number_wagon"));
        int typeSeatID = Integer.parseInt(request.getParameter("id_type_seat"));
        int routeFragmentID = Integer.parseInt(request.getParameter("id_route_fragment"));

        MainDAO dao = MainDAO.getMainDAO(ConfigurationManager.CONNECTION);

        HttpSession session = request.getSession();
        Client client = (Client) session.getAttribute("client");

        int clientID = client.getClientID();

        TicketDAO ticketDAO = dao.getTicketDAO();
        if (ticketDAO.addTicket(dateTimeBegin, dateTimeEnd, numberWagon, typeSeatID, routeFragmentID, clientID))
            return ConfigurationManager.CLIENT_MAIN_PAGE_PATH;
        else
            return ConfigurationManager.ERROR_PAGE_PATH;
    }
}
