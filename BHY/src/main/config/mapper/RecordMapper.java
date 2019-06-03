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

    /**
     * 插入一条销售记录，回返r_id
     * @param recordQueryVo 插入的信息，必须包括顾客手机号码，登陆状态，d_id（前端下拉菜单单选），当前时间，售出价格，购买数量
     * @return 插入成功返回true，否则返回false
     */
    public boolean insertRecord(RecordQueryVo recordQueryVo) throws Exception;

    /**
     * 更新一条销售记录，r_id为查找索引，其他信息都为更新信息
     * @param recordCustom 可以更改的信息：销售物品（c_id）销售时间（r_time），销售金额（r_price），销售数量（r_num），支付方式（r_pattern）
     * @return 更新成功返回true，否则返回false
     */
    public boolean updateRecord(RecordCustom recordCustom) throws Exception;

    /**
     * 删除一条销售记录
     * @param r_id 要删除的销售记录的r_id
     * @return 删除成功返回true，否则返回0
     */
    public boolean deleteRecord(Integer r_id) throws Exception;
}
