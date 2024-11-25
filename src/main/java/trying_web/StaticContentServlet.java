package trying_web;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StaticContentServlet extends HttpServlet {
    private final String prefix;

    public StaticContentServlet(String prefix) {
        this.prefix = ResourcesOps.dirUnsafe(prefix);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String fileName = req.getPathInfo();
        String fullName = prefix + fileName;

        if (!new File(fullName).exists()) {
            res.setStatus(HttpServletResponse.SC_NOT_FOUND);
        } else try (ServletOutputStream os = res.getOutputStream()) {
            Path fullPath = Paths.get(fullName);
            Files.copy(fullPath, os);
        }
    }
}
