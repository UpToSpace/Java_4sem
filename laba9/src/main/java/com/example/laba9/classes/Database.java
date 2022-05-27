package com.example.laba9.classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Database {
    private final Connection connection;
     public Database() throws SQLException {
         DatabaseConnector databaseConnector = new DatabaseConnector();
         connection = databaseConnector.Connect();
     }
    public ArrayList<Gamers> GetGamers() throws SQLException {
        ArrayList<Gamers> gamers = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from Gamers");
        while(resultSet.next()) {
            gamers.add(new Gamers(resultSet.getInt("Number"), resultSet.getString("Name")));
        }
        statement.close();
        return gamers;
    }

    public void RemoveGamer(String number) throws SQLException {
         Statement statement = connection.createStatement();
         statement.executeQuery("delete from Gamers where Number = " + number);
         statement.close();
    }

    public void AddGamer(String number, String name) throws SQLException {
         Statement statement = connection.createStatement();
         statement.executeQuery("insert into Gamers values ('" + number + "', '" + name + "')");
         statement.close();
    }

    public void UpdateGamer(String number, String name) throws SQLException {
         Statement statement = connection.createStatement();
         statement.executeQuery("update Gamers set name = '" + name + "' where number = " + number);
         statement.close();
    }
}
