package trying_web;

import lombok.SneakyThrows;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.util.HashMap;

public class ChatServlet extends HttpServlet {
    TemplateEngine te;
    private final Connection connection;
    CookieOps cookieOps;
    DBOps dbOps;
    MainOps mainOps;

    public ChatServlet(TemplateEngine te, Connection connection) {
        this.te = te;
        this.connection = connection;
        this.dbOps = new DBOps(connection);
        this.cookieOps = new CookieOps(connection);
        this.mainOps = new MainOps(connection);
    }

    @SneakyThrows
    public void doGet(HttpServletRequest req, HttpServletResponse res) {
        String[] uri = req.getRequestURI().split("/");
        int chatId = Integer.parseInt(uri[uri.length - 1]);
        int maybeId = mainOps.getUserId(req);

        if (mainOps.isChatOwner(chatId, maybeId)) {
            if (maybeId == -1)
                res.sendRedirect("/login");
            else {
                HashMap<String, Object> data = mainOps.messages(chatId, maybeId);
                if (data.isEmpty())
                    te.render("emptyChat.ftl", res);
                else
                    te.render("chat.ftl", mainOps.messages(chatId, maybeId), res);
            }
        } else
            res.sendRedirect("/login");
    }

    @SneakyThrows
    public void doPost(HttpServletRequest req, HttpServletResponse res) {
        String thisUri = req.getRequestURI();
        String[] uri = req.getRequestURI().split("/");
        int chatId = Integer.parseInt(uri[uri.length - 1]);
        int maybeId = mainOps.getUserId(req);

        if (mainOps.isChatOwner(chatId, maybeId)) {
            if (maybeId == -1)
                res.sendRedirect("/login");
            else {
                mainOps.saveNewMessage(chatId, maybeId, req.getParameter("message"));
                res.sendRedirect(thisUri);
            }
        } else
            res.sendRedirect("/login");
    }
}
