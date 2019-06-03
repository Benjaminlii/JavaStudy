package service;

import entity.ServiceCustom;
import entity.ServiceQueryVo;
import main.config.mapper.ServiceMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
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

    /**
     * 插入一条服务项信息
     * @param serviceCustom 插入的服务信息，必须要提供的信息：宠物id， 字典id（服务类型）， 员工id
     * @return 插入成功返回true，否则返回false
     */
    public static boolean insertService(ServiceCustom serviceCustom){
        boolean rtn = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ServiceMapper serviceMapper = sqlSession.getMapper(ServiceMapper.class);

        try {
            rtn = serviceMapper.insertService(serviceCustom);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rtn;
    }

    /**
     * 更新服务项内容
     * @param serviceCustom s_id作为见多信息，其他都为要修改的新信息,宠物id， 字典id（服务类型）， 员工id不为空
     * @return 更新成功返回true，否则返回false
     */
    public static boolean updateService(ServiceCustom serviceCustom){
        boolean rtn = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ServiceMapper serviceMapper = sqlSession.getMapper(ServiceMapper.class);

        try {
            rtn = serviceMapper.updateService(serviceCustom);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rtn;
    }

    /**
     * 删除一条服务项信息
     * @param serviceCustom 删除的服务项信息，只需要填充s_id字段
     * @return 删除成功返回true，否则返回false
     */
    public static boolean deleteService(ServiceCustom serviceCustom){
        boolean rtn = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ServiceMapper serviceMapper = sqlSession.getMapper(ServiceMapper.class);

        try {
            rtn = serviceMapper.deleteService(serviceCustom.getS_id());
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rtn;
    }
}
