package service;

import dao.StoreDao;
import dao.StoreDaoImpl;
import entity.StoreCustom;
import entity.StoreQueryVo;
import main.config.mapper.StoreMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

/**
 * 关于Store（宠物店）的业务逻辑
 */
public class StoreService {
    private static SqlSessionFactory sqlSessionFactory;

    static  {
        try (
                InputStream inputStream = Resources.getResourceAsStream("main/config/SqlMapConfig.xml")
        ) {
            StoreService.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private static StoreDao storeDao = new StoreDaoImpl();

    /**
     * 分页查询宠物店信息,并且封装好
     * @return 所有宠物店信息组成的List
     */
    public static List<StoreCustom> findStoreLimit(int page){
        List<StoreCustom> stores = null;
        try {
            stores = storeDao.findStoreLimitInDetail(page);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stores;
    }

    /**
     * [分页][条件]查询宠物店信息
     * @param storeQueryVo 宠物店信息和分页信息
     * @return 查询出的宠物店信息
     */
    public static List<StoreCustom> findStoreLimitInDetail(StoreQueryVo storeQueryVo){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StoreMapper storeMapper = sqlSession.getMapper(StoreMapper.class);

        List<StoreCustom> storeCustoms = null;
        try {
            storeCustoms = storeMapper.findStoreLimitInDetail(storeQueryVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return storeCustoms;
    }
}
