package main.config.mapper;

import entity.StoreCustom;
import entity.StoreQueryVo;

import java.util.List;

public interface StoreMapper {
    /**
     * [分页][条件]查询宠物店信息
     * @param storeQueryVo 查询条件
     * @return 查询到的宠物店信息
     */
    public List<StoreCustom> findStoreLimitInDetail(StoreQueryVo storeQueryVo) throws Exception;

}
