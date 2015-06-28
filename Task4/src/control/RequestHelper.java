package control;

import javax.servlet.http.HttpServletRequest;

import command.*;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * Created by Anna Oliinyk
 *
 * @author Anna Oliinyk
 */
public class RequestHelper {

    private static RequestHelper instance = null;

    public static final TreeSet<String> UnknownPersonCommandList = new TreeSet<String>();
    public static final TreeSet<String> ClientCommandList = new TreeSet<String>();

    static
    {
        UnknownPersonCommandList.add("login");
        UnknownPersonCommandList.add("registration");
        UnknownPersonCommandList.add("accept_registration");

        ClientCommandList.add("add_client_info");
        ClientCommandList.add("main_page");
        ClientCommandList.add("buy_ticket");
        ClientCommandList.add("get_trains_for_ticket");
        ClientCommandList.add("accept_buy_data");
        ClientCommandList.add("view_history");
        ClientCommandList.add("logout");
    }

    HashMap<String, Command> commands = new HashMap<String, Command>();

    private RequestHelper() {
        commands.put("login", new LoginCommand());
        commands.put("registration", new RegistrationCommand());
        commands.put("accept_registration", new AcceptRegistrationCommand());
        commands.put("add_client_info", new AddClientCommand());

        commands.put("main_page" , new MainPageCommand());

        //client page
        commands.put("buy_ticket", new BuyTicketCommand());
        commands.put("get_trains_for_ticket", new GetTrainsForTicketCommand());
        commands.put("accept_buy_data", new AcceptBuyDataCommand());

        commands.put("view_history", new ViewHistoryCommand());

        //admin page
        commands.put("tickets_unconfirmed", new TicketsUnconfirmedCommand());
        commands.put("set_ticket_status", new SetTicketStatusCommand());

        commands.put("logout", new LogoutCommand());
    }

    public static RequestHelper getInstance() {
        if (instance == null) {
            instance = new RequestHelper();
        }
        return instance;
    }

    /**
     * Returns Command object from map of commands
     * @param request defines what command will be chosen
     * @return Command object
     */
    public Command getCommand(HttpServletRequest request) {
        Command command = commands.get(request.getParameter("command"));
        if (command == null)
        {
            command = new NoCommand();
        }
        return command;
    }



}
