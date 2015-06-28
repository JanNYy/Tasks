package dao.station;

import dao.DBConnectionPool;
import model.Station;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Anna Oliinyk
 *
 * @author Anna Oliinyk
 */
public interface StationDAO {

    public abstract List<Station> getAllStations();

}
