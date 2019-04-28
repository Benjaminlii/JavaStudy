package demo;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

public class HelloServlet implements Servlet{

    /**
     * ������
     * ������Ҫ������и���
     * �ڹ���Servlet����ʱ����
     * ֻ������һ�Σ�˵��Servlet�ǵ�ʵ����
     */
    public HelloServlet(){
        System.out.println("������");
    }

    /**
     * �ڵ�һ�μ��ظ�Servletʱ�����и÷���
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init hello");
        // ����ServletConfig��
        // ��ȡServlet����ĳ�ʼ������
        System.out.println("user : " + servletConfig.getInitParameter("user"));
        Enumeration<String> names = servletConfig.getInitParameterNames();
        while(names.hasMoreElements()){
            String name = names.nextElement();
            String value = servletConfig.getInitParameter(name);
            System.out.println("" + name + " : " + value);
        }
        System.out.println();

        // ����ServletContext��
        ServletContext servletContext = servletConfig.getServletContext();
        // ��ȡ��ǰWebӦ�ó���ĳ�ʼ��������������ʹ��ServletConfig������ͬ��
        // ֻ����ʹ��ServletContext�����ѯ�õ���������������WebӦ�ó����ȫ�ֳ�ʼ������
        System.out.println("jdbcDriver ; " +
                servletContext.getInitParameter("jdbcDriver"));
        System.out.println();

        // ��ȡĳ���ļ��ڷ������ϵľ���·��
        System.out.println("path(helloServlet.java) : " +
                servletContext.getRealPath("helloServlet.java"));
        System.out.println();

        // ��ȡWebӦ�ó��������
        System.out.println("Web APP name : " +
                servletContext.getContextPath());
        System.out.println();

        // ��ȡÿһ���ļ���Ӧ�����������൱�ڴ���������
        System.out.println("IO Stream(web.xml) : " +
                servletContext.getResourceAsStream("/WEB-INF/web.xml"));


    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("getServletConfig");
        return null;
    }

    /**
     * ÿһ������ʱ����ִ��
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
     * ����
     * �رշ���������������Servletʱ��ִ��
     */
    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
