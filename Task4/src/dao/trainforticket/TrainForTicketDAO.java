package dao.trainforticket;

import model.TrainForTicket;

import java.util.List;

/**
 * Created by Anna Oliinyk
 *
 * @author Anna Oliinyk
 */
public interface TrainForTicketDAO {

    List<TrainForTicket> getTrainsForTicket(String date, int startStationID, int finishStationID);

}
