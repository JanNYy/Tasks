package manager;

import java.util.ResourceBundle;

/**
 * Created by Anna Oliinyk
 *
 * @author Anna Oliinyk
 */
public class ConfigurationManager {

    private static final String BUNDLE_NAME = "resources.config";

    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);

    public static final String CONNECTION = getProperty("connection");

    public static final String DATABASE_DRIVER_NAME = getProperty("database_driver_name");
    public static final String DATABASE_URL = getProperty("database_url");
    public static final String DATABASE_USER = getProperty("database_user");
    public static final String DATABASE_PASSWORD = getProperty("database_password");

    public static final String ERROR_PAGE_PATH = getProperty("error_page_path");
    public static final String LOGIN_PAGE_PATH = getProperty("login_page_path");
    public static final String REGISTRATION_PAGE_PATH = getProperty("registration_page_path");

    public static final String CLIENT_NEW_PAGE_PATH = getProperty("client_new_page_path");

    public static final String CLIENT_MAIN_PAGE_PATH = getProperty("client_main_page_path");

    public static final String BUY_TICKET_PAGE_PATH = getProperty("buy_ticket_page_path");

    public static final String TRAINS_FOR_TICKET_PAGE_PATH = getProperty("trains_for_ticket_page_path");

    public static final String CLIENT_HISTORY_PAGE_PATH = getProperty("client_history_page_path");

    public static final String NO_RESULTS_PAGE_PATH = getProperty("no_results_page_path");

    public static final String ADMIN_MAIN_PAGE_PATH = getProperty("admin_main_page_path");

    public static final String TICKETS_UNCONFIRMED_PAGE_PATH = getProperty("tickets_unconfirmed_page_path");

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }

}
