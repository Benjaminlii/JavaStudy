package main.config.mapper;

import entity.PetCustom;
import entity.PetQueryVo;

import java.util.List;

public interface PetMapper {

    /**
     * [分页][条件]查询所有宠物信息
     * @param petQueryVo 查询信息的封装，包括Pet信息和Page（分页）信息
     * @return 查询出的PetCustom列表
     */
    public List<PetCustom> findPetLimitInDetail(PetQueryVo petQueryVo) throws Exception;
}
