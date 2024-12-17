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
    public HashMap<String, Object> randomUser(int id) {
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
    public int getUserId(HttpServletRequest req) {
        Optional<String> maybeCookie = Optional.ofNullable(req.getCookies())
                .stream()
                .flatMap(Arrays::stream)
                .filter(c -> c.getName().equals("UID"))
                .findFirst()
                .map(Cookie::getValue);

        PreparedStatement st = connection.prepareStatement("""
                SELECT id from users where cookie=?
                """);

        if (maybeCookie.isPresent()) {
            st.setString(1, maybeCookie.get());
            ResultSet rs = st.executeQuery();
            if (rs.next())
                return rs.getInt("id");
            else
                return -1;
        } else
            return -1;
    }

    @SneakyThrows
    public void likeUser(int who, int whom) {
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
    public HashMap<String, Object> matches(int who) {
        HashMap<String, Object> result = new HashMap<>();

        PreparedStatement st = connection.prepareStatement("""
                SELECT whom FROM likes WHERE who=?
                """);
        st.setInt(1, who);
        ResultSet rs = st.executeQuery();

        List<SimpleUser> s = new ArrayList<>();

        while (rs.next()) {
            PreparedStatement st1 = connection.prepareStatement("""
                    SELECT name, surname, id FROM users WHERE id=?
                    """);
            st1.setInt(1, rs.getInt("whom"));
            ResultSet rs1 = st1.executeQuery();
            rs1.next();

            SimpleUser su = new SimpleUser(
                    rs1.getString("name"),
                    rs1.getString("surname"),
                    rs1.getInt("id")
            );
            s.add(su);
        }
        result.put("users", s);

        return result;
    }

    @SneakyThrows
    public int getChatId(int id1, int id2) {
        PreparedStatement st = connection.prepareStatement("""
                SELECT EXISTS (SELECT 1 FROM chatRelations WHERE (id1=? and id2=?) or (id1=? and id2=?))
                """);
        st.setInt(1, id1);
        st.setInt(2, id2);
        st.setInt(3, id2);
        st.setInt(4, id1);
        ResultSet rs = st.executeQuery();
        rs.next();
        if (rs.getBoolean(1)) {
            st = connection.prepareStatement("""
                    SELECT chat_id FROM chatRelations WHERE (id1=? and id2=?) or (id1=? and id2=?)
                    """);
            st.setInt(1, id1);
            st.setInt(2, id2);
            st.setInt(3, id2);
            st.setInt(4, id1);
            rs = st.executeQuery();
            rs.next();
            return rs.getInt("chat_id");
        } else {
            st = connection.prepareStatement("""
                    INSERT INTO chatRelations (id1, id2) VALUES (?, ?)
                    """);
            st.setInt(1, id1);
            st.setInt(2, id2);
            st.executeUpdate();
            return getChatId(id1, id2);
        }
    }

    @SneakyThrows
    public HashMap<String, Object> messages(int chatId, int userId) {
        PreparedStatement st = connection.prepareStatement("""
                SELECT message, sender FROM chathistory WHERE chat_id=? ORDER BY message_id ASC
                """);
        st.setInt(1, chatId);
        ResultSet rs = st.executeQuery();

        HashMap<String, Object> result = new HashMap<>();
        List<SimpleMessage> s = new ArrayList<>();

        while (rs.next()) {
            int sender = rs.getInt("sender");
            String type = sender == userId ? "sent" : "received";

            PreparedStatement st1 = connection.prepareStatement("""
                    SELECT name, surname FROM users WHERE id=?
                    """);

            st1.setInt(1, sender);
            ResultSet rs1 = st1.executeQuery();
            rs1.next();

            String username = rs1.getString("name") + " " + rs1.getString("surname");

            SimpleMessage sm = new SimpleMessage(
                    rs.getString("message"),
                    username,
                    type
            );

            s.add(sm);
        }

        result.put("messages", s);

        return result;
    }

    @SneakyThrows
    public boolean isChatOwner(int chatId, int userId) {
        PreparedStatement st = connection.prepareStatement("""
                SELECT EXISTS (SELECT 1 FROM chatRelations WHERE (id1=? OR id2=?) AND (chat_id=?))
                """);
        st.setInt(1, userId);
        st.setInt(2, userId);
        st.setInt(3, chatId);
        ResultSet rs = st.executeQuery();
        rs.next();
        return rs.getBoolean(1);
    }

    @SneakyThrows
    public void saveNewMessage(int chatId, int userId, String message) {
        int receiverId;

        PreparedStatement st = connection.prepareStatement("""
                SELECT id1, id2 FROM chatRelations WHERE chat_id=?
                """);
        st.setInt(1, chatId);
        ResultSet rs = st.executeQuery();
        rs.next();
        receiverId = rs.getInt("id1") == userId ?
                rs.getInt("id2") : rs.getInt("id1");

        st = connection.prepareStatement("""
                INSERT INTO chathistory (chat_id, sender, receiver, message) VALUES (?, ?, ?, ?)
                """);
        st.setInt(1, chatId);
        st.setInt(2, userId);
        st.setInt(3, receiverId);
        st.setString(4, message);
        st.executeUpdate();
    }
}
