package model;

import java.util.List;

/**
 * Created by Anna Oliinyk
 *
 * Model for train
 *
 * @author Anna Oliinyk
 */
public class TrainForTicket {

    private int routeFragmentID;
    private int trainID;
    private String trainName;

    private String startStationName;
    private String finishStationName;

    private String dateTimeDeparture; // Время и дата отправления
    private String dateTimeArrival; // Время и дата прибытия

    private int distance;

    private int numOfFreeSeats;

    private List<TypeOfFreeSeats> typeOfFreeSeats;

    public TrainForTicket() {

    }

    public TrainForTicket(int routeFragmentID, int trainID, String trainName, String startStationName,
                          String finishStationName, String dateTimeDeparture, String dateTimeArrival,
                          int distance, int numOfFreeSeats, List<TypeOfFreeSeats> typeOfFreeSeats) {
        this.routeFragmentID = routeFragmentID;
        this.trainID = trainID;
        this.trainName = trainName;
        this.startStationName = startStationName;
        this.finishStationName = finishStationName;
        this.dateTimeDeparture = dateTimeDeparture;
        this.dateTimeArrival = dateTimeArrival;
        this.distance = distance;
        this.numOfFreeSeats = numOfFreeSeats;
        this.typeOfFreeSeats = typeOfFreeSeats;
    }

    public int getRouteFragmentID() {
        return routeFragmentID;
    }

    public void setRouteFragmentID(int routeFragmentID) {
        this.routeFragmentID = routeFragmentID;
    }

    public int getTrainID() {
        return trainID;
    }

    public void setTrainID(int trainID) {
        this.trainID = trainID;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getStartStationName() {
        return startStationName;
    }

    public void setStartStationName(String startStationName) {
        this.startStationName = startStationName;
    }

    public String getFinishStationName() {
        return finishStationName;
    }

    public void setFinishStationName(String finishStationName) {
        this.finishStationName = finishStationName;
    }

    public String getDateTimeDeparture() {
        return dateTimeDeparture;
    }

    public void setDateTimeDeparture(String dateTimeDeparture) {
        this.dateTimeDeparture = dateTimeDeparture;
    }

    public String getDateTimeArrival() {
        return dateTimeArrival;
    }

    public void setDateTimeArrival(String dateTimeArrival) {
        this.dateTimeArrival = dateTimeArrival;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getNumOfFreeSeats() {
        return numOfFreeSeats;
    }

    public void setNumOfFreeSeats(int numOfFreeSeats) {
        this.numOfFreeSeats = numOfFreeSeats;
    }

    public List<TypeOfFreeSeats> getTypeOfFreeSeats() {
        return typeOfFreeSeats;
    }

    public void setTypeOfFreeSeats(List<TypeOfFreeSeats> typeOfFreeSeats) {
        this.typeOfFreeSeats = typeOfFreeSeats;
    }
}
