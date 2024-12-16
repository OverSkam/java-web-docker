package trying_web;

import lombok.SneakyThrows;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class MainOps {
    Connection connection;

    public MainOps(Connection connection) {
        this.connection = connection;
    }

    @SneakyThrows
    public HashMap<String, Object> randomUser(int id){
        PreparedStatement st = connection.prepareStatement("""
                SELECT name, surname, age, about FROM users WHERE id=?
                """);
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();
        HashMap<String, Object> user = new HashMap<>();
        while (rs.next()) {
            user.put("name", rs.getString("name"));
            user.put("surname", rs.getString("surname"));
            user.put("age", String.valueOf(rs.getInt("age")));
            if (rs.getString("about") != null)
                user.put("about", rs.getString("about"));
            else
                user.put("about", "nothing");
        }
        return user;
    }

    @SneakyThrows
    public int getUserId(HttpServletRequest req){
        Optional<String> maybeCookie = Optional.ofNullable(req.getCookies())
                .stream()
                .flatMap(Arrays::stream)
                .filter(c -> c.getName().equals("UID"))
                .findFirst()
                .map(Cookie::getValue);

        PreparedStatement st = connection.prepareStatement("""
                SELECT id from users where cookie=?
                """);

        if (maybeCookie.isPresent()){
            st.setString(1, maybeCookie.get());
            ResultSet rs = st.executeQuery();
            if (rs.next())
                return rs.getInt("id");
            else
                return -1;
        }
        else
            return -1;
    }

    @SneakyThrows
    public void likeUser(int who, int whom){
        PreparedStatement st = connection.prepareStatement(
                """
                SELECT EXISTS (SELECT 1 FROM likes WHERE who=? AND whom=?)
               """);
        st.setInt(1, who);
        st.setInt(2, whom);
        ResultSet rs = st.executeQuery();
        rs.next();
        if (!rs.getBoolean(1)) {
            st = connection.prepareStatement("""
                    INSERT INTO likes (who, whom) values (?, ?)
                    """);
            st.setInt(1, who);
            st.setInt(2, whom);
            st.executeUpdate();
        }
    }

    @SneakyThrows
    public HashMap<String, Object> matches(int who){
        HashMap<String, Object> result = new HashMap<>();

        PreparedStatement st = connection.prepareStatement("""
                SELECT whom FROM likes WHERE who=?             
                """);
        st.setInt(1, who);
        ResultSet rs = st.executeQuery();

        List<String> s = new LinkedList<>();

        while (rs.next()) {
            PreparedStatement st1 = connection.prepareStatement("""
                    SELECT name, surname FROM users WHERE id=?
                    """);
            st1.setInt(1, rs.getInt("whom"));
            ResultSet rs1 = st1.executeQuery();
            rs1.next();

            s.add("%s %s".formatted(rs1.getString("name"), rs1.getString("surname")));
        }
        result.put("users", s);

        return result;
    }
}
