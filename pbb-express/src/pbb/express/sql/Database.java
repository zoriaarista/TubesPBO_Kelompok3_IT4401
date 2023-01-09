package pbb.express.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private final static String DB_URL = "jdbc:mysql://localhost:3306/pbbexpress";
    private final static String DB_USER = "root";
    private final static String DB_PASS = "";

    private static Database instance = null;

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    private Connection connection = null;

    private Database() {}

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

}
