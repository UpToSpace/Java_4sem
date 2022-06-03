package com.example.laba9.classes;

import com.example.laba9.classes.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Validation {
    private String role;
    public boolean CheckLogin(String email, String pass) throws SQLException {
        if (email.isEmpty()|| pass.isEmpty()) {
            return false;
        }
        DatabaseConnector connector = new DatabaseConnector();
        Connection connection = connector.Connect();
        PreparedStatement prepareStatement = connection.prepareStatement("select login, role from Users where login = ? and password = ?");
        prepareStatement.setString(1, email);
        prepareStatement.setString(2, pass);
        ResultSet resultSet = prepareStatement.executeQuery();
        if(resultSet.next()) {
            setRole(resultSet.getString("role"));
            return true;
        }
        return false;
    }

    public boolean AddNewUser(String email, String pass) throws SQLException {
        if (email.trim().isEmpty()|| pass.trim().isEmpty()) {
            return false;
        }
        DatabaseConnector connector = new DatabaseConnector();
        Connection connection = connector.Connect();
        PreparedStatement preparedStatement = connection.prepareStatement("select login from Users where login = ?");
        preparedStatement.setString(1, email);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return false;
        }
        preparedStatement = connection.prepareStatement("insert into Users values (?, ?, 'user')");
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, pass);
        preparedStatement.execute();
        return true;
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
