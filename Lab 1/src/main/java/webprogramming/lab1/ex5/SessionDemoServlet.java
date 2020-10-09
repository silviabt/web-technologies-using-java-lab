package webprogramming.lab1.ex5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet("/count-using-session")
public class SessionDemoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        int count = 1;

        Object counter = session.getAttribute("counter");
        if (counter != null) {
            AtomicInteger existingCount = (AtomicInteger) counter;
            count = existingCount.incrementAndGet();
        } else {
            AtomicInteger newCount = new AtomicInteger(1);
            session.setAttribute("counter", newCount);
        }

        resp.getWriter().println("The count is: " + count);
    }
}
