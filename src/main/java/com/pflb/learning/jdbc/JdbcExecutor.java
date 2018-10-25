package com.pflb.learning.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcExecutor {
    private static final String path = "./data";
    private static final String driver = "org.h2.Driver";

    static <T> T query(ResultHandler<T> handler, String query, String... params) {
        try {
            Class.forName(driver);
            String url = "jdbc:h2:file:" + path;

            Connection connection = DriverManager.getConnection(url);
            PreparedStatement ps = connection.prepareStatement(query);
            for (int i = 1; i < params.length; i++) {
                ps.setString(i, params[i - 1]);
            }
            ResultSet resultSet = ps.executeQuery();
            return handler.handle(resultSet);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("driver not found!", e);
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to database!", e);
        }
    }
}
