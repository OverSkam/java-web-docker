package trying_web;

import lombok.SneakyThrows;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Optional;
import java.util.Random;

public class MainServlet extends HttpServlet {

    Random rd = new Random();

    TemplateEngine te;
    private final Connection connection;
    CookieOps cookieOps;
    DBOps dbOps;
    MainOps mainOps;
    int randomId;

    public MainServlet(TemplateEngine te, Connection connection){
        this.te = te;
        this.connection = connection;
        this.dbOps = new DBOps(connection);
        this.cookieOps = new CookieOps(connection);
        this.mainOps = new MainOps(connection);
    }

    @SneakyThrows
    public void doGet(HttpServletRequest req, HttpServletResponse res){
        this.randomId = rd.nextInt(dbOps.countUsers()) + 1;
        te.render("main.ftl", mainOps.randomUser(randomId), res);
    }

    @SneakyThrows
    public void doPost(HttpServletRequest req, HttpServletResponse res){
        Optional<String> action = Optional.ofNullable(req.getParameter("action"));
        Optional<String> navigation = Optional.ofNullable(req.getParameter("navigation"));

        if (action.isPresent())
            switch (action.get()){
                case "skip":
                    res.sendRedirect("/main");
                    break;
                case "like":
                    int maybeId = mainOps.getUserId(req);
                    if (maybeId == -1)
                        res.sendRedirect("/login");
                    else {
                        mainOps.likeUser(maybeId, randomId);
                        res.sendRedirect("/main");
                    }
                    break;
            }
        if (navigation.isPresent())
            switch (navigation.get()){
                case "logout":
                cookieOps.deleteCookie(res);
                res.sendRedirect("/login");
                break;
            }

    }



}
