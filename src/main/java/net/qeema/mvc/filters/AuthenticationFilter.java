package net.qeema.mvc.filters;

import jakarta.servlet.*;

import java.io.IOException;

public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        /*HttpSession session = ((HttpServletRequest)servletRequest).getSession();
        Boolean loggedIn = (Boolean) session.getAttribute("logged-in");
        if (loggedIn != null && loggedIn)
            filterChain.doFilter(servletRequest , servletResponse);
        else {
            servletRequest.getRequestDispatcher("/login-user.jsp").forward(servletRequest, servletResponse);
        }*/
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
