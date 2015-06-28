package dao.ticket;

import model.Ticket;

import java.util.List;

/**
 * Created by Anna Oliinyk
 *
 * @author Anna Oliinyk
 */
public interface TicketDAO {

    List<Ticket> getTicketsForClient(int idClient);

    boolean addTicket(String dateTimeBegin, String dateTimeEnd, int numberWagon, int typeSeatID, int routeFragmentID, int clientID);

    List<Ticket> getUnconfirmedTickets();

    boolean setTicketStatus(int id, int status);

}
