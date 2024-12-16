package trying_web;

import lombok.SneakyThrows;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.util.HashMap;

public class MatchesServlet extends HttpServlet {
    TemplateEngine te;
    private final Connection connection;
    CookieOps cookieOps;
    DBOps dbOps;
    MainOps mainOps;

    public MatchesServlet(TemplateEngine te, Connection connection){
        this.te = te;
        this.connection = connection;
        this.dbOps = new DBOps(connection);
        this.cookieOps = new CookieOps(connection);
        this.mainOps = new MainOps(connection);
    }

    @SneakyThrows
    public void doGet(HttpServletRequest req, HttpServletResponse res){
        int maybeId = mainOps.getUserId(req);
        if (maybeId == -1)
            res.sendRedirect("/login");
        else {
            te.render("matches.ftl", mainOps.matches(maybeId), res);
        }
    }
}
