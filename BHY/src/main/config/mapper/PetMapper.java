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

    /**
     * 插入一条宠物信息
     * @param petCustom 插入的宠物信息
     * @return 插入成功返回true，否则返回false
     */
    public boolean insertPet(PetCustom petCustom) throws Exception;

    /**
     * 更新宠物信息
     * @param petCustom p_id为检索信息，其他为更新信息，包括st_id， p_age， p_sex， p_height， p_healthy， cl_id
     * @return 是否更新成功
     */
    public boolean updatePet(PetCustom petCustom) throws Exception;
}
