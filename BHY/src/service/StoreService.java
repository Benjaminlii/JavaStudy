package service;

import dao.StoreDao;
import dao.StoreDaoImpl;
import entity.StoreCustom;

import java.sql.SQLException;
import java.util.List;

/**
 * 关于Store（宠物店）的业务逻辑
 */
public class StoreService {
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

}
