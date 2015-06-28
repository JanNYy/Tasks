package command;

import dao.MainDAO;
import dao.station.StationDAO;
import manager.ConfigurationManager;
import model.Station;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Anna Oliinyk
 *
 * @author Anna Oliinyk
 */
public class BuyTicketCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MainDAO dao = MainDAO.getMainDAO(ConfigurationManager.CONNECTION);
        StationDAO stationDAO = dao.getStationDAO();
        List<Station> stations = stationDAO.getAllStations();
        if (stations == null) return ConfigurationManager.ERROR_PAGE_PATH;
        if (!stations.isEmpty())
        {
            request.setAttribute("stations",stations);
            return ConfigurationManager.BUY_TICKET_PAGE_PATH;
        }
        return ConfigurationManager.NO_RESULTS_PAGE_PATH;
    }

}
