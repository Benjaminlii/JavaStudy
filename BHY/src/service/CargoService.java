package service;

import dao.CargoDao;
import dao.CargoDaoImpl;
import entity.CargoCustom;

import java.sql.SQLException;
import java.util.List;

/**
 * 关于Cargo（货物）的业务逻辑
 */
public class CargoService {
    private static CargoDao cargoDao = new CargoDaoImpl();

    /**
     * 分页查询所有的货物详细信息
     * @param page 页码
     * @return List<CargoCustom>
     */
    public static List<CargoCustom> findCargoLimit(int page){
        List<CargoCustom> cargoCustoms = null;
        try {
            cargoCustoms = cargoDao.findCargoLimitInDetail(page);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cargoCustoms;
    }
}
