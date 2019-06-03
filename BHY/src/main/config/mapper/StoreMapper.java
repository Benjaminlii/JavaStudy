package main.config.mapper;

import entity.StoreCustom;
import entity.StoreQueryVo;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface StoreMapper {
    /**
     * [分页][条件]查询宠物店信息
     * @param storeQueryVo 查询条件
     * @return 查询到的宠物店信息
     */
    public List<StoreCustom> findStoreLimitInDetail(StoreQueryVo storeQueryVo) throws Exception;

    /**
     * 添加一条宠物店信息
     * @param storeCustom 新建的宠物店信息，必须填充d_id(宠物店类型，前端下拉列表获得)字段
     * @return 插入成功返回true，否则返回false
     */
    public boolean insertStore(StoreCustom storeCustom) throws Exception;

    /**
     * 更新一条宠物店信息
     * @param storeCustom 更新的信息，st_id为检索信息，其他字段都为更改后的新信息
     * @return 成功返回true，否则返回false
     */
    public boolean updateStore(StoreCustom storeCustom) throws Exception;

    /**
     * 删除一条宠物店信息
     * @param st_id 要进行删除的宠物店st_id
     * @return 删除成功返回true，否则返回false
     */
    public boolean deleteStore(Integer st_id) throws Exception;

}
