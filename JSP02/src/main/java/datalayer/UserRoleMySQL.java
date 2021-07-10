package datalayer;

import model.Role;
import model.User;
import model.UserRole;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserRoleMySQL {
    private static String urlDb = "jdbc:mysql://localhost:3306/javaweb";
    private static String username = "root";
    private static String password = "123456";
    private static String driver = "com.mysql.cj.jdbc.Driver";

    public static boolean addUserRole(UserRole userRole) {
        boolean add = false;
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(urlDb, username,password);
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO `UserRole`(uid, rid) values (?,?)");
            preparedStatement.setInt(1, userRole.getUserId());
            preparedStatement.setInt(2, userRole.getRoleId());
            add = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return add;

    }
    public static User loginUser(String email) {
        User users = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(urlDb,username,password);
            PreparedStatement preparedStatement = connection.prepareStatement("select u.*, r.role as role from user as u inner join userrole as ur on u.userId = ur.uid inner join role as r on r.role_id = ur.rid where u.email = ?");
            preparedStatement.setString(1, email);
            ResultSet rs = preparedStatement.executeQuery();
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

    public static List<String> emailList() {
        List<String> emails = new ArrayList<String>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(urlDb,username,password);
            PreparedStatement preparedStatement = connection.prepareStatement("select email from user");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                emails.add(rs.getString("email"));
            }

            rs.close();
            connection.close();
            for (String email : emails
                 ) {
                System.out.println(email);
            }
            return emails;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
