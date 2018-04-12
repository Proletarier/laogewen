package com.app.mvc.util;

import java.sql.*;

/**
 * Created by wenheng on 2018/4/3.
 */
public class JDBCSQLite {

    static Connection conn = null;

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection() throws SQLException {
        if (conn == null || conn.isClosed()) {
            conn = DriverManager.getConnection("jdbc:sqlite:laogewen.db");
        }
        return conn;
    }

    public static void colseConnection(ResultSet resultSet, PreparedStatement statement) {

        try {
            if (resultSet != null)
                resultSet.close();
            if (statement != null)
                statement.close();
            if (conn != null)
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
