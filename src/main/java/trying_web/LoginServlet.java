package trying_web;

import lombok.SneakyThrows;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

public class LoginServlet extends HttpServlet {
    TemplateEngine te;
    private final Connection connection;
    CookieOps cookieOps;

    private static final String sql_check_login = """
      SELECT id FROM users WHERE login=? and pass=?
    """;

    public LoginServlet(TemplateEngine te, Connection connection){
        this.te = te;
        this.connection = connection;
        this.cookieOps = new CookieOps(connection);
    }

    @SneakyThrows
    public void doGet(HttpServletRequest req, HttpServletResponse res){
        te.render("login.ftl", res);
    }

    @SneakyThrows
    public void doPost(HttpServletRequest req, HttpServletResponse res){
        Optional<String> action = Optional.ofNullable(req.getParameter("login"));
        if (action.isPresent()){
            String login = req.getParameter("login");
            login = login.toLowerCase();
            String password = req.getParameter("password");

            int userId = isInDB(login, password);
            if (userId != -1){
                cookieOps.setCookieFromDB(res, userId);
                res.sendRedirect("/main");
            }
            else
                res.sendRedirect("/login");
        }

        Optional<String> action1 = Optional.ofNullable(req.getParameter("reg"));
        if (action1.isPresent())
            res.sendRedirect("/reg");

    }

    @SneakyThrows
    public int isInDB(String login, String password){
        PreparedStatement st = connection.prepareStatement(sql_check_login);
        st.setString(1, login);
        st.setString(2, password);

        ResultSet rs = st.executeQuery();

        if (rs.next())
            return rs.getInt("id");
        else
            return -1;
    }

}
