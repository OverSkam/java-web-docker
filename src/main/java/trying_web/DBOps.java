package trying_web;

import lombok.SneakyThrows;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.UUID;

public class DBOps {
    private final Connection connection;

    public DBOps(Connection connection) {
        this.connection = connection;
    }

    @SneakyThrows
    public void saveNewUser(String login, String pass, String name, String surname) {

        if (!doesUserExist(login)) {
            PreparedStatement st = connection.prepareStatement(
                    """
                   INSERT INTO users (login, pass, name, surname, cookie, image) values (?, ?, ?, ?, ?, ?)
               """
            );
            st.setString(1, login);
            st.setString(2, pass);
            st.setString(3, name);
            st.setString(4, surname);
            st.setString(5, UUID.randomUUID().toString());
            st.setString(6, "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png");
            st.execute();
            System.out.println("Registered");
        }
        else
            System.out.println("Not registered");
    }

    @SneakyThrows
    public int countUsers(){
        PreparedStatement st = connection.prepareStatement("""
                SELECT COUNT(id) AS count FROM users
                """);
        ResultSet rs = st.executeQuery();
        rs.next();
        return rs.getInt("count");
    }


    @SneakyThrows
    public boolean doesUserExist(String login) {
        PreparedStatement st = connection.prepareStatement(
                """
                SELECT EXISTS (SELECT 1 FROM users WHERE login = ?)
               """);
        st.setString(1, login);
        ResultSet rs = st.executeQuery();
        rs.next();
        return rs.getBoolean(1);
    }
}
