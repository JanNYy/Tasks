package dao.trainforticket;

import dao.AbstractModelDAO;
import dao.DBConnector;
import manager.QueriesManager;
import model.FreeWagon;
import model.TrainForTicket;
import model.TypeOfFreeSeats;

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
public class MySQLTrainForTicketDAO extends AbstractModelDAO implements TrainForTicketDAO {

    protected ResultSet resultSetInner, resultSetInner2;

    protected List<TrainForTicket> trainsForTicket;
    protected TrainForTicket trainForTicket;

    protected List<TypeOfFreeSeats> typesOfFreeSeats;
    protected TypeOfFreeSeats typeOfFreeSeats;

    protected List<FreeWagon> freeWagons;
    protected FreeWagon freeWagon;

    /**
     * Returns list of trains based on start date, start station ID and finish station ID
     * @param date is start date
     * @param startStationID is ID of start station
     * @param finishStationID is ID of finish station
     * @return list of trains based on start date, start station ID and finish station ID
     */
    @Override
    public List<TrainForTicket> getTrainsForTicket(String date, int startStationID, int finishStationID) {

        trainsForTicket = new ArrayList<TrainForTicket>();

        try {
            Connection cn = DBConnector.getConnection();
            if (cn != null)
            {
                statement = cn.prepareStatement(QueriesManager.GET_TRAINS_FOR_TICKET);
                statement.setString(1, date);
                statement.setInt(2, startStationID);
                statement.setInt(3, finishStationID);

                try
                {
                    resultSet = statement.executeQuery();

                    while (resultSet.next())
                    {
                        trainForTicket = createTrainForTicket(resultSet);

                        statement = cn.prepareStatement(QueriesManager.GET_TYPE_FREE_SEATS);
                        statement.setInt(1, trainForTicket.getRouteFragmentID());
                        statement.setInt(2, trainForTicket.getTrainID());
                        statement.setString(3, date);

                        resultSetInner = statement.executeQuery();

                        typesOfFreeSeats = new ArrayList<TypeOfFreeSeats>();

                        while (resultSetInner.next())
                        {
                            typeOfFreeSeats = createTypeOfFreeSeats(resultSetInner);

                            if ((typeOfFreeSeats != null) && (typeOfFreeSeats.getNumOfFreeTypeSeats() > 0))
                            {
                                statement = cn.prepareStatement(QueriesManager.GET_NUMBER_OF_FREE_WAGONS);
                                statement.setInt(1, trainForTicket.getRouteFragmentID());
                                statement.setInt(2, trainForTicket.getTrainID());
                                statement.setString(3, date);
                                statement.setInt(4, typeOfFreeSeats.getTypeSeatID());

                                resultSetInner2 = statement.executeQuery();

                                freeWagons = new ArrayList<FreeWagon>();

                                while (resultSetInner2.next())
                                {
                                    freeWagon = createFreeWagon(resultSetInner2);

                                    if ((freeWagon != null) && (freeWagon.getNumOfFreeSeats() > 0))
                                    {
                                        freeWagons.add(freeWagon);
                                    }
                                }

                                if (resultSetInner2 != null)
                                    resultSetInner2.close();

                                typeOfFreeSeats.setFreeWagons(freeWagons);

                                typesOfFreeSeats.add(typeOfFreeSeats);
                            }
                        }

                        if (resultSetInner != null)
                            resultSetInner.close();

                        trainForTicket.setTypeOfFreeSeats(typesOfFreeSeats);

                        trainsForTicket.add(trainForTicket);
                    }
                    return trainsForTicket;

                } catch (SQLException e)
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
     * Creates train from result set
     *
     * @param rs to create train
     * @return Created train
     */
    private TrainForTicket createTrainForTicket(ResultSet rs) {
        TrainForTicket trainForTicket = new TrainForTicket();
        try
        {
            trainForTicket.setRouteFragmentID(rs.getInt("id_route_fragment"));
            trainForTicket.setTrainID(rs.getInt("id_train_FK"));
            trainForTicket.setTrainName(rs.getString("name_train"));
            trainForTicket.setStartStationName(rs.getString("name_station_start"));
            trainForTicket.setFinishStationName(rs.getString("name_station_finish"));
            trainForTicket.setDateTimeDeparture(rs.getString("datetime_departure"));
            trainForTicket.setDateTimeArrival(rs.getString("datetime_arrival"));
            trainForTicket.setDistance(rs.getInt("distance"));
            trainForTicket.setNumOfFreeSeats(rs.getInt("num_of_free_seats"));
            return trainForTicket;
        }
        catch (SQLException e)
        {
            log.error(e.getMessage());
        }
        return null;
    }

    /**
     * Creates type of free seats from result set
     *
     * @param rs to create type of free seats
     * @return Created type of free seats
     */
    private TypeOfFreeSeats createTypeOfFreeSeats(ResultSet rs) {
        TypeOfFreeSeats type = new TypeOfFreeSeats();
        try
        {
            type.setTypeSeatID(rs.getInt("id_type_seat_FK"));
            type.setTypeSeatName(rs.getString("name_type_seat"));
            type.setNumOfFreeTypeSeats(rs.getInt("num_of_free_seats"));
            return type;
        }
        catch (SQLException e)
        {
            log.error(e.getMessage());
        }
        return null;
    }

    /**
     * Creates wagon from result set
     *
     * @param rs to create wagon
     * @return Created wagon
     */
    private FreeWagon createFreeWagon(ResultSet rs) {
        FreeWagon wagon = new FreeWagon();
        try
        {
            wagon.setNumberWagon(rs.getInt("number_wagon"));
            wagon.setNumOfFreeSeats(rs.getInt("num_of_free_seats"));
            return wagon;
        }
        catch (SQLException e)
        {
            log.error(e.getMessage());
        }
        return null;
    }

}
