package trying_web;

import lombok.SneakyThrows;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.UUID;

public class CookieOps {

    Connection conn;
    public CookieOps(Connection connection) {
        this.conn = connection;
    }

    @SneakyThrows
    public void setCookie(HttpServletResponse res, int id){
        PreparedStatement st = conn.prepareStatement("SELECT cookie FROM users WHERE id=?");
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();

        String cid;
        if (rs.next())
            cid = rs.getString("cookie");
        else
            cid = UUID.randomUUID().toString();

        st = conn.prepareStatement(" UPDATE users SET cookie = ?  WHERE id = ?");
        st.setString(1, cid);
        st.setInt(2, id);
        st.execute();
        st.close();

        Cookie c = new Cookie("UID", cid);
        res.addCookie(c);
    }

    public String getCookie(HttpServletRequest req){
        Optional<String> maybeCookie = Authorization.getCookieValue(req);

        if (maybeCookie.isPresent())
            return maybeCookie.get();
        else
            return null;
    }
}
