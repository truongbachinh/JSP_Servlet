package main.java.controller;

import main.java.datalayer.UserIO;
import main.java.model.User;
import main.java.util.CookieUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/download")
public class SvletDownload extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String url = "/viewalbum.jsp";
        if (action.equals("viewAlbums"))
            url = "/viewalbum.jsp";
        else if (action.equals("checkUser"))
            url = checkUser(req, resp);
        else if (action.equals("viewCookies"))
            url = "/view_cookies.jsp";
        else if (action.equals("deleteCookies"))
            url = deleteCookies(req, resp);
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String url = "/viewalbum.jsp";
        if (action.equals("registerUser"))
            url = registerUser(req, resp);
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
        // 1 session tồn tại trong 2 tiếng
        // 1 cookies có thể tồn tại rất lâu tùy thuộc vào cấu hình thời gian sống của nó bên backend
    // cookies được lưu trên máy tính.
    // các trang web thường yêu cầu người dùng lưu cookies gồm 3 tham số : (giá trị truyền , thời gian sống, path sử dụng )
    // xóa về bản chất là set thời gian sống cửa cookies về 0 => thời gian sống = 0 => dead
    private String checkUser(HttpServletRequest request, HttpServletResponse response) {
        String productCode = request.getParameter("productCode");
        HttpSession session = request.getSession();
        session.setAttribute("productCode", productCode);
        User user = (User) session.getAttribute("user");
        String url;
        if (user == null) {
            Cookie[] cookies = request.getCookies();
            String emailAddress = CookieUtil.getCookieValue(cookies, "emailCokie");
            if (emailAddress == "" || emailAddress.isEmpty()) {
                url = "/Register.jsp";
            } else {
                ServletContext sc = getServletContext();
                String path = sc.getRealPath("/WEB-INF/EmailList.txt");
                user = UserIO.getUser(emailAddress, path);
                session.setAttribute("user", user);
                url = "/" + productCode + "_download.jsp";
            }

        } else {
            url = "/" + productCode + "_download.jsp";
        }
        return url;
    }

    private String registerUser(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        User user = new User();
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        ServletContext sc = getServletContext();
        String path = sc.getRealPath("/WEB-INF/EmailList.txt");
        UserIO.add(user, path);

        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        Cookie cookie = new Cookie("emailCookie", email);
        cookie.setMaxAge(60 * 60 * 24 * 30 * 2);
        cookie.setPath("/");
        response.addCookie(cookie);
        String productCodeString = (String) session.getAttribute("productCode");
        String url = "/" + productCodeString + "_download.jsp";
        return url;
    }

    private String deleteCookies(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);
        }
        String url = "/delete_cookies.jsp";
        return url;
    }
}
