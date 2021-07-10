package util;

import dao.ProductIO;
import model.Product;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
@WebListener
public class CartContextListenner implements ServletContextListener {
    public CartContextListenner() {

    }


    public void contextInitialized(ServletContextEvent event) {
        ServletContext sc = event.getServletContext();

        // initialize the customer service email address
        String custServEmail = sc.getInitParameter("custServEmail");
        sc.setAttribute("custServEmail", custServEmail);
      //  System.out.println(custServEmail);
        // initialize the current year
        GregorianCalendar currentDate = new GregorianCalendar();
        int currentYear = currentDate.get(Calendar.YEAR);
        sc.setAttribute("currentYear", currentYear);
    //    System.out.println(currentYear);
        // initialize the path for the products text file
        String productsPath = sc.getRealPath("/WEB-INF/products.txt");
        sc.setAttribute("productsPath", productsPath);

        // initialize the list of products
        ArrayList<Product> products = ProductIO.getProducts(productsPath);
        sc.setAttribute("products", products);

    }

    public void contextDestroyed(ServletContextEvent sce) {

    }
}
