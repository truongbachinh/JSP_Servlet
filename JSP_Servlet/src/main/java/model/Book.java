package model;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Book {
    private int id;
    private String book_name;
    private String title;
    private String author;
    private float price;
    private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    String strDate;
    private Date date;

    public Book() {

    }

    public Book(String title, String author, float price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public Book(int id) {
        this.id = id;
    }

    public Book(int id, String book_name, String title, String author, float price, Date date) {
        this.id = id;
        this.book_name = book_name;
        this.title = title;
        this.author = author;
        this.price = price;
        this.strDate = dateFormat.format(date);

    }

    public Book(String book_name, String title, String author, float price) {

        this.book_name = book_name;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getStrDate() {
        return strDate;
    }

    public Date getDate() {
        return date;
    }

    public void setDateFormat(Date date) {
        if (date != null) {
            this.strDate = dateFormat.format(date);
        }
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                        ", book_name='" + book_name + '\'' +
                        ", title='" + title + '\'' +
                        ", author='" + author + '\'' +
                        ", price=" + price +
                        ", dateFormat=" + dateFormat;
    }
}
