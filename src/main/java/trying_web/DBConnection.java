package trying_web;

import lombok.SneakyThrows;

import java.sql.*;


public class DBConnection {

    @SneakyThrows
    public static Connection make(String url) {
        String user = "postgres";
        String password = "pg123456";
        return DriverManager.getConnection(url, user, password);
    }
}
