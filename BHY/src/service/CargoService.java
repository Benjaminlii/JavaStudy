package service;

import entity.CargoCustom;
import entity.CargoQueryVo;
import main.config.mapper.CargoMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 关于Cargo（货物）的业务逻辑
 */
public class CargoService {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try (
                InputStream inputStream = Resources.getResourceAsStream("main/config/SqlMapConfig.xml")
        ) {
            CargoService.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * [分页][条件]查询货物信息
     *
     * @param cargoQueryVo 查询条件
     * @return 查询出的list
     */
    public static List<CargoCustom> findCargoLimitInDetail(CargoQueryVo cargoQueryVo) {
        //得到SqlSession，这是不可少的步骤
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //通过SqlSession得到代理的mapper接口对象
        CargoMapper cargoMapper = sqlSession.getMapper(CargoMapper.class);
        List<CargoCustom> cargoCustoms = null;
        try {
            cargoCustoms = cargoMapper.findCargoLimitInDetail(cargoQueryVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cargoCustoms;
    }

    /**
     * 进货和销售
     * 通过c_id确定销售的货物，根据c_num对数量进行更更新
     * @return 成功返回true，否则返回false
     */
    public static boolean addCargo(CargoQueryVo cargoQueryVo) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CargoMapper cargoMapper = sqlSession.getMapper(CargoMapper.class);
        boolean rtn = false;

        try {
            rtn = cargoMapper.addCargo(cargoQueryVo);

            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rtn;
    }
}
