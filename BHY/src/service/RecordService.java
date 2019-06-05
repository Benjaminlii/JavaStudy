package service;

import entity.*;
import main.config.mapper.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
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

    /**
     * 添加一条销售单信息，回返r_id
     * @param recordQueryVo 必须包括顾客手机号码，登陆状态，c_id前端下拉菜单（或通过点击货物进入下单页面），当前时间，售出价格，购买数量
     * @return 插入成功返回true，否则返回false
     */
    public static boolean insertRecord(RecordQueryVo recordQueryVo){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        RecordMapper recordMapper = sqlSession.getMapper(RecordMapper.class);
        CargoMapper cargoMapper = sqlSession.getMapper(CargoMapper.class);
        boolean rtn = false;

        try {
            rtn = recordMapper.insertRecord(recordQueryVo);
            //更新货物信息
            CargoCustom cargoCustom = new CargoCustom();
            cargoCustom.setC_id(recordQueryVo.getRecordCustom().getC_id());
            cargoCustom.setC_num(recordQueryVo.getRecordCustom().getR_num());
//            CargoService.inAndOutCargo(cargoCustom);
            cargoMapper.inAndOutCargo(cargoCustom);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return rtn;
    }

    /**
     * 更新一条销售记录，r_id为查找索引，其他信息都为更新信息
     * @param recordCustom 可以更改的信息：销售物品（c_id）销售时间（r_time），销售金额（r_price），销售数量（r_num），支付方式（r_pattern）
     * @return 更新成功返回true，否则返回false
     */
    public static boolean updateRecord(RecordCustom recordCustom){
        boolean rtn = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        RecordMapper recordMapper = sqlSession.getMapper(RecordMapper.class);

        try {
            rtn = recordMapper.updateRecord(recordCustom);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rtn;
    }

    /**
     * 删除一条销售记录
     * @param recordCustom 要删除的销售记录信息，只需要填充r_id字段
     * @return 删除成功返回true，否则返回false
     */
    public static boolean deleteRecord(RecordCustom recordCustom){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        RecordMapper recordMapper = sqlSession.getMapper(RecordMapper.class);
        boolean rtn = false;

        try {
            rtn = recordMapper.deleteRecord(recordCustom.getR_id());
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return rtn;
    }
}
