package trying_web;

import lombok.SneakyThrows;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;

public class MainMenuServlet extends HttpServlet {
    private TemplateEngine te;

    public MainMenuServlet(TemplateEngine te) {
        this.te = te;
    }

    @SneakyThrows
    public void doGet(HttpServletRequest req, HttpServletResponse res){
        te.render("menu.ftl", res);
    }

    @SneakyThrows
    public void doPost(HttpServletRequest req, HttpServletResponse res){
        GameLogic.player.setName(req.getParameter("name"));
        res.sendRedirect("/start");
    }
}
