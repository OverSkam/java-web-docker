package trying_web;

import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.SneakyThrows;
import org.eclipse.jetty.server.RequestLog;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class TemplateEngine {

    private final Configuration cfg;
    private final HashMap<String, Object> empty = new HashMap<>();

    @SneakyThrows
    public TemplateEngine(String rootFolder) {
        cfg = new Configuration(Configuration.VERSION_2_3_33);
        cfg.setDirectoryForTemplateLoading(new File(
                ResourcesOps.dirUnsafe(rootFolder)));
    }

    @SneakyThrows
    public void render(String templateName, Map<String, Object> data, HttpServletResponse resp){
        try (Writer w = resp.getWriter()) {
            cfg.getTemplate(templateName)
                    .process(data, w);
        }
    }

    public void render(String templateName, HttpServletResponse resp){
        render(templateName, empty, resp);
    }
}
