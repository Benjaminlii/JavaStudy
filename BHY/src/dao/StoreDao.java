package dao;

import entity.Service;
import entity.Store;

import java.sql.SQLException;
import java.util.List;

public interface StoreDao {
    /**
     * 向数据库中的Store（宠物店）表中添加数据
     * @param store 传入的封装好的数对象
     * @return 添加成功返回true，否则返回false
     */
    public boolean addStore(Store store);

    /**
     * 根据st_id从Store表中删除一条信息
     * @param st_id 需要删除的信息的st_id
     * @return 删除成功返回true，否则返回false
     */
    public boolean deleteStore(int st_id);

    /**
     * 根据传入信息更改一条Store表中的数据
     * @param store 传入的信息，st_id为查找该条信息的条件，其他数据均为新数据修改到该信息处
     * @return 修改成功返回true，否则返回false
     */
    public boolean updateStore(Store store);

    /**
     * 查询Service表中的所有信息
     * @return 将表中的所有信息封装成List<Store>进行返回
     * @throws SQLException 遍历ResultSet
     */
    public List<Store> findAllStore() throws SQLException;
}
