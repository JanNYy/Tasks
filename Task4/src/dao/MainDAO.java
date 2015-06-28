package dao;

import dao.client.ClientDAO;
import dao.station.StationDAO;
import dao.ticket.TicketDAO;
import dao.trainforticket.TrainForTicketDAO;
import dao.user.UserDAO;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Anna Oliinyk
 *
 * @author Anna Oliinyk
 */
public abstract class MainDAO {

    public static MainDAO getMainDAO(String connection) {
        switch (connection)
        {
            case "MySQL": return new MySQLMainDAO();
            default: return new MySQLMainDAO();
        }
    }

    public abstract UserDAO getUserDAO();
    public abstract StationDAO getStationDAO();
    public abstract ClientDAO getClientDAO();
    public abstract TrainForTicketDAO getTrainForTicketDAO();
    public abstract TicketDAO getTicketDAO();

}
