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
        System.out.println("user : " + servletConfig.getInitParameter("user"));
        System.out.println();

        Enumeration<String> names = servletConfig.getInitParameterNames();
        while(names.hasMoreElements()){
            String name = names.nextElement();
            String value = servletConfig.getInitParameter(name);
            System.out.println("" + name + " : " + value);
        }
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
