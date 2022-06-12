package filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;


@WebFilter(filterName = "UUIDFilter", urlPatterns = {"/*"})
public class UUIDFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        UUID uuid = UUID.randomUUID();
        Cookie cookie = new Cookie("UUID", uuid.toString());
        cookie.setMaxAge(60);
        res.addCookie(cookie);
        java.util.logging.Logger logger =  java.util.logging.Logger.getLogger(this.getClass().getName());
        logger.warning("We are in the filter"+uuid.toString());

        chain.doFilter(request, response);
    }
}
