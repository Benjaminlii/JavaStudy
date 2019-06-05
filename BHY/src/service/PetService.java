package service;

import entity.*;
import main.config.mapper.ClientMapper;
import main.config.mapper.PetMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
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

    /**
     * 添加宠物信息
     * 需要传入宠物品种（d_id），顾客姓名，顾客手机号（唯一索引）
     * @param petQueryVo 宠物信息，需要宠物类型（d_id），其中的顾客信息，只需要包装手机号mobile
     * @return 顾客不存在或者数据库底层出现问题时返回false，成功添加返回true
     */
    public static boolean addPet(PetQueryVo petQueryVo){
        boolean rtn = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PetMapper petMapper = sqlSession.getMapper(PetMapper.class);
        ClientMapper clientMapper = sqlSession.getMapper(ClientMapper.class);

        try {
            ClientCustom clientCustom = clientMapper.findClientByMobile(petQueryVo.getClient().getMobile());
            if(clientCustom != null){
                //手机号存在
                petQueryVo.getPetCustom().setCl_id(clientCustom.getCl_id());
                rtn = petMapper.insertPet(petQueryVo);
                sqlSession.commit();
            }
        } catch (Exception e) {
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

    /**
     * 更新一条宠物信息
     * @param petCustom p_id为检索信息，其他为更新信息，包括st_id， p_age， p_sex， p_height， p_healthy， cl_id
     * @return 是否更新成功
     */
    public static boolean updatePet(PetCustom petCustom){
        boolean rtn = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PetMapper petMapper = sqlSession.getMapper(PetMapper.class);

        try {
            rtn = petMapper.updatePet(petCustom);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rtn;
    }

    /**
     * 删除一条宠物信息
     * @param petCustom 要删除的宠物，只需要填充p_id字段
     * @return 成功返回true，否则返回false
     */
    public static boolean deletePet(PetCustom petCustom){
        boolean rtn = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PetMapper petMapper = sqlSession.getMapper(PetMapper.class);

        try {
            rtn = petMapper.deletePet(petCustom.getP_id());
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rtn;
    }
}
