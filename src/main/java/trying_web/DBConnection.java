package trying_web;

import lombok.SneakyThrows;

import java.sql.*;


public class DBConnection {

    @SneakyThrows
    public static Connection make(String url) {
        String user = "u3jollt5esm84g";
        String password = "p2e0861f4de93bf9138d27d416e8d34ff729c329c5d6924d8b0ce886dc7013675";
        return DriverManager.getConnection(url, user, password);
    }
}
