package trying_web;

import lombok.SneakyThrows;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.sql.Connection;

public class Application {
    @SneakyThrows
    public static void main(String[] args) {

        Connection conn = DBConnection.make("jdbc:postgresql://ccaml3dimis7eh.cluster-czz5s0kz4scl.eu-west-1.rds.amazonaws.com:5432/dc8u7tinlsasdi");
        Server server = new Server(8080);
        TemplateEngine te = new TemplateEngine("templates");

        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(new ServletHolder(new LoginServlet(te, conn)), "/login");
        handler.addServlet(new ServletHolder(new RegisterServlet(te, conn)), "/reg");
        handler.addServlet(new ServletHolder(new MainServlet(te, conn)), "/main");
        handler.addServlet(new ServletHolder(new MatchesServlet(te, conn)), "/matches");
        handler.addServlet(new ServletHolder(new ChatServlet(te, conn)), "/chat/*");
        handler.addServlet(new ServletHolder(new UserToChatServlet(conn)), "/user/*");
        handler.addServlet(new ServletHolder(new Logout()), "/gol");
        handler.addServlet(new ServletHolder(new StaticContentServlet("static0")), "/static/*");
        handler.addServlet(new ServletHolder(new LoginServlet(te, conn)), "/*");

        server.setHandler(handler);

        server.start();
        server.join();
    }
}
