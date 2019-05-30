package service;

import dao.ServiceDao;
import dao.ServiceDaoImpl;
import entity.ServiceCustom;

import java.sql.SQLException;
import java.util.List;

/**
 * 关于Service（服务）的业务逻辑代码
 */
public class ServiceService {
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
