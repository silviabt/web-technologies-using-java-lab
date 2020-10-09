package webprogramming.lab1.ex4;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet("/count")
public class ContextDemoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = req.getServletContext();

        int count = 1;

        Object counter = context.getAttribute("counter");
        if (counter != null) {
            AtomicInteger existingCount = (AtomicInteger) counter;
            count = existingCount.incrementAndGet();
        } else {
            AtomicInteger newCount = new AtomicInteger(1);
            context.setAttribute("counter", newCount);
        }

        resp.getWriter().println("The count is: " + count);
    }
}
