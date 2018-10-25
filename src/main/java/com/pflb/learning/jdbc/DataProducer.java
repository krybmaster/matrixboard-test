package com.pflb.learning.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Creates aa h2 database, table structure
 * and fills it with some values
 */
public class DataProducer {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:h2:file:./data";
        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();

        String query = "CREATE TABLE users (id int primary key auto_increment, " +
                "username VARCHAR, " +
                "password VARCHAR, " +
                "role VARCHAR )";

        statement.execute(query);

        Statement statement1 = connection.createStatement();
        query = "INSERT INTO users (username, password, role) VALUES ('user', 'user', 'user'), " +
                "('admin', 'admin', 'admin')";
        statement1.execute(query);
    }
}
