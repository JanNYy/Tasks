package control;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import java.io.IOException;

import manager.ConfigurationManager;

import static logger.RailwaySystemLogger.log;

/**
 * Created by Anna Oliinyk
 *
 * Main controller
 *
 * @author Anna Oliinyk
 */
public class FrontController extends HttpServlet {

    RequestHelper requestHelper = RequestHelper.getInstance();

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        try
        {
            Command command = requestHelper.getCommand(request);
            dispatcher = request.getRequestDispatcher(command.execute(request, response));
        }
        catch (ServletException | IOException e )
        {
            log.error(e.getMessage());
            dispatcher = request.getRequestDispatcher(ConfigurationManager.ERROR_PAGE_PATH);
        }
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

}
