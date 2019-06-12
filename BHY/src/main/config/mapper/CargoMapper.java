package main.config.mapper;

import entity.CargoCustom;
import entity.CargoQueryVo;

import java.util.List;

public interface CargoMapper {
    /**
     * [分页][条件]查询所有货物信息
     * @param cargoQueryVo 查询信息的封装，包括Cargo信息和Page（分页）信息
     * @return 查询出的CargoCustom列表
     */
    public List<CargoCustom> findCargoLimitInDetail(CargoQueryVo cargoQueryVo) throws Exception;

    /**
     * 进货和销售
     * @param cargoCustom 通过c_id确定销售的货物，根据c_num对数量进行更更新
     * @return 成功返回true，否则返回false
     */
    public boolean inAndOutCargo(CargoCustom cargoCustom)throws Exception;

    /**
     * 进货
     * @param cargoQueryVo
     * @return
     * @throws Exception
     */
    public boolean addCargo(CargoQueryVo cargoQueryVo)throws Exception;
}
