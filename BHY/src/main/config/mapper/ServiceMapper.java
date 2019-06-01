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
}
