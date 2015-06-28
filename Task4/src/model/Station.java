package model;

/**
 * Created by Anna Oliinyk
 *
 * Model for table station in DB
 *
 * @author Anna Oliinyk
 */
public class Station {

    private int stationID;
    private String name;

    public Station() {

    }

    public Station(int stationID, String name) {
        this.stationID = stationID;
        this.name = name;
    }

    public int getStationID() {
        return stationID;
    }

    public void setStationID(int stationID) {
        this.stationID = stationID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
