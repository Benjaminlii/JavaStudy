package main.config.mapper;

import entity.RecordCustom;
import entity.RecordQueryVo;

import java.util.List;

public interface RecordMapper {
    public List<RecordCustom> findRecordLimitInDetail(RecordQueryVo recordQueryVo) throws Exception;
}
