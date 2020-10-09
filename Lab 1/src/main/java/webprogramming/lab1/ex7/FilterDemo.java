package webprogramming.lab1.ex7;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import java.io.IOException;

public class FilterDemo extends HttpFilter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // code to execute before servlet
        response.getWriter().println("Hello everybody!");

        chain.doFilter(request, response);

        // code to execute after servlet
    }
}
