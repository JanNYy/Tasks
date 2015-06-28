package command;

import dao.MainDAO;
import dao.ticket.TicketDAO;
import manager.ConfigurationManager;
import model.Ticket;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Anna Oliinyk
 *
 * @author Anna Oliinyk
 */
public class ViewHistoryCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MainDAO dao = MainDAO.getMainDAO(ConfigurationManager.CONNECTION);
        TicketDAO ticketDAO = dao.getTicketDAO();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<Ticket> tickets = ticketDAO.getTicketsForClient(user.getUserID());
        if (tickets == null) return ConfigurationManager.ERROR_PAGE_PATH;
        if (!tickets.isEmpty())
        {
            request.setAttribute("tickets",tickets);
            return ConfigurationManager.CLIENT_HISTORY_PAGE_PATH;
        }
        return ConfigurationManager.NO_RESULTS_PAGE_PATH;
    }

}
