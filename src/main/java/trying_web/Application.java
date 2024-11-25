package trying_web;

import lombok.SneakyThrows;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Application {
    @SneakyThrows
    public static void main(String[] args) {

        Server server = new Server(8080);
        TemplateEngine te = new TemplateEngine("templates");

        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(new ServletHolder(new MainMenuServlet(te)), "/menu");
        handler.addServlet(new ServletHolder(new GameServlet(te)), "/start");
        handler.addServlet(new ServletHolder(new StaticContentServlet("static0")), "/static/*");

        server.setHandler(handler);

        server.start();
        server.join();
    }
}
