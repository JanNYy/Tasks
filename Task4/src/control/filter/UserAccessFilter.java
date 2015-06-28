package control.filter;

import control.RequestHelper;
import dao.MainDAO;
import manager.ConfigurationManager;
import model.Client;
import model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Anna Oliinyk
 *
 * @author Anna Oliinyk
 */
public class UserAccessFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        if (request.getParameter("command") != null)
        {
            HttpSession session = request.getSession();
            User user = (User)session.getAttribute("user");
            RequestDispatcher dispatcher;
            if (user == null)
            {
                if (!RequestHelper.UnknownPersonCommandList.contains(request.getParameter("command")))
                {
                    dispatcher = request.getRequestDispatcher(ConfigurationManager.LOGIN_PAGE_PATH);
                    dispatcher.forward(servletRequest, servletResponse);
                }
            }
            else
            {
                if (user.getRole() == User.Role.CLIENT)
                {
                    if (!RequestHelper.ClientCommandList.contains(request.getParameter("command")))
                    {
                        Client client = (Client)session.getAttribute("client");
                        if (client != null)
                            dispatcher = request.getRequestDispatcher(ConfigurationManager.CLIENT_MAIN_PAGE_PATH);
                        else
                            dispatcher = request.getRequestDispatcher(ConfigurationManager.CLIENT_NEW_PAGE_PATH);
                        dispatcher.forward(servletRequest, servletResponse);
                    }
                }
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }

}
