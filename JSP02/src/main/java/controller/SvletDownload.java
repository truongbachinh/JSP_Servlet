package controller;

import datalayer.RoleMySQL;
import datalayer.UserIO;
import datalayer.UserRoleMySQL;
import datalayer.UsermySQLDB;
import model.DBConfig;
import model.Role;
import model.User;
import model.UserRole;
import util.CookieUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/download")
public class SvletDownload extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        DBConfig dbConfig = (DBConfig) sc.getAttribute("config");

        String action = req.getParameter("action");
        req.setCharacterEncoding("utf-8");
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
        ServletContext sc = getServletContext();
        DBConfig dbConfig = (DBConfig) sc.getAttribute("config");
        req.setCharacterEncoding("utf-8");
        String action = req.getParameter("action");
        String url = "";
        if (action.equals("registerUser"))
            url = registerUser(req, resp);
        else if (action.equals("updateUser")) {
            url = updateUser(req, resp);
        } else if (action.equals("delete")) {
            int id = Integer.parseInt(req.getParameter("id"));
            boolean a = UsermySQLDB.deleteUserById(id, dbConfig);
            url = "/Thank.jsp";
            String msg;
            if (a == true) {
                msg = "Delete sucesss. please reload page to update new list user";
                req.setAttribute("message", msg);
            } else {
                msg = "Delete error";
                req.setAttribute("message", msg);
            }

        } else if (action.equals("addRole")) {
            url = addRole(req, resp);
        } else if (action.equals("submitRole")) {
            url = updateRole(req, resp);
        } else if (action.equals("addUserRole")) {
            url = addUserRole(req, resp);
        }
        else if(action.equals("login"))
        {
            url = loginUser(req,resp);
        }
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
    private String loginUser(HttpServletRequest request, HttpServletResponse response)
    {
        String email =   request.getParameter("email");
        User user = UserRoleMySQL.loginUser(email);
        String url  = "";
        List<String> emails = new ArrayList<String>();
        emails    =  UserRoleMySQL.emailList();
        if(user.getEmail().equals("chinhtbgch17527@fpt.edu.vn"))
        {
            url = "/viewAdmin.jsp";
        }
        else if(emails.contains(user.getEmail()) && !(user.getEmail().equals("chinhtbgch17527@fpt.edu.vn")))
        {
            url = "/viewalbum.jsp";
        }
        else {
            url = "/invalidPage.jsp";
        }

        return url;
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

    private String addUserRole(HttpServletRequest request, HttpServletResponse response) {

        int idUser = Integer.parseInt(request.getParameter("userName"));
        int idRole = Integer.parseInt(request.getParameter("roleName"));
        String message =  request.getParameter("message");
        UserRole userRole =  new UserRole();
        userRole.setUserId(idUser);
        userRole.setRoleId(idRole);
      boolean a = UserRoleMySQL.addUserRole(userRole);
        String url = "";
      if(a == true)
      {
          url = "/viewalbum.jsp";
      }
      else
      {
          request.setAttribute("Error r! ",message);
      }
        return url;
    }

    private String addRole(HttpServletRequest request, HttpServletResponse response) {
        ServletContext sc = getServletContext();
        DBConfig dbConfig = (DBConfig) sc.getAttribute("config");
        String roleName = request.getParameter("roleName");
        String roleDes = request.getParameter("roleDes");
        Role role = new Role();
        role.setRoleName(roleName);
        role.setRoleDes(roleDes);
        boolean a = RoleMySQL.add(role);
        HttpSession session = request.getSession();
        session.setAttribute("role", role);
        String url = "";
        String message = "Error r bạn ơi";
        if (a == true) {
            url = "/ThanksRole.jsp";
        } else
            request.setAttribute(message, message);

        return url;
    }

    private String registerUser(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        ServletContext sc = getServletContext();
        DBConfig dbConfig = (DBConfig) sc.getAttribute("config");

        // request.setCharacterEncoding("utf-8");
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        User user = new User();
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);

        String path = sc.getRealPath("/WEB-INF/EmailList.txt");
        UserIO.add(user, path);
        UsermySQLDB.add(user, dbConfig);

        String url;
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        Cookie cookie = new Cookie("emailCookie", email);
        cookie.setMaxAge(60 * 60 * 24 * 30 * 2);
        cookie.setPath("/");
        response.addCookie(cookie);
        String productCodeString = (String) session.getAttribute("productCode");


        if (productCodeString == null || productCodeString.isEmpty()) {

            url = "/Thanks.jsp";
        } else {
            url = "/" + productCodeString + "_download.jsp";
        }

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

    private String updateUser(HttpServletRequest req, HttpServletResponse res) throws UnsupportedEncodingException {
        ServletContext sc = getServletContext();
        DBConfig dbConfig = (DBConfig) sc.getAttribute("config");
        req.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(req.getParameter("userID"));
        String email = req.getParameter("email");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        User userUpdate = new User();
        userUpdate.setEmail(email);
        userUpdate.setFirstName(firstName);
        userUpdate.setLastName(lastName);
        userUpdate.setUserId(id);

        boolean a = UsermySQLDB.upDateUser(userUpdate, dbConfig);
        if (a == true)
            req.setAttribute("user", userUpdate);
        String url = "/Thanks.jsp";
        return url;

    }

    private String updateRole(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("roleId"));
        String roleName = request.getParameter("roleName");
        String roleDes = request.getParameter("roleDes");
        String msg = request.getParameter("message");
        Role role = new Role();
        role.setRoleId(id);
        role.setRoleName(roleName);
        role.setRoleDes(roleDes);
        boolean a = RoleMySQL.updateRole(role);
        String url = "";
        if (a == true) {
            url = "/download?action=listRoles";
        } else {
            request.setAttribute(msg, "error");
        }

        return url;
    }


    private String deleteUser(HttpServletRequest req, HttpServletResponse res) throws UnsupportedEncodingException {
        String url = "/Thanks.jsp";
        ServletContext sc = getServletContext();
        DBConfig dbConfig = (DBConfig) sc.getAttribute("config");
        req.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(req.getParameter("userID"));
        String email = req.getParameter("email");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        User userUpdate = new User();
        userUpdate.setEmail(email);
        userUpdate.setFirstName(firstName);
        userUpdate.setLastName(lastName);
        userUpdate.setUserId(id);

        UsermySQLDB.upDateUser(userUpdate, dbConfig);
        req.setAttribute("user", userUpdate);
        return url;

    }
}
