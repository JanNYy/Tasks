package model;

import java.util.List;

/**
 * Created by Anna Oliinyk
 *
 * Model for type of free seat in train
 *
 * @author Anna Oliinyk
 */
public class TypeOfFreeSeats {

    private int typeSeatID;
    private String typeSeatName;
    private int numOfFreeTypeSeats;

    private List<FreeWagon> freeWagons;

    public TypeOfFreeSeats() {

    }

    public TypeOfFreeSeats(int typeSeatID, String typeSeatName, int numOfFreeTypeSeats, List<FreeWagon> freeWagons) {
        this.typeSeatID = typeSeatID;
        this.typeSeatName = typeSeatName;
        this.numOfFreeTypeSeats = numOfFreeTypeSeats;
        this.freeWagons = freeWagons;
    }

    public int getTypeSeatID() {
        return typeSeatID;
    }

    public void setTypeSeatID(int typeSeatID) {
        this.typeSeatID = typeSeatID;
    }

    public String getTypeSeatName() {
        return typeSeatName;
    }

    public void setTypeSeatName(String typeSeatName) {
        this.typeSeatName = typeSeatName;
    }

    public int getNumOfFreeTypeSeats() {
        return numOfFreeTypeSeats;
    }

    public void setNumOfFreeTypeSeats(int numOfFreeTypeSeats) {
        this.numOfFreeTypeSeats = numOfFreeTypeSeats;
    }

    public List<FreeWagon> getFreeWagons() {
        return freeWagons;
    }

    public void setFreeWagons(List<FreeWagon> freeWagons) {
        this.freeWagons = freeWagons;
    }

}
