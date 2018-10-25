package com.pflb.learning.jdbc;

import java.sql.ResultSet;

@FunctionalInterface
public interface ResultHandler<T> {
    T handle(ResultSet resultSet);
}
