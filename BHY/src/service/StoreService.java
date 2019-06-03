package service;

import entity.StoreCustom;
import entity.StoreQueryVo;
import main.config.mapper.StoreMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
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

    /**
     * 添加一条宠物店信息
     * @param storeCustom 新建的宠物店信息，必须填充d_id(宠物店类型，前端下拉列表获得)字段
     * @return 插入成功返回true，否则返回false
     */
    public static boolean insertStore(StoreCustom storeCustom){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StoreMapper storeMapper = sqlSession.getMapper(StoreMapper.class);
        boolean rtn = false;

        try {
            rtn = storeMapper.insertStore(storeCustom);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rtn;
    }

    /**
     * 更新一条宠物店信息
     * @param storeCustom 更新的信息，st_id为检索信息，其他字段都为更改后的新信息
     * @return 成功返回true，否则返回false
     */
    public static boolean updateStore(StoreCustom storeCustom){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StoreMapper storeMapper = sqlSession.getMapper(StoreMapper.class);
        boolean rtn = false;

        try {
            rtn = storeMapper.updateStore(storeCustom);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rtn;
    }

    /**
     * 删除一条宠物店信息
     * @param storeCustom 要进行删除的宠物店的信息，其中st_id必须被填充
     * @return 删除成功返回true，否则返回false
     */
    public static boolean deleteStore(StoreCustom storeCustom){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StoreMapper storeMapper = sqlSession.getMapper(StoreMapper.class);
        boolean rtn = false;

        try {
            rtn = storeMapper.deleteStore(storeCustom.getSt_id());
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rtn;
    }
}
