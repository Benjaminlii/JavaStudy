package service;

import dao.RecordDao;
import dao.RecordDaoImpl;
import entity.RecordCustom;

import java.sql.SQLException;
import java.util.List;

/**
 * 关于record（销售记录）的业务逻辑
 */
public class RecordService {
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
