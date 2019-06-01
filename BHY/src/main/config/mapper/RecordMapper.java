package main.config.mapper;

import entity.RecordCustom;
import entity.RecordQueryVo;

import java.util.List;

public interface RecordMapper {
    /**
     * [分页][条件]查询销售单信息
     * @param recordQueryVo 查询条件
     * @return 查询出的销售单信息
     */
    public List<RecordCustom> findRecordLimitInDetail(RecordQueryVo recordQueryVo) throws Exception;
}
