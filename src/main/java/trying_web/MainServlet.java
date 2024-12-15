package trying_web;

import lombok.SneakyThrows;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;

public class MainServlet extends HttpServlet {
    TemplateEngine te;
    private final Connection connection;
    CookieOps cookieOps;
    DBOps dbOps;

    public MainServlet(TemplateEngine te, Connection connection){
        this.te = te;
        this.connection = connection;
        this.dbOps = new DBOps(connection);
        this.cookieOps = new CookieOps(connection);
    }

    @SneakyThrows
    public void doGet(HttpServletRequest req, HttpServletResponse res){
        te.render("main.ftl", res);
    }
}
