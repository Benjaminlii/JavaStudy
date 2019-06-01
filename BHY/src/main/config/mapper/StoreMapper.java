package main.config.mapper;

import entity.StoreCustom;
import entity.StoreQueryVo;

import java.util.List;

public interface StoreMapper {
    public List<StoreCustom> findStoreLimitInDetail(StoreQueryVo storeQueryVo) throws Exception;

}
