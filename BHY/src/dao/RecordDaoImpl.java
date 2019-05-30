package dao;

import entity.Record;
import entity.RecordCustom;
import util.DBUtil;
import util.PageUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecordDaoImpl implements RecordDao {
    @Override
    public boolean addRecord(Record record) {
        String sql = "insert into record (cl_id, s_id, c_id, r_time, r_price, r_num, r_pattern) " +
                "values (?,?,?,?,?,?,?);";
        Object[] para = {
                record.getCl_id(), record.getS_id(), record.getC_id(),
                record.getR_time(), record.getR_price(), record.getR_num(),
                record.getR_pattern()
        };
        boolean rtn = DBUtil.executeUpdate(sql, para) == 1;
        DBUtil.closeAll();
        return rtn;
    }

    @Override
    public boolean deleteRecord(int r_id) {
        String sql = "delete from record where r_id = ?";
        Object[] para = {r_id};
        boolean rtn = DBUtil.executeUpdate(sql, para) == 1;
        DBUtil.closeAll();
        return rtn;
    }

    @Override
    public boolean updateRecord(Record record) {
        String sql = "update record set cl_id = ?, s_id = ?, c_id = ? " +
                "r_time = ?, r_price = ?, r_num = ? " +
                "r_pattern = ? " +
                "where r_id = ?";
        Object[] para = {
                record.getCl_id(), record.getS_id(), record.getC_id(),
                record.getR_time(), record.getR_price(), record.getR_num(),
                record.getR_pattern(), record.getR_id()
        };
        boolean rtn = DBUtil.executeUpdate(sql, para) == 1;
        DBUtil.closeAll();
        return rtn;
    }

    @Override
    public List<Record> findAllRecord() throws SQLException {
        String sql = "select * from record;";
        ResultSet resultSet = DBUtil.executeQuery(sql, null);
        List<Record> rtn = new ArrayList<>();
        Record record;
        while (resultSet.next()) {
            record = new Record(
                    resultSet.getInt("r_id"),
                    resultSet.getInt("cl_id"),
                    resultSet.getInt("s_id"),
                    resultSet.getInt("c_id"),
                    (Date) resultSet.getObject("r_time"),
                    resultSet.getFloat("r_price"),
                    resultSet.getInt("r_num"),
                    resultSet.getString("r_pattern")
            );
            rtn.add(record);
        }
        DBUtil.closeAll();
        return rtn;
    }

    @Override
    public List<RecordCustom> findRecordInDetail() throws SQLException {
        String sql = "select record.*, cl_name, s_address, c_name " +
                "from record " +
                "left join client " +
                "on record.cl_id = client.cl_id " +
                "left join store " +
                "on record.s_id = store.st_id " +
                "left join cargo " +
                "on record.c_id = cargo.c_id;";
        ResultSet resultSet = DBUtil.executeQuery(sql, null);
        List<RecordCustom> rtn = new ArrayList<>();
        RecordCustom recordCustom;
        while (resultSet.next()) {
            recordCustom = new RecordCustom(
                    resultSet.getInt("r_id"),
                    resultSet.getInt("cl_id"),
                    resultSet.getInt("s_id"),
                    resultSet.getInt("c_id"),
                    (Date) resultSet.getObject("r_time"),
                    resultSet.getFloat("r_price"),
                    resultSet.getInt("r_num"),
                    resultSet.getString("r_pattern"),
                    resultSet.getString("cl_name"),
                    resultSet.getString("s_address"),
                    resultSet.getString("c_name")
            );
            rtn.add(recordCustom);
        }
        DBUtil.closeAll();
        return rtn;
    }

    @Override
    public List<RecordCustom> findRecordLimitInDetail(int page) throws SQLException {
        String sql = "select record.*, cl_name, s_address, c_name " +
                "from record " +
                "left join client " +
                "on record.cl_id = client.cl_id " +
                "left join store " +
                "on record.s_id = store.st_id " +
                "left join cargo " +
                "on record.c_id = cargo.c_id " +
                "limit ?, ?;";
        Object[] para = {PageUtil.getOffSet(page), PageUtil.getSize()};
        ResultSet resultSet = DBUtil.executeQuery(sql, para);
        List<RecordCustom> rtn = new ArrayList<>();
        RecordCustom recordCustom;
        while (resultSet.next()) {
            recordCustom = new RecordCustom(
                    resultSet.getInt("r_id"),
                    resultSet.getInt("cl_id"),
                    resultSet.getInt("s_id"),
                    resultSet.getInt("c_id"),
                    (Date) resultSet.getObject("r_time"),
                    resultSet.getFloat("r_price"),
                    resultSet.getInt("r_num"),
                    resultSet.getString("r_pattern"),
                    resultSet.getString("cl_name"),
                    resultSet.getString("s_address"),
                    resultSet.getString("c_name")
            );
            rtn.add(recordCustom);
        }
        DBUtil.closeAll();
        return rtn;
    }
}
