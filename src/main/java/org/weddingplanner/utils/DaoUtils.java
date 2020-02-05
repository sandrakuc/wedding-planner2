package org.weddingplanner.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public enum DaoUtils {

    INSTANCE;

    public Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "wedding", "wedding");
        return connection;
    }
}
