package dao;

import entity.Dictionary;
import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DictionaryDaoImpl implements DictionaryDao {
    @Override
    public boolean addDictionary(Dictionary dictionary) {
        String sql = "insert into dictionary (d_par_id, d_name, d_value) values (?,?,?);";
        Object[] para = {
                dictionary.getD_par_id(), dictionary.getD_name(), dictionary.getD_value()
        };
        boolean rtn = DBUtil.executeUpdate(sql, para) == 1;
        DBUtil.closeAll();
        return rtn;
    }

    @Override
    public boolean deleteDictionary(int d_id) {
        String sql = "delete from dictionary where d_id = ?";
        Object[] para = {d_id};
        boolean rtn = DBUtil.executeUpdate(sql, para) == 1;
        DBUtil.closeAll();
        return rtn;
    }

    @Override
    public boolean updateDictionary(Dictionary dictionary) {
        String sql = "update dictionary set d_par_id = ?, d_name = ?, d_value = ? where cl_id = ?";
        Object[] para = {dictionary.getD_par_id(), dictionary.getD_name(), dictionary.getD_value(),
                dictionary.getD_id()};
        boolean rtn = DBUtil.executeUpdate(sql, para) == 1;
        DBUtil.closeAll();
        return rtn;
    }

    @Override
    public List<Dictionary> findAllDictionary() throws SQLException {
        String sql = "select * from Dictionary;";
        ResultSet resultSet = DBUtil.executeQuery(sql, null);
        List<Dictionary> rtn = new ArrayList<>();
        Dictionary dictionary;
        while (resultSet.next()) {
            dictionary = new Dictionary(
                    resultSet.getInt("d_id"),
                    resultSet.getInt("d_par_id"),
                    resultSet.getString("d_name"),
                    resultSet.getString("d_value")
            );
            rtn.add(dictionary);
        }
        DBUtil.closeAll();
        return rtn;
    }

    @Override
    public List<Dictionary> findDictionaryByParValue(String parValue) throws SQLException {
        String sql = "select d1.* from dictionary d1 inner join dictionary d2 on d1.d_par_id = d2.d_id where d2.d_value = ？;";
        Object[] para = {parValue};
        ResultSet resultSet = DBUtil.executeQuery(sql, para);
        List<Dictionary> rtn = new ArrayList<>();
        Dictionary dictionary;
        while (resultSet.next()) {
            dictionary = new Dictionary(
                    resultSet.getInt("d_id"),
                    resultSet.getInt("d_par_id"),
                    resultSet.getString("d_name"),
                    resultSet.getString("d_value")
            );
            rtn.add(dictionary);
        }
        DBUtil.closeAll();
        return rtn;
    }

//    @Override
//    public List<Dictionary> findAllDictionaryByParValue(String parValue) throws SQLException {
//        String sql = "select d1.* from dictionary d1 inner join dictionary d2 on d1.d_par_id = d2.d_id where d2.d_value = ？;";
//        Object[] para = {parValue};
//        ResultSet resultSet = DBUtil.executeQuery(sql, para);
//        List<Dictionary> rtn = new ArrayList<>();
//        Dictionary dictionary;
//        while (resultSet.next()) {
//            dictionary = new Dictionary(
//                    resultSet.getInt("d_id"),
//                    resultSet.getInt("d_par_id"),
//                    resultSet.getString("d_name"),
//                    resultSet.getString("d_value")
//            );
//            rtn.add(dictionary);
//            rtn.addAll(findAllDictionaryByParValue(dictionary.getD_value()));
//        }
//        DBUtil.closeAll();
//        return rtn;
//    }
}
