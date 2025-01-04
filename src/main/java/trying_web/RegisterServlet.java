package trying_web;

import lombok.SneakyThrows;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;

public class RegisterServlet extends HttpServlet {
    TemplateEngine te;
    CookieOps cookieOps;
    DBOps dbOps;

    public RegisterServlet(TemplateEngine te, Connection connection) {
        this.te = te;
        this.dbOps = new DBOps(connection);
        this.cookieOps = new CookieOps(connection);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) {
        te.render("register.ftl", res);
    }

    @SneakyThrows
    public void doPost(HttpServletRequest req, HttpServletResponse res) {
        String login = req.getParameter("login");
        login = login.toLowerCase();
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        dbOps.saveNewUser(login, password, name, surname);
        res.sendRedirect("/login");
    }
}
