package main.config.mapper;

import entity.ClientCustom;
import entity.ClientQueryVo;

import java.util.List;

public interface ClientMapper {
    /**
     * [分页][条件]查询顾客信息
     * @param clientQueryVo 查询条件，包括顾客信息和分页信息
     * @return 查询出的列表
     */
    public List<ClientCustom> findClientLimitInDetail(ClientQueryVo clientQueryVo) throws Exception;
}
