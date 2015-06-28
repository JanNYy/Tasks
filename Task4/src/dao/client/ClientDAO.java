package dao.client;

import model.Client;

/**
 * Created by Anna Oliinyk
 *
 * @author Anna Oliinyk
 */
public interface ClientDAO {

    Client getUserClient(int id);

    boolean addClient(Client client);

}
