package main.config.mapper;

import entity.ServiceCustom;
import entity.ServiceQueryVo;

import java.util.List;

public interface ServiceMapper {
    /**
     * [分页][条件]查询服务项
     * @param serviceQueryVo 查询条件和分页条件
     * @return 查询出的数据
     */
    public List<ServiceCustom> findServiceLimitInDetail(ServiceQueryVo serviceQueryVo) throws Exception;

    /**
     * 添加一条服务信息，回返服务信息s_id
     * @param serviceCustom 插入的服务信息，必须要提供的信息：宠物id， 字典id（服务类型）， 员工id
     * @return 插入成功返回true，否则返回false
     */
    public boolean insertService(ServiceCustom serviceCustom) throws Exception;

    /**
     * 更新服务项内容
     * @param serviceCustom s_id作为见多信息，其他都为要修改的新信息,宠物id， 字典id（服务类型）， 员工id不为空
     * @return 更新成功返回true，否则返回false
     */
    public boolean updateService(ServiceCustom serviceCustom) throws Exception;

    /**
     * 删除一条服务信息
     * @param s_id 要删除的服务项的s_id
     * @return 删除成功返回true，否则返回false
     */
    public boolean deleteService(Integer s_id) throws Exception;
}
