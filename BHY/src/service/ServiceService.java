package service;

import dao.ServiceDao;
import dao.ServiceDaoImpl;
import entity.ServiceCustom;
import entity.ServiceQueryVo;
import main.config.mapper.ServiceMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

/**
 * 关于Service（服务）的业务逻辑代码
 */
public class ServiceService {
    private static SqlSessionFactory sqlSessionFactory;

    static  {
        try (
                InputStream inputStream = Resources.getResourceAsStream("main/config/SqlMapConfig.xml")
        ) {
            ServiceService.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * [分页][条件]查询服务项
     * @param serviceQueryVo 查询条件
     * @return 查询出的数据
     */
    public static List<ServiceCustom> findServiceLimitInDetail(ServiceQueryVo serviceQueryVo){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ServiceMapper serviceMapper = sqlSession.getMapper(ServiceMapper.class);
        List<ServiceCustom> serviceCustoms = null;
        try {
            serviceCustoms = serviceMapper.findServiceLimitInDetail(serviceQueryVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return serviceCustoms;
    }



    private static ServiceDao serviceDao = new ServiceDaoImpl();

    public static List<ServiceCustom> findServiceLimitInDetail(int page){
        List<ServiceCustom> services = null;
        try {
            services = serviceDao.findServiceLimitInDetail(page);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return services;
    }
}
