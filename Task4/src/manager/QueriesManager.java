package manager;

import java.util.ResourceBundle;

/**
 * Created by Anna Oliinyk
 *
 * @author Anna Oliinyk
 */
public class QueriesManager {

    //private static QueriesManager instance;

    private static final String BUNDLE_NAME = "resources.queries";

    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);

    public static final String GET_ALL_USERS = getProperty("get_all_users");
    public static final String GET_USER_LOGIN_PASSWORD = getProperty("get_user_login_password");
    public static final String GET_USER_LOGIN = getProperty("get_user_login");

    public static final String GET_USER_CLIENT = getProperty("get_user_client");

    public static final String INSERT_USER = getProperty("insert_user");

    public static final String INSERT_CLIENT = getProperty("insert_client");

    public static final String GET_ALL_STATIONS = getProperty("get_all_stations");

    public static final String GET_TRAINS_FOR_TICKET = getProperty("get_trains_for_ticket");
    public static final String GET_TYPE_FREE_SEATS = getProperty("get_type_free_seats");
    public static final String GET_NUMBER_OF_FREE_WAGONS = getProperty("get_number_of_free_wagons");

    public static final String INSERT_TICKET = getProperty("insert_ticket");
    public static final String FIND_SEAT_NUM = getProperty("find_seat_number");

    public static final String GET_CLIENT_PURCHASE_HISTORY = getProperty("get_client_purchase_history");

    public static final String GET_TICKETS_UNCONFIRMED = getProperty("get_tickets_unconfirmed_status");

    public static final String SET_TICKET_STATUS = getProperty("set_ticket_status");

    /*private QueriesManager() {

    }*/

    /*public static QueriesManager getInstance() {
        if (instance == null)
        {
            instance = new QueriesManager();
            instance.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
        }
        return instance;
    }*/

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }

}
