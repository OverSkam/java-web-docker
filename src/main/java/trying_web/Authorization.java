package trying_web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Optional;

public class Authorization {
    public static final String NAME = "UID";

    public static Optional<Cookie> getCookie(HttpServletRequest req) {
        return Optional.ofNullable(req.getCookies())
                .stream()
                .flatMap(Arrays::stream)
                .filter(c -> c.getName().equals(NAME))
                .findFirst();
    }

    public static Optional<String> getCookieValue(HttpServletRequest req) {
        return Optional.ofNullable(req.getCookies())
                .stream()
                .flatMap(Arrays::stream)
                .filter(c -> c.getName().equals(NAME))
                .findFirst()
                .map(Cookie::getValue);
    }

    public static String getCookieValueUnsafe(HttpServletRequest req) {
        return Optional.ofNullable(req.getCookies())
                .stream()
                .flatMap(Arrays::stream)
                .filter(c -> c.getName().equals(NAME))
                .findFirst()
                .map(Cookie::getValue)
                .orElseThrow(() -> new RuntimeException("Cookie must exist by design"));
    }
}
