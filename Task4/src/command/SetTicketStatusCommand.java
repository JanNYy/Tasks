package command;

import dao.MainDAO;
import dao.ticket.TicketDAO;
import manager.ConfigurationManager;
import model.Ticket;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Anna Oliinyk
 *
 * @author Anna Oliinyk
 */
public class SetTicketStatusCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("ticket_id"));
        int status = Integer.parseInt(request.getParameter("status"));
        MainDAO dao = MainDAO.getMainDAO(ConfigurationManager.CONNECTION);
        TicketDAO ticketDAO = dao.getTicketDAO();
        if (ticketDAO.setTicketStatus(id, status))
        {
            List<Ticket> tickets = ticketDAO.getUnconfirmedTickets();
            if (tickets == null) return ConfigurationManager.ERROR_PAGE_PATH;
            //if (!tickets.isEmpty())
            {
                request.setAttribute("tickets",tickets);
                return ConfigurationManager.TICKETS_UNCONFIRMED_PAGE_PATH;
            }
            //return ConfigurationManager.NO_RESULTS_PAGE_PATH;
        }
        return ConfigurationManager.ERROR_PAGE_PATH;
    }
}
