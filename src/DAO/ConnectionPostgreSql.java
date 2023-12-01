package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPostgreSql {
    private static String uri = "jdbc:postgresql://localhost:5432/";
    private static String user = "postgres";
    private static String pass = "admin123";
    private static ConnectionPostgreSql instance;
    private Connection connection;

    private ConnectionPostgreSql() {
    	
    }

    public static ConnectionPostgreSql getInstance() {
        if (instance == null) {
            instance = new ConnectionPostgreSql();
        }
        return instance;
    }

    public Connection getConn() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(uri, user, pass);
        }
        return connection;
    }

    public void closeConn() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException er) {
                er.printStackTrace();
            }
        }
    }
}
