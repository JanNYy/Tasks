package control.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Anna Oliinyk
 *
 * @author Anna Oliinyk
 */
public class LanguageFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        request.getSession().setAttribute("language", request.getParameter("language"));
        ((HttpServletResponse) servletResponse).sendRedirect(request.getHeader("referer"));
    }


    @Override
    public void destroy() {

    }
}
