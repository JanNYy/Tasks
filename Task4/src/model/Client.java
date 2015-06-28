package model;

/**
 * Created by Anna Oliinyk
 *
 * Model for table client in DB
 *
 * @author Anna Oliinyk
 */
public class Client {

    private int clientID;
    private String surname;
    private String name;
    private String patronymic;
    private String telephone;
    private int userID;

    public Client() {

    }

    public Client(int clientID, String surname, String name, String patronymic, String telephone, int userID) {
        this.clientID = clientID;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.telephone = telephone;
        this.userID = userID;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;

        Client client = (Client) o;

        return clientID == client.clientID;

    }

    @Override
    public int hashCode() {
        return clientID;
    }

}
