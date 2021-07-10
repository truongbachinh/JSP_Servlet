package controller;

import model.User;
import model.UserInfor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/surveyList")
public class SurveyList extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public SurveyList() {
        super();
    }
    private String encoding = "utf-8";

    @Override
    public void init()
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    {

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding(encoding);
        String url = "/FormSurvey.jsp";
        String action = request.getParameter("action");
        if (action.equals("join")) {
            url = "/FormSurvey.jsp";
        } else if (action.equals("add")) {
            String firstName = request.getParameter("ipFirstName");
            String lastName = request.getParameter("ipLastName");
            String email = request.getParameter("ipEmail");
            String kind_email = request.getParameter("selectEmail");
            String checkHead = request.getParameter("rdCheck");
            String cbReceive = request.getParameter("cbReceive");
            String msg ;
            UserInfor user = new UserInfor(firstName, lastName, email,checkHead,cbReceive,kind_email);
            if (firstName == null || lastName == null || email == null || checkHead == null || cbReceive == null || kind_email == null
                    || firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || checkHead.isEmpty() || cbReceive.isEmpty() || kind_email.isEmpty()) {
                msg = "Please fill the form";
                url = "/FormSurvey.jsp";
            } else {
                msg = "Sucessfully";
                url = "/ThankSurvey.jsp";
                // ghi vào cơ sở dữ liệu btvn
            }
            request.setAttribute("user", user);
            request.setAttribute("message", msg);
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);

    }
}
