package dao.station;

import dao.AbstractModelDAO;
import dao.DBConnector;
import manager.QueriesManager;
import model.Station;

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
public class MySQLStationDAO extends AbstractModelDAO implements StationDAO{

    protected List<Station> stations;
    protected Station station;

    /**
     * Returns list of all stations from DB
     * @return list of all stations from DB
     */
    @Override
    public List<Station> getAllStations() {

        stations = new ArrayList<Station>();

        try {

            Connection cn = DBConnector.getConnection();
            if (cn != null)
            {
                statement = cn.prepareStatement(QueriesManager.GET_ALL_STATIONS);
                try
                {
                    resultSet = statement.executeQuery();

                    while (resultSet.next())
                    {
                        station = createStation(resultSet);
                        stations.add(station);
                    }
                    return stations;

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
     * Creates station from result set
     *
     * @param rs to create station
     * @return Created station
     */
    private Station createStation(ResultSet rs) {
        Station station = new Station();
        try
        {
            station.setStationID(rs.getInt("id_station"));
            station.setName(rs.getString("name_station"));
            return station;
        }
        catch (SQLException e)
        {
            log.error(e.getMessage());
        }
        return null;
    }

}
