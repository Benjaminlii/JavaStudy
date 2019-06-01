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
}
