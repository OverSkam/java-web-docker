package trying_web;

import lombok.SneakyThrows;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.module.Configuration;
import java.sql.Connection;
import java.util.HashMap;

public class UserToChatServlet extends HttpServlet {
    Connection connection;
    MainOps mainOps;

    public UserToChatServlet(Connection connection) {
        this.connection = connection;
        mainOps = new MainOps(connection);
    }

    @SneakyThrows
    public void doGet(HttpServletRequest req, HttpServletResponse res){
        String[] uri = req.getRequestURI().split("/");
        int uriLast = Integer.parseInt(uri[uri.length - 1]);
        int maybeId = mainOps.getUserId(req);
        if (maybeId == -1)
            res.sendRedirect("/login");
        else {
            String url = req.getContextPath() + "/chat/" + String.valueOf(mainOps.getChatId(maybeId, uriLast));
            res.sendRedirect(url);
        }
    }
}
