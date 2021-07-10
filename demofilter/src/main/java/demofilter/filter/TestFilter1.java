package demofilter.filter;

import demofilter.model.User;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class TestFilter1
 */
//@WebFilter("/TestFilter1")
public class TestFilter1 implements Filter {
    private FilterConfig filterConfig = null;

    /**
     * Default constructor.
     */
    public TestFilter1() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        filterConfig = null;
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // TODO Auto-generated method stub
        // place your code here
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        httpRequest.setCharacterEncoding("utf-8");
        ServletContext sc = filterConfig.getServletContext();
        String filterName = filterConfig.getFilterName();
        String servletPath = "Servlet path: " + httpRequest.getServletPath();
        System.out.println(filterName + "|" + servletPath + " | before request");

        HttpSession session = httpRequest.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            System.out.println("Session variable: " + user.getFirstName());
            if (user.getRoles().contains(servletPath)) {
                resp.sendRedirect("invalidRole.jsp");
            }
            chain.doFilter(request, response);

        } else {
                if (!servletPath.contains("register.jsp")) {
                resp.sendRedirect("register.jsp");
            }
        }
      //  chain.doFilter(request,response);
        // pass the request along the filter chain
        //Thao tác ở trước lệnh dưới => trước request
        chain.doFilter(request, response);
        //Thao tác ở sau lệnh trên => sau request
        System.out.println(filterName + "|" + servletPath + " | after request");
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        filterConfig = fConfig;
    }

}
