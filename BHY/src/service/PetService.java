package service;

import dao.ClientDao;
import dao.ClientDaoImpl;
import dao.PetDao;
import dao.PetDaoImpl;
import entity.Client;
import entity.Pet;
import entity.PetCustom;
import entity.PetQueryVo;
import main.config.mapper.PetMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

/**
 * 关于Pet（宠物）的业务逻辑层
 */
public class PetService {
    private static SqlSessionFactory sqlSessionFactory;

    static  {
        try (
                InputStream inputStream = Resources.getResourceAsStream("main/config/SqlMapConfig.xml")
        ) {
            PetService.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    private static PetDao petDao = new PetDaoImpl();
    private static ClientDao clientDao = new ClientDaoImpl();

    /**
     * 查询所有的宠物信息，封装成List返回
     * @return 所有宠物信息构成的List
     */
    public static List<PetCustom> findPetLimit(int page){
        List<PetCustom> pets = null;
        try {
            pets = petDao.findPetLimitInDetail(page);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pets;
    }

    /**
     * 添加宠物信息
     * 需要传入宠物品种（d_id），顾客姓名，顾客手机号（唯一索引）
     * @param pet 宠物信息
     * @param client 封装顾客信息
     * @return 顾客不存在或者数据库底层出现问题时返回false，成功添加返回true
     */
    public static boolean addPet(Pet pet, Client client){
        boolean rtn = false;
        try {
            if(clientDao.isClientExist(client.getMobile())){
                //顾客信息存在
                rtn = petDao.addPet(pet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rtn;
    }

    /**
     * [分页][条件]查询宠物信息
     * @param petQueryVo 查询条件
     * @return 查询出的list
     */
    public static List<PetCustom> findPetLimitInDetail(PetQueryVo petQueryVo){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PetMapper petMapper = sqlSession.getMapper(PetMapper.class);

        List<PetCustom> petCustoms = null;
        try {
            petCustoms = petMapper.findPetLimitInDetail(petQueryVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return petCustoms;
    }
}
