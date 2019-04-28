package demo;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

public class HelloServlet implements Servlet{

    /**
     * 构造器
     * 并不需要特意进行覆盖
     * 在构造Servlet对象时调用
     * 只被调用一次，说明Servlet是单实例的
     */
    public HelloServlet(){
        System.out.println("构造器");
    }

    /**
     * 在第一次加载该Servlet时会运行该方法
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init hello");
        // 测试ServletConfig类
        // 获取Servlet对象的初始化参数
        System.out.println("user : " + servletConfig.getInitParameter("user"));
        Enumeration<String> names = servletConfig.getInitParameterNames();
        while(names.hasMoreElements()){
            String name = names.nextElement();
            String value = servletConfig.getInitParameter(name);
            System.out.println("" + name + " : " + value);
        }
        System.out.println();

        // 测试ServletContext类
        ServletContext servletContext = servletConfig.getServletContext();
        // 获取当前Web应用程序的初始化参数，方法和使用ServletConfig类是相同的
        // 只不过使用ServletContext对象查询得到的是作用于整的Web应用程序的全局初始化参数
        System.out.println("jdbcDriver ; " +
                servletContext.getInitParameter("jdbcDriver"));
        System.out.println();

        // 获取某个文件在服务器上的绝对路径
        System.out.println("path(helloServlet.java) : " +
                servletContext.getRealPath("helloServlet.java"));
        System.out.println();

        // 获取Web应用程序的名称
        System.out.println("Web APP name : " +
                servletContext.getContextPath());
        System.out.println();

        // 获取每一个文件对应的输入流，相当于创建输入流
        System.out.println("IO Stream(web.xml) : " +
                servletContext.getResourceAsStream("/WEB-INF/web.xml"));


    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("getServletConfig");
        return null;
    }

    /**
     * 每一次请求时都会执行
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("get post");
    }

    @Override
    public String getServletInfo() {
        System.out.println("getServletInfo");
        return null;
    }

    /**
     * 销毁
     * 关闭服务器，销毁所有Servlet时会执行
     */
    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
