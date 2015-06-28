package model;

/**
 * Created by Anna Oliinyk
 *
 * Model for wagon with free seats
 *
 * @author Anna Oliinyk
 */
public class FreeWagon {

    private int numberWagon;
    private int numOfFreeSeats;

    public FreeWagon() {

    }

    public FreeWagon(int numberWagon, int numOfFreeSeats) {
        this.numberWagon = numberWagon;
        this.numOfFreeSeats = numOfFreeSeats;
    }

    public int getNumberWagon() {
        return numberWagon;
    }

    public void setNumberWagon(int numberWagon) {
        this.numberWagon = numberWagon;
    }

    public int getNumOfFreeSeats() {
        return numOfFreeSeats;
    }

    public void setNumOfFreeSeats(int numOfFreeSeats) {
        this.numOfFreeSeats = numOfFreeSeats;
    }

}
