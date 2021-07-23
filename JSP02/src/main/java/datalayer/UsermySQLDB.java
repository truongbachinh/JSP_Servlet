package datalayer;

import model.DBConfig;
import model.User;

import java.sql.*;
import java.util.ArrayList;

public class UsermySQLDB {
    private static String urlDb = "jdbc:mysql://localhost:3306/javaweb";
    private static String username = "root";
    private static String password = "123456";
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static DBConfig config;
    public static void main(String[] args) {

        User users = null;

        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(urlDb,username,password);
            PreparedStatement preparedStatement = connection.prepareStatement("select u.*, r.role from user as u inner join userrole as ur on u.userId = ur.uid inner join role as r on r.role_id = ur.rid where u.userId = ?");
            preparedStatement.setInt(1, 1);
            ResultSet  rs = preparedStatement.executeQuery();
            while (rs.next()) {
//                users = new User(
//                        rs.getInt("userId"),
//                        rs.getString("firstName"),
//                        rs.getString("lastName"),
//                        rs.getString("email"),
//                        rs.getString("role")
//                );
              //  System.out.println(users);
                System.out.println(rs.getInt("userId"));
                System.out.println(rs.getString("firstName"));
                System.out.println(rs.getString("lastName"));
                System.out.println(rs.getString("email"));
                System.out.println(rs.getString("role"));

            }

            rs.close();
            connection.close();
            System.out.println(users);

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public static boolean add(User user, DBConfig config) {
        boolean add = false;
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(config.getDbUrl(), config.getUsername(), config.getPassword());
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO `User`(firstName, lastName, email) values (?,?,?)");
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            add = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return add;

    }

    public static ArrayList<User> listUsers( ) {
        ArrayList<User> users = new ArrayList<User>();
        try {

            Statement stmt = null;

            String sSQL = "";
            Class.forName(driver);

            Connection connection = DriverManager.getConnection(urlDb,username,password);
            stmt = connection.createStatement();
            sSQL = "SELECT userId,firstName,lastName,email FROM user";
            System.out.println(sSQL);
            ResultSet rs = null;
            rs = stmt.executeQuery(sSQL);
            while (rs.next()) {


                User u = new User(rs.getInt("userId"), rs.getString("firstName").toString(),
                        rs.getString("lastName").toString(),
                        rs.getString("email").toString());
                users.add(u);
            }

            rs.close();
            connection.close();
            return users;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static boolean deleteUserById(int id,DBConfig config)
    {

        boolean check = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(config.getDbUrl(), config.getUsername(), config.getPassword());
            PreparedStatement preparedStatement =  connection.prepareStatement("DELETE FROM user where userId = ?");
            int a = preparedStatement.executeUpdate();
           if(a > 0)
               check = true;
           else
               check = false;
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return check;
    }

    public static boolean upDateUser(User user, DBConfig config)
    {
        boolean check = false;
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(config.getDbUrl(), config.getUsername(), config.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE user set firstName = ?, lastName = ?, email = ? where userId = ?");
            preparedStatement.setString(1,user.getFirstName());
            preparedStatement.setString(2,user.getLastName());
            preparedStatement.setString(3,user.getEmail());
            preparedStatement.setInt(4,user.getUserId());
           int a =  preparedStatement.executeUpdate();
            if(a >0)
            {
                check =  true;
            }
            else
                check = false;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    public static User getUserDetail(int id) {
        User users = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(urlDb,username,password);
            PreparedStatement preparedStatement = connection.prepareStatement("select u.*, r.role from user as u inner join userrole as ur on u.userId = ur.uid inner join role as r on r.role_id = ur.rid where u.userId = ?", 3,4);
            preparedStatement.setInt(1, id);
            ResultSet  rs = preparedStatement.executeQuery();
            while (rs.next()) {
                users = new User(
                        rs.getInt("userId"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("email"),
                        rs.getString("role")
                        );
                System.out.println(users);
            }


            rs.close();
            connection.close();
            System.out.println(users);
            return users;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }




}
