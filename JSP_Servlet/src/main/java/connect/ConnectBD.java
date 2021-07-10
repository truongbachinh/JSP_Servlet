package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectBD {
    private String dbName = "jdbc:mysql://localhost:3306/bookstore";
    private String dbUsername = "root";
    private String dbPassword = "123456";
    private Connection conn;
    public Connection connect() throws SQLException {
        return   conn = DriverManager.getConnection(dbName, dbUsername, dbPassword);
    }

    public Connection disconect() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();

        }
        return null;
    }
}
