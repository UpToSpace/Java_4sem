package com.example.laba9.classes;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private final String user = "sa";
    private final String password = "Vv1542139";
    private final String dbURL = "jdbc:sqlserver://DESKTOP-6BQAJ6M;databaseName=Weathers;integratedSecurity=false;"
            + "encrypt=false;trustServerCertificate=true";

    public DatabaseConnector() {
        try {
            DriverManager.registerDriver(new SQLServerDriver());
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Connection Connect() throws SQLException {
        return DriverManager.getConnection(dbURL, user, password);
    }

    public void Disconnect(Connection connection) throws SQLException {
        if (connection != null)
        {
            connection.close();
        }
    }
}
