package com.pflb.learning.jdbc;

import com.pflb.learning.jdbc.entity.User;

import java.sql.SQLException;

public class DataProvider {
    public static User getUserByRole(String role) {
        return JdbcExecutor.query(resultSet -> {
            try {
                if (!resultSet.next()) {
                    throw new RuntimeException("no records found with role " + role);
                }
                int id = resultSet.getInt("ID");
                String username = resultSet.getString("USERNAME");
                String password = resultSet.getString("PASSWORD");
                String resultRole = resultSet.getString("ROLE");
                return new User(id, username, password, resultRole);
            } catch (SQLException e) {
                throw new RuntimeException("can't process result set", e);
            }
        },
                "SELECT * FROM users WHERE role = ?",
                role);
    }
}
