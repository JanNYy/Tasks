package command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Anna Oliinyk
 *
 * Returns String that points to page with results of executing
 *
 * @author Anna Oliinyk
 */
public interface Command {

    String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
