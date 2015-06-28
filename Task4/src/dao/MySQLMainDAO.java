package dao;

import dao.client.ClientDAO;
import dao.client.MySQLClientDAO;
import dao.station.MySQLStationDAO;
import dao.station.StationDAO;
import dao.ticket.MySQLTicketDAO;
import dao.ticket.TicketDAO;
import dao.trainforticket.MySQLTrainForTicketDAO;
import dao.trainforticket.TrainForTicketDAO;
import dao.user.MySQLUserDAO;
import dao.user.UserDAO;

import java.sql.Connection;

/**
 * Created by Anna Oliinyk
 *
 * @author Anna Oliinyk
 */
public class MySQLMainDAO extends MainDAO{

    @Override
    public StationDAO getStationDAO() {
        return new MySQLStationDAO();
    }

    @Override
    public ClientDAO getClientDAO() {
        return new MySQLClientDAO();
    }

    @Override
    public UserDAO getUserDAO() {
        return new MySQLUserDAO();
    }

    @Override
    public TrainForTicketDAO getTrainForTicketDAO() {
        return new MySQLTrainForTicketDAO();
    }

    @Override
    public TicketDAO getTicketDAO() {
        return new MySQLTicketDAO();
    }
}
