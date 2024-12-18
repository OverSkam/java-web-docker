package trying_web;

import lombok.SneakyThrows;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout extends HttpServlet {

    @SneakyThrows
    public void doGet(HttpServletRequest req, HttpServletResponse res){
        Cookie c = new Cookie("UID", "");
        c.setMaxAge(0);
        res.addCookie(c);
        res.sendRedirect("/login");
    }

}
