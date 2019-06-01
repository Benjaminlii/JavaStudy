package service;

import dao.ClientDao;
import dao.ClientDaoImpl;
import entity.Client;
import entity.ClientCustom;
import entity.ClientQueryVo;
import main.config.mapper.ClientMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
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


    private static ClientDao clientDao = new ClientDaoImpl();

    /**
     * 增加一个Client
     *
     * @param client 要增加的Client信息 手机号为唯一表示
     * @return 成功返回true，失败返回false
     */
    public static boolean addClient(Client client) {
        return clientDao.addClient(client);
    }

    /**
     * 查询全部的Client
     *
     * @return 返回所有Client组成的List
     */
    public static List<Client> findClientLimit(int page) {
        List<Client> clients = null;
        try {
            clients = clientDao.findClientLimit(page);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

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
}
