package demo;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * @param servletRequest 封装了请求信息
     * @param servletResponse 封装了响应信息
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        String username = servletRequest.getParameter("userName");
        String password = servletRequest.getParameter("passWord");
        System.out.println(username + ", " + password);

        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse)servletResponse;
        System.out.println("URI : " +
                httpServletRequest.getRequestURI());
        System.out.println("URL : " +
                httpServletRequest.getRequestURL());
        System.out.println("method : " +
                httpServletRequest.getMethod());

        PrintWriter out =  servletResponse.getWriter();
        out.print(username + ", " + password);

        //在这里顺便测试请求的转发和重定向
        //请求转发
        httpServletRequest.getRequestDispatcher("/world").forward(servletRequest,servletResponse);
        //请求重定向
        httpServletResponse.sendRedirect("/world");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
