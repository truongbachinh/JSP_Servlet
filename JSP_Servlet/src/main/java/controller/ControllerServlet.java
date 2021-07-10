package controller;

import dao.BookDAO;
import model.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BookDAO bookDAO; // thiết lập relationship

    @Override
    public void init() {
        String urlDB = getServletContext().getInitParameter("jdbc:mysql://localhost:3306/bookstore");
        String username = getServletContext().getInitParameter("root");
        String password = getServletContext().getInitParameter("123456");
        bookDAO = new BookDAO(urlDB, username, password);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertNew(request,response);
                    break;
                default:
                    listBook(request,response);
                    break;

            }
        }
        catch (SQLException ex)
        {
            throw new ServletException(ex);
        }

    }
    private void listBook(HttpServletRequest request, HttpServletResponse reponse) throws SQLException,ServletException, IOException
    {
        List<Book> list = bookDAO.selectDB();
        request.setAttribute("listBook",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("BookList.jsp");
        dispatcher.forward(request,reponse);
    }
    private void insertNew(HttpServletRequest request, HttpServletResponse response) throws SQLException,IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        float price  = Float.parseFloat(request.getParameter("price"));

        Book newBook = new Book(title,author,price);
        bookDAO.insertDB(newBook);
        response.sendRedirect("list");
    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("BookForm.jsp");
        dispatcher.forward(request, reponse);
    }
}
