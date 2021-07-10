package main.java.controller;

import main.java.datalayer.UserDB;
import main.java.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns =  "/userAdmin")
public class UsersServlet extends HttpServlet {
    public UsersServlet()
    {

    }
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String url = "/index.jsp";

        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "display_users";  // default action
        }

        // perform action and set URL to appropriate page
        if (action.equals("display_users")) {
            // get list of users
            ArrayList<User> users = UserDB.selectUsers();

            // set as a request attribute
            // forward to index.jsp
        }
        else if (action.equals("display_user")) {
            // get user for specified email
            // set as session attribute
            // forward to user.jsp
            ArrayList<User> users = UserDB.selectUsers();
            request.setAttribute("users",users);
        }
        else if (action.equals("update_user")) {
            // update user in database
            // get current user list and set as request attribute
            // forward to index.jsp
        }
        else if (action.equals("delete_user")) {
            // get the user for the specified email
            // delete the user
            // get current list of users
            // set as request attribute
            // forward to index.jsp
        }

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}
