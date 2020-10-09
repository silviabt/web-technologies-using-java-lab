package webprogramming.lab1.ex3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

@WebServlet("/headers")
public class HeadersDemoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        if (name == null) {
            name = "";
        }

        Locale locale = req.getLocale();
        String languageTag = locale.toLanguageTag().substring(0,2);

        String greeting;
        switch (languageTag) {
            case "fr":
                greeting = "Bonjour";
                break;
            case "en":
                greeting = "Hello";
                break;
            default:
                greeting = "Buna";
                languageTag = "ro";
        }

        resp.setHeader("Content-Language", languageTag);
        resp.getWriter().println(String.format("%s %s!", greeting, name));
    }
}
