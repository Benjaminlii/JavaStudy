package service;

import entity.ClientCustom;
import entity.ClientQueryVo;
import main.config.mapper.ClientMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 关于Client（顾客）的业务逻辑
 */
public class ClientService {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try (
                InputStream inputStream = Resources.getResourceAsStream("main/config/SqlMapConfig.xml")
        ) {
            ClientService.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 插入一条client数据
     * @param clientQueryVo 插入的数据的封装（因为要使用查询，所以不使用ClientQueryVo）
     * @return 插入成功返回true，否则返回false
     */
    public static boolean addClient(ClientQueryVo clientQueryVo) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ClientMapper clientMapper = sqlSession.getMapper(ClientMapper.class);
        boolean rtn = false;

        try {
            if(clientMapper.findClientByMobile(clientQueryVo.getClientCustom().getMobile())==null){
                //未找到已有的数据，手机号未登记
                rtn = clientMapper.insertClient(clientQueryVo.getClientCustom());
                sqlSession.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rtn;
    }

    /**
     * [分页][条件]查询顾客信息
     * @param clientQueryVo 查询条件
     * @return 查询出的数据
     */
    public static List<ClientCustom> findClientLimitInDetail(ClientQueryVo clientQueryVo){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ClientMapper clientMapper = sqlSession.getMapper(ClientMapper.class);

        List<ClientCustom> clientCustoms = null;
        try {
            clientCustoms = clientMapper.findClientLimitInDetail(clientQueryVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clientCustoms;
    }

    /**
     * 更新一条顾客信息
     * @param clientCustom cl_id为检索信息，其他为更新信息
     * @return 更新成功返回true，否则返回false
     */
    public static boolean updateClient(ClientCustom clientCustom){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ClientMapper clientMapper = sqlSession.getMapper(ClientMapper.class);
        boolean rtn = false;

        try {
            rtn = clientMapper.updateClient(clientCustom);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rtn;
    }
}
