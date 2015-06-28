package command;

import dao.MainDAO;
import dao.trainforticket.TrainForTicketDAO;
import manager.ConfigurationManager;
import model.TrainForTicket;

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
public class GetTrainsForTicketCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        MainDAO dao = MainDAO.getMainDAO(ConfigurationManager.CONNECTION);
        TrainForTicketDAO trainForTicketDAO = dao.getTrainForTicketDAO();

        String date = request.getParameter("date");
        int stationStart = Integer.parseInt(request.getParameter("station_start"));
        int stationFinish = Integer.parseInt(request.getParameter("station_finish"));

        if ( (date == null) || (date.equals("")) )
        {
            request.setAttribute("error_empty_message", "error");
            return ConfigurationManager.BUY_TICKET_PAGE_PATH;
        }

        List<TrainForTicket> trainsForTicket = trainForTicketDAO.getTrainsForTicket(date, stationStart, stationFinish);
        if (trainsForTicket == null) return ConfigurationManager.ERROR_PAGE_PATH;
        if (!trainsForTicket.isEmpty())
        {
            request.setAttribute("trainsForTicket", trainsForTicket);
            return ConfigurationManager.TRAINS_FOR_TICKET_PAGE_PATH;
        }
        return ConfigurationManager.NO_RESULTS_PAGE_PATH;

    }

}
