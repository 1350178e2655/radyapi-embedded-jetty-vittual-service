package me.chrisanabo.jetty.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class MessageEncryptionFilter implements javax.servlet.Filter {

    // include encryption
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {

        if (req instanceof HttpServletRequest) {
            HttpServletRequest request = (HttpServletRequest) req;


        }

        filterChain.doFilter(req, resp);

    }

    public void destroy() {

    }
}
