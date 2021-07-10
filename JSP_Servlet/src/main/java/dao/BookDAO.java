package dao;

import connect.ConnectBD;
import model.Book;

import javax.sql.RowSet;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


public class BookDAO {
    private String dbName = "jdbc:mysql://localhost:3306/bookstore";
    private String dbUsername = "root";
    private String dbPassword = "123456";
    private Connection conn;

    public BookDAO() {

    }

    public BookDAO(String dbName, String dbUsername, String dbPassword) {
        this.dbName = dbName;
        this.dbUsername = dbUsername;
        this.dbPassword = dbPassword;
        try {
            connect();
        }
        catch (SQLException e)
        {
            e.getMessage();
        }
    }

    protected void connect() throws SQLException {
        conn = DriverManager.getConnection(dbName, dbUsername, dbPassword);

    }

    protected void disconect() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }

    public List<Book> selectDB() throws SQLException {
        List<Book> book = new LinkedList<Book>();


        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery("SELECT * from book");
        while (result.next()) {
            Book book1 = new Book();
            book1.setId(result.getInt("book_id"));
            book1.setTitle(result.getString("title"));
            book1.setBook_name(result.getString("book_name"));
            book1.setAuthor(result.getString("author"));
            book1.setPrice(result.getFloat("price"));
            book1.setDateFormat(result.getDate("create_date"));
            book.add(book1);
        }
        result.close();
        statement.close();
        disconect();
        return book;

    }


    public boolean insertDB(Book book) throws SQLException {
        boolean checkInsert;
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO book (title,book_name,author,price) values (?,?,?,?) ");
        preparedStatement.setString(1, book.getTitle());
        preparedStatement.setString(2, book.getBook_name());
        preparedStatement.setString(3, book.getAuthor());
        preparedStatement.setFloat(4, book.getPrice());

        checkInsert = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        disconect();
        return checkInsert;
    }

    public boolean deleteDB(Book book) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("DELETE from book where book.id = ?");
        preparedStatement.setInt(1, book.getId());
        boolean checkDelete = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        disconect();
        return checkDelete;
    }

    public boolean updateDB(Book book) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("Update book set title = ?, bookname = ?, author = ?, price = ? where id = ?");
        preparedStatement.setString(1, book.getTitle());
        preparedStatement.setString(2, book.getBook_name());
        preparedStatement.setString(3, book.getAuthor());
        preparedStatement.setFloat(4, book.getPrice());
        preparedStatement.setInt(5, book.getId());
        boolean checkUpdate = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        disconect();
        return checkUpdate;
    }

    public static void main(String[] args) {

       BookDAO bookDAO = new BookDAO();
       try {
           System.out.println(bookDAO.selectDB());
          List<Book>  b =  bookDAO.selectDB();
           for (Book bk: b) {
               System.out.println(bk);
           }
       }
       catch (Exception e)
       {
           e.getMessage();
       }



    }
}
