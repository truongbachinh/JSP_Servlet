package utils;

import model.DBConfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ConfigListener implements ServletContextListener {
    public ConfigListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext(); // global variable
        DBConfig dbConfig = new DBConfig();
        String dbConfigString = sc.getInitParameter("dbConnectionStr");
        System.out.println(dbConfigString);
        String[] arr = dbConfigString.split("#",3);
        dbConfig.setDbUrl(arr[0]);
        System.out.println(dbConfig.getDbUrl());
        dbConfig.setUsername(arr[1]);
        System.out.println(dbConfig.getUsername());
        dbConfig.setPassword(arr[2]);
        System.out.println(dbConfig.getPassword());
        sc.setAttribute("config", dbConfig);

    }

}
