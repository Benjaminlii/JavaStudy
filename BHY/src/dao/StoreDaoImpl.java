package dao;

import entity.Store;
import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StoreDaoImpl implements StoreDao {
    @Override
    public boolean addStore(Store store) {
        String sql = "insert into store (d_id, e_id, st_address, st_time) " +
                "values (?,?,?,?);";
        Object[] para = {
                store.getD_id(), store.getE_id(),
                store.getSt_address(), store.getSt_time()
        };
        boolean rtn = DBUtil.executeUpdate(sql, para) == 1;
        DBUtil.closeAll();
        return rtn;
    }

    @Override
    public boolean deleteStore(int st_id) {
        String sql = "delete from store where st_id = ?";
        Object[] para = {st_id};
        boolean rtn = DBUtil.executeUpdate(sql, para) == 1;
        DBUtil.closeAll();
        return rtn;
    }

    @Override
    public boolean updateStore(Store store) {
        String sql = "update store set d_id = ?, e_id = ?, st_address = ? " +
                "st_time = ? " +
                "where st_id = ?";
        Object[] para = {
                store.getD_id(), store.getE_id(), store.getSt_address(),
                store.getSt_time(), store.getSt_id()
        };
        boolean rtn = DBUtil.executeUpdate(sql, para) == 1;
        DBUtil.closeAll();
        return rtn;
    }

    @Override
    public List<Store> findAllStore() throws SQLException {
        String sql = "select * from store;";
        ResultSet resultSet = DBUtil.executeQuery(sql, null);
        List<Store> rtn = new ArrayList<>();
        Store store;
        while (resultSet.next()) {
            store = new Store(
                    resultSet.getInt("st_id"),
                    resultSet.getInt("d_id"),
                    resultSet.getInt("e_id"),
                    resultSet.getString("st_address"),
                    (Date) resultSet.getObject("st_time")
            );
            rtn.add(store);
        }
        DBUtil.closeAll();
        return rtn;
    }
}