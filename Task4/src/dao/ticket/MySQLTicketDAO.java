package dao.ticket;

import dao.AbstractModelDAO;
import dao.DBConnector;
import manager.QueriesManager;
import model.Ticket;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static logger.RailwaySystemLogger.log;

/**
 * Created by Anna Oliinyk
 *
 * @author Anna Oliinyk
 */
public class MySQLTicketDAO extends AbstractModelDAO implements TicketDAO {

    protected List<Ticket> tickets;
    protected Ticket ticket;

    /**
     * Returns list of all tickets for determined user from DB based on the user ID
     * @param idUser is user ID
     * @return list of all tickets for determined user from DB based on the user ID
     */
    @Override
    public List<Ticket> getTicketsForClient(int idUser) {

        tickets = new ArrayList<Ticket>();

        try {

            Connection cn = DBConnector.getConnection();
            if (cn != null)
            {
                statement = cn.prepareStatement(QueriesManager.GET_CLIENT_PURCHASE_HISTORY);
                statement.setInt(1, idUser);
                try
                {
                    resultSet = statement.executeQuery();

                    while (resultSet.next())
                    {
                        ticket = createTicket(resultSet);
                        tickets.add(ticket);
                    }
                    return tickets;

                }
                catch (SQLException e)
                {
                    log.error(e.getMessage());
                }
            }
            else
            {
                log.error(" Connection failed ");
            }
        } catch (SQLException e) {
           log.error(e.getMessage());
        }
        finally {
            closeStatements();
            DBConnector.destroyConnection();
        }
        return null;
    }

    /**
     * Adds ticket to DB
     * Returns <tt>true</tt> if the transaction is successful
     * @param dateTimeBegin is start date and time
     * @param dateTimeEnd is finish date and time
     * @param numberWagon is wagon number
     * @param typeSeatID is ID of type seat
     * @param routeFragmentID is ID of route fragment
     * @param clientID is client ID
     * @return <tt>true</tt> if the transaction is successful
     */
    @Override
    public boolean addTicket(String dateTimeBegin, String dateTimeEnd, int numberWagon, int typeSeatID, int routeFragmentID, int clientID) {
        try
        {
            Connection cn = DBConnector.getConnection();
            if (cn != null)
            {
                statement = cn.prepareStatement(QueriesManager.FIND_SEAT_NUM);
                statement.setInt(1, typeSeatID);
                statement.setInt(2, routeFragmentID);
                statement.setInt(3, numberWagon);
                statement.setString(4, dateTimeBegin);
                statement.setInt(5, typeSeatID);
                statement.setInt(6, routeFragmentID);
                statement.setInt(7, numberWagon);
                statement.setString(8, dateTimeBegin);
                statement.setInt(9, typeSeatID);
                statement.setInt(10, routeFragmentID);
                statement.setInt(11, numberWagon);
                statement.setString(12, dateTimeBegin);
                resultSet = statement.executeQuery();
                resultSet.next();
                int seatNumber = resultSet.getInt("seat_num");

                statement = cn.prepareStatement(QueriesManager.INSERT_TICKET);
                statement.setString(1, dateTimeBegin);
                statement.setString(2, dateTimeEnd);
                statement.setInt(3, numberWagon);
                statement.setInt(4, seatNumber);
                statement.setInt(5, typeSeatID);
                statement.setInt(6, clientID);
                statement.setInt(7, routeFragmentID);
                statement.executeUpdate();
                return true;
            }
            else
            {
                log.error(" Connection failed ");
            }
        }
        catch (SQLException e)
        {
            log.error(e.getMessage());
        }
        finally
        {
            closeStatements();
            DBConnector.destroyConnection();
        }
        return false;

    }

    /**
     * Returns list of all tickets with unconfirmed status from DB
     * @return list of all tickets with unconfirmed status from DB
     */
    @Override
    public List<Ticket> getUnconfirmedTickets() {

        tickets = new ArrayList<Ticket>();

        try
        {
            Connection cn = DBConnector.getConnection();
            if (cn != null)
            {
                statement = cn.prepareStatement(QueriesManager.GET_TICKETS_UNCONFIRMED);
                try
                {
                    resultSet = statement.executeQuery();

                    while (resultSet.next()) {

                        ticket = createTicket(resultSet);
                        tickets.add(ticket);
                    }
                    return tickets;
                }
                catch (SQLException e)
                {
                    log.error(e.getMessage());
                }
            }
            else
            {
                log.error(" Connection failed ");
            }
        }
        catch (SQLException e)
        {
            log.error(e.getMessage());
        }
        finally
        {
            closeStatements();
            DBConnector.destroyConnection();
        }
        return null;
    }

    /**
     * Changes status of ticket based on ticket ID
     * Returns <tt>true</tt> if the transaction is successful
     * @param id is ticket ID
     * @param status is new ticket status
     * @return <tt>true</tt> if the transaction is successful
     */
    @Override
    public boolean setTicketStatus(int id, int status) {
        try
        {
            Connection cn = DBConnector.getConnection();
            if (cn != null)
            {
                statement = cn.prepareStatement(QueriesManager.SET_TICKET_STATUS);
                statement.setInt(1, status);
                statement.setInt(2, id);
                statement.executeUpdate();
                return true;
            }
            else
            {
                log.error(" Connection failed ");
            }
        }
        catch (SQLException e)
        {
            log.error(e.getMessage());
        }
        finally
        {
            closeStatements();
            DBConnector.destroyConnection();
        }
        return false;
    }

    /**
     * Creates ticket from result set
     *
     * @param rs to create ticket
     * @return Created ticket
     */
    private Ticket createTicket(ResultSet rs) {
        Ticket ticket = new Ticket();
        try
        {
            ticket.setTicketID(rs.getInt("id_ticket"));

            ticket.setSurnameClient(rs.getString("surname"));
            ticket.setNameClient(rs.getString("name"));
            ticket.setPatronymicClient(rs.getString("patronymic"));
            ticket.setTelephoneClient(rs.getString("telephone"));

            ticket.setDateTimeBegin(rs.getString("datetime_begin"));
            ticket.setDateTimeEnd(rs.getString("datetime_end"));

            ticket.setNameTrain(rs.getString("name_train"));

            ticket.setNumberWagon(rs.getInt("number_wagon"));
            ticket.setNameTypeSeat(rs.getString("name_type_seat"));
            ticket.setNumberSeat(rs.getInt("number_seat"));

            ticket.setNameStationStart(rs.getString("name_station_start"));
            ticket.setNameStationFinish(rs.getString("name_station_finish"));

            ticket.setDistance(rs.getInt("distance"));

            ticket.setPrice(rs.getDouble("price"));

            ticket.setStatus(rs.getInt("status"));

            return ticket;

        }
        catch (SQLException e)
        {
            log.error(e.getMessage());
        }
        return null;
    }

}
