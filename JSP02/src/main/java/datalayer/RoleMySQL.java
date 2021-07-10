package datalayer;

import model.DBConfig;
import model.Role;
import model.User;

import java.sql.*;
import java.util.ArrayList;

public class RoleMySQL {
    private static String urlDb = "jdbc:mysql://localhost:3306/javaweb";
    private static String username = "root";
    private static String password = "123456";
    private static String driver = "com.mysql.cj.jdbc.Driver";

    public static boolean add(Role role) {
        boolean add = false;
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(urlDb, username,password);
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO `Role`(role, comment) values (?,?)");
            preparedStatement.setString(1, role.getRoleName());
            preparedStatement.setString(2, role.getRoleDes());
            add = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return add;

    }
    public static ArrayList<Role> listUsers() {
        ArrayList<Role> roles = new ArrayList<Role>();
        try {

            Statement stmt = null;

            String sSQL = "";
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(urlDb, username,password);
            stmt = connection.createStatement();
            sSQL = "SELECT * FROM role";
            System.out.println(sSQL);
            ResultSet rs = null;
            rs = stmt.executeQuery(sSQL);
            while (rs.next()) {


                Role r = new Role(rs.getInt("role_id"), rs.getString("role").toString(),
                        rs.getString("comment").toString());
                roles.add(r);
            }

            rs.close();
            connection.close();
            return roles;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Role getRoleDetail(int id) {
        Role role = null;

        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(urlDb, username,password);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM role where role_id = ? ");
            preparedStatement.setInt(1, id);
            ResultSet  rs = preparedStatement.executeQuery();
            while (rs.next()) {


                role = new Role(
                        rs.getInt("role_id"),
                        rs.getString("role"),
                        rs.getString("comment")

                );
                System.out.println(role);
            }

            rs.close();
            connection.close();
            System.out.println(role);
            return role;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean updateRole(Role role)
    {
        boolean check = false;
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(urlDb, username,password);
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE role set role = ?, comment = ? where role_id = ?");
            preparedStatement.setString(1,role.getRoleName());
            preparedStatement.setString(2,role.getRoleDes());
            preparedStatement.setInt(3,role.getRoleId());
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

}
