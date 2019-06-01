package service;

import dao.RecordDao;
import dao.RecordDaoImpl;
import entity.RecordCustom;
import entity.RecordQueryVo;
import main.config.mapper.RecordMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

/**
 * 关于record（销售记录）的业务逻辑
 */
public class RecordService {
    private static SqlSessionFactory sqlSessionFactory;

    static  {
        try (
                InputStream inputStream = Resources.getResourceAsStream("main/config/SqlMapConfig.xml")
        ) {
            RecordService.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * [分页][条件]查询销售记录
     * @param recordQueryVo 查询条件
     * @return 查询出的销售记录
     */
    public static List<RecordCustom> findRecordLimitInDetail(RecordQueryVo recordQueryVo){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        RecordMapper recordMapper = sqlSession.getMapper(RecordMapper.class);

        List<RecordCustom> recordCustoms = null;
        try {
            recordCustoms = recordMapper.findRecordLimitInDetail(recordQueryVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recordCustoms;
    }




    private static RecordDao recordDao = new RecordDaoImpl();

    /**
     * 分页查询所有的销售记录的详细信息
     * @param page 页码
     * @return 当前页码的销售记录包装类的List
     */
    public static List<RecordCustom> findRecordLimit(int page){
        List<RecordCustom> recordCustoms = null;
        try {
            recordCustoms = recordDao.findRecordLimitInDetail(page);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recordCustoms;
    }



}
