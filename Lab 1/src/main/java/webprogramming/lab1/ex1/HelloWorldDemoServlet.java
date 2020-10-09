package webprogramming.lab1.ex1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// tell the application server the HTTP path to the servlet
@WebServlet("/hello")
public class HelloWorldDemoServlet extends HttpServlet {

    // in order to process HTTP get request -> need to override the doGet method
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // HttpServletResponse object has a method that provides an IO print writer
        // we can use that print writer to output text
        resp.getWriter().println("Hello everybody!");
    }

}
