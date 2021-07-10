package controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

@WebFilter("/TestFilter1")
public class TestFilter1 implements Filter {
    private FilterConfig filterConfig = null;

    public TestFilter1() {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        ServletContext sc = filterConfig.getServletContext();
        String filterNameString = filterConfig.getFilterName();

        String servletPathString = "Servlet path: " + httpServletRequest.getRequestURI();
        System.out.println(filterNameString + " | " + servletPathString + " | before request");

        System.out.println(filterNameString + " | " + servletPathString + " | after request");

        System.out.println("getEncoding : " + httpServletRequest.getCharacterEncoding() + " | before request");
        if (httpServletRequest.getCharacterEncoding() != "utf-8") {
            httpServletRequest.setCharacterEncoding("utf-8");
            System.out.println("getEncoding : " + httpServletRequest.getCharacterEncoding() + " | after request");
        }
        filterChain.doFilter(servletRequest, servletResponse);

    }

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    public void destroy() {
        filterConfig = null;
    }
}
