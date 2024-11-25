package trying_web;

import freemarker.template.Configuration;
import lombok.SneakyThrows;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class TemplateServlet extends HttpServlet {

    private TemplateEngine te;

    public TemplateServlet(TemplateEngine te) {
        this.te = te;
    }

    @Override
    @SneakyThrows
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        HashMap<String, Object> data = new HashMap<>();
        data.put("name", "Skam");

        te.render("menu.ftl", data, resp);
    }
}
