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

    /**
     * 根据手机号查询顾客信息
     * @param clientQueryVo 封装的查询条件，只需要填充mobile属性
     * @return 如果查询成功返回满足手机号的顾客信息，否则返回null
     */
    public ClientCustom findClientByMobile(ClientQueryVo clientQueryVo) throws Exception;

    /**
     * 插入一条client数据(这里本来应该通过视图插入，但是client表未产生视图)
     * @param clientCustom 插入的信息
     * @return 插入成功返回true，否则返回false
     */
    public boolean insertClient(ClientCustom clientCustom) throws Exception;
}
