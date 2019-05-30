package dao;

import entity.Record;
import entity.RecordCustom;

import java.sql.SQLException;
import java.util.List;

public interface RecordDao {
    /**
     * 向数据库中的Record（销售记录）表中添加数据
     * @param record 传入的封装好的数对象
     * @return 添加成功返回true，否则返回false
     */
    public boolean addRecord(Record record);

    /**
     * 根据p_id从Record表中删除一条信息
     * @param r_id 需要删除的信息的r_id
     * @return 删除成功返回true，否则返回false
     */
    public boolean deleteRecord(int r_id);

    /**
     * 根据传入信息更改一条Record表中的数据
     * @param record 传入的信息，r_id为查找该条信息的条件，其他数据均为新数据修改到该信息处
     * @return 修改成功返回true，否则返回false
     */
    public boolean updateRecord(Record record);

    /**
     * 查询Record表中的所有信息
     * @return 将表中的所有信息封装成List<Record>进行返回
     */
    public List<Record> findAllRecord() throws SQLException;

    /**
     * 查询Record表中的所有详细信息
     * @return 将表中的所有信息封装成List<RecordService>进行返回
     */
    public List<RecordCustom> findRecordInDetail() throws SQLException;

    public List<RecordCustom> findRecordLimitInDetail(int page) throws SQLException;

}
