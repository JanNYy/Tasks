package model;

/**
 * Created by Anna Oliinyk
 *
 * Model for combined information about ticket
 *
 * @author Anna Oliinyk
 */
public class Ticket {

    private int ticketID;

    private String nameClient;
    private String surnameClient;
    private String patronymicClient;
    private String telephoneClient;

    private String dateTimeBegin;
    private String dateTimeEnd;

    private String nameTrain;

    private int numberWagon;
    private String nameTypeSeat;
    private int numberSeat;

    private String nameStationStart;
    private String nameStationFinish;

    private int distance;

    private double price;

    private int status;

    public Ticket() {

    }

    public Ticket(int ticketID, String nameClient, String surnameClient, String patronymicClient,
                  String telephoneClient, String dateTimeBegin, String dateTimeEnd, String nameTrain,
                  int numberWagon, String nameTypeSeat, int numberSeat, String nameStationStart,
                  String nameStationFinish, int distance, double price, int status) {
        this.ticketID = ticketID;
        this.nameClient = nameClient;
        this.surnameClient = surnameClient;
        this.patronymicClient = patronymicClient;
        this.telephoneClient = telephoneClient;
        this.dateTimeBegin = dateTimeBegin;
        this.dateTimeEnd = dateTimeEnd;
        this.nameTrain = nameTrain;
        this.numberWagon = numberWagon;
        this.nameTypeSeat = nameTypeSeat;
        this.numberSeat = numberSeat;
        this.nameStationStart = nameStationStart;
        this.nameStationFinish = nameStationFinish;
        this.distance = distance;
        this.price = price;
        this.status = status;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getSurnameClient() {
        return surnameClient;
    }

    public void setSurnameClient(String surnameClient) {
        this.surnameClient = surnameClient;
    }

    public String getPatronymicClient() {
        return patronymicClient;
    }

    public void setPatronymicClient(String patronymicClient) {
        this.patronymicClient = patronymicClient;
    }

    public String getTelephoneClient() {
        return telephoneClient;
    }

    public void setTelephoneClient(String telephoneClient) {
        this.telephoneClient = telephoneClient;
    }

    public String getDateTimeBegin() {
        return dateTimeBegin;
    }

    public void setDateTimeBegin(String dateTimeBegin) {
        this.dateTimeBegin = dateTimeBegin;
    }

    public String getDateTimeEnd() {
        return dateTimeEnd;
    }

    public void setDateTimeEnd(String dateTimeEnd) {
        this.dateTimeEnd = dateTimeEnd;
    }

    public String getNameTrain() {
        return nameTrain;
    }

    public void setNameTrain(String nameTrain) {
        this.nameTrain = nameTrain;
    }

    public int getNumberWagon() {
        return numberWagon;
    }

    public void setNumberWagon(int numberWagon) {
        this.numberWagon = numberWagon;
    }

    public String getNameTypeSeat() {
        return nameTypeSeat;
    }

    public void setNameTypeSeat(String nameTypeSeat) {
        this.nameTypeSeat = nameTypeSeat;
    }

    public int getNumberSeat() {
        return numberSeat;
    }

    public void setNumberSeat(int numberSeat) {
        this.numberSeat = numberSeat;
    }

    public String getNameStationStart() {
        return nameStationStart;
    }

    public void setNameStationStart(String nameStationStart) {
        this.nameStationStart = nameStationStart;
    }

    public String getNameStationFinish() {
        return nameStationFinish;
    }

    public void setNameStationFinish(String nameStationFinish) {
        this.nameStationFinish = nameStationFinish;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
