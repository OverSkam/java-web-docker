package trying_web;

import lombok.SneakyThrows;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class GameServlet extends HttpServlet {
    TemplateEngine te;
    GameLogic logic = new GameLogic();

    public GameServlet(TemplateEngine te) {
        this.te = te;
    }

    HashMap<String, Object> data = logic.getPLayerAndEnemy();


    public void doGet(HttpServletRequest req, HttpServletResponse res){
        te.render("game.ftl", logic.getPLayerAndEnemy(), res);
    }

    @SneakyThrows
    public void doPost(HttpServletRequest req, HttpServletResponse res){
        String action = req.getParameter("action");
        int[] rollAndSuccess = new int[2];
        switch (action) {
            case "attack":
                rollAndSuccess = logic.attackEnemy();
                break;
            case "heal":
                rollAndSuccess =logic.healPlayer();
                break;
        }
        data.put("roll", String.valueOf(rollAndSuccess[0]));
        res.sendRedirect("/start");
    }
}
