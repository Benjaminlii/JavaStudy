package filterAndListener;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "file0", value = "/testFilter")
public class testFilter implements Filter {
    public void destroy() {
//        System.out.println("------> Filter destroy");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("--------> filterAndListener get request");
        chain.doFilter(req, resp);
        System.out.println("--------> filterAndListener get response");
    }

    public void init(FilterConfig config) throws ServletException {
//        System.out.println("------> Filter init");
    }

}
