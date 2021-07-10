package main.java.controller;

import main.java.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/emailList")
public class EmailList extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public EmailList() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = "/index.jsp";
        String action = request.getParameter("action");
        if (action == null)
            action = "join";
        if (action.equals("join")) {
            url = "/index.jsp";
        } else if (action.equals("add")) {
            String firstName = request.getParameter("ipLastName");
            String lastName = request.getParameter("ipFirstName");
            String email = request.getParameter("ipEmail");
            String msg ;
            User user = new User(firstName, lastName, email);

            if (firstName == null || lastName == null || email == null
                    || firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()) {
                msg = "Please fill the form";
                url = "/index.jsp";
            } else {
                msg = "Sucessfully";
                url = "/Thanks.jsp";
                // ghi vào cơ sở dữ liệu btvn
            }
            request.setAttribute("user", user);
            request.setAttribute("message", msg);
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
}
